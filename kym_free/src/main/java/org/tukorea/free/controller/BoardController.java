package org.tukorea.free.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tukorea.free.domain.ApplyVO;
import org.tukorea.free.domain.NoticeBoardVO;
import org.tukorea.free.service.BoardService;

@Controller
@Component
@RequestMapping("/board")
@SessionAttributes("id")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	public boolean notLogin(HttpServletRequest request, RedirectAttributes rttr) {
		HttpSession httpSession = request.getSession(true);
		String id = (String) httpSession.getAttribute("id");
		
		if(id == null) {
			logger.info("/list URL method called. But there is no such id");
			rttr.addFlashAttribute("msg","로그인이 되어있지 않습니다.");
			return true;
		}
		return false;
	}
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value={"/list"},method=RequestMethod.GET)
	public String presentBoardList(Model model,HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		if(notLogin(request,rttr)) {
			return "redirect:/auth/login";
		}
		
		List<NoticeBoardVO>boards = boardService.readListBoard();
		logger.info("/board/list URL method called. then forward board/list.jsp");
		model.addAttribute("notice_boards",boards);
		return "board/list";
	}
	
	@RequestMapping(value={"/register"},method=RequestMethod.GET)
	public String createBoardGet(HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		logger.info("/board/register Get URL method called. then forward board.jsp");
		if(notLogin(request,rttr)) {
			return "redirect:/auth/login";
		}
		
		return "board/register";
	}
	
	@RequestMapping(value={"/register"},method=RequestMethod.POST)
	public String createBoardPost(@ModelAttribute("board") NoticeBoardVO board,HttpServletRequest request) throws Exception{
		HttpSession httpSession = request.getSession(true);
		String id = (String) httpSession.getAttribute("id");
		board.setId(id);
		boardService.addBoard(board);
		logger.info("/board/register URL Post method called. then createBoard method executed");
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="content",method=RequestMethod.GET)
	public String presentBoardContent(@RequestParam("num")int num,Model model, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		if(notLogin(request,rttr)) {
			return "redirect:/auth/login";
		}
		
		NoticeBoardVO board = boardService.readBoard(num);
		model.addAttribute("board",board);
		logger.info("/board/content URL method called.then forward board/content.jsp");
		return "board/content";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public String modifyBoardGet(@RequestParam("num")int num,Model model,HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		if(notLogin(request,rttr)) {
			return "redirect:/auth/login";
		}
		NoticeBoardVO board = boardService.readBoard(num);
		model.addAttribute("board",board);
		logger.info("/board/modify URL Get method called.then forward board/modify.jsp");
		return "board/modify";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modifyBoardPost(@ModelAttribute("board")NoticeBoardVO board) throws Exception{
		logger.info("/board/content URL Post method called.then modifyBoardContentPost method executed");
		System.out.println(board);
		boardService.modifyBoard(board);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value={"/delete"},method=RequestMethod.GET)
	public String deleteBoard(@RequestParam("num")int num) throws Exception{

		logger.info("/board/delete URL method called. then deleteBoard method exceuted");
		boardService.deleteBoard(num);
		return "redirect:/board/list";
	}
		
	@RequestMapping(value="/apply/{num}",method=RequestMethod.POST)
	public String applyBoard(@PathVariable("num")int num,HttpServletRequest request,RedirectAttributes rttr) throws Exception{
		logger.info("/board/apply?num= URL method called. then applyBoard method exceuted");
		
		if(notLogin(request,rttr)) {
			return "redirect:/auth/login";
		}
		
		HttpSession httpSession = request.getSession(true);
		String id = (String) httpSession.getAttribute("id");
		
		ApplyVO apply = new ApplyVO();
		apply.setNum(num);
		apply.setOther(id);
		
		boardService.applyBoard(apply);
		
		rttr.addFlashAttribute("msg","신청이 완료되었습니다.");
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/checkApply",method=RequestMethod.GET)
	public String checkApplyBorad(HttpServletRequest request,Model model, RedirectAttributes rttr) throws Exception{
		logger.info("/board/checkApply method called. then applyBoard method exceuted");
		if(notLogin(request,rttr)) {
			return "redirect:/auth/login";
		}
		
		HttpSession httpSession = request.getSession(true);
		String id = (String)httpSession.getAttribute("id");
		
		List<ApplyVO>applys = boardService.readApplyListBOard(id);
		
		System.out.println(applys);
		model.addAttribute("applys",applys);
		
		return "board/apply";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public String logout(HttpServletRequest request)throws Exception{
		request.getSession().invalidate();
		
		return "redirect:/auth/login";
	}
	
	@RequestMapping(value="/deleteApply/{num}",method=RequestMethod.GET)
	public String deleteApply(@PathVariable("num")int num) throws Exception {
		boardService.deleteApply(num);
		
		return "redirect:/board/checkApply";
	}
}
