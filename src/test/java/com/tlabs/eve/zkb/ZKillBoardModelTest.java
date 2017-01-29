package com.tlabs.eve.zkb;

import com.openpojo.reflection.PojoClass;
import com.tlabs.eve.ModelObjectTest;
import org.junit.runners.Parameterized;

import java.util.Collection;

public class ZKillBoardModelTest extends ModelObjectTest {

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> parameters() {
        return parameters("com.tlabs.eve.zkb");
    }

    public ZKillBoardModelTest(String name, PojoClass pojoClass) {
        super(name, pojoClass);
    }
}
