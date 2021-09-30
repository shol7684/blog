package com.blog.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO {
	private int id;
	private String username;
	private String password;
	private String email;
	private String address;
	private String userRole;
	private Timestamp createDate;
}
