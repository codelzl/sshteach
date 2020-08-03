package com.beauxie.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.beauxie.bean.User;
import com.beauxie.service.UserService;
import com.beauxie.util.StringUtil;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author
 * 
 */
@Controller
// 用于标注控制层组件
@Scope("prototype")// Action默认是单例，但实际开发中，一般是多例，因为一般一个Action可能会对应多个不同的请求
@Results({ @Result(name = "loginSuccess", location = "/main.jsp"),
		@Result(name = "login", location = "/index.jsp") })
public class UserAction {

	@Autowired
	// 自动注入
	private UserService service;
	private String Msg;

	// struts默认拦截“.action以及不加任何后缀”
	@Action(value = "regist")
	// 访问：/user/regist.action 或 /user/regist
	public String regist() {

		// 获取request
		HttpServletRequest request = ServletActionContext.getRequest();
		// 获取表单提交的数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 封装userBean
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		// 调用service层的方法，向数据库中增加一条记录
		service.addUser(user);
		// 将提示信息存入request域中，用以前台显示
		// request.setAttribute("msg", "恭喜您，注册成功！<br>注册名："+username);
		request.setAttribute("uname", username);
		setMsg("注册成功，您当前登录账户为：" + username);
		int id = user.getId();
		request.getSession().putValue("uid", id);
		request.getSession().putValue("uname", username);
		List<User> list = new ArrayList<User>();
		list = service.allUser();
		request.getSession().putValue("Stuinfo", list);
		request.getSession().putValue("user", user);
		return "loginSuccess";
	}

	@Action(value = "login")
	public String login() {
		// 获取request
		HttpServletRequest request = ServletActionContext.getRequest();
		// 获取表单提交的数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 封装userBean
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setId(service.getUserId(user).getId());
		System.out.println(user.getId());
		if (StringUtil.isEmpty(user.getUsername())
				|| StringUtil.isEmpty(user.getPassword())) {
			setMsg("用户名或密码为空！");
			return "login";
		}
		if (service.checkUser(user)) {
			setMsg("欢迎使用本系统：您当前登录账户为：" + username);
			int id = user.getId();
			request.getSession().putValue("uid", id);
			request.getSession().putValue("uname", username);
			List<User> list = new ArrayList<User>();
			list = service.allUser();
			request.getSession().putValue("Stuinfo", list);
			request.getSession().putValue("user", user);
			return "loginSuccess";
		} else {
			setMsg("账号或者密码错误!请重新填写");
			return "login";
		}

	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String Msg) {
		this.Msg = Msg;
	}

}
