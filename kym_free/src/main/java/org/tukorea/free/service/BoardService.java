package org.tukorea.free.service;

import java.util.List;

import org.tukorea.free.domain.ApplyVO;
import org.tukorea.free.domain.NoticeBoardVO;

public interface BoardService {
	public List<NoticeBoardVO> readListBoard() throws Exception;
	public NoticeBoardVO readBoard(int num) throws Exception;
	public void addBoard(NoticeBoardVO board) throws Exception;
	public void deleteBoard(int num) throws Exception;
	public void modifyBoard(NoticeBoardVO board) throws Exception;
	public void applyBoard(ApplyVO apply) throws Exception;
	public List<ApplyVO> readApplyListBOard(String id) throws Exception;
}
