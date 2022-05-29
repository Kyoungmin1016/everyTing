package org.tukorea.free.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tukorea.free.domain.MemberVO;
import org.tukorea.free.service.MemberService;

@Controller
@RequestMapping(value="/auth")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired(required=true)
	private MemberService memberService;
	
	@RequestMapping(value={"/login"},method=RequestMethod.GET)
	public String loginMemberGet(RedirectAttributes rttr) throws Exception{
		logger.info("/login URL GET method called. then forward login.jsp");
		return "auth/login";
	}
	
	@RequestMapping(value= {"/login"},method=RequestMethod.POST)
	public String loginMemberPost(@RequestParam("id") String id, @RequestParam("passwd") String passwd, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		HttpSession session = request.getSession(true);
		
		String check_id = memberService.checkLogin(id,passwd);
		
		if(check_id == null) {
			logger.info("/login URL POST method called. But there is no such member");
			rttr.addFlashAttribute("msg","로그인 실패");
			return "redirect:/auth/login";
		}
		
		logger.info("/login URL POST method called. then login method executed.");
		session.setAttribute("id", check_id);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value= "/register",method=RequestMethod.GET)
	public String createMemberGet() throws Exception{
		logger.info("/register URL GET method called. then forward register.jsp");
		return "auth/register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String createMemberPost(@ModelAttribute("member")MemberVO member, RedirectAttributes rttr) throws Exception{
		memberService.addMember(member);
		rttr.addFlashAttribute("msg","회원가입 성공");
		logger.info("/register URL POST method called. then createMember method excuted.");
		return "redirect:/auth/login";
	}

}
