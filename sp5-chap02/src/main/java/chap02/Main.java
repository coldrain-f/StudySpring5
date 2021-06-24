package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		//자바 설정에서 정보를 읽어와 빈 객체를 생성하고 관리한다.
		AnnotationConfigApplicationContext ctx = //여기서는 Greeter 객체를 생성하고 초기화한다.
				new AnnotationConfigApplicationContext(AppContext.class);
		
		//getBean() 메서드는 생성한 빈 객체를 검색할 때 사용한다.
		//첫 번째 파라미터는 메서드 이름인 빈 객체의 이름
		//두 번째 파라미터는 객체의 타입이 된다.
		Greeter g = ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("스프링");
		System.out.println(msg);
		
		ctx.close();
	}

}
