package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {

	@Autowired
	private MemberDao memberDao;
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		//이메일로 회원을 조회해서
		Member member = memberDao.selectByEmail(email);
		if (member == null) //회원이 없다면 회원을 찾을 수 없다는 예외를 발생시키고
			throw new MemberNotFoundException();
		
		//회원이 있다면 비밀번호를 변경한다.
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
