package com.sevatec.gsa.ads.openfda.data.setup;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.sevatec.gsa.ads.openfda.data.Drug;
import com.sevatec.gsa.ads.openfda.data.DynamoModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DynamoSetup {

    public static void runSetup() {
        setupDrugTable();
    }

    private static void setupDrugTable() {
        CreateTableRequest request = createRequest(Drug.class);
        Table table;
        try {
            table = new Drug().createTable(request);
            if (table != null) {
                table.waitForActive();
                loadDrugTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(DynamoSetup.class.getName()).log(Level.SEVERE, "We failed to setup the drug table!!!", ex);
        }
    }

    private static void loadDrugTable() {
        BufferedReader br = null;
        try {
            Logger.getLogger(DynamoSetup.class.getName()).log(Level.INFO, "Starting to load drug table...");

            URL drugsFile = new URL("https://s3-us-west-2.amazonaws.com/drugriskinfo/drugs.txt");
            br = new BufferedReader(new InputStreamReader(drugsFile.openStream()));

            String line = null;
            while ((line = br.readLine()) != null) {
                Drug drug = new Drug();
                drug.setName(line);
                drug.setViews(0);
                drug.save();
            }

        } catch (Exception ex) {
            Logger.getLogger(DynamoSetup.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(DynamoSetup.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    private static CreateTableRequest createRequest(Class<? extends DynamoModel<?>> clazz) {
        CreateTableRequest request = new CreateTableRequest();

        List<AttributeDefinition> atts = new ArrayList<AttributeDefinition>();
        List<KeySchemaElement> keys = new ArrayList<KeySchemaElement>();

        for (Field f : clazz.getDeclaredFields()) {
            DynamoDBHashKey key = f.getAnnotation(DynamoDBHashKey.class);
            if (key != null) {
                atts.add(new AttributeDefinition(key.attributeName(), ScalarAttributeType.S));
                keys.add(new KeySchemaElement(key.attributeName(), KeyType.HASH));
            }
        }

        request.setTableName(clazz.getAnnotation(DynamoDBTable.class).tableName());
        request.setAttributeDefinitions(atts);
        request.setKeySchema(keys);
        // using the min here...
        request.setProvisionedThroughput(new ProvisionedThroughput(3L, 3L));

        return request;
    }

}
