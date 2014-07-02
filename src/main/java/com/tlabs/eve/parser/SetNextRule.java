package com.tlabs.eve.parser;

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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SetNextRule extends BaseRule {
    private static final Log LOG = LogFactory.getLog("CREST");

    private String methodName;

    public SetNextRule(String methodName) {
        super();
        this.methodName = methodName;
    }

    @Override
    public void doEnd(String name) {
        Object toSet = getDigester().peek(0);
        Object bean = getDigester().peek(1);

        try {
            Method addMethod = bean.getClass().getMethod(this.methodName, toSet.getClass());
            addMethod.invoke(bean, toSet);
        }
        catch (NoSuchMethodException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(e.getLocalizedMessage(), e);
            }
            LOG.warn(bean.getClass().getSimpleName() + " NoSuchMethodException:" + e.getLocalizedMessage() + "(" + toSet.getClass() + ")");
        }
        catch (InvocationTargetException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(e.getLocalizedMessage(), e);
            }
            LOG.warn(bean.getClass().getSimpleName() + " InvocationTargetException:" + e.getLocalizedMessage() + "(" + toSet.getClass() + ")");
        }
        catch (IllegalAccessException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(e.getLocalizedMessage(), e);
            }
            LOG.warn(bean.getClass().getSimpleName() + " IllegalAccessException:" + e.getLocalizedMessage() + "(" + toSet.getClass() + ")");
        }
    }

}
