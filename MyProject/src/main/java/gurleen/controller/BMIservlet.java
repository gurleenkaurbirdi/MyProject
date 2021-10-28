/*package gurleen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gurleen.dao.DB;
import gurleen.model.BMI;
import gurleen.model.User;

/**
 * Servlet implementation class BMIservlet
 */
/*@WebServlet({ "/BMIservlet", "/auth" })
public class BMIservlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BMI bmi = new BMI();
		bmi.weight= Double.parseDouble(request.getParameter("weight"));
		bmi.height= Integer.parseInt(request.getParameter("height"));
		//user.age= request.getParameter("textAge");
		bmi.yourBMI= Double.parseDouble(request.getParameter("bmi"));
		
		
		System.out.println(bmi);
	
		//logical operations and to send the response to the client
	   DB db = new DB();
	   response.setContentType("text/html");
	PrintWriter writer = response.getWriter();
	   
	   boolean result = db.StoreBMI(bmi);
	 
	if(result) {
		System.out.println(" THANK YOU ");
		String  message = "<html><body><center> Your BMI is "+bmi.yourBMI+"</center></body></html>";
		writer.println(message);
		
		User user= new User();
		   HttpSession session= request.getSession();
		   session.setAttribute("keyUser", user);
		   
		   String message1= "<html><body><center> Thank you "+user.name+"<br> "
		   		+"<a href= 'Home.jsp'> ENTER HOME</a>"
				   + "</center></body></html>";
	       writer.println(message1);
	     
	}
	
	else {
	
		String  message1 = "<html><body><center> OOPS! Something went wrong "
				           +"Try Again Later " 
				           +"</center></body></html>";
		writer.println(message1);
		
	}
	
	
	
	}	
		
		
	}*/


