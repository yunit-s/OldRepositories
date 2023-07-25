package my.spring.SpringWeb.sample02.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@ToString
//@EqualsAndHashCode
public class Member {

//	@NonNull
//	private String memberName;
//	private int memberAge;
//	@NonNull
//	@ToString.Exclude
//	private String memberAddr;
	
	private String name;
	private String phone;
	private String id;
	private String password;
	
}
