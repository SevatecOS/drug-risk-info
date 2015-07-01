package com.sevatec.drugriskinfo.openfda.api;

import com.google.gson.Gson;
import com.sevatec.drugriskinfo.openfda.api.dto.Drug;
import com.sevatec.drugriskinfo.openfda.api.dto.DrugLabel;
import com.sevatec.drugriskinfo.openfda.api.dto.DrugLabelList;
import edu.emory.mathcs.backport.java.util.Collections;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;


/**
 *
 * @author gax
 */
public class EventServiceImplTest extends AbstractBaseTest {
    
    @Mock private DrugDataStore dataStore;
    private EventServiceImpl servive = new EventServiceImpl();

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        servive.setCache(dataStore);
    }

    @After
    public void tearDown() throws Exception {
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

    /**
     * Test of getCache method, of class EventServiceImpl.
     */
    //@Test
    public void testGetCache() {
        System.out.println("getCache");
        EventServiceImpl instance = new EventServiceImpl();
        DrugDataStore expResult = null;
        DrugDataStore result = instance.getCache();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCache method, of class EventServiceImpl.
     */
    //@Test
    public void testSetCache() {
        System.out.println("setCache");
        DrugDataStore cache = null;
        EventServiceImpl instance = new EventServiceImpl();
        instance.setCache(cache);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDrugsByName method, of class EventServiceImpl.
     */
    //@Test
    public void testGetDrugsByName() {
        System.out.println("getDrugsByName");
        String name = "";
        EventServiceImpl instance = new EventServiceImpl();
        List<Drug> expResult = null;
        List<Drug> result = instance.getDrugsByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Ignore//Test
    public void testGetLabelsFromOpenFda() {
        String drugName = "ASPIRIN";
        DrugLabelList result = servive.getLabels(drugName);
        DrugLabel label = result.getResults().get(0);
        assertEquals("00023ca2-4433-4f88-8252-bc8c1d7ea2e0", label.getSet_id());
    }
    /**
     * Test of getLabels method, of class EventServiceImpl.
     */
    @Test
    public void testGetLabelsFromFile() throws IOException {
        servive = mock(EventServiceImpl.class);
        Reader json = new InputStreamReader(ClassLoader.getSystemResource("json/label01.json").openStream());
        Gson gson = new Gson();
        DrugLabelList labels = gson.fromJson(json, DrugLabelList.class);
        String drugId = "myId";
        when(servive.getLabels(anyString())).thenReturn(labels);
     
        
        DrugLabelList result = servive.getLabels(drugId);
        DrugLabel label = result.getResults().get(0);
        assertEquals("00023ca2-4433-4f88-8252-bc8c1d7ea2e0", label.getSet_id());
        assertEquals("For the temporary relief of nasal decongestiom due to the commomn cold.", 
                label.getIndications_and_usage()[0]);
        assertEquals("Ephed 60", label.getOpenfda().getBrand_name().get(0));
   
    }

    /**
     * Test of findDrugByName method, of class EventServiceImpl.
     */
    //@Test
    public void testFindDrugByName() throws Exception {
        System.out.println("findDrugByName");
        String prefix = "";
        EventServiceImpl instance = new EventServiceImpl();
        List<Drug> expResult = null;
        List<Drug> result = instance.findDrugByName(prefix);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
