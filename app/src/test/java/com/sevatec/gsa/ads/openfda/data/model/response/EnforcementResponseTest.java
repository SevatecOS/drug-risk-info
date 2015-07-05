package com.sevatec.gsa.ads.openfda.data.model.response;

import com.owlike.genson.Genson;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gax
 */
public class EnforcementResponseTest {
    
    public EnforcementResponseTest() {
    }

    @Test
    public void testDeserialize() {
        Genson genson = new Genson();
        EnforcementResponse deserialize = genson.deserialize(EventNode.class.getResourceAsStream("/enforcement.json"), EnforcementResponse.class);
        assertEquals(1, deserialize.getResults().size());
    }
    
}
