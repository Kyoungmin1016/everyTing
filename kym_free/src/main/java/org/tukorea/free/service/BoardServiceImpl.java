package org.tukorea.free.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tukorea.free.domain.ApplyVO;
import org.tukorea.free.domain.NoticeBoardVO;
import org.tukorea.free.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<NoticeBoardVO> readListBoard() throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.readList();
	}

	@Override
	public NoticeBoardVO readBoard(int num) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.read(num);
	}

	@Override
	public void addBoard(NoticeBoardVO board) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.add(board);
	}

	@Override
	public void deleteBoard(int num) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.delete(num);
	}

	@Override
	public void modifyBoard(NoticeBoardVO board) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.modify(board);
	}

	@Override
	public void applyBoard(ApplyVO apply) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.addApply(apply);
	}

	@Override
	public List<ApplyVO> readApplyListBOard(String id) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.readApplyList(id);
	}

}
