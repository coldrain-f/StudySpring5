package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.VersionPrinter;

@Configuration //스프링 설정 클래스임을 명시한다.
public class AppCtx {

	@Bean //해당 메서드가 생성한 객체를 스프링 빈으로 설정한다.
	public MemberDao memberDao() { //메서드의 이름이 생성한 스프링 빈의 이름이 된다.
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		//memberDao()가 생성한 객체를 MemberRegisterService에 주입한다.
		return new MemberRegisterService(memberDao()); //여기에 주입된 memberDao 스프링 빈과
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdScv = new ChangePasswordService();
		pwdScv.setMemberDao(memberDao()); //여기에 주입된 memberDao 스프링 빈은 서로 동일한 빈이다.
		//memberDao() 메서드를 호출하면 호출할 때마다 매번 보관하고 있는 동일한 객체를 반환한다.
		return pwdScv; 
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao(), memberPrinter());
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setPrinter(memberPrinter());
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
