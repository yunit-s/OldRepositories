package springioc.sample6;

public class ConsoleOutput implements Output {

	public ConsoleOutput() {
		System.out.println("ConsoleOutput() default 생성자 호출");
	}
	
	@Override
	public void print(String message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ConsoleOutput.print() 호출");
		System.out.println("message : " + message);
	}

}
