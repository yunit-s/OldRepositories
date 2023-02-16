package member.dao;

import org.apache.ibatis.session.SqlSession;

import common.mybatis.MyBatisConnectionFactory;
import member.vo.Member;

public class MemberDao {

	SqlSession sqlSession;
	
	public MemberDao() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberDao(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	public Member select(Member loginMember) {
		System.out.println("!! MemberDao.select() 실행");
		Member rsMember = sqlSession.selectOne("memberXml.login", loginMember);
		return rsMember;
	}

	public Member selectOne(Member tgMember) {
		System.out.println("!! MemberDao.selectOne() 실행");
		Member rsMember = sqlSession.selectOne("memberXml.selectOne", tgMember);
		return rsMember;
	}

	public int insert(Member newMember) {
		System.out.println("!! MemberDao.insert() 실행");
		int result = sqlSession.insert("memberXml.insertOne", newMember);
		return result;
	}

	public int update(Member tgMember) {
		System.out.println("!! MemberDao.update() 실행");
		int result = sqlSession.update("memberXml.updateOne", tgMember);
		return result;
	}

	public int delete(Member tgMember) {
		System.out.println("!! MemberDao.delete() 실행");
		int result = sqlSession.update("memberXml.deleteOne", tgMember);
		return result;
	}

}
