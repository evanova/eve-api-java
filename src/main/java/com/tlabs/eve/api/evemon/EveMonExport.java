package com.tlabs.eve.api.evemon;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * 
 * ------------------------------------------------------------------------
 * %%
 * Copyright (C) 2011 - 2012 Traquenard Labs
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

import com.tlabs.eve.api.character.SkillInTraining;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public final class EveMonExport {
    private static final String ENTRY = "\n\t<entry skillID=\"%d\" skill=\"%s\" level=\"%d\" priority=\"%d\" type=\"%s\"/>";

    private EveMonExport() {
    }

    public static int export(final String title, final List<SkillInTraining> queue, final OutputStream out) throws IOException {

        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(out));
        w.write("<?xml version=\"1.0\"?>\n");
        w.write("<plan xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" name=\"" + title + "\" revision=\"3860\">");

        int priority = 0;
        for (SkillInTraining t : queue) {
            String type = null;
            switch (t.getType()) {
            case COMPLETED:
            case QUEUE:
                break;
            case PLAN:
                type = "Planned";
                break;
            }//switch
            if (null != type) {
                w.write(String.format(ENTRY, t.getSkillID(), t.getSkillName(), t.getSkillLevel(), priority, type));
                w.flush();
                priority++;
            }
        }
        w.write("\n</plan>");
        w.flush();
        return priority;
    }

}
