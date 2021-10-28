package gurleen.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BMI {
	public  String _id;
	public String dateTime;
	public String userId;
	public  int height;
    public double weight;
	public double yourBMI;
    public String phoneNumber;
	
public BMI() {
	
}
	    
		public BMI( String dateTime, String userId, int height, double weight, Date date,
			SimpleDateFormat formatter, String time,double yourBMI,String phoneNumber) {
		
	
		this.dateTime = dateTime;
		this.userId = userId;
		this.height = height;
		this.weight = weight;
		this.date = date;
		this.formatter = formatter;
		this.time = time;
		this.yourBMI= yourBMI;
		this.phoneNumber=phoneNumber;
	}


		
		
		@Override
		public String toString() {
			return "BMI [_id=" + _id + ", dateTime=" + dateTime + ", userId=" + userId + ", height=" + height
					+ ", weight=" + weight + ", yourBMI=" + yourBMI + ", phoneNumber=" + phoneNumber + ", date=" + date
					+ ", formatter=" + formatter + ", time=" + time + "]";
		}




		Date date= new Date();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formatter.format(date);
		
		
		public Map<String,Object> toMap(){
		Map<String, Object> map = new HashMap<String,Object>();
	   map.put("dateTime", time);
		map.put("userId", userId);
	    map.put("height",height);
	    map.put("weight",weight);
	    map.put("yourBMI",yourBMI);
	    map.put("phoneNumber", phoneNumber);
	    return map;
	}
	}



