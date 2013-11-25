package com.mbau.miniproject5;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Image")
public class Image extends ParseObject {

	public Image() {
		// A default constructor is required.
	}
	
	public String getTitle() {
		return getString("title");
	}

	public void setTitle(String title) {
		put("title", title);
	}
	
	public String getUser() {
		return getString("username");
	}
	
	public void setUser(String username) {
		put("username", username);
	}

	public ParseUser getAuthor() {
		return getParseUser("author");
	}

	public void setAuthor(ParseUser user) {
		put("author", user);
	}

	public ParseFile getPhotoFile() {
		return getParseFile("photo");
	}

	public void setPhotoFile(ParseFile file) {
		put("photo", file);
	}

}
