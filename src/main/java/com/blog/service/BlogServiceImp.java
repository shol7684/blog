package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.BlogDAO;
import com.blog.vo.BoardVO;
import com.blog.vo.JoinVO;
import com.blog.vo.LoginVO;

@Service
public class BlogServiceImp implements BlogService {

	@Autowired
	BlogDAO blogDAO;
	
	@Override
	public void join(JoinVO joinVO) {
		blogDAO.join(joinVO);
	}

	@Override
	public int idCheck(String id) {
		return blogDAO.idCheck(id);
	}

	@Override
	public LoginVO login(LoginVO loginVO) {
		return  blogDAO.login(loginVO);
	}

	@Override
	public void write(BoardVO boardVO) {
		blogDAO.write(boardVO);
		
	}

	@Override
	public List<BoardVO>  boardList(int start, int end) {
		return blogDAO.boardList(start, end);
	}

	@Override
	public BoardVO boardDetail(int id) {
		blogDAO.readCountUpdate(id);
		return blogDAO.boardDetail(id);
	}

	@Override
	public void boardDelete(int id) {
		blogDAO.boardDelete(id);
		
	}

	@Override
	public void boardModify(BoardVO boardVO) {
		blogDAO.boardModify(boardVO);
		
	}

}
