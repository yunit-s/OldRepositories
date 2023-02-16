package member.service;

import member.dao.MemberDao;
import member.vo.Member;

public class MemberService {

	public Member login(Member loginMember) {
		System.out.println("!! MemberService.login() 실행");
		MemberDao mDao = new MemberDao();
		Member rsMember = mDao.select(loginMember);
		return rsMember;
	}

	public boolean isDuplicatedId(String userId) {
		System.out.println("!! MemberService.isDuplicatedId() 실행");
		Member tgMember = new Member();
		tgMember.setMemberId(userId);
		MemberDao mDao = new MemberDao();
		tgMember = mDao.selectOne(tgMember);
		if (tgMember != null) {
			return true;
		} else {
			return false;
		}
	}

	public int addMember(Member newMember) {
		System.out.println("!! MemberService.addMember() 실행");
		MemberDao mDao = new MemberDao();
		int result = mDao.insert(newMember);
		return result;
	}

}
