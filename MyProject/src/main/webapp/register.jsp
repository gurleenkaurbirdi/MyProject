<%@page import="gurleen.dao.DB"%>
<%@page import="gurleen.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register</title>
</head>
<body>

<%!
DB db = new DB();
User user = new User();

%>
<% 
user.name= request.getParameter("txtName");
user.age= Integer.parseInt(request.getParameter("txtAge"));
//user.age= request.getParameter("txtAge");//
user.email= request.getParameter("txtEmail");
user.password= request.getParameter("txtPassword");

System.out.println(user); 


%>
	
	<% 
		response.setContentType("text/html");
	            response.getWriter();
		  
				boolean result= db.RegisterUser(user);
				if(result) {
					System.out.println(" THANK YOU FOR REGISTRATION ");
					out.println("Thank You "+user.email);	
				}else {
				
					out.println(" OOPS! Something went wrong ");
				}
%>
<a href="index.html">ENTER HOME</a>

</body>
</html>