package com.ssdeol.bookmarkapp.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import com.ssdeol.bookmarkapp.managers.BookmarkManager;

class WeblinkTest {

	@Test
	void testIsKidFriendlyEligible() {
		// Test 1: Porn in url -> false
		Weblink weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
				"http://www.javaworld.com");
		
		boolean isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertFalse("For porn in url - isKidFriendlyEligible() must return false", isKidFriendlyEligible);
		
		// Test 2: Porn in title -> false
		weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, porn 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertFalse("For porn in title - isKidFriendlyEligible() must return false", isKidFriendlyEligible);
		
		// Test 3: Adult in host -> false
		weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld-adult.com");
		
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertFalse("For adult in host - isKidFriendlyEligible() must return false", isKidFriendlyEligible);

		// Test 4: Adult in url, but not in host part -> true
		weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/adult/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertTrue("For adult in url but not host part- isKidFriendlyEligible() must return true", isKidFriendlyEligible);
		
		// Test 5: adult in title only -> true
		weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming Adult Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertTrue("For adult in title- isKidFriendlyEligible() must return true", isKidFriendlyEligible);
	}

}
