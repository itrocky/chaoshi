package wyf.hxl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			   throws ServletException, IOException {
			  doPost(req,resp);
			 }
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			   throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = req.getSession(); //获得session对象
		PrintWriter out = resp.getWriter(); //获得输出流对象
		
	   PaginationBean handlePage = (PaginationBean)session.getAttribute("handlePage");
	   
	   if(handlePage==null){
		   handlePage = new PaginationBean();
		   session.setAttribute("handlePage", handlePage);
	   }
	   String action = req.getParameter("action");
	   if(action==null){return;}
	   if(action.equals("denglu")){
		   String cname = req.getParameter("zname");
		   String zpassword = req.getParameter("zpassword");
		   String sql = "select cname from gcustomer where cname='"+cname+"' and cpw='"+zpassword+"'";
		   boolean s = sqlUtils.selectMsg(sql);
		   if(s){
			   session.setAttribute("user", cname);
			   String fromWhere = (String)session.getAttribute("fromWhere");//从session中取出标志位
			   if(fromWhere!=null){
				   if(fromWhere.equals("jz")){
					   this.getServletContext().getRequestDispatcher("/CustomerServlet?action=jiezhang").forward(req, resp);
					   return;
				   }
				   else if(fromWhere.equals("wddd")){
					   this.getServletContext().getRequestDispatcher("/CustomerServlet?action=modify2").forward(req, resp);
					   return;
				   }
				   else if(fromWhere.equals("mmcz")){
					   this.getServletContext().getRequestDispatcher("/customerpwchange.jsp").forward(req, resp);
					   return;
				   }
			   }
			   this.getServletContext().getRequestDispatcher("/pagination.jsp").forward(req, resp);
		   }else{
			   String msg = "对不起，登陆失败，请重新登陆！！！";
			   req.setAttribute("msg", msg);
			   this.getServletContext().getRequestDispatcher("/customermanage.jsp").forward(req, resp);
		   }
		   
	   }
	
	
	
	
	
	
	
	
	}
}
