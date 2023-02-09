package member.dao;

import org.apache.ibatis.session.SqlSession;

import common.mybatis.MyBatisConnectionFactory;
import member.vo.Member;

public class MemberDao {

	public Member select(Member member) {
		// 데이터베이스 처리
		// MyBatis를 이용해서 Database 처리하기
		
		// SqlSession이라는 게 있어야 XML에 있는 Query를 실행할 수 있다.
		// SqlSession을 만들려면 SqlSessionFactory가 있어야 한다.
		// SqlSessionFactory를 만들려면 데이터베이스 연결정보와 같은 XML정보를 줘서 이 공장을 만들어야 한다.
		// 이 공장을 짓는 코드는 이미 정해져있다. -> 전에 사용했던 코드 그대로 가져오자.
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		sqlSession.selectOne("myMember.login", member);
		Member result = sqlSession.selectOne("myMember.login", member);
		sqlSession.close();
		return result;
	}

}
