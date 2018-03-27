package com.ssdeol.bookmarkapp;

import com.ssdeol.bookmarkapp.constants.KidFriendlyStatus;
import com.ssdeol.bookmarkapp.constants.UserType;
import com.ssdeol.bookmarkapp.controllers.BookmarkController;
import com.ssdeol.bookmarkapp.entities.Bookmark;
import com.ssdeol.bookmarkapp.entities.User;

/**
 * In a real project, this class would simulate the User Interface. It will
 * simulate actions taken by a single user on the UI. Each method will simulate
 * an action that can be taken by the user such as bookmarking a link or an
 * editor marking something kid friendly. Methods in this class will be invoked
 * by the "Launch" class.
 */
public class View {

	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is bookmarking.");
		int bookmarkCount = 0;

		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						System.out.println("New Item Bookmarked " + bookmark);
					}
				}

				// Mark as kid-friendly
				if (user.getUserType().contentEquals(UserType.EDITOR)
						|| user.getUserType().contentEquals(UserType.CHIEF_EDITOR)) {
					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
						if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							bookmark.setKidFriendlyStatus(kidFriendlyStatus);
							System.out.println("Kid-Friendly Status: " + kidFriendlyStatus + ", " + bookmark);
						}
					}
				}
			}
		}
	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: (Math.random() >= 0.4 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN;
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;
	}
}
