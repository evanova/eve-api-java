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
import com.tlabs.eve.net.AbstractEveNetwork;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public abstract class ModelObjectTest {

    private static final PojoClassFilter filter = new PojoClassFilter() {
        private final PojoClassFilter tests = new FilterClassName("^((?!Test$).)*$");
        private final PojoClassFilter parsers = new FilterClassName("^((?!Parser$).)*$");
        private final PojoClassFilter res = new FilterClassName("^((?!Resource).)*$");

        @Override
        public boolean include(PojoClass pojoClass) {
            if (pojoClass.getClazz().equals(AbstractEveNetwork.class)) {
                return false;
            }
            if ((null != pojoClass.getClazz().getEnclosingClass()) && (EveParser.class.isAssignableFrom(pojoClass.getClazz().getEnclosingClass()))) {
                return false;
            }

            return tests.include(pojoClass) && parsers.include(pojoClass) && res.include(pojoClass);
        }
    };

    protected static List<Object[]> parameters(final String... packageName) {
        final List<PojoClass> pojoClasses = new ArrayList<>();
        for (String p: packageName) {
            pojoClasses.addAll(PojoClassFactory.getPojoClassesRecursively(p, filter));
        }
        return parameters(pojoClasses);
    }

    protected static List<Object[]> parameters(final Class... classes) {
        final List<PojoClass> pojoClasses = new ArrayList<>();
        for (Class c: classes) {
            pojoClasses.add(PojoClassFactory.getPojoClass(c));
        }
        return parameters(pojoClasses);
    }

    protected static List<Object[]> parameters(final List<PojoClass> pojoClasses) {
        final List<Object[]> parameters = new ArrayList<>();
        for (PojoClass c: pojoClasses) {
            parameters.add(new Object[]{c.getName(), c});
        }
        return parameters;
    }

    private static PojoValidator pojoValidator;
    private final PojoClass pojoClass;

    public ModelObjectTest(final String name, final PojoClass pojoClass) {
        this.pojoClass = pojoClass;
    }

    @BeforeClass
    public static void beforeClass() {
        pojoValidator = new PojoValidator();
        pojoValidator.addRule(new NoStaticExceptFinalRule());

        pojoValidator.addRule(new NoPublicFieldsExceptStaticFinalRule());
        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
    }

    @Test
    public void testPojo() {
        pojoValidator.runValidation(pojoClass);
    }
}
