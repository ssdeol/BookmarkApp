package com.ssdeol.bookmarkapp.controllers;

import com.ssdeol.bookmarkapp.entities.Bookmark;
import com.ssdeol.bookmarkapp.entities.User;
import com.ssdeol.bookmarkapp.managers.BookmarkManager;

public class BookmarkController {
	private static BookmarkController instance = new BookmarkController();
	private BookmarkController() {}
	
	public static BookmarkController getInstance() {
		return instance;
	}
	
	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
	}
}
