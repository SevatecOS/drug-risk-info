package com.sevatec.drugriskinfo.openfda.api;

import org.junit.*;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author gax
 */
abstract public class AbstractBaseTest {
    @Before 
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
}
