package wyf.hxl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;

public class sqlUtils {
	
	//判断查询是否存在
	public static boolean selectMsg(String sql)
	{
		boolean flag = false;
		try
		{	
			Context initial = new InitialContext();//初始化上下文  
            //其中mysql为数据源jndi名称    
			 DBUtils db = new  DBUtils();
            Connection con=db.getConnection();//得到连接
            Statement st = con.createStatement();//声明语句
            ResultSet rs = st.executeQuery(sql); //执行语句得到结果集
            if(rs.next())
            {
            	flag = true;
            }			
            rs.close();//关闭结果集
            st.close();//关闭语句
            con.close();//归还连接
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}

}
