package org.tukorea.free.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tukorea.free.domain.MemberVO;
import org.tukorea.free.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public MemberVO readMember(String id) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.read(id);
	}

	@Override
	public void addMember(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		memberDAO.add(member);
	}

	@Override
	public void deleteMember(String id) throws Exception {
		// TODO Auto-generated method stub
		memberDAO.delete(id);
	}

	@Override
	public String checkLogin(String id, String passwd) throws Exception {
		// TODO Auto-generated method stub
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPasswd(passwd);
		return memberDAO.check(member);
	}
	
	
}
