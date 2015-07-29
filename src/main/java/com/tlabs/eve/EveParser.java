package com.tlabs.eve;

import java.io.IOException;
import java.io.InputStream;

public interface EveParser<T extends EveResponse> {

    T parse(InputStream in) throws IOException;

}
