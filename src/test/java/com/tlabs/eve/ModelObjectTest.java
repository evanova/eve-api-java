package com.tlabs.eve;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.filters.FilterClassName;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.PojoValidator;
import com.openpojo.validation.rule.impl.NoPublicFieldsExceptStaticFinalRule;
import com.openpojo.validation.rule.impl.NoStaticExceptFinalRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.central.EveCentralParser;
import com.tlabs.eve.net.AbstractEveNetwork;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@RunWith(Parameterized.class)
public class ModelObjectTest {

    private static final PojoClassFilter filter = new PojoClassFilter() {
        private PojoClassFilter tests = new FilterClassName("^((?!Test$).)*$");
        private PojoClassFilter parsers = new FilterClassName("^((?!Parser$).)*$");
        @Override
        public boolean include(PojoClass pojoClass) {
            if (pojoClass.getClazz().equals(EveCentralParser.class)) {
                return false;
            }
            if (pojoClass.getClazz().equals(AbstractEveNetwork.class)) {
                return false;
            }
            if ((null != pojoClass.getClazz().getEnclosingClass()) && (EveParser.class.isAssignableFrom(pojoClass.getClazz().getEnclosingClass()))) {
                return false;
            }

            return tests.include(pojoClass);
        }
    };

    private static Collection<PojoClass> pojoClasses() {
        final List<PojoClass> pojoClasses = new LinkedList<>();

        pojoClasses.addAll(PojoClassFactory.getPojoClassesRecursively("com.tlabs.eve", filter));

        return pojoClasses;
    }

    private static PojoValidator pojoValidator;

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> parameters() {
        final List<Object[]> parameters = new LinkedList<>();
        for (PojoClass c: pojoClasses()) {
            parameters.add(new Object[]{c.getName(), c});
        }
        return parameters;
    }

    private final PojoClass pojoClass;

    public ModelObjectTest(final String name, final PojoClass pojoClass) {
        this.pojoClass = pojoClass;
    }

    @BeforeClass
    public static void beforeClass() {
        pojoValidator = new PojoValidator();
        pojoValidator.addRule(new NoStaticExceptFinalRule());

        //pojoValidator.addRule(new SerializableMustHaveSerialVersionUIDRule());
        pojoValidator.addRule(new NoPublicFieldsExceptStaticFinalRule());
        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
    }

    @Test
    public void testPojo() {
        pojoValidator.runValidation(pojoClass);
    }
}
