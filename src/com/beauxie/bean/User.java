package com.beauxie.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * ������User������Ӧ����t_user���е��ֶ���ͬ��
 * �������Ҫ�ֶ�Ϊ����ͬ������ָ����Ӧ���е��ֶ�
 */
@Entity//ӳ�����ݿ��
@Table(name="t_user")//�������ע�⣬Ĭ�϶�Ӧ����user��
public class User {
	
	@Id//��Ӧt_user���е�����
	private int id;//�û�ID
	
	private String username;//�û���
	
	private String password;//����
	

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

