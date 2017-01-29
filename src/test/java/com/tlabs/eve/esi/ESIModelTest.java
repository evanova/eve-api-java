package com.tlabs.eve.esi;

import com.openpojo.reflection.PojoClass;
import com.tlabs.eve.ModelObjectTest;
import org.junit.runners.Parameterized;

import java.util.Collection;

public class ESIModelTest extends ModelObjectTest {

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> parameters() {
        return parameters("com.tlabs.eve.esi.model");
    }

    public ESIModelTest(String name, PojoClass pojoClass) {
        super(name, pojoClass);
    }
}
