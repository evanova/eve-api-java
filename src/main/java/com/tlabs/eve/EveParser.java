package com.tlabs.eve;

import java.io.IOException;
import java.io.InputStream;

public interface EveParser<T extends EveResponse> {

    public T parse(InputStream in) throws IOException;

}
