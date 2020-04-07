package one;
public class students implements Comparable<students>{
	 private String name;  
	    private int age;  
	    private float score;  
	      
	    public students(String name, int age, float score) {  
	        this.name = name;  
	        this.age = age;  
	        this.score = score;  
	    }
	    public String toString()  
	    {  
	        return name+"\t\t"+age+"\t\t"+score;  
	    }  
		@Override
		public int compareTo(students o) {
			// TODO Auto-generated method stub
			if(this.score>o.score) {
				
			}
			return 0;
		}  
	
}