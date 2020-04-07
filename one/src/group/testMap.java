package group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testMap {
	public static Object getKey(Map<String, String> map, Object value){
	    List<Object> keyList = new ArrayList<>();
	    for(Object key: map.keySet()){
	        if(map.get(key).equals(value)){
	            keyList.add(key);
	        }
	    }
	    return keyList;
	}

public static void main(String []args) {
	Map<String, String> m1=new HashMap<String, String>();
	m1.put("Tom", "CoreJava");
	m1.put("John", "Oracle");
	m1.put("Susan", "Oracle");
	m1.put("Jerry", "JDBC");
	m1.put("Jim", "Unix");
	m1.put("Kevin", "JSP");
	m1.put("Lucy", "JSP");
	m1.put("Allen", "JDBC");
		
	m1.put("Lucy", "CoreJava");

	 for (String key : m1.keySet()) {
	      System.out.println(key + ":" + m1.get(key));
	    }
	
	 System.out.println("Êä³öµÄkeyÎª£º" + getKey(m1, "JSP"));
         }  	 
}


