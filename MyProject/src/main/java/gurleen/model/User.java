package gurleen.model;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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




	public User( String _id , String name, int age, String email, String password,String phoneNumber) {

		this._id= _id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
		this.phoneNumber=phoneNumber;
		
	}
	
	public void makePasswordSecure() {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] byteOfSHA = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			
			BigInteger number = new BigInteger(1, byteOfSHA);
			
			StringBuilder passwordHexString = new StringBuilder(number.toString(16));
			
			while (passwordHexString.length() < 32) {
				
				passwordHexString.insert(0, '0');
			}
			
			password = passwordHexString.toString();
			
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
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
