package com.sitaram.bookshare.features.product.helper;

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

	public void setDate(String date) {
		this.date = date;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setImage(int image) {
		this.image = image;
	}
}
