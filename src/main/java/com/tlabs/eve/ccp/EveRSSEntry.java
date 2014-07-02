package com.tlabs.eve.ccp;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * 
 * ------------------------------------------------------------------------
 * %%
 * Copyright (C) 2011 - 2013 Traquenard Labs
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

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class EveRSSEntry implements Serializable {

    private static final long serialVersionUID = -8047807156394679404L;

    private String id;
    private String title;
    private long datePublished;
    private long dateUpdated;
    private String author;
    private String link;

    private String htmlContent;

    /* 
     <entry>
     <id>http://community.eveonline.com/news/news-channels/eve-online-news/eve-online-odyssey-1.1-has-been-deployed/</id>
     <title type="html">EVE Online: Odyssey 1.1 has been deployed!</title>
     <published>2013-09-03T11:29:41Z</published>
     <updated>2013-09-03T11:29:41Z</updated>
     <author>
       <name>CCP Falcon</name>
       <uri>92532650</uri>
     </author>
     <link rel="alternate" href="http://community.eveonline.com/news/news-channels/eve-online-news/eve-online-odyssey-1.1-has-been-deployed/" />
     <content type="html"><![CDATA[<p>
     EVE Online: Odyssey 1.1 has been succesfully deployed.</p>
    <p>
     This release brings a host of fixes along with new features and changes, including&nbsp;balancing of Mindlink implants and Warfare Link modules, as well as changes to medium turrets, energy vampire systems, Command Ships, Heavy Assault Cruisers and Industrials. A reorganization of the skill tree and changes to the names of several skill groups are also included as well as a number of improvements to the user interface and localization.</p>
    <p>
     Please see the full <a href="http://community.eveonline.com/news/patch-notes/patch-notes-for-odyssey-1.1">patch notes</a> for further details on the contents of the Odyssey 1.1 point release. More detailed information on specific changes is available in recent <a href="http://community.eveonline.com/news/dev-blogs/">dev blogs</a> from the EVE Dev Team.</p>
    <p>
     To report any issues you encounter, please <a href="https://forums.eveonline.com/default.aspx?g=posts&amp;m=3564755">use this thread</a>, and for general feedback please<a href="https://forums.eveonline.com/default.aspx?g=posts&amp;m=3564756"> post here.</a></p>
    ]]></content>
     <simple xmlns="http://ccp/custom">EVE Online: Odyssey 1.1 has been deployed!</simple>
     <unique xmlns="http://ccp/custom">eve-online-odyssey-1.1-has-been-deployed</unique>
    </entry>*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(long dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public long getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(long datePublished) {
        this.datePublished = datePublished;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = StringUtils.removeEnd(StringUtils.removeStart(htmlContent.trim(), "<![CDATA[").trim(), "]]>").trim();
    }

}
