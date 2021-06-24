package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //해당 클래스를 스프링 설정 클래스로 지정
public class AppContext {
	
	//9~14행은 객체를 생성하고 초기화하는 설정을 담고 있다.
	@Bean //메서드에 @Bean 애노테이션을 붙이면 해당 메서드가 생성한 객체를 스프링 빈으로 등록한다.
	public Greeter greeter() { //메서드의 이름은 빈 객체를 구분할 때 사용한다. ( 빈 이름이 된다 )
		Greeter g = new Greeter();
		g.setFormat("%s, 안녕하세요!");
		return g;
	}
}
