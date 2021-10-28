package gurleen.dao;



import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCursor;

import gurleen.model.BMI;
import gurleen.model.User;




public class DB {
	MongoClient mongoClient;
	
	public DB() {
		
			try {
		
				//create the connection
		String connectionURL ="mongodb+srv://abcd:abcd@cluster0.3i1xy.mongodb.net/myFirstDatabase?retryWrites=true "; 
	    mongoClient= MongoClients.create(connectionURL);
	    System.out.println("[DB] connection created with mongodb");
	    
		
	} catch (Exception e) {
		
		System.out.println("Oops!Something Went Wrong "+e);
	}	
	}
	
	public boolean RegisterUser(User user){
		// to covert the data into the database || unboxing
		Document document = new Document(user.toMap());
		mongoClient.getDatabase("MyProject").getCollection("User").insertOne(document);
		System.out.println( user.name+"[REGISTERD] in mongodb");
		
		
		return true;
		
	}
	
	/*public boolean StoreBMI( BMI bmi){
		// to covert the data into the database || unboxing
		Document document = new Document(bmi.toMap());
		mongoClient.getDatabase("MyProject").getCollection("new").insertOne(document);
		System.out.println("[BMI STORED ] in mongodb");
		
		
		return true;
		
	}*/
	
	
	
	
	public boolean LoginUser( User user) {
		
		BasicDBObject query= new BasicDBObject();
	System.out.println("[BEFORE]"+user);
	
		query.put("email",user.email);
	    query.put("password", user.password);
		
		MongoCursor<Document>cursor = mongoClient.getDatabase("MyProject").getCollection("User").find(query).iterator();
		
		System.out.println("[DB] "+user);
		boolean flag= cursor.hasNext();
		if(flag) {
			
		Document document= cursor.next();
		System.out.println(document.getObjectId("_id"));
		System.out.println(document.getString("name"));
		System.out.println(document.getString("phoneNumber"));
		
		System.out.println(user);
		
		user._id =(document.getObjectId("_id").toString());		
		user.name= document.getString("name");
	    user.phoneNumber= document.getString("phoneNumber");
		//user.age=Integer.parseInt(document.getString("age"));
		//user.age= document.getString("age");
		
				System.out.println("[ 2. LOGIN AFTER] user ;"+user);
		
		}
		
		return flag;
	}
	
	public boolean LogBMI(BMI bmi) {
		// MongoDB Document which will convert the HashMap to the Document|| BOXING
    
    	Document document = new Document(bmi.toMap());
    
    	System.out.println(document);
    
    	//Insert into Database:
    	mongoClient.getDatabase("MyProject").getCollection("details").insertOne(document);
    	System.out.println(bmi.userId+" "+ bmi.height+ " Height Saved in MongoDB ");//check the mongoDB in the details Database
    	System.out.println(bmi.userId+" "+ bmi.weight+ " Weight Saved in MongoDB ");
    	System.out.println(bmi.userId+" "+ bmi.phoneNumber+ " PhoneNumber Saved in MongoDB ");
    	return true;
    	
	}	
	
	public ArrayList<BMI> fetchDetails(String userId){
		
		ArrayList<BMI> bmiRecords = new ArrayList<BMI>();
		
		try {
		BasicDBObject query = new BasicDBObject();
		query.put("userId",userId);
		System.out.print(userId);
		
		MongoCursor<Document>cursor= mongoClient.getDatabase("MyProject").getCollection("details").find(query).iterator();
        
		while(cursor.hasNext()) {
			
		Document document = cursor.next()	;

		BMI bmi = new BMI();
		
			bmi._id = document.getObjectId("_id").toString();
			bmi.userId= document.getString("userId");
			bmi.height= document.getInteger("height");
			bmi.weight= document.getDouble("weight");
			bmi.dateTime= document.getString("dateTime");
			bmi.yourBMI= document.getDouble("yourBMI");
			bmi.phoneNumber= document.getString("phoneNumber");
			System.out.print(bmi);
	       bmiRecords.add(bmi);
		
		
		}
			
		} catch (Exception e) {
			System.out.println("[2] Somethig Went Wrong"+e);
			
		}
		
		return bmiRecords;
		
		
	}

	
	 
	 
	 public void delete(String bmiId) {
			
			
			System.out.println("Deleting Weight "+bmiId);
			System.out.println("Deleting Height "+bmiId);
			BasicDBObject query = new BasicDBObject();
			query.put("_id", new ObjectId(bmiId));
			
			//Fetching the data
	    	mongoClient.getDatabase("MyProject").getCollection("details").deleteMany(query);
	    	
		}
	 
	 public boolean LoginClient(User user) {
			
			BasicDBObject query = new BasicDBObject();
			System.out.println("before "+user);
			query.put("phoneNumber", user.phoneNumber);
			//query.put("email", user.email);
			System.out.println("[DB] user = "+user);
			
			//Fetching the data
	   	MongoCursor<Document> cursor= mongoClient.getDatabase("MyProject").getCollection("details").find(query).iterator();
	   	//while(cursor.hasNext()) {
	   	//System.out.println(cursor.next());	
	   	
	   	boolean flag = cursor.hasNext();
	   	if(flag) {
	   	Document document = cursor.next();
	   	System.out.println(document.getObjectId("_id"));
	   //	System.out.println(document.getString("password"));
	   	
	   	user._id =(document.getObjectId("_id").toString());
	   	//user.password =( document.getString("password"));
	   	user.phoneNumber=( document.getString("phoneNumber"));
	   	System.out.println("user._id"+user._id);
	   	System.out.println(" USER USER USER "+ user.toString());
	   	}
	   	
	   	 
	   	
	   	//System.out.println(cursor.next().toJson());
	   	return flag;
	   	
		} 
	 
	 public ArrayList<BMI> fetchClients(String phoneNumber) {
			ArrayList<BMI> Records= new ArrayList<BMI>();
		   try {
			   BasicDBObject query = new BasicDBObject();
			   query.put("phoneNumber",phoneNumber);
			   
			   System.out.println("print query"+query.toString());
			   
			   
				MongoCursor<Document> cursor= mongoClient.getDatabase("MyProject").getCollection("details").find().iterator();
				while(cursor.hasNext()) {
					Document document = cursor.next();
					System.out.println("DOCUMENT "+document);
					BMI bmi = new BMI();
				        bmi._id= document.getObjectId("_id").toString();
				        System.out.println(document.getObjectId("_id"));  
				  bmi.phoneNumber=	document.getString("phoneNumber");
				   	bmi.userId= document.getString("userId").toString();
				   	bmi.height= document.getInteger("height");
				   	bmi.weight= document.getDouble("weight");
				   	bmi.dateTime= document.getString("dateTime");
					bmi.yourBMI= document.getDouble("yourBMI");
				   	Records.add(bmi);
				   	System.out.println("RECORDS reference variable "+Records);
				   	System.out.println("print height"+bmi.height);
				}
				
			} catch (Exception e) {
				System.out.println("[2] Somethig Went Wrong"+e);
			}
			
		  
		   return Records;
		}
			
	  /* public void updateDetails(String bmiId, Double weight, int height) {
	   BasicDBObject query = new BasicDBObject();
	   query.put("bmiId", bmiId);
	   
	  MongoCursor<Document> cursor= mongoClient.getDatabase("MyProject").getCollection("details").find(query).iterator();
 	 Document document = cursor.next();
   document.put("weight",weight);
   document.put("height", height);
 	//Insert into Database:
 	mongoClient.getDatabase("MyProject").getCollection("details").updateMany(query,document);
 	System.out.println(" Updated in mongodb");//check the mongoDB 
 		
 
} */
	 
	 public void updateDetails(String bmiId , Double weight, int height) {
			
			BasicDBObject query = new BasicDBObject();
			query.put("_id", new ObjectId(bmiId));
			
			System.out.println();
			
			System.out.println("bmiId"+bmiId);
			
			MongoCursor<Document> cursor = mongoClient.getDatabase("MyProject").getCollection("details").find(query).iterator();
			Document document = cursor.next();
			System.out.println(document.getObjectId("_id"));
			document.put("weight",weight);
			document.put("height",height);
			
			System.out.println("doc: "+document.toString());
			//Update into DataBase
			mongoClient.getDatabase("MyProject").getCollection("details").replaceOne(query, document);
			System.out.println("Details Updated");//check the mongoDB
			
		}
}
