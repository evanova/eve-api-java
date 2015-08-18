package com.tlabs.eve;

import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import com.tlabs.eve.net.DefaultEveNetwork;

public class EveTest {

    private static EveNetwork eve;

    @ClassRule
    public static ExternalResource resource= new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            eve = new DefaultEveNetwork();
        }

        @Override
        protected void after() {
            eve = null;
        }
    };

    protected <T extends EveResponse> T execute(final EveRequest<T> request) {
        return eve.execute(request).toBlocking().last();
    }
}
