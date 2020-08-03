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
// ���ڱ�ע���Ʋ����
@Scope("prototype")// ActionĬ���ǵ�������ʵ�ʿ����У�һ���Ƕ�������Ϊһ��һ��Action���ܻ��Ӧ�����ͬ������
@Results({ @Result(name = "loginSuccess", location = "/main.jsp"),
		@Result(name = "login", location = "/index.jsp") })
public class UserAction {

	@Autowired
	// �Զ�ע��
	private UserService service;
	private String Msg;

	// strutsĬ�����ء�.action�Լ������κκ�׺��
	@Action(value = "regist")
	// ���ʣ�/user/regist.action �� /user/regist
	public String regist() {

		// ��ȡrequest
		HttpServletRequest request = ServletActionContext.getRequest();
		// ��ȡ���ύ������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// ��װuserBean
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		// ����service��ķ����������ݿ�������һ����¼
		service.addUser(user);
		// ����ʾ��Ϣ����request���У�����ǰ̨��ʾ
		// request.setAttribute("msg", "��ϲ����ע��ɹ���<br>ע������"+username);
		request.setAttribute("uname", username);
		setMsg("ע��ɹ�������ǰ��¼�˻�Ϊ��" + username);
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
		// ��ȡrequest
		HttpServletRequest request = ServletActionContext.getRequest();
		// ��ȡ���ύ������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// ��װuserBean
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setId(service.getUserId(user).getId());
		System.out.println(user.getId());
		if (StringUtil.isEmpty(user.getUsername())
				|| StringUtil.isEmpty(user.getPassword())) {
			setMsg("�û���������Ϊ�գ�");
			return "login";
		}
		if (service.checkUser(user)) {
			setMsg("��ӭʹ�ñ�ϵͳ������ǰ��¼�˻�Ϊ��" + username);
			int id = user.getId();
			request.getSession().putValue("uid", id);
			request.getSession().putValue("uname", username);
			List<User> list = new ArrayList<User>();
			list = service.allUser();
			request.getSession().putValue("Stuinfo", list);
			request.getSession().putValue("user", user);
			return "loginSuccess";
		} else {
			setMsg("�˺Ż����������!��������д");
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
