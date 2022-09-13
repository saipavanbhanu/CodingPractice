package javaExamples.innerClassesExamples;

/*it can be used to provide the implementation of normal class or abstract class or interface*/

public class AnonymousInnerClassDemo {
	public static void main(String[] args) {
		OuterClass o = new OuterClass();
		o.m2();
		o.t.m1();
	}
}

interface Test {
	abstract public void m1();
};

class OuterClass {
	void m2() {
		System.out.println("m2 method");
	}

	Test t = new Test() {
		public void m1() {
			System.out.println("annonymus inner class");
		}
	};

};
