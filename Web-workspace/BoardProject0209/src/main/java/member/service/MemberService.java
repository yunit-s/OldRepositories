package member.service;

import member.dao.MemberDao;
import member.vo.Member;

public class MemberService {

	public Member login(Member member) {
		// 로그인 Transaction(작업, 로직) 처리 진행하기
		// 로그인 작업에서는 특별히 할 로직 처리가 없다.
		// 단순하게 Database 처리만 하면 된다.
		//		그리고 이 Database 처리를 담당하는 것도 service가 아니라 DAO에서 한다.
		MemberDao dao = new MemberDao();
		Member result = dao.select(member);
		return result;
	}

}
