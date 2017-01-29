package com.tlabs.eve.crest.impl;


import com.tlabs.eve.crest.model.CrestToken;

public interface CrestStore {

    void save(final CrestToken token);

    void delete(final String refresh);

    CrestToken get(final String refresh);

}
