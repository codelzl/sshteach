package com.beauxie.action;

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
import com.beauxie.service.ContentService;

@Controller
// ���ڱ�ע���Ʋ����
@Scope("prototype")
// ActionĬ���ǵ�������ʵ�ʿ����У�һ���Ƕ�������Ϊһ��һ��Action���ܻ��Ӧ�����ͬ������
@Results({ @Result(name = "Ncontent", location = "Etheme", type = "chain"),
})
public class ContentAction {

	@Autowired
	// �Զ�ע��
	private ContentService service;
	private String Msg;

	@Action(value = "Ncontent")
	public String Ncontent() {

		HttpServletRequest request = ServletActionContext.getRequest();
		String content = request.getParameter("content");
		int userid = (Integer) request.getSession().getAttribute("uid");
		int themeid = ((Theme) request.getSession().getAttribute("ThemeID")).getTid();
		Content contentbean = new Content();
		contentbean.setContent(content);
		contentbean.setTheme(themeid);
		contentbean.setUser(userid);
		service.addContent(contentbean);
		setMsg("�ɹ��ύ�����ػ���ҳ�棡");
		return "Ncontent";
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

}
