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
		
//		// debug
//		if (rsMember == null) {
//			System.out.println("!!! rsMember == null");
//		} else {
//			System.out.println("!!! rsMember != null. id = " + rsMember.getMemberId());
//		}
		return rsMember;
	}

}
