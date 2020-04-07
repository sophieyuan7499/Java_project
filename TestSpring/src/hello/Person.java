package hello;

import sun.net.idn.Punycode;

public class Person {
public String name ;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public void say() {
	System.out.println(name+":hello");
}
}
