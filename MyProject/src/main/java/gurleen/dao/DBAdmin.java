package gurleen.dao;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCursor;

import gurleen.model.Admin;



public class DBAdmin {

	
		MongoClient mongoClient;
		
		public DBAdmin() {
		try {
			
			String connectionURL = "mongodb+srv://abcd:abcd@cluster0.3i1xy.mongodb.net/myFirstDatabase?retryWrites=true ";
			mongoClient = MongoClients.create(connectionURL);
			System.out.println(" [DB] connection with mongoDB created ");
			
		} catch (Exception e) {
			System.out.println("Something went wrong "+e);
		}	
		
		}
		
		public boolean RegisterAdmin(Admin admin) {
			// MongoDB Document which will convert the HashMap to the Document|| BOXING
	    
	    	Document document = new Document(admin.toMap());
	    	System.out.println(document);
	    	
	    	//Insert into Database:
	    	mongoClient.getDatabase("MyProject").getCollection("admin").insertOne(document);
	    	System.out.println(admin.nameAdmin+"  [REGISTERED] in mongoDB admin ");//check the mongoDB in the user Database
	    		
	    	return true;
			
		}
		
		public boolean LoginAdmin(Admin admin) {
			
			
			BasicDBObject query = new BasicDBObject();
			System.out.println(" [before] " +admin );
			query.put("password", admin.passwordAdmin);
			query.put("email", admin.email1Admin);
			System.out.println(" [DBAdmin admin] "+admin);
			
			MongoCursor<Document> cursor= mongoClient.getDatabase("MyProject").getCollection("admin").find(query).iterator();
		
			boolean flag1 = cursor.hasNext();
			if(flag1) {
				
				Document document = cursor.next();
				System.out.println(document.getObjectId("_id"));
		    	System.out.println(document.getString("name"));
		    	
		    	admin._id =(document.getObjectId("_id").toString());
		    	admin.nameAdmin =( document.getString("name"));
				
			}
			
			
			return  flag1;
			
		
			
			
		}
		
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
	
		
	

