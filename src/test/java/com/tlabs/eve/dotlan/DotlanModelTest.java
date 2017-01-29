package com.tlabs.eve.dotlan;

import com.openpojo.reflection.PojoClass;
import com.tlabs.eve.ModelObjectTest;
import org.junit.Ignore;
import org.junit.runners.Parameterized;

import java.util.Collection;

@Ignore
public class DotlanModelTest extends ModelObjectTest {

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> parameters() {
        return parameters("com.tlabs.eve.dotlan.model");
    }

    public DotlanModelTest(String name, PojoClass pojoClass) {
        super(name, pojoClass);
    }
}
