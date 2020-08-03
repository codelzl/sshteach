package com.beauxie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauxie.bean.User;
import com.beauxie.dao.UserDao;

/**
 * @author Beauxie Service��
 */

@Service
// ������Զ�Ӧ����ҵ���(һ��ΪService��)��˵������spring��������Ӧ�İ��µ�����Ҳ����һ��"S"
public class UserService {

	@Autowired
	// ͬ�����Զ�ע��
	private UserDao userDao;

	public void addUser(User user) {
		// ����Dao���addUser����
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
