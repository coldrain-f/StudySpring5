package chap02;

//Greeter -> 손님을 맞이하는 사람
public class Greeter {

	private String format;
	
	//greet -> 환영하다
	public String greet(String guest) {
		//String.format()은 문자열 인수를 사용하여 포맷된 문자열을 반환한다.
		return String.format(format, guest);
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
}
