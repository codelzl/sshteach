package com.beauxie.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.beauxie.bean.Content;
import com.beauxie.bean.Theme;
import com.beauxie.bean.User;
import com.beauxie.service.ContentService;
import com.beauxie.service.ThemeService;
import com.beauxie.service.UserService;

@Controller
// ���ڱ�ע���Ʋ����
@Scope("prototype")
// ActionĬ���ǵ�������ʵ�ʿ����У�һ���Ƕ�������Ϊһ��һ��Action���ܻ��Ӧ�����ͬ������
@Results({ @Result(name = "Ntheme", location = "/main.jsp"),
		@Result(name = "Stheme", location = "/MTheme.jsp"),
		@Result(name = "Etheme", location = "/ETheme.jsp"),
		@Result(name = "MyTheme", location = "/ManageTheme.jsp"),
		@Result(name = "UpdateTheme", location = "MyTheme", type = "chain"),
		@Result(name = "UpFirstTheme", location = "/UpdateTheme.jsp"), })
public class ThemeAction {

	@Autowired
	// �Զ�ע��
	private ThemeService service;
	@Autowired
	// �Զ�ע��
	private ContentService cservice;
	@Autowired
	// �Զ�ע��
	private UserService uservice;
	private String Msg;

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

	@Action(value = "Ntheme")
	public String Ntheme() {
		// ��ȡrequest
		HttpServletRequest request = ServletActionContext.getRequest();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Date date = new Date(System.currentTimeMillis());
		User user = (User) request.getSession().getAttribute("user");
		int userid = user.getId();
		Theme theme = new Theme();
		theme.setDate(date);
		theme.setTheme(content);
		theme.setTitle(title);
		theme.setUser(userid);
		service.addTheme(theme);
		setMsg("�����ɹ���");
		return "Ntheme";
	}

	@Action(value = "Stheme")
	public String Stheme() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Theme> list = new ArrayList<Theme>();
		list = service.allTheme();
		request.getSession().putValue("ThemeInfo", list);
		return "Stheme";
	}

	@Action(value = "Etheme")
	public String Etheme() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Theme> list = new ArrayList<Theme>();
		int id = Integer.parseInt(request.getParameter("id"));
		request.getSession().putValue("Tid", id);
		list = service.findByid(id);
		request.getSession().putValue("ThemeID", list.get(0));
		int uid = list.get(0).getUser();
		String uname = uservice.findByID(uid).get(0).getUsername();
		request.getSession().putValue("USERID", uname);
		List<Content> list1 = new ArrayList<Content>();
		list1 = cservice.findByid(id);
		if (list1.size() > 0) {
			request.getSession().putValue("ContentID", list1);
		} else {
			list1 = null;
			request.getSession().putValue("ContentID", list1);
		}

		return "Etheme";
	}

	@Action(value = "FindTheme")
	public String FindTheme() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String searchValue = request.getParameter("searchValue");
		List<Theme> querylist = new ArrayList<Theme>();
		querylist = service.findTheme(searchValue);
		if (querylist.size() > 0) {
			request.getSession().putValue("ThemeInfo", querylist);
		} else {
			setMsg("���Ҳ�����Ǹ��");
			return "Ntheme";
		}
		return "Stheme";
	}

	@Action(value = "MyTheme")
	public String MyTheme() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = ((User) request.getSession().getAttribute("user")).getId();
		System.out.println(id);
		List<Theme> querylist = new ArrayList<Theme>();
		querylist = service.findByuid(id);
		if (querylist.size() > 0) {
			request.getSession().putValue("ThemeInfo", querylist);
		} else {
			setMsg("���Ҳ�����Ǹ��");
			return "Ntheme";
		}
		return "MyTheme";
	}

	@Action(value = "UpFirstTheme")
	public String UpFirstTheme() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		Theme theme = service.findByid(id).get(0);
		request.getSession().putValue("UpID", theme);
		return "UpFirstTheme";

	}

	@Action(value = "UpdateTheme")
	public String UpdateTheme() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Date date = new Date(System.currentTimeMillis());
		User user = (User) request.getSession().getAttribute("user");
		int userid = user.getId();
		int id = Integer.parseInt(request.getParameter("id"));
		Theme theme = service.findByid(id).get(0);
		theme.setDate(date);
		theme.setTheme(content);
		theme.setTitle(title);
		theme.setUser(userid);
		service.UpdateTheme(theme);
		setMsg("���³ɹ���");
		return "UpdateTheme";
	}

	@Action(value = "DTheme")
	public String DTheme() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		Theme theme = service.findByid(id).get(0);
		service.DTheme(theme);
		setMsg("ɾ���ɹ�!");
		return "UpdateTheme";
	}
}
