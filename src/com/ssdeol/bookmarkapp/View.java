package com.ssdeol.bookmarkapp;

import com.ssdeol.bookmarkapp.controllers.BookmarkController;
import com.ssdeol.bookmarkapp.entities.Bookmark;
import com.ssdeol.bookmarkapp.entities.User;

/**
 * In a real project, this class would simulate the User Interface.
 * It will simulate actions taken by a single user on the UI.
 * Each method will simulate an action that can be taken by the user such as bookmarking a link or an editor marking something kid friendly.
 * Methods in this class will be invoked by the "Launch" class. 
 */
public class View {
	
	/**
	 * 
	 * @param user - The user that is marking the bookmarks
	 * @param bookmarks - The bookmarks available to the user.
	 * 
	 * In this method, the user will be given a list of bookmarks of different types and user would randomly pick and bookmark the items.
	 */
	public static void bookmark(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is bookmarking.");
		for (int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
			
			// Randomize to simulate different User Inputs 
			// type will be: book, movie, link
			// bookmark will be list of the products available.
			int typeOffset = (int)(Math.random() * DataStore.BOOKMARK_TYPE_COUNT);
			int bookmarkOffset = (int)(Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
			Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
			
			BookmarkController.getInstance().saveUserBookmark(user, bookmark);
			
			System.out.println(bookmark);
		}
	}
}
