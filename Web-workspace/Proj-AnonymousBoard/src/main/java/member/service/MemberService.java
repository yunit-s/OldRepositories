package member.service;

import org.apache.ibatis.session.SqlSession;

import common.mybatis.MyBatisConnectionFactory;
import member.dao.MemberDao;
import member.vo.Member;

public class MemberService {

	public Member login(Member loginMember) {
		System.out.println("!! MemberService.login() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		MemberDao mDao = new MemberDao(sqlSession);
		Member rsMember = mDao.select(loginMember);
		sqlSession.close();
		return rsMember;
	}

	public boolean isDuplicatedId(String userId) {
		System.out.println("!! MemberService.isDuplicatedId() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		Member tgMember = new Member();
		tgMember.setMemberId(userId);
		MemberDao mDao = new MemberDao(sqlSession);
		tgMember = mDao.selectOne(tgMember);
		sqlSession.close();
		if (tgMember != null) {
			return true;
		} else {
			return false;
		}
	}

	public int addMember(Member newMember) {
		System.out.println("!! MemberService.addMember() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		MemberDao mDao = new MemberDao(sqlSession);
		int result = mDao.insert(newMember);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	public int editMember(Member tgMember) {
		System.out.println("!! MemberService.editMember() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		MemberDao mDao = new MemberDao(sqlSession);
		int result = mDao.update(tgMember);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	public int delMember(Member tgMember) {
		System.out.println("!! MemberService.delMember() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		MemberDao mDao = new MemberDao(sqlSession);
		int result = mDao.delete(tgMember);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

}
