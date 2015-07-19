package com.tlabs.eve.api.corporation;

import com.tlabs.eve.api.BookmarksResponse;

public final class CorporationBookmarksRequest extends CorporationRequest<BookmarksResponse> {
    public CorporationBookmarksRequest(final String corpID) {
        super(BookmarksResponse.class, "/corp/Bookmarks.xml.aspx", 67108864, corpID);
    }
}
