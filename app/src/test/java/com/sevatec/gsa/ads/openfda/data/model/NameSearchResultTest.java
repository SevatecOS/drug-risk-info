package com.sevatec.gsa.ads.openfda.data.model;

import com.owlike.genson.Genson;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gax
 */
public class NameSearchResultTest {
    
    public NameSearchResultTest() {
    }

    @Test
    public void testSomeMethod() {
        NameSearchResult names = new NameSearchResult();
        names.addName("foo");
        names.addName("bar");
        Genson genson = new Genson();
        String result  = genson.serialize(names);
        System.out.println("--------------###>"+com.owlike.genson.Genson.class.getProtectionDomain().getCodeSource().getLocation());
        
        System.out.println(result);
        names = genson.deserialize(result, NameSearchResult.class);
        assertEquals(2, names.getNames().size());
    }
    
}
