package com.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.vo.BoardVO;
import com.blog.vo.JoinVO;
import com.blog.vo.LoginVO;

public interface BlogService {

	void join(JoinVO joinVO);

	int idCheck(String id);

	LoginVO login(LoginVO loginVO);

	void write(BoardVO boardVO);

	List<BoardVO>  boardList(int start, int end);

}
