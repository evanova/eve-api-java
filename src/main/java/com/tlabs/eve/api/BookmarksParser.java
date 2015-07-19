package com.tlabs.eve.api;


import com.tlabs.eve.parser.SetAttributePropertyRule;

import org.apache.commons.digester.Digester;

//https://developers.eveonline.com/blog/article/adding-bookmarks-to-the-api
public class BookmarksParser extends EveAPIParser<BookmarksResponse> {

    public BookmarksParser() {
        super(BookmarksResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", Bookmark.Folder.class);
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());

        digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", Bookmark.class);
        digester.addRule("eveapi/result/rowset/row/rowset/row", new SetAttributePropertyRule());
        /*<?xml version="1.0" encoding="UTF-8"?>
-<eveapi version="2"><currentTime>2015-07-08 21:42:12</currentTime>-<result>-<rowset columns="folderName,creatorID" key="folderID" name="folders">-<row creatorID="0" folderName="" folderID="0">+<rowset columns="creatorID,created,itemID,typeID,locationID,x,y,z,memo,note" key="bookmarkID" name="bookmarks"></row>+<row creatorID="90000001" folderName="A lovely empty folder" folderID="1">+<row creatorID="90000001" folderName="Sites" folderID="3">-+<row creatorID="90000001" folderName="Random crap" folderID="4">-</rowset></result><cachedUntil>2015-07-08 22:42:12</cachedUntil></eveapi>*/
    }
}
