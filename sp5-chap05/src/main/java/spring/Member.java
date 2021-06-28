package spring;

import java.time.LocalDateTime;

public class Member {

	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;
	
	public Member(String email, String password,
			String name, LocalDateTime regDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = regDateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}
	
	/**
	 * @param oldPassword 예전 비밀번호
	 * @param newPassword 변경할 새로운 비밀번호
	 * 현재 비밀번호와 예전 비밀번호가 같지 않다면 에러를 발생하고
	 * 현재 비밀번호와 예전 비밀번호가 같다면 새로운 비밀번호로 변경한다.
	 */
	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password = newPassword;
	}
}
