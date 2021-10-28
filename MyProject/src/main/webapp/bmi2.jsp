<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BMI calculator</title>
</head>
<body>
<script language="JavaScript">

function calculateBmi() {
var weight = document.bmiForm.weight.value
var height = document.bmiForm.height.value
let fun;
if(weight > 0 && height > 0){	
var finalBmi = weight/(height/100*height/100)
document.bmiForm.bmi.value = finalBmi
if(finalBmi < 18.5){
document.bmiForm.meaning.value = "THIN(UNDERWEIGHT)"
fun="<html><body><center>Check your Video</center><body><html>"
+"<a href= 'video.jsp'>video thin</a>"
+"</center></body></html>"
}
if(finalBmi > 18.5 && finalBmi < 25){
document.bmiForm.meaning.value = "HEALTHY"
fun=fun="<html><body><center>Check your healthy</center><body><html>"
	+"<a href= 'video.jsp'>video healthy</a>"
	+"</center></body></html>"

}
if(finalBmi > 25){
document.bmiForm.meaning.value = "OVERWEIGHT"
	fun=fun="<html><body><center>Check your healthy</center><body><html>"
		+"<a href= 'video.jsp'>video healthy</a>"
		+"</center></body></html>"
}
}
else{
alert("Please Fill in everything correctly")
}
}

</script>
</head>

<body>
<center>

<h3> BMI CALCULATOR </h3>

<form name="bmiForm">
 <form action="auth" method="post">
Your Weight(kg): <input type="text" name="weight" size="10"><br />
<br>
Your Height(cm): <input type="text" name="height" size="10"><br />
<br>
<input type="button" value="Calculate BMI" onClick="calculateBmi()"><br />
<br>
Your BMI: <input type="text" name="bmi" size="10"><br />
<br>
This Means: <input type="text" name="meaning" size="25"><br />
<br>
<input type="reset" value="Reset" />
<button type="submit" class="btn btn-primary">submit</button>
</form>

</form>















<!--  
<form name="bmiForm">

Your Weight(kg): <input type="text" name="weight" size="10"><br />
<br>
Your Height(cm): <input type="text" name="height" size="10"><br />
<br>
<input type="button" value="Calculate BMI" onClick="calculateBmi()"><br />
<br>
Your BMI: <input type="text" name="bmi" size="10"><br />
<br>
This Means: <input type="text" name="meaning" size="25"><br />
<br>
<input type="text" name="meaning" size="25"><br />
<button type="submit" class="btn btn-primary">submit</button>

</form>

</form>-->
<!--  <a href="auth"> Don't have an account? sign up</a>-->

</center>

</body>
</html>
</body>
</html>