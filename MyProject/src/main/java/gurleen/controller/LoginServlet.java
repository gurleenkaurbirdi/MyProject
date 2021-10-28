package gurleen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gurleen.model.User;
import gurleen.dao.DB;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User user = new User();
		user.email = request.getParameter("txtEmail");
		user.password = request.getParameter("txtPassword");
		user.makePasswordSecure();
		 DB db = new DB();
	      boolean result =  db.LoginUser(user);
	        
	        
	        //[3] to send the response to the client
	        
	        response.setContentType("text/html");
	       PrintWriter writer= response.getWriter();
	       if(result) {
	    	  //to access the user everywhere in the project 
	    	   HttpSession session= request.getSession();
	    	   session.setAttribute("keyUser", user);
	    	   
	    	   String message= "<html><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n"
	    	   		+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
	    	   		+ "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n"
	    	   		+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n"
	    	   		+ "\r\n"
	    	   		+ "<body><center><br> <h3>Thank you "+user.name+"</h3><br> "
	    			   +" <body style=\"background-color:PowderBlue;\">"
	    	   		+" <a href=\"Home1.jsp\" class=\"btn btn-primary\" role=\"button\">ENTER DETAILS</a>"
	    			   + "</center></body></html>";
	           writer.println(message);
	         
	       }else {
	    	   String message= "<html><body><center> Oops! Something went wrong </center></body></html>";
	           writer.println(message);
	       }
	        
		
		
	}

}
    
    
    


