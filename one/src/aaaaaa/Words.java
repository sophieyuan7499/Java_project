package aaaaaa;

public class Words { 
int charnum=0,number=0,blank=0,other=0;  

public int getCharNum(String str) {
	int n=str.length();
	for(int i=0;i<n;i++)  
	  {    
		if((str.charAt(i)>=65&&str.charAt(i)<=90)||(str.charAt(i)>=97&&str.charAt(i)<=122)) { 
			charnum++;   
	  }
}
	System.out.println("�ַ�����"+str);
	System.out.println("��ĸ������"+charnum);
	 return charnum;   
}

public int getNumberNum(String str) {
	int n=str.length();
	for(int i=0;i<n;i++)   {    
	if(str.charAt(i)>=48&&str.charAt(i)<=57)   {
		   number++;
	}
}
	System.out.println("�ַ�����"+str);
	System.out.println("���ָ�����"+number);
	return number;
}

public int getBlankNum(String str) {
	int n=str.length();
	for(int i=0;i<n;i++)  {    
		if(str.charAt(i)==32) {  
			   blank++; 
		}
	  }
	System.out.println("�ַ�����"+str);
	System.out.println("�ո������"+blank);
	return blank;
	}

public int getOtherNum(String str) {
	int n=str.length();
	for(int i=0;i<n;i++)  {   
		if(!   (str.charAt(i)==32||(str.charAt(i)>=65&&str.charAt(i)<=90)||(str.charAt(i)>=97&&str.charAt(i)<=122)||(str.charAt(i)>=48&&str.charAt(i)<=57))    ) {
			 other++; 
		}
	}
	System.out.println("�ַ�����"+str);
	System.out.println("�����ַ�������"+other);
	return -1;
}

public int fun(String str, int type) {  
	switch (type) {
	case 1:
		getCharNum(str);
		break ;
	case 2:
		getNumberNum(str);
		break ;
	case 3:
		getBlankNum(str);
		break ;
	default:
		getOtherNum(str);
	}
	return 0 ;
	  	
} 
public static void main(String[] args) {
	Words words=new Words();
	words.fun("emmaps ASpp12345 6==", 1);
	words.fun("sss m qiw +/*-==", 2);
	words.fun("skoopfj 12376 + ", 3);
	words.fun("/*-+!jiof", 4);
}
}


