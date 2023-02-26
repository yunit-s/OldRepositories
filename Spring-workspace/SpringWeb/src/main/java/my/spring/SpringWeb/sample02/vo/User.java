package my.spring.SpringWeb.sample02.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok을 활용하면, annotation으로 설정을 잡아주면 간편하게 활용 가능하다.
/*
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

위 5개(추가 2가지도 있음)를 모두 한 번에 해결해주는 게 @Data 다.
*/

@Data
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

	private String userName;
	private int userAge;
	private String userDept;
	private String userAddress;
	
}
