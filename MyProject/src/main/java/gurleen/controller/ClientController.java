package gurleen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gurleen.dao.DB;
import gurleen.model.User;

;

/**
 * Servlet implementation class ClientController
 */
@WebServlet({ "/ClientController", "/client" })
public class ClientController extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = new User();
		user.email= request.getParameter("txtEmail");
		
		user.phoneNumber= request.getParameter("txtPhone");
		System.out.println("debugg no"+user.phoneNumber);
		System.out.println("debug name "+user.name);
		System.out.println("[CLIENT DETAILS] "+user);
		
		
      //  System.out.println("name  of the user is s"+user.name);
		
        
        DB db = new DB();
        
        boolean result =  db.LoginClient(user);
          
          
          //[3] to send the response to the client
          
          response.setContentType("text/html");
         PrintWriter writer= response.getWriter();
         if(result) {
      	  //to access the user everywhere in the project 
      	   HttpSession session= request.getSession();
      	  session.setAttribute("keyUser", user);
      	   System.out.println(" print user      "+user);
        	 
	    	   String message= "<html><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n"
	    	   		+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
	    	   		+ "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n"
	    	   		+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n"
	    	   		+ "\r\n"
	    	   		+ "<body><center><br> <h3>Thank you <br>"
	    	   		+ "client "+user.email+"    found"+"</h3><br> "
	    			   +" <body style=\"background-color:PowderBlue;\">"
	    	   		+" <a href=\"ViewClient.jsp\" class=\"btn btn-primary\" role=\"button\">VIEW RECORD</a>"
	    			   + "</center></body></html>";
	           writer.println(message);
         }else {
      	   String message= "<html><body><center> Oops! Something went wrong </center></body></html>";
             writer.println(message);
         }
          
         
        
		
		
		
		
	}

}
