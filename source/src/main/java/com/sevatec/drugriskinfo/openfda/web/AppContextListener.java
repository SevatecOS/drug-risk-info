
package com.sevatec.drugriskinfo.openfda.web;

import com.sevatec.drugriskinfo.openfda.api.DrugDataStore;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author gax
 */
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // make sure your web.xlm has the correct path to the ascii file you got from
        // http://www.fda.gov/Drugs/GuidanceComplianceRegulatoryInformation/Surveillance/AdverseDrugEffects/ucm082193.htm
        // unziped 
        String drugDataFilePath = sce.getServletContext().getInitParameter("drug-data-file");
        File dataFile = new File(drugDataFilePath);
        DrugDataStore store = DrugDataStore.getInstance();
        store.setCsvPath(dataFile);
        try {
            store.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
