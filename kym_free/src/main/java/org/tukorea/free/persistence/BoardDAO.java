package org.tukorea.free.persistence;

import java.util.List;

import org.tukorea.free.domain.ApplyVO;
import org.tukorea.free.domain.NoticeBoardVO;

public interface BoardDAO {
	public List<NoticeBoardVO> readList() throws Exception;
	public NoticeBoardVO read(int num) throws Exception;
	public void add(NoticeBoardVO board) throws Exception;
	public void delete(int num) throws Exception;
	public void modify(NoticeBoardVO board) throws Exception;
	public void addApply(ApplyVO apply) throws Exception;
	public List<ApplyVO> readApplyList (String id) throws Exception;
}
