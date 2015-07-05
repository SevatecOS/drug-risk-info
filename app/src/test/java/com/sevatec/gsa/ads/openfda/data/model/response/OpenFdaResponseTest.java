package com.sevatec.gsa.ads.openfda.data.model.response;

import com.owlike.genson.Genson;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gax
 */
public class OpenFdaResponseTest {
    
    public OpenFdaResponseTest() {
    }

    @Test
    public void testDeserialize() {
        Genson genson = new Genson();
        OpenFdaResponse deserialize = genson.deserialize(OpenFdaResponse.class.getResourceAsStream("/label.json"), OpenFdaResponse.class);
        assertEquals(1, deserialize.getResults().size());
    }
    
}
