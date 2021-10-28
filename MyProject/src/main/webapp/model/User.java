package gurleen.model;

import java.util.HashMap;
import java.util.Map;

public class User {

public String _id;
public 	String name;
public	int age;
//public String age;
public 	String email;
public 	String password;
public String phoneNumber;

public User() {

}




public User( String _id , String name, int age, String email, String password) {

	this._id= _id;
	this.name = name;
	this.age = age;
	this.email = email;
	this.password = password;
	this.phoneNumber= phoneNumber;
}
	
public Map<String,Object> toMap(){
	Map<String,Object> map= new HashMap<String,Object>();
	map.put("name", name);
	map.put("age", age);
	map.put("email", email);
	map.put("password",password);
	map.put("phoneNumber", phoneNumber);
	return map;
	
	
	
}




@Override
public String toString() {
	return "User [_id=" + _id + ", name=" + name + ", age=" + age + ", email=" + email + ", password=" + password
			+ ", phoneNumber=" + phoneNumber + "]";
}









}
