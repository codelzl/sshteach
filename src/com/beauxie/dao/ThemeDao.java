package com.beauxie.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.beauxie.bean.Theme;
import com.beauxie.bean.User;




@Repository//这个属性对应的是持久层(一般为Dao层)，说明交给spring管理，而对应的包下的类名也会有一个"S"
public class ThemeDao {

	@Autowired//自动注入，不需要设值，因为在spring配置文件中已经配置过
	private HibernateTemplate template;
	
	public void addTheme(Theme theme){
		template.save(theme);
	}
	
	public List<Theme> allTheme(){
		return (List<Theme>) template.find("from Theme");
	}
	
	public List<Theme> findByid(int id){
		return (List<Theme>) template.find("from Theme t where t.tid=?",id);
	}

	public List<Theme> findTheme(String searchValue){
		return (List<Theme>) template.find("from Theme t where t.title like  '%" + searchValue + "%' ");
	}
	

	public void UpdateTheme(Theme t){
		template.update(t);
	}
	
	public List<Theme> findByuid(int id){
		return (List<Theme>) template.find("from Theme t where t.user=?",id);
	}
	public void DTheme(Theme t){
		template.delete(t);
	}
	
}
