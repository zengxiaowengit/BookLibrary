package impl;


import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import dao.DBConn;
import java.sql.Connection;
import java.sql.Statement;

public class reg{
	/**
	 * ‘]É‘Ìì√Ê°£
	 */
	
	public int register(String username,String password) throws Exception {
		int count = 0;
		DBConn dbConn = new DBConn();
		Connection conn = dbConn.getConn();
		Statement stmt = conn.createStatement();
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		String sqlString = "INSERT INTO user(username,password) "+" VALUES("+"'"+username+"','"+password+"')";
		count=stmt.executeUpdate(sqlString);
		dbConn.closeConn();
		if(stmt!=null)
			stmt.close();
		
		return count;
		
	}
}
