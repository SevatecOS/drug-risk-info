package com.sevatec.gsa.ads.openfda.data.model.response;

import com.owlike.genson.Genson;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gax
 */
public class EventNodeTest {
    
    public EventNodeTest() {
    }

    @Test
    public void testDeserialize() {
        Genson genson = new Genson();
        EventNode deserialize = genson.deserialize(EventNode.class.getResourceAsStream("/event.json"), EventNode.class);
        assertEquals(10, deserialize.getResults().size());
    }
    
}
