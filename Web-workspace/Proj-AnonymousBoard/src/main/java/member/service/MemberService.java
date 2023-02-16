package member.service;

import member.dao.MemberDao;
import member.vo.Member;

public class MemberService {

	public Member login(Member loginMember) {
		MemberDao dao = new MemberDao();
		Member rsMember = dao.select(loginMember);
		return rsMember;
	}

}
