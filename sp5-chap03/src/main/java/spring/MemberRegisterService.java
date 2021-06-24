package spring;

import java.time.LocalDateTime;

public class MemberRegisterService {

	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	

	public Long regist(RegisterRequest req) {
		//이메일로 회원을 조회해서
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) { //같은 이메일을 사용하는 회원이 있다면 에러를 발생하고
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		
		//같은 이메일을 사용하는 회원이 없다면 새로운 회원을 생성해서 저장소에 저장한다.
		Member newMember = new Member(req.getEmail(), req.getPassword(),
				req.getName(), LocalDateTime.now());
		
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
