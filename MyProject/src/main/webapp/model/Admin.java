package gurleen.model;

import java.util.HashMap;
import java.util.Map;

public class Admin {
	public String _id;
	public String nameAdmin;
	public String email1Admin;
    public String passwordAdmin;
	
    public Admin() {
		 
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
