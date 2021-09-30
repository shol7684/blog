package com.blog.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class BoardVO {
	private int id;
	private int userId;
	private  String title;
	private String content;
	private  int readCount;
	private Timestamp createDate;
	
	private int total;
}
