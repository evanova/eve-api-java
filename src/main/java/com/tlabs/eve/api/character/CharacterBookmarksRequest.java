package com.tlabs.eve.api.character;

import com.tlabs.eve.api.BookmarksResponse;

public final class CharacterBookmarksRequest extends CharacterRequest<BookmarksResponse> {
    public CharacterBookmarksRequest(final String characterID) {
        super(BookmarksResponse.class, "/char/Bookmarks.xml.aspx", 268435456 , characterID);
    }
}
