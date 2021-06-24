package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		//자바 설정정보를 보고 빈을 초기화하고 생성한다.
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppContext.class);
		
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		
		//스프링 컨테이너에서 검색한 g1과 g2는 동일한 객체이다.  ( 이를 싱글톤 객체라고 한다. ) 
		//싱글톤 객체는 몇 번을 getBean()해서 가져와도 매번 똑같은 객체를 반환한다.
		//별도의 설정이 없다면 스프링 컨테이너는 빈을 생성하고 등록할 때 싱글톤 객체로 등록한다.
		System.out.println("(g1 == g2) = " + (g1 == g2) ); //true
		
		Greeter g3 = new Greeter();
		Greeter g4 = new Greeter();
		
		System.out.println("(g3 == g4) = " + (g3 == g4) ); //false
		
	}
}
