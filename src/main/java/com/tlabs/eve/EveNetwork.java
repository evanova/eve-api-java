package com.tlabs.eve;

public interface EveNetwork {

    <Q extends EveRequest<R>, R extends EveResponse> R execute(final Q request);
}
