package com.sevatec.drugriskinfo.openfda.api;

import edu.emory.mathcs.backport.java.util.Collections;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author gax
 */
public class EventServiceImplTest extends AbstractBaseTest {
    
    @Mock private DrugDataStore dataStore;
    private EventServiceImpl servive = new EventServiceImpl();
    
    @Before
    public void setUp() {
        servive.setCache(dataStore);
    }
    
    @Test
    public void testfindDrugByName() throws IOException {
        Drug drug1 = new Drug();
        drug1.setCaseid("drug1-caseid");
        drug1.setDrugname("drug1-drugname");
        drug1.setPrimaryid("drug1-primaryid");
        when(dataStore.getCache()).thenReturn(Collections.singletonMap("drug1-drugname", drug1));
        
        List<Drug> result = servive.findDrugByName(drug1.getDrugname());
        verify(dataStore, times(1)).getCache();
        TestCase.assertNotNull(result);
    }
    
}
