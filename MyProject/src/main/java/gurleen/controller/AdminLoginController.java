package gurleen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gurleen.dao.DBAdmin;
import gurleen.model.Admin;


/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet({ "/AdminLoginController", "/logadmin" })
public class AdminLoginController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Admin admin= new Admin();
        admin.email1Admin = request.getParameter("txtEmail");
        admin.passwordAdmin= request.getParameter("txtPassword");
        System.out.println("[LOGIN ADMIN ] "+admin);
     admin.makePasswordSecure();
        System.out.println("password "+admin.passwordAdmin);
        // [2] Perform some Logical Operations 
        
        DBAdmin dba = new DBAdmin();
		
        response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		boolean result= dba.LoginAdmin(admin);
		if(result) {
			HttpSession session= request.getSession();
	    	   session.setAttribute("keyUser", admin);
			 String message= "<html><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n"
		    	   		+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
		    	   		+ "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n"
		    	   		+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n"
		    	   		+ "\r\n"
		    	   		+ "<body><center><br> <h3>Thank you "+admin.nameAdmin+"</h3><br> "
		    			   +" <body style=\"background-color:PowderBlue;\">"
		    	   		+" <a href=\"client.html\" class=\"btn btn-primary\" role=\"button\">ENTER CLIENT</a>"
		    			   + "</center></body></html>";
		           writer.println(message);	
		}else {
		String  message1 = "<html><body><center>[adminLogin]  OOPS! Something went wrong</center></body></html>";
			writer.println(message1);
				
		
}				//[3] to send the response to the client
		
		
		
	}

}
