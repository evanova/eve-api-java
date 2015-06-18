package com.tlabs.eve.ccp;



import com.tlabs.eve.EveParser;
import com.tlabs.eve.api.EveAPI;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

public abstract class ImageParser<T extends ImageResponse> implements EveParser<T> {

    protected abstract T createResponse();

    public T parse(InputStream in) throws IOException {
        T response = createResponse();
        final byte[] data = IOUtils.toByteArray(in);
        response.setImageData(data);

        Calendar cached = EveAPI.getEveCalendar();
        if (data.length == 0) {
            //FIXME: arbitrary...
            cached.add(Calendar.MINUTE, 5);
        }
        else {
            //FIXME: arbitrary...
            cached.add(Calendar.DAY_OF_MONTH, 7);
        }
        response.setCachedUntil(cached.getTimeInMillis());
        return response;
    }
}
