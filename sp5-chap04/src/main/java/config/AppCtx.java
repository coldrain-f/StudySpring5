package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.MemberSummaryPrinter;
import spring.VersionPrinter;

@Configuration //스프링 설정 클래스임을 명시한다.
public class AppCtx {

	@Bean //해당 메서드가 생성한 객체를 스프링 빈으로 설정한다.
	public MemberDao memberDao() { //메서드의 이름이 생성한 스프링 빈의 이름이 된다.
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(); 
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdScv = new ChangePasswordService();
		//pwdScv.setMemberDao(memberDao());
		//의존을 주입하지 않아도 ChangePasswordService에 의존 필드에 @Autowired를 붙였기 때문에
		//자동으로 MemberDao 타입의 스프링 빈 객체를 주입해 준다.
		return pwdScv; 
	}
	
//	@Bean
//	public MemberPrinter memberPrinter() {
//		return new MemberPrinter();
//	}
	
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		//infoPrinter.setMemberDao(memberDao());
		infoPrinter.setPrinter(memberPrinter2());
		//두 Setter 메서드에 @Autowired를 붙여줬기 때문에 설정 파일에서 의존 주입을 하지 않아도
		//자동으로 주입해 준다.
		return infoPrinter;
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
