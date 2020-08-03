package com.beauxie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauxie.bean.Theme;
import com.beauxie.dao.ThemeDao;

@Service
public class ThemeService {

	@Autowired
	// 同样是自动注入
	private ThemeDao themeDao;

	public void addTheme(Theme theme) {
		themeDao.addTheme(theme);
	}

	public List<Theme> allTheme() {
		return themeDao.allTheme();
	}

	public List<Theme> findByid(int id) {
		return themeDao.findByid(id);
	}

	public List<Theme> findTheme(String searchValue) {
		return themeDao.findTheme(searchValue);
	}

	public void UpdateTheme(Theme t) {
		themeDao.UpdateTheme(t);
	}

	public List<Theme> findByuid(int id) {
		return themeDao.findByuid(id);
	}

	public void DTheme(Theme t) {
		themeDao.DTheme(t);
	}
}
