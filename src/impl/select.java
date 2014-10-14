package impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.DBConn;

public class select{  
    
    /** 
     * 注册时检测功能 
     * @param userName 
     * @return 
     */  
    public int selectByName(String userName) {  
        int count=0;  
        try {  
            DBConn db = new DBConn();  
            Connection conn = db.getConn();  
            Statement stmt = conn.createStatement();  
          
            String sq20 = "SELECT count(*) FROM user WHERE username = "   
                + "'" + userName + "'";  
            //执行给定的 SQL 语句，该语句返回单个 ResultSet对象  
            ResultSet rs = stmt.executeQuery(sq20) ;  
            while(rs.next()){   
                count = rs.getInt(1);  
            }  
            if(rs != null){ // 关闭记录集  
                try{   
                    rs.close() ;   
                }catch(SQLException e){   
                    e.printStackTrace() ;  
                }   
            }   
            if(stmt != null){ // 关闭声明   
                try{  
                    stmt.close() ;   
                }catch(SQLException e){  
                    e.printStackTrace() ;  
                }  
            }   
            if(conn != null){ // 关闭连接对象  
                try{  
                    conn.close() ;  
                }catch(SQLException e){   
                    e.printStackTrace() ;   
                }  
            }  
            db.closeConn();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return count;  
    }
    
    /*
     @param userName 
     * @param passWord 
     * @return 
     * */
    public int selectStatement(String userName,String passWord) {  
        int count=0;  
        try {  
            DBConn db = new DBConn();  
            Connection conn = db.getConn();  
            Statement stmt = conn.createStatement() ;  
              
            String sq20 = "SELECT count(*) FROM user WHERE username = "   
                + "'" + userName + "' and password = '" + passWord + "'";  
              
            ResultSet rs = stmt.executeQuery(sq20) ;  
            while(rs.next()){   
                count = rs.getInt(1);  
            }  
            if(rs != null){ // 关闭记录集  
                try{   
                    rs.close() ;   
                }catch(SQLException e){   
                    e.printStackTrace() ;  
                }   
            }   
            if(stmt != null){ // 关闭声明   
                try{  
                    stmt.close() ;   
                }catch(SQLException e){  
                    e.printStackTrace() ;  
                }  
            }   
            if(conn != null){ // 关闭连接对象  
                try{  
                    conn.close() ;  
                }catch(SQLException e){   
                    e.printStackTrace() ;   
                }  
            }  
            db.closeConn();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return count;  
    }  
}
