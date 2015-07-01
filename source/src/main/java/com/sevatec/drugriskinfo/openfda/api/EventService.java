
package com.sevatec.drugriskinfo.openfda.api;

import com.sevatec.drugriskinfo.openfda.api.dto.Drug;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author gax
 */
public interface EventService {

    /**
     * Fins a drug that has the parameter String in the name.
     * @param prefix a String that will match the a substring of the drug name.
     * @return list of matching drugs.
     * @throws java.io.IOException if database loading fails.
     */
    List<Drug> findDrugByName(String prefix) throws IOException;

    /**
     * get a drug from openFDA.
     * @param name drug name.
     * @return list of openFDA drugs matching the name.
     */
    List<Drug> getDrugsByName(String name);
    
}
