package com.tlabs.eve.ccp;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * %%
 * Copyright (C) 2010 - 2012 Evanova (Traquenard Labs)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.io.IOException;
import java.util.Calendar;

import com.tlabs.eve.EveParser;
import com.tlabs.eve.api.EveAPI;

public abstract class ImageParser<T extends ImageResponse> implements EveParser<T> {

	protected abstract T createResponse();
		
	public T parse(byte[] data) throws IOException {		
		T response = createResponse();		
		response.setContent(data);
		
		Calendar now = EveAPI.getEveCalendar();
		if (data.length == 0) {
			//FIXME: arbitrary...
			now.add(Calendar.HOUR, 1);				
		}
		else {
			//FIXME: arbitrary...
			now.add(Calendar.DAY_OF_MONTH, 7);
		}
		response.setCachedUntil(now.getTimeInMillis());
		return response;
	}
}
