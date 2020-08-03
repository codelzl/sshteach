package com.beauxie.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.beauxie.bean.User;

/**
 * @author 
 * Dao�㣬�����ݿ���в���
 */
@Repository//������Զ�Ӧ���ǳ־ò�(һ��ΪDao��)��˵������spring��������Ӧ�İ��µ�����Ҳ����һ��"S"
public class UserDao {
	
	@Autowired//�Զ�ע�룬����Ҫ��ֵ����Ϊ��spring�����ļ����Ѿ����ù�
	private HibernateTemplate template;
	
	
	/**
	 * �û�ע�ᣬ����������һ���µļ�¼
	 * @param user
	 */
	public void addUser(User user){
		//�����ݿ������һ�����ݣ�һ�仰�Ϳ��Ը㶨
		template.save(user);
	}
	

	public List<User> findByNameAndPass(User user) {  
        // TODO Auto-generated method stub  
		return (List<User>) template.find("from User u where u.username=? and u.password=?", user.getUsername(), user.getPassword());  
    }  
	
	public List<User> allUser(){
		return (List<User>) template.find("from User");
	}
	
	public List<User> findByID(int ID){
		return (List<User>) template.find("from User u where u.id=?",ID);
	}

}

