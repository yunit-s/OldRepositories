package my.spring.SpringWeb.sample05.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// lombok 어노테이션은 사람들마다 의견이 분분하다.
//		찬성하는 쪽은 귀찮아서, 반대하는 쪽은 괜히 무거워진다고 생각해서.
public class User {

	private int userNumber;
	private String userName;
	private String userDept;
	
}
