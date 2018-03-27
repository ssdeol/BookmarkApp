# BookmarkApp

Overview:

This is a Java Application which simulates bookmarking books, links and movies on a website.

This project implements the MVC and Singleton design patterns and for some parts of the projects, Test Driven Development (TDD) process is used.

Project Specification:

This System will simulate 5 users and 15 bookmarks(5 Books, 5 links and 5 movies). The data for these users and bookmarks will be hardcoded in the project so we could simulate talking to some database.

Project Features:

-One user can bookmark up to 5 items. Duplicates are allowed.
-Restricting bookmarks by specifications. For example, kid friendly and only certain type of user would be able to use this feature, example would be (editor).
-Sharing the kid-friendly bookmarks with other websites. Can only be done by editor type users and only books and web-links can be shared. Movies not allowed.

Project Structure:

Model and Controller
View - View.java (Will simulate User Interface and actions taken by users)
Database - DataStore.java (Will simulate a database such as SQL)
Entities:
User, Bookmark, Book, Movie, Weblink

Note: This project is inspired from semanticsqaure.com 
