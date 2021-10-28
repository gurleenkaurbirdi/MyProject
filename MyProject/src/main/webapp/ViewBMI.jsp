<%@page import="gurleen.model.BMI"%>
<%@page import="java.util.ArrayList"%>
<%@page import="gurleen.dao.DB"%>
<%@page import="gurleen.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> view BMI</title>

 <body style="background-color:PowderBlue;">
 
</head>
<body>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous"></head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<%   

User user = (User)session.getAttribute("keyUser");
DB db = new DB();
%>

<div class="container">
  <h2>BMI Record</h2>
 <h4><%= user.name %>, Your Records till date are:</h4>    
  <table class="table table-dark">
    <thead>
      <tr>
        <th>Date Time</th>                                                                                                                                                                                                
        <th> Height</th>
        <th> Weight</th>
        <th> yourBMI</th>
        <th> Edit | Delete</th>
<%
ArrayList<BMI>details = db.fetchDetails(user._id);
for(BMI bmi: details){
	
	
%>

 <tr>                            <%--tr is the row --%>
        <td><%=bmi.dateTime%></td> <%--td are the coloumns i.e in this line i added the dateTime of the fever in the coloumn--%>
           <td><%= bmi.height %></td>
        <td><%= bmi.weight%></td>
        <td><%= bmi.yourBMI %></td>
     <td><a href='Action.jsp?action=update&bmiid=<%=bmi._id%>&weight=<%=bmi.weight%>&height=<%=bmi.height %>'><button class=""><i class="fa fa-edit"></i> </button></a> | <a href='actionDelete.jsp?action=delete&bmiid=<%=bmi._id%>'> <button class=""><i class="fa fa-trash"></i></button></a></td>
     </tr>  
   


	
<%	
	
}

%>


      </tr>
    </thead>
    <tbody>

</body>
</html>