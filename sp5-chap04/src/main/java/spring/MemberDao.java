package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {

	
	private static long nextId = 0;
	private Map<String, Member> map = new HashMap<>();
	
	/**
	 * 
	 * @param email 이메일
	 * @return Member 회원
	 * 이메일을 파라미터로 받아서 조회하고 조회된 회원을 반환한다.
	 */
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	/**
	 * 
	 * @param member 회원
	 * 회원을 파라미터로 받아서 Map 자료구조에 key:email, value:Member로 저장한다.
	 */
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}
	
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	
	/**
	 * 
	 * @return Collection<Member> 맵에 존재하는 모든 Member를 반환한다.
	 */
	public Collection<Member> selectAll() {
		return map.values();
	}
}
