package com;

import java.math.BigDecimal;
import java.sql.Date;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.Book;
import factory.BookDAOFactory;

public class bookAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private BigDecimal isbn;
	private String title;
	private BigDecimal authorID;
	private String publisher;
	private Date publishDate;
	private int price;

	// ���������ֲ�ԃbook
	public String queryByAuthor() throws Exception {
		String author = ServletActionContext.getRequest()
				.getParameter("author");
		System.out.println("��ȡ����authorֵ��"+author);
		try {
			// Request����
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("authorQuery", BookDAOFactory.getBookDAOInstance()
					.queryByAuthor(author));
			request.setAttribute("current_author", author);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "query";
	}
	
	public String queryByTitle() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//String title = ServletActionContext.getRequest()
			//	.getParameter("title");
		new String(request.getParameter("title").getBytes("UTF-8"),"UTF-8");
		System.out.println("��ȡ����titleֵ��"+title);
		try {
			// Request����
			List<Book> titleQuery = new ArrayList<Book>();
			titleQuery = BookDAOFactory.getBookDAOInstance()
					.queryByTitle(title);
			request.setAttribute("titleQuery",titleQuery);
			//��һ�����request
			Book book;
		Iterator<Book> it = titleQuery.iterator();
		if(it.hasNext()){
			book = it.next();
			authorID = book.getAuthorID();
			AuthorAction author = new AuthorAction();
			author.queryAuthor(authorID);
		}
			System.out.println("QueryByTitleִ����ϡ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "detail";
	}
	
	// ɾ���û�--��ʵ��
	public String delete() throws Exception {
		try {
			// ��ȡ���͹�����title

			String title = ServletActionContext.getRequest().getParameter(
					"title");
			BookDAOFactory.getBookDAOInstance().delete(title);
			
			//�ڲ�����
			System.out.println("deleteִ�����.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "delete";
	}
	

	public String revise()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		Book book = new Book();
		//����bookֵ��
		try{
			System.out.println("revise start");
		book.setIsbn(new BigDecimal(request.getParameter("isbn")));
			System.out.println("isbn");
		book.setTitle(request.getParameter("title"));
		book.setAuthorID(new BigDecimal(request.getParameter("authorID")));
		book.setPublisher(request.getParameter("publisher"));
			System.out.println("publisher");
		//book.setPublishDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("publishDate")));
		//	System.out.println("publishDate");
		book.setPrice(Integer.parseInt(request.getParameter("price")));
		System.out.println("price");
		BookDAOFactory.getBookDAOInstance().revise(book);
		System.out.println("book");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Reviseʧ�ܣ�");
		}
		return "revise";
	}
	
	public String revises() throws Exception{
		Map<String, Object> session = ActionContext.getContext()
				.getSession();
		session.put("titleMsg", ServletActionContext.getRequest().getParameter("title"));
		return "revises";
	}
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public BigDecimal getAuthorID() {
		return authorID;
	}

	public void setAuthorID(BigDecimal authorID) {
		this.authorID = authorID;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
