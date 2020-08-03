package com.beauxie.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.beauxie.bean.Theme;
import com.beauxie.bean.User;




@Repository//������Զ�Ӧ���ǳ־ò�(һ��ΪDao��)��˵������spring��������Ӧ�İ��µ�����Ҳ����һ��"S"
public class ThemeDao {

	@Autowired//�Զ�ע�룬����Ҫ��ֵ����Ϊ��spring�����ļ����Ѿ����ù�
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
