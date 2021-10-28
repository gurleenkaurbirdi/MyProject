<%@page import="gurleen.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>

<%

User user= new User();
user.email = request.getParameter("txtEmail");
user.password= request.getParameter("txtPassword");
System.out.println("[LOGIN] "+user);

%>
<% 
 // DB db = new DB();
  //    boolean result =  db.LoginUser(user);
        
        
        //[3] to send the response to the client
        
       
      response.getWriter();
     //  if(result) {
    	  //to access the user everywhere in the project 
    //	 //  HttpSession session= request.getSession();
    	   session.setAttribute("keyUser", user);
    	   
    	   String message= "<html><body><center>  "
    	   		+"<a href= 'Home.jsp'> ENTER HOME</a>"
    			   + "</center></body></html>";
          
    			   out.println( " Thank you "+user.name);
         
     //  }else {
    	   
           out.println("Oops! Something went wrong");
    //   }
        
       

%>



</body>
</html>