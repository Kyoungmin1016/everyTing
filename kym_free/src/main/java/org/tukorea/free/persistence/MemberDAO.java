package org.tukorea.free.persistence;

import org.tukorea.free.domain.MemberVO;

public interface MemberDAO {
	public MemberVO read(String id) throws Exception;
	public void add(MemberVO member) throws Exception;
	public void delete(String id) throws Exception;
	public String check(MemberVO member) throws Exception;
}
