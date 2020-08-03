package com.beauxie.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 在这里User的属性应当与t_user表中的字段相同，
 * 否则就需要手动为不相同的属性指定对应表中的字段
 */
@Entity//映射数据库表
@Table(name="t_user")//不加这个注解，默认对应的是user表
public class User {
	
	@Id//对应t_user表中的主键
	private int id;//用户ID
	
	private String username;//用户名
	
	private String password;//密码
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

