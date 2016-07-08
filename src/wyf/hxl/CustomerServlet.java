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
		   String zname = req.getParameter("zname");
		   String zpassword = req.getParameter("zpassword");
		   
	   }
	
	
	
	
	
	
	
	
	}
}
