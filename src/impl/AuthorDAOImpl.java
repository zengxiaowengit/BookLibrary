package impl;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dao.Author;
import dao.AuthorDAO;
import dao.DBConn;

public class AuthorDAOImpl implements AuthorDAO{
	
	public List<Author> queryAuthor(BigDecimal authorID) throws Exception {
		List<Author> list=new ArrayList<Author>();
		Author author=null;
		String sql="select * from Author where AuthorID=?";
		PreparedStatement pstmt=null;
		DBConn dbc=null;
		dbc=new DBConn();
		try
		{
			
			pstmt=dbc.getConn().prepareStatement(sql);//预编译sql
			pstmt.setBigDecimal(1, authorID);
			ResultSet rs=pstmt.executeQuery();//执行操作，返回结果集
			while(rs.next())//循环读取结果
			{
				author=new Author();//实例化Book
				author.setAuthorID(rs.getBigDecimal(1));
				author.setName(rs.getString(2));
				author.setAge(rs.getInt(3));
				author.setCountry(rs.getString(4));
				list.add(author);//将book对象中加入到list集合中
				
			}
		}
		catch(Exception e)
		{
			throw new Exception("操作错误!");
		}
		finally
		{
			dbc.closeConn();
		}
		return list;
	}
}
