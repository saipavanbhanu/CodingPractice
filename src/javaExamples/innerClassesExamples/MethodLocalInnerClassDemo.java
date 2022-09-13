package javaExamples.innerClassesExamples;

/*in method local inner classes it is not possible to call the non-final variables inside the inner classes 
 * hence we must declare that local variables must be final then only it is possible to access that members.*/

public class MethodLocalInnerClassDemo {
	private int a = 100;
	void m2() {
		System.out.println("Outer class method");
	}
	void m1() {
		class Inner {
			void innerMethod() {
				System.out.println("inner class method");
				System.out.println(a);
				m2();
			}
		}
		;
		Inner i = new Inner();
		i.innerMethod();
	}
	
	public static void main(String[] args) {
		MethodLocalInnerClassDemo o = new MethodLocalInnerClassDemo();
		o.m1();
	}
}


