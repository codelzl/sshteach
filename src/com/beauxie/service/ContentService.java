package com.beauxie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauxie.bean.Content;
import com.beauxie.dao.ContentDao;

@Service
public class ContentService {
	@Autowired
	// 同样是自动注入
	private ContentDao contentDao;

	public void addContent(Content content) {
		contentDao.addContent(content);
	}

	public List<Content> findByid(int id) {
		return contentDao.findByid(id);
	}
}
