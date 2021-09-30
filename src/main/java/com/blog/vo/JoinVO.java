package com.blog.vo;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JoinVO {
	private String username;
	private String password;
	private String email;
	private String address;
}
