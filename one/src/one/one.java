package one;

public class one {
	public static void main(String[] args) {
		/*String s[][] = null;
		       for(int a=0;a<10;a++) {
		    	   if(a%2==0&&a>0) {
		    		   System.out.println("");
		    	   }
		    	   else  if(a==0||a==9){
		    	for(int b=5;b>0;b--) {  
		    		System.out.print("*");   
		    	   }
		    		   
		    	   }else {
		    		   if(a==3) {System.out.print("  *"); }
		    		   if(a==5) {System.out.print(" *"); }
		    		   if(a==7) {System.out.print("*"); }
		    	   }
		    		   }  
		    	   }*/
	/*int n;
for(n=100;n<1000;n++) {
	int a=n/100;
	int b=(n/10)%10;
	int c=n%10;
	if(n==a*a*a+b*b*b+c*c*c) {
		System.out.println(n);
	}
}*/
	
		for(int a=0;a<11;a++) {
			for(int b=0;b<11;b++) {
				for(int c=0;c<11;c++) {
					if(a*100+b*10+c==a*a*a+b*b*b+c*c*c) {
						System.out.println(a*100+b*10+c);
					}
				}
			}
			
		}
	}}	       
		    	  
		     
