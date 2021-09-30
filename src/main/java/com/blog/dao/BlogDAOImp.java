package com.blog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.vo.BoardVO;
import com.blog.vo.JoinVO;
import com.blog.vo.LoginVO;

@Repository
public class BlogDAOImp implements BlogDAO {

	@Autowired
	private SqlSession sql;
	
	private static String namespace = "com.blog.dao.BlogDAO";

	@Override
	public void join(JoinVO joinVO) {
		System.out.println(joinVO);
		sql.insert(namespace + ".join" , joinVO);
		
	}

	@Override
	public int idCheck(String id) {
		return sql.selectOne(namespace + ".idCheck" , id); 
	}

	@Override
	public LoginVO login(LoginVO loginVO) {
		return  sql.selectOne(namespace + ".login" , loginVO); 
	}

	@Override
	public void write(BoardVO boardVO) {
		System.out.println("dao");
		sql.insert(namespace + ".write" , boardVO);
		
	}

	@Override
	public List<BoardVO> boardList(int start, int end) {
		Map<String,Integer> map = new HashMap<>();
		
		map.put("start", start);
		map.put("end", end);
		
		System.out.println("map = " + map);
		return sql.selectList(namespace + ".boardList", map) ;
	}

	@Override
	public BoardVO boardDetail(int id) {
		return sql.selectOne(namespace + ".boardDetail" , id);
	}

	@Override
	public void readCountUpdate(int id) {
		sql.update(namespace + ".readCountUpdate", id);
	}

	@Override
	public void boardDelete(int id) {
		sql.delete(namespace + ".boardDelete" , id);
		
	}

	@Override
	public void boardModify(BoardVO boardVO) {
		sql.update(namespace + ".boardModify" , boardVO);
		
	}
	
	
}
