package spring;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberPrinter {

	private DateTimeFormatter dateTimeFormatter;
	
	//자동 주입 대상 필드를 기본 생성자에서 초기화한 예
	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}
	
	public void print(Member member) {
		
		if (dateTimeFormatter == null) {
			System.out.printf("회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
					member.getId(), member.getEmail(), 
					member.getName(), member.getRegisterDateTime());			
		} else {
			System.out.printf("회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n",
					member.getId(), member.getEmail(), member.getName(),
					dateTimeFormatter.format(member.getRegisterDateTime()));
		}
		
	}
	
	//원래는 @Autowired를 붙이면 의존 주입할 빈이 없으면 예외가 발생하는데 required = false를 설정하면 
	//주입할 빈이 있으면 주입하고 없으면 딱히 주입하지 않아도 상관 없다는 설정이다.
	@Autowired(required = false) //주입할 빈이 없으면 setter 메서드를 호출하지 않는다.
	public void setDateFormatter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}
	
//	//방법2 (스프링 5부터 가능)
//	@Autowired
//	public void setDateFormatter(Optional<DateTimeFormatter> formatterOpt) {
//		if (formatterOpt.isPresent()) { //값이 존재하면 true를 반환한다.
//			this.dateTimeFormatter = formatterOpt.get(); //주입
//		} else {
//			this.dateTimeFormatter = null;
//		}
//	}
//	
//	//방법3
//	@Autowired //주입할 빈이 있으면 주입하고 없으면 null을 주입한다. 주입할 빈이 없어도 setter 메서드를 호출한다.
//	public void setDateFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
//		this.dateTimeFormatter = dateTimeFormatter;
//	}
}
