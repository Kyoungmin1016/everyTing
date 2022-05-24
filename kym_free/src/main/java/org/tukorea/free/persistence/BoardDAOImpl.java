package org.tukorea.free.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tukorea.free.domain.ApplyVO;
import org.tukorea.free.domain.NoticeBoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.free.mappers.BoardMapper";
	
	@Override
	public List<NoticeBoardVO> readList() throws Exception {
		// TODO Auto-generated method stub
		List<NoticeBoardVO>boardList = new ArrayList<NoticeBoardVO>();
		boardList = sqlSession.selectList(namespace+".selectAll");
		return boardList;
	}

	@Override
	public NoticeBoardVO read(int num) throws Exception {
		// TODO Auto-generated method stub
		NoticeBoardVO board = sqlSession.selectOne(namespace+".selectBynum",num);
		return board;
	}

	@Override
	public void add(NoticeBoardVO board) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".insert",board);
	}

	@Override
	public void delete(int num) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace+".delete",num);
	}

	@Override
	public void modify(NoticeBoardVO board) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".update",board);
	}

	@Override
	public void addApply(ApplyVO apply) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".insertApply",apply);
	}

	@Override
	public List<ApplyVO> readApplyList(String id) throws Exception {
		// TODO Auto-generated method stub
		List<ApplyVO> applyList = new ArrayList<ApplyVO>();
		applyList = sqlSession.selectList(namespace+".selectCheckApply",id);
		
		return applyList;
	}
	
}
