package javaExamples.innerClassesExamples;

/*Static inner classes can access only static variables and static methods 
 * it does not access the instace variables and instance methods*/

public class StaticInnerClassDemo {

	static int a = 10;
	static int b = 20;

	static class Inner {
		int c = 30;

		void m1() {
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
		}
	};

	public static void main(String[] args) {
		StaticInnerClassDemo o = new StaticInnerClassDemo();
		StaticInnerClassDemo.Inner i = new StaticInnerClassDemo.Inner();
		i.m1();
	}

}
