package gurleen.model;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Admin {

	 public String _id;
		public String nameAdmin;
		public String email1Admin;
	    public String passwordAdmin;
		
	    public Admin() {
			 
	    }
	    
	    public void makePasswordSecure() {
			try {
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				byte[] byteOfSHA = digest.digest(passwordAdmin.getBytes(StandardCharsets.UTF_8));
				
				BigInteger number = new BigInteger(1, byteOfSHA);
				
				StringBuilder passwordHexString = new StringBuilder(number.toString(16));
				
				while (passwordHexString.length() < 32) {
					
					passwordHexString.insert(0, '0');
				}
				
				passwordAdmin = passwordHexString.toString();
				
				
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
	    
	    
	    
	    
	   
		
	    
	    
	    @Override
		public String toString() {
			return "Admin [_id=" + _id + ", nameAdmin=" + nameAdmin + ", email1Admin=" + email1Admin + ", passwordAdmin="
					+ passwordAdmin + "]";
		}





		public Admin(String _id ,String nameAdmin, String email1Admin, String passwordAdmin) {
			this._id= _id;
			this.nameAdmin = nameAdmin;
			this.email1Admin = email1Admin;
			this.passwordAdmin = passwordAdmin;
		}  
		
		
	    public Map<String, Object> toMap(){
	  	  Map<String,Object> map= new HashMap<String, Object>();
	  	  map.put("name", nameAdmin);
	  	  map.put("email", email1Admin);
	  	  map.put("password",passwordAdmin);
	  	  
	  	  return map;
	    }


		
	
}
