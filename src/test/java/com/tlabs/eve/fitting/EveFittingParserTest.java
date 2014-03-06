package com.tlabs.eve.fitting;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EveFittingParserTest {
        
    private static EveFittingResponse response;
    
    @BeforeClass
    public static void setupClass() throws Exception {
        response = parseFittings("/fittings.xml");
    }
    
    @Test
    public void testFittingsParser() throws IOException {
        Assert.assertEquals("Invalid number of fittings.", response.getShipFittings().size(), 2);
    }
    
    @Test
    public void testDescription() throws IOException {
        final ShipFitting fit = response.getShipFittings().get(0);
        Assert.assertEquals("My damp Drake", fit.getDescription());       
    }
    
    @Test
    public void testName() throws IOException {
        final ShipFitting fit = response.getShipFittings().get(0);
        Assert.assertEquals(fit.getName(), "Drake - Doctrine Damp Drake");
    }
    
    @Test
    public void testSlots() throws IOException {
        final ShipFitting fit = response.getShipFittings().get(0);

        assertSlot(fit, ShipFitting.Slot.Type.RIG, 0, "Medium Core Defense Field Extender I");
        assertSlot(fit, ShipFitting.Slot.Type.RIG, 1, "Medium Core Defense Field Extender I");
        assertSlot(fit, ShipFitting.Slot.Type.RIG, 2, "Medium Core Defense Field Extender I");
        
        assertSlot(fit, ShipFitting.Slot.Type.LOW, 0, "Damage Control II");
        assertSlot(fit, ShipFitting.Slot.Type.LOW, 1, "Ballistic Control System II");
        assertSlot(fit, ShipFitting.Slot.Type.LOW, 2, "Ballistic Control System II");
        assertSlot(fit, ShipFitting.Slot.Type.LOW, 3, "Nanofiber Internal Structure II");
        
        assertSlot(fit, ShipFitting.Slot.Type.MEDIUM, 0, "Experimental 10MN Microwarpdrive I");
        assertSlot(fit, ShipFitting.Slot.Type.MEDIUM, 1, "Stasis Webifier II");
        assertSlot(fit, ShipFitting.Slot.Type.MEDIUM, 2, "Warp Disruptor II");
        assertSlot(fit, ShipFitting.Slot.Type.MEDIUM, 3, "Warp Scrambler II");
        assertSlot(fit, ShipFitting.Slot.Type.MEDIUM, 4, "Large Shield Extender II");
        assertSlot(fit, ShipFitting.Slot.Type.MEDIUM, 5, "Large Shield Extender II");
        
        assertSlot(fit, ShipFitting.Slot.Type.HIGH, 0, "Heavy Missile Launcher II");
        assertSlot(fit, ShipFitting.Slot.Type.HIGH, 1, "Heavy Missile Launcher II");
        assertSlot(fit, ShipFitting.Slot.Type.HIGH, 2, "Heavy Missile Launcher II");
        assertSlot(fit, ShipFitting.Slot.Type.HIGH, 3, "Heavy Missile Launcher II");
        assertSlot(fit, ShipFitting.Slot.Type.HIGH, 4, "Heavy Missile Launcher II");
        assertSlot(fit, ShipFitting.Slot.Type.HIGH, 5, "Heavy Missile Launcher II");
        
    }
    
    private static EveFittingResponse parseFittings(final String resource) throws IOException {
        final InputStream in = EveFittingParserTest.class.getResourceAsStream(resource);
        try {
            return new EveFittingParser().parse(in);            
        }        
        finally {
            IOUtils.closeQuietly(in);
        }
    }
    
    private static void assertSlot(final ShipFitting fit, ShipFitting.Slot.Type slotType, int index, String itemName) {
        Assert.assertEquals(
                "Item Type Names don't match.",                
                itemName,
                fit.getSlot(slotType, index).getItemTypeName());
    }
}
