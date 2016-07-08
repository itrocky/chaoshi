package wyf.hxl;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;
/** 
 * 
 * @author yu 
 * @since 2016-3-27 21:30 
 */ 

public class DBUtils {
	private  String url = "jdbc:mysql://localhost:3306/chaoshi";  
    private  String user = "root";  
    private  String psw = "1290869472";  
      
    private   Connection conn;  
    public DBUtils() {
		super();
		// TODO Auto-generated constructor stub
	}  
    static {  
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
            throw new RuntimeException(e);  
        }  
    }  
  
      
    /** 
     * 
     * @return conn 
     */  
    public Connection getConnection() {  
      
            try {  
                conn = DriverManager.getConnection(url, user, psw);  
            } catch (SQLException e) {  
                e.printStackTrace();  
                throw new RuntimeException(e);  
            }  
         
        return conn;  
    }  
      
	

	/** 
     * �ͷ���Դ 
     * @param conn 
     * @param pstmt 
     * @param rs 
     */  
    public  void closeResources(Connection conn,PreparedStatement pstmt,ResultSet rs) {  
        if(null != rs) {  
            try {  
                rs.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
                throw new RuntimeException(e);  
            } finally {  
                if(null != pstmt) {  
                    try {  
                        pstmt.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                        throw new RuntimeException(e);  
                    } finally {  
                        if(null != conn) {  
                            try {  
                                conn.close();  
                            } catch (SQLException e) {  
                                e.printStackTrace();  
                                throw new RuntimeException(e);  
                            }  
                        }  
                    }  
                }  
            }  
        }  
    }  
}
