package com.example.bookshare.features.book.helper;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BooksItem implements Serializable {

	@SerializedName("date")
	private String date;
	@SerializedName("author")
	private String author;
	@SerializedName("price")
	private int price;
	@SerializedName("rating")
	private int rating;
	@SerializedName("id")
	private String id;
	@SerializedName("detail")
	private String detail;
	@SerializedName("title")
	private String title;
	@SerializedName("url")
	private String url;

	@SerializedName("image")
	private int image;

	// getter methods
	public String getDate(){
		return date;
	}

	public String getAuthor(){
		return author;
	}

	public int getPrice(){
		return price;
	}

	public int getRating(){
		return rating;
	}

	public String getId(){
		return id;
	}

	public String getDetail(){
		return detail;
	}

	public String getTitle(){
		return title;
	}

	public String getUrl(){
		return url;
	}

}
