package com.blog.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyVO {
	private int id;
	private int userId;
	private int boardId;
	private  String content;
	private Timestamp createDate;

}
