package com.ssdeol.bookmarkapp.managers;

import com.ssdeol.bookmarkapp.dao.BookmarkDao;
import com.ssdeol.bookmarkapp.entities.Book;
import com.ssdeol.bookmarkapp.entities.Bookmark;
import com.ssdeol.bookmarkapp.entities.Movie;
import com.ssdeol.bookmarkapp.entities.UserBookmark;
import com.ssdeol.bookmarkapp.entities.Weblink;
import com.ssdeol.bookmarkapp.entities.User;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao dao = new BookmarkDao();
	private BookmarkManager() {
	}

	public static BookmarkManager getInstance() {
		return instance;
	}

	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, String genre, double imbdRating) {
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImbdRating(imbdRating);

		return movie;
	}

	public Book createBook(long id, String title, int publicationYear, String publisher, String[] authors, String genre, double amazonRating) {
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);
		
		return book;
	}
	
	public Weblink createWeblink(long id, String title, String url, String host) {
		Weblink weblink = new Weblink();
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setUrl(url);
		weblink.setHost(host);
		
		return weblink;
	}
	
	public Bookmark[][] getBookmarks(){
		return dao.getBookmarks();
	}
	
	public void saveUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);
		
		dao.saveUserBookmark(userBookmark);
	}
}
