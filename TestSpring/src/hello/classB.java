package hello;

public class classB {
private  classA a;

public classA getA() {
	return a;
}

public void setA(classA a) {
	this.a = a;
}

public void say() {
	this.a.say();
}
}
