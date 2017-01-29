package com.tlabs.eve.api;

import com.openpojo.reflection.PojoClass;
import com.tlabs.eve.ModelObjectTest;
import org.junit.runners.Parameterized;

import java.util.Collection;

public class APIModelTest extends ModelObjectTest {

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> parameters() {
        return parameters("com.tlabs.eve.api");
    }

    public APIModelTest(String name, PojoClass pojoClass) {
        super(name, pojoClass);
    }
}
