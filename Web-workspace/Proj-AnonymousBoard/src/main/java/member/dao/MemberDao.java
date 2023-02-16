package member.dao;

import org.apache.ibatis.session.SqlSession;

import common.mybatis.MyBatisConnectionFactory;
import member.vo.Member;

public class MemberDao {

	public Member select(Member loginMember) {
		// 세션 연결 - factory에서
		// 세션에서 selectOne()
		// 세션 닫기
		// 리턴
		System.out.println("!! MemberDao.select() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		Member rsMember = sqlSession.selectOne("memberXml.login", loginMember);
		sqlSession.close();
		return rsMember;
	}

	public Member selectOne(Member tgMember) {
		System.out.println("!! MemberDao.selectOne() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		Member rsMember = sqlSession.selectOne("memberXml.selectOne", tgMember);
		sqlSession.close();
		return rsMember;
	}

	public int insert(Member newMember) {
		System.out.println("!! MemberDao.insert() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int result = sqlSession.insert("memberXml.insertOne", newMember);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

}
