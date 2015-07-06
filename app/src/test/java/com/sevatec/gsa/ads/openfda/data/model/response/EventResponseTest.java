package com.sevatec.gsa.ads.openfda.data.model.response;

import com.owlike.genson.Genson;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gax
 */
public class EventResponseTest {
    
    public EventResponseTest() {
    }

    @Test
    public void testDeserialize() {
        Genson genson = new Genson();
        EventResponse deserialize = genson.deserialize(EventNode.class.getResourceAsStream("/event.json"), EventResponse.class);
        assertEquals(10, deserialize.getResults().size());
        assertEquals("US", deserialize.getResults().get(0).getPrimarysourcecountry());
    }
    
}
