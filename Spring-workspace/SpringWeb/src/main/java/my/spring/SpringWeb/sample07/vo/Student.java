package my.spring.SpringWeb.sample07.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	// html에서 넘겨주는 input 태그 데이터의 name과 필드명이 동일해야 한다.
	private int studentNumber;
	private String studentName;
	private String studentDept;
}
