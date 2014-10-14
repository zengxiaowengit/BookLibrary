package dao;

import java.math.BigDecimal;
import java.util.*;

public class Book {
	private BigDecimal isbn;
	private String title;
	private BigDecimal authorID;
	private String publisher;
	private Date publishDate;
	private int price;
	
	public BigDecimal getIsbn() {
		return isbn;
	}
	public void setIsbn(BigDecimal isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public BigDecimal getAuthorID() {
		return authorID;
	}
	public void setAuthorID(BigDecimal authorID) {
		this.authorID = authorID;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
