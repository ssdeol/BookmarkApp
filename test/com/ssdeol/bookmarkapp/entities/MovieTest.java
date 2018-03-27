package com.ssdeol.bookmarkapp.entities;

import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Test;

import com.ssdeol.bookmarkapp.constants.MovieGenre;
import com.ssdeol.bookmarkapp.managers.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidFriendlyEligible() {
		// Test 1
		Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5);

		boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();

		assertFalse("For Horror Genre - isKidFriendlyEligible should return false", isKidFriendlyEligible);

		// Test 2
		movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5);

		isKidFriendlyEligible = movie.isKidFriendlyEligible();

		assertFalse("For Thrillers Genre - isKidFriendlyEligible should return false", isKidFriendlyEligible);

	}

}
