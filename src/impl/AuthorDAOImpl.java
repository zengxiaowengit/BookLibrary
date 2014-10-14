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
			
			pstmt=dbc.getConn().prepareStatement(sql);//Ԥ����sql
			pstmt.setBigDecimal(1, authorID);
			ResultSet rs=pstmt.executeQuery();//ִ�в��������ؽ����
			while(rs.next())//ѭ����ȡ���
			{
				author=new Author();//ʵ����Book
				author.setAuthorID(rs.getBigDecimal(1));
				author.setName(rs.getString(2));
				author.setAge(rs.getInt(3));
				author.setCountry(rs.getString(4));
				list.add(author);//��book�����м��뵽list������
				
			}
		}
		catch(Exception e)
		{
			throw new Exception("��������!");
		}
		finally
		{
			dbc.closeConn();
		}
		return list;
	}
}
