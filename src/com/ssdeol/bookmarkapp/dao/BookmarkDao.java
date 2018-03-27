package com.ssdeol.bookmarkapp.dao;

import com.ssdeol.bookmarkapp.DataStore;
import com.ssdeol.bookmarkapp.entities.Bookmark;
import com.ssdeol.bookmarkapp.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
	}
}
