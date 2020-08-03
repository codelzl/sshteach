package com.beauxie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauxie.bean.User;
import com.beauxie.dao.UserDao;

/**
 * @author Beauxie Service层
 */

@Service
// 这个属性对应的是业务层(一般为Service层)，说明交给spring管理，而对应的包下的类名也会有一个"S"
public class UserService {

	@Autowired
	// 同样是自动注入
	private UserDao userDao;

	public void addUser(User user) {
		// 调用Dao层的addUser方法
		userDao.addUser(user);
	}

	public Boolean checkUser(User user) {

		List<User> users = (userDao.findByNameAndPass(user));
		if (users.size() > 0)
			return true;
		else
			return false;
	}

	public List<User> allUser() {
		return userDao.allUser();
	}

	public User getUserId(User key) {
		return userDao.findByNameAndPass(key).get(0);
	}

	public List<User> findByID(int ID) {
		return userDao.findByID(ID);
	}

}
