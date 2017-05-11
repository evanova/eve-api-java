package com.tlabs.eve.net;

import java.util.HashMap;
import java.util.Map;

public interface EveStore {

    EveStore DEFAULT = new EveStore() {
        private Map<String, EveToken> map = new HashMap<>();

        @Override
        public void save(EveToken token) {
            this.map.put(token.getRefreshToken(), token);
        }

        @Override
        public void delete(String refresh) {
            this.map.remove(refresh);
        }

        @Override
        public EveToken get(String refresh) {
            return this.map.get(refresh);
        }
    };


    void save(final EveToken token);

    void delete(final String refresh);

    EveToken get(final String refresh);

}
