package dao;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
//这个class用于实现数据库的连接访问。
public class DBConn {
	private Connection conn;  
    /** 
     * 连接数据库 
     * @return 
     */  
    public Connection getConn(){  
        String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_zengxiaowen"; // 数据库地址[jdbc:mysql://<IP>:<db-port>/<db-name>]  
        String user = "oow10ny3o0"; // 数据库用户名  
        String pwd = "k30y1x21hljk1hmw0i52xzillxhzill2552y5z3y"; // 数据库密码
    	//String url = "jdbc:mysql://localhost:3306/BOOKDB";
    	//String user = "root";
    	//String pwd = "admin";
        try {  
            Class.forName("com.mysql.jdbc.Driver"); // 加载驱动  
            conn = DriverManager.getConnection(url, user, pwd);// 注册驱动程序  
            if (!conn.isClosed()) {  
                System.out.println("数据库连接成功");  
            }  
            if (conn == null) {  
                System.out.println("连接数据库失败，从检查后重新启动！");  
            }  
  
        } catch (ClassNotFoundException e) {  
        	System.out.println("Class NOT find...");
            e.printStackTrace();  
        } catch (SQLException e) {  
        	System.out.println("SQL Exception 30...");
            e.printStackTrace();  
        }  
        return conn;  
    }  
    /** 
     * 关闭数据库连接 
     */  
    public void closeConn(){  
        if(conn!=null) {  
            try{  
                conn.close();  
            }catch(Exception e){  
            	System.out.println("SQL Exception 43...");
                e.printStackTrace();  
            }  
        }  
    }  

}
