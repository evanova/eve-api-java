package com.tlabs.eve.api;

import org.junit.Assert;
import org.junit.Test;
import com.tlabs.eve.EveTest;

public class SkillTreeRequestTest extends EveTest {

    @Test
    public void testSkillTreeRequest() {
        final SkillTreeResponse response = execute(new SkillTreeRequest());
        Assert.assertFalse(response.getSkillTree().getGroups().isEmpty());
    }
}
