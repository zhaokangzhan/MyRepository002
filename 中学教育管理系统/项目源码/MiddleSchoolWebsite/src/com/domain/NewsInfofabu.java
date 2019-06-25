package com.domain;

public class NewsInfofabu {
	private String title;
	private String content;
	private String imagepath;
	public NewsInfofabu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewsInfofabu(String title, String content, String imagepath) {
		super();
		this.title = title;
		this.content = content;
		this.imagepath = imagepath;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
}
