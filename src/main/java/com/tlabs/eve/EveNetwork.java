package com.tlabs.eve;

import rx.Observable;

public interface EveNetwork {

    <T extends EveResponse> Observable<T> execute(final EveRequest<T> request);
}
