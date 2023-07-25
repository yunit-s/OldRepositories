package lecture.jdbc.di.step6;

public class Main {

	public static void main(String[] args) {
		UserVO user = new UserVO("hong", "홍길동", "1234");
		
		ConnectionMaker cm = new KosaConnectionMaker();
		
		UserDAO dao = new UserDAO(cm);
		
		dao.insert(user);
		
		System.out.println("새로운 사용자 등록!");
		
		UserVO user2 = dao.select("hong");
		
		System.out.println(user2.getName() + ", " + user2.getPassword());
		System.out.println("조회 성공!");
	}
}
