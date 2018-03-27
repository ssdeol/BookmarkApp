package com.ssdeol.bookmarkapp;

import com.ssdeol.bookmarkapp.entities.Bookmark;
import com.ssdeol.bookmarkapp.entities.User;
import com.ssdeol.bookmarkapp.managers.BookmarkManager;
import com.ssdeol.bookmarkapp.managers.UserManager;

public class Launch {

	private static User[] users;
	private static Bookmark[][] bookmarks;
	
	public static void main(String[] args) {
		loadData();
		startBookmarking();
	}
	
	private static void loadData() {
		System.out.println("Loadind Data...");
		DataStore.loadData();
		
		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();
		
		System.out.println("Printing Data...");
		printUserData();
		printBookmarkData();
	}

	private static void printUserData() {
		for (User user: users) {
			System.out.println(user);
		}
	}
	
	private static void printBookmarkData() {
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				System.out.println(bookmark);
			}
		}
	}
	
	private static void startBookmarking() {
		System.out.println("\n2. Bookmarking...");
		for(User user : users) {
			View.bookmark(user, bookmarks);
		}
	}

}
