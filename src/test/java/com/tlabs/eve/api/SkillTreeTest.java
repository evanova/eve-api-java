package com.tlabs.eve.api;



import com.tlabs.eve.api.SkillTree.SkillGroup;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SkillTreeTest extends EveApiTest {

    @Test(timeout = 10000)
    public void testSkillTreeParser() throws Exception {
        SkillTreeResponse r = apiCall(new SkillTreeRequest());
        Assert.assertNotNull("Null response", r);

        SkillTree tree = r.getSkillTree();
        Assert.assertNotNull("Null Skill Tree", tree);

        List<SkillGroup> all = tree.getGroups();
        Assert.assertTrue("No SkillTree.Certificate", all.size() > 0);

        /*for (SkillGroup g: all) {
        	System.out.println(
        			ToStringBuilder.reflectionToString(g, ToStringStyle.SIMPLE_STYLE));
        }*/
    }
}
