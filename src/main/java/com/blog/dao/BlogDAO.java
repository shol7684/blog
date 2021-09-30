package com.blog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.blog.vo.BoardVO;
import com.blog.vo.JoinVO;
import com.blog.vo.LoginVO;

public interface BlogDAO {

	void join(JoinVO joinVO);

	int idCheck(String id);

	LoginVO login(LoginVO loginVO);

	void write(BoardVO boardVO);

	List<BoardVO>  boardList(int start, int end);

	BoardVO boardDetail(int id);

	void readCountUpdate(int id);

	void boardDelete(int id);

	void boardModify(BoardVO boardVO);

}
