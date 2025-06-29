package annotations;

@TestAnnotation
public class TestAnnotationExample {

	@TestAnnotation
	private Integer field;

	@TestAnnotation
	TestAnnotationExample(){

	}

	@TestAnnotation
	public void method(){
		@TestAnnotation
		Integer localVariable = 23;


	}

	@TestAnnotation
	public static void staticMethod(){

	}

}
