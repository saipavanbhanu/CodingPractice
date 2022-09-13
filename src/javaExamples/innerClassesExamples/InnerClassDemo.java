package javaExamples.innerClassesExamples;

class Outer{
	int a = 10;
	void method2() {
		System.out.println("Outer class method");
	}
	class Inner{
		int a = 20;
		void method(int a) {
			System.out.println("local: "+a);
			System.out.println("inner class:"+this.a);
			System.out.println("Outer class:"+Outer.this.a);
			method2();
		}
	}
	
}


public class InnerClassDemo {

	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.Inner i = o.new Inner();
		i.method(30);
	}

}
