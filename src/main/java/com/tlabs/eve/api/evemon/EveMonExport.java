package com.tlabs.eve.api.evemon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import com.tlabs.eve.api.character.SkillInTraining;

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
            switch (t.getTrainingType()) {
            case SkillInTraining.TYPE_COMPLETED:
            case SkillInTraining.TYPE_QUEUE:
                break;
            case SkillInTraining.TYPE_PLAN:
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
