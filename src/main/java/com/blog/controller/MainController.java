package com.blog.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blog.service.BlogService;
import com.blog.vo.BoardVO;
import com.blog.vo.JoinVO;
import com.blog.vo.LoginVO;


@Controller
public class MainController {

	@Autowired
	BlogService blogService;
	
	@GetMapping( {"/list/{page}" , "/list"})
	public String main(Model model, @PathVariable Optional<Integer> page) {
		
		System.out.println(page.isPresent());
		
		int p = page.orElse(1);
		
		System.out.println(p);
//		1 = 1 2 3 4 5
//		2 = 6 7 8 9 10
//		3 = 11 12 13 14 15
		
		int count = 5; // 한 페이지당 보여줄 글 갯수
		int start = 1 + (count * (p-1)); // 한페이지 시작
		int end = p * count; // 한 페이지 끝
		
		List<BoardVO> boardList = blogService.boardList(start, end);
		
		int pageCount = 5; // 보여줄 페이지 갯수
		int startPage = p - (p -1 ) %  pageCount; // 페이지번호 시작
		int endPage = startPage + pageCount - 1; // 페이지번호 끝
		
		int totalPage = boardList.get(0).getTotal();
		
		totalPage = (totalPage % pageCount) == 0 ? totalPage / pageCount : totalPage / pageCount + 1; // 전체 페이지 갯수   
		// 토탈 62 = (62 % 5) == 0 ? (62 / 5) : (62 / 5 + 1) 나머지가 0이 아니면 +1
		
		double currentPersent =  p / (double)totalPage * 100; // 페이지 게이지
		
		model.addAttribute("boardList" , boardList);
		model.addAttribute("page" , p);
		model.addAttribute("startPage" , startPage);
		model.addAttribute("endPage" , endPage);
		model.addAttribute("totalPage" , totalPage);
		model.addAttribute("currentPersent" , currentPersent);
		
		return "blog/list";
	}
	
	
	
	@GetMapping("/join")
	public String getJoin() {
		return "blog/join";
	}
	
	@PostMapping("/join")
	public String postJoin(JoinVO joinVO) {
		System.out.println(joinVO);
		
		blogService.join(joinVO);
		return "redirect:/list";
	}
	
	
	@GetMapping("/login")
	public String getLogin() {
		return "blog/login";
	}
	
	@PostMapping("/login")
	public String postLogin(LoginVO loginVO, HttpSession session, RedirectAttributes rttr, HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println(loginVO);
		
		LoginVO login = blogService.login(loginVO);
		
		System.out.println(login);
		
		
		
		// 맞는 아이디가 없으면
		if(login == null) {
			// 아이디를 확인해주세요
			rttr.addFlashAttribute("loginFail" , "아이디를 확인해 주세요");
			return "redirect:/login";
		}
		
		// 아이디 있고 패스워드 일치
		if(login.getPassword().equals(loginVO.getPassword())) {
			// 로그인 성공
			session.setAttribute("user", login);
			
//			Cookie cookie = new Cookie("login" , "on");
			
			return "redirect:/list";
		} else {
			// 비밀번호를 확인해 주세요
			rttr.addFlashAttribute("loginFail" , "비밀번호를 확인해 주세요");
			return "redirect:/login";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		
		return "redirect:/list";
	}
	
	@GetMapping("/write")
	public String getWrite() {
		
		return "blog/write";
	}
	@PostMapping("/write")
	public String postWrite(BoardVO boardVO, HttpSession session) throws InterruptedException {
		
		LoginVO user = (LoginVO) session.getAttribute("user");
		
		boardVO.setUserId(user.getId());
			
		blogService.write(boardVO);
			
		return "redirect:/";
	}
	
	@GetMapping("/userInfo")
	public String userInfo(HttpSession session) {
		
		return "blog/userInfo";
	}
	
	@Transactional
	@GetMapping("/board/detail/{id}")
	public String boardDetail(@PathVariable int id,Model model) {
		
		System.out.println(id);
		
		BoardVO boardDetail = blogService.boardDetail(id);
		
		System.out.println(boardDetail);
		
		model.addAttribute("boardDetail", boardDetail);
		
		return "blog/detail";
	}
	
	@PostMapping("/board/modifyPage")
	public String modifyPage(Model model, BoardVO boardVO) {
		model.addAttribute("boardVO" , boardVO);
		
		System.out.println(boardVO);
		
		return "blog/modify";
	}
	
	@PostMapping("/board/modify") 
	public String boardModify(BoardVO boardVO) {
		
		blogService.boardModify(boardVO);
		
		System.out.println("수정 " + boardVO);
		
		return "redirect:/board/detail/" + boardVO.getId();
	}
	
	
	
	@ResponseBody
	@PostMapping("/idCheck")
	public int idCheck(String id) {
		System.out.println(id);
		
		int idCheck = blogService.idCheck(id);
		
		System.out.println("idCheck = " + idCheck);
		return idCheck;
	}
	
	@ResponseBody
	@PostMapping("/board/delete")
	public void boardDelete(int id) {
		
		System.out.println(id);
		
		blogService.boardDelete(id);
	}
	
	

}