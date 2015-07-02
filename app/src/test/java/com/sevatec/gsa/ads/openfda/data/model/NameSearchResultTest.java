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
        Genson genson = new Genson();
        String result  = genson.serialize(names);
        System.out.println(result);
    }
    
}
