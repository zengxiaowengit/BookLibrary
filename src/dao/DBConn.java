package dao;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
//���class����ʵ�����ݿ�����ӷ��ʡ�
public class DBConn {
	private Connection conn;  
    /** 
     * �������ݿ� 
     * @return 
     */  
    public Connection getConn(){  
        String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_zengxiaowen"; // ���ݿ��ַ[jdbc:mysql://<IP>:<db-port>/<db-name>]  
        String user = "oow10ny3o0"; // ���ݿ��û���  
        String pwd = "k30y1x21hljk1hmw0i52xzillxhzill2552y5z3y"; // ���ݿ�����
    	//String url = "jdbc:mysql://localhost:3306/BOOKDB";
    	//String user = "root";
    	//String pwd = "admin";
        try {  
            Class.forName("com.mysql.jdbc.Driver"); // ��������  
            conn = DriverManager.getConnection(url, user, pwd);// ע����������  
            if (!conn.isClosed()) {  
                System.out.println("���ݿ����ӳɹ�");  
            }  
            if (conn == null) {  
                System.out.println("�������ݿ�ʧ�ܣ��Ӽ�������������");  
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
     * �ر����ݿ����� 
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
