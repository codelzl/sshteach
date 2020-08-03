package com.beauxie.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.beauxie.bean.User;

/**
 * @author 
 * Dao层，对数据库进行操作
 */
@Repository//这个属性对应的是持久层(一般为Dao层)，说明交给spring管理，而对应的包下的类名也会有一个"S"
public class UserDao {
	
	@Autowired//自动注入，不需要设值，因为在spring配置文件中已经配置过
	private HibernateTemplate template;
	
	
	/**
	 * 用户注册，即向表中添加一条新的记录
	 * @param user
	 */
	public void addUser(User user){
		//往数据库中添加一条数据，一句话就可以搞定
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

