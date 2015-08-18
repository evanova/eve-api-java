package com.tlabs.eve;

public interface EveNetwork {

    <T extends EveResponse> T execute(final EveRequest<T> request);
}
