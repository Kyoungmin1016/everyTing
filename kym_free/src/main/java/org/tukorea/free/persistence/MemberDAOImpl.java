package org.tukorea.free.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tukorea.free.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.free.mappers.MemberMapper";
	
	@Override
	public MemberVO read(String id) throws Exception {
		// TODO Auto-generated method stub
		MemberVO member = sqlSession.selectOne(namespace+".selectByid",id);
		return member;
	}

	@Override
	public void add(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".insert",member);
	}

	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace+".delete",id);
	}

	@Override
	public String check(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".checkLogin", member);
	}

}
