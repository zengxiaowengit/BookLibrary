package dao;

import java.math.BigDecimal;


public class Author {
	private BigDecimal AuthorID;
	private String Name;
	private	int Age;
	private String	Country;
	public BigDecimal getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(BigDecimal authorID) {
		AuthorID = authorID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
}
