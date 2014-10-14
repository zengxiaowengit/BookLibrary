package com;

import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import factory.AuthorDAOFactory;
public class AuthorAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private BigDecimal authorID;
	private String name;
	private String country;
	private int age;
	public String queryAuthor(BigDecimal authorID) throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		//String temp = request.getParameter("authorID");
		//BigDecimal authorID = new BigDecimal(temp);
		//System.out.println("读取到的authorID值是" + authorID);
		try {
			// Request对象
			request.setAttribute("authorInfo", AuthorDAOFactory
					.getAuthorDAOInstance().queryAuthor(authorID));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "authordetail";
	}
	public BigDecimal getAuthorID() {
		return authorID;
	}
	public void setAuthorID(BigDecimal authorID) {
		this.authorID = authorID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
