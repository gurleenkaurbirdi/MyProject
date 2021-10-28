package gurleen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gurleen.dao.DB;
import gurleen.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet({ "/RegisterServlet", "/register" })
public class RegisterServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = new User();
		user.name= request.getParameter("txtName");
		user.age= Integer.parseInt(request.getParameter("txtAge"));
		//user.age= request.getParameter("textAge");
		user.email= request.getParameter("txtEmail");
		user.password= request.getParameter("txtPassword");
		user.phoneNumber= request.getParameter("txtPhone");
		user.makePasswordSecure();
		
		System.out.println(user);
	
		//logical operations and to send the response to the client
	   DB db = new DB();
	   response.setContentType("text/html");
	PrintWriter writer = response.getWriter();
	   
	   boolean result = db.RegisterUser(user);
	
	if(result) {
		System.out.println(" THANK YOU FOR THE REGISTRATION ");
		String message= "<html><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n"
    	   		+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
    	   		+ "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n"
    	   		+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n"
    	   		+ "\r\n"
    	   		+ "<body><center><br> <h3>Thank you "+user.email+"</h3><br> "
    			   +" <body style=\"background-color:PowderBlue;\">"
    	   		+" <a href=\"Home1.jsp\" class=\"btn btn-primary\" role=\"button\">ENTER DETAILS</a>"
    			   + "</center></body></html>";
           writer.println(message); 
	}
	
	else {
	
		String  message1 = "<html><body><center> OOPS! Something went wrong "
				           +"Try Again Later " 
				           +"</center></body></html>";
		writer.println(message1);
		
	}
	
	
	
	}

}
/*"<html><link rel=\\\"stylesheet\\\" href=\\\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\\\">\\r\\n\"\r\n"
				+ " \"  <script src=\\\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\\\"></script>\\r\\n\"\r\n"
				+ "	\"  <script src=\\\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\\\"></script>\\r\\n\"\r\n"
				+ " \"  <script src=\\\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\\\"></script>\\r\\n\"\r\n"
				+ " \"\\r\\n\"<body><center>  "
		   		+"<a href=\\\"Home.jsp\\\" class=\\\"btn btn-primary\\\" role=\\\"button\\\">ENTER HOME</a>"
				+ "</center></body></html>";*/
