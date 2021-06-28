package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//스프링 빈으로 등록할 때 클래스 이름의 맨 앞글자를 소문자로 바꾼 이름을 스프링 빈 이름으로 사용한다.
//하지만 속성값을 주면 속성값으로 준 infoPrinter를 스프링 빈 이름으로 사용한다.
@Component("infoPrinter")
public class MemberInfoPrinter {

	private MemberDao memDao;
	private MemberPrinter printer;
	
	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		if (member == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(member);
		System.out.println();
	
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memDao = memberDao;
	}
	
	@Autowired
	@Qualifier("printer")
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
}
