package com.beauxie.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.beauxie.bean.Content;
import com.beauxie.bean.Theme;

@Repository
public class ContentDao {

	@Autowired//自动注入，不需要设值，因为在spring配置文件中已经配置过
	private HibernateTemplate template;
    public void addContent(Content content){
    	template.save(content);
    }
    
	public List<Content> findByid(int id){
		return (List<Content>) template.find("from Content c where c.theme=?",id);
	}

}
