package com.tlabs.eve.api;

import org.junit.Assert;
import org.junit.Test;
import com.tlabs.eve.EveTest;

public class JournalReferenceTypeRequestTest extends EveTest {

    @Test
    public void testJournalReferenceTypeRequest() {
        final JournalReferenceTypeResponse response = execute(new JournalReferenceTypeRequest());
        Assert.assertFalse(response.getReferences().isEmpty());
    }
}
