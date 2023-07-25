package springioc.sample6;

import java.io.FileWriter;

public class FileOutput implements Output {

	private String filePath;
	
	public FileOutput() {
		System.out.println("FileOutput() default 생성자 호출");
	}
	
	public FileOutput(String filePath) {
		super();
		this.filePath = filePath;
		System.out.println("FileOutput() 생성자 호출 - " + filePath);
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
		System.out.println("FileOutput.setFilePath() 호출");
	}

	@Override
	public void print(String message) throws Exception {

		FileWriter out = new FileWriter(filePath);
		out.write(message);
		out.close(); // stream 닫기
		System.out.println("FileOutput.print() 호출");
	}
	
}
