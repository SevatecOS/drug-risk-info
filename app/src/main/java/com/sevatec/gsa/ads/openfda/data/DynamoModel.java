package com.sevatec.gsa.ads.openfda.data;

import java.util.List;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.dynamodbv2.util.Tables;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DynamoModel<T> {

    /*
     * AWS credentials provider chain that looks for credentials in this order:
     * <ul> <li>Environment Variables - AWS_ACCESS_KEY_ID and
     * AWS_SECRET_KEY</li> <li>Java System Properties - aws.accessKeyId and
     * aws.secretKey</li> <li>Credential profiles file at the default location
     * (~/.aws/credentials) shared by all AWS SDKs and the AWS CLI</li>
     * <li>Instance profile credentials delivered through the Amazon EC2
     * metadata service</li> </ul>
     */
    private static AmazonDynamoDBClient client = new AmazonDynamoDBClient(
            new DefaultAWSCredentialsProviderChain());
    private static DynamoDB db = new DynamoDB(client);
    private static DynamoDBMapper mapper = new DynamoDBMapper(client);

    static {
        // currently setting explicit region... 
        client.setRegion(Region.getRegion(Regions.US_WEST_2));
    }

    public String getTableName() {
        return this.getClass().getAnnotation(DynamoDBTable.class).tableName();
    }

    public void save() {
        mapper.save(this);
    }

    public Table getTable() {
        return db.getTable(getTableName());
    }

    public void delete() {
        mapper.delete(this);
    }

    public Integer count() {
        ScanRequest scanRequest = new ScanRequest(getTableName());
        ScanResult result = client.scan(scanRequest);
        return result.getCount();
    }

    public T findByAttribute(String attributeName, String attributeValue) {
        List<T> scanResult = listByAttribute(ComparisonOperator.EQ, attributeName, attributeValue);
        if (scanResult.size() >= 1) {
            return scanResult.get(0);
        }
        return null;
    }

    public List<T> findByAttributeGreaterThan(String attributeName, Integer attributeValue) {
        return listByAttribute(ComparisonOperator.GE, attributeName, attributeValue);
    }

    public List<T> searchByAttribute(String attributeName, String attributeValue) {
        return listByAttribute(ComparisonOperator.CONTAINS, attributeName, attributeValue);
    }

    @SuppressWarnings("unchecked")
    public T findById(String id) {
        if (id == null) {
            return null;
        }
        return (T) mapper.load(this.getClass(), id);
    }

    public Table deleteTable() throws InterruptedException {
        Logger.getLogger(DynamoModel.class.getName()).log(Level.INFO, "deleting table: ", getTableName());
        Table table = getTable();
        table.delete();
        return table;
    }

    public boolean tableExists() {
        return Tables.doesTableExist(client, getTableName());
    }

    public Table createTable(CreateTableRequest request)
            throws InterruptedException {
        Table table = null;

        if (!Tables.doesTableExist(client, getTableName())) {
            Logger.getLogger(DynamoModel.class.getName()).log(Level.INFO, "creating table: ", getTableName());
            table = db.createTable(request);
            Tables.waitForTableToBecomeActive(client, getTableName());
        } else {
            Logger.getLogger(DynamoModel.class.getName()).log(Level.INFO, "table already exists: ", getTableName());
        }
        return table;
    }

    public abstract boolean exists();

    private List<T> listByAttribute(ComparisonOperator op, String attributeName, Object attributeValue) {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        AttributeValue value = null;
        if (attributeValue instanceof Integer) {
            value = new AttributeValue().withN(attributeValue.toString());
        } else {
            value = new AttributeValue().withS(attributeValue.toString());
        }
        scanExpression.addFilterCondition(attributeName, new Condition()
                .withComparisonOperator(op)
                .withAttributeValueList(value));
        @SuppressWarnings("unchecked")
        List<T> scanResult = (List<T>) mapper.scan(this.getClass(), scanExpression);
        return scanResult;
    }

}
