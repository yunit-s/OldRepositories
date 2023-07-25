package example.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

// JavaFX View와 연결된 Controller이다.
// View가 생성되면, 연결된 Controller 객체도 자동적으로 생성된다.
// 이 Controller 안에서 버튼에 대한 이벤트 처리를 해야 한다.
// 그런데 여기에 버튼에 대한 reference가 있어야 버튼 클릭 처리를 할 수 있겠지?
// javaFX가 주는 annotation 이 있어야 이게 가능해진다.
// 우선, fxml의 버튼에서 fx:id="이름설정" 을 해두자.
// 그리고 이 컨트롤러 클래스에 대해 Initializable 인터페이스를 구현해야 한다.
// 인터페이스를 구현했으니, 그에 맞는 추상메소드 오버라이딩해야하고.

public class MyController implements Initializable {


	@FXML private Button upperBtn;
	@FXML private Button bottomBtn;
	
	public MyController() {
		// fxml 에서 컨트롤러를 지정해줬기 때문에, java에서 new를 통한 인스턴스 생성 코드를 적지 않아도
		// 자동으로 controller 객체가 생성된다.
		System.out.println("constructor 호출됨.");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// components들의 초기화할 내용들을 여기에 작성한다.
		// 일반적으로 이벤트 등록, 처리 코드들이 여기에 작성된다.
		upperBtn.setOnAction(e -> {
			// service 객체를 만들어서 일 시키기
		});
		
		bottomBtn.setOnAction(e -> {
			// service 객체를 만들어서 일 시키기
		});
	}

}
