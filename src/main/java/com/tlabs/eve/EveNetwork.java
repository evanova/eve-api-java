package com.tlabs.eve;

public interface EveNetwork {

    <R extends EveResponse, Q extends EveRequest<R>> R execute(final Q request);
}
