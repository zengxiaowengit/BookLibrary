package com;

import impl.regImpl;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import impl.select;

@Namespace("")
@Results({ @Result(name = "loginSuccess", location = "/query.jsp"),
		@Result(name = "loginFailure", location = "/index.jsp"),
		@Result(name = "checkSuccess", location = "/login.jsp"),
		@Result(name = "checkFailure", location = "/register.jsp") })
public class loginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String reg_username;
	private String reg_password;
	private String resultMsg;
	private int resultInt;
	regImpl reg = new regImpl();

	// 对应的jsp:
	// namespace/类名!方法名.action
	// <form action="action/login!login.action">

	// Action!方法名.action
	// <form action="login!login.action">
	 @Action("register")
	public String register() throws Exception {
		// 验证用户名是否重复
		resultInt = reg.findByUserName(reg_username);
		if (resultInt != 0) {
			resultMsg = "用户名已被使用，请重新输入";
			return "registerFailure";
		} else {
			resultInt = reg.register(reg_username, reg_password);
			if (1 == resultInt) {
				// 1. 将用户信息保存到Session中。
				Map<String, Object> session = ActionContext.getContext()
						.getSession();
				session.put("reg_username", reg_username);
				session.put("reg_password", reg_password);
				// 2. 标识传递
				resultMsg = "注册成功";
				return "registerSuccess";
			} else {
				resultMsg = "注册失败";
				return "registerFailure";
			}
		}
	}

	// 登录
	 @Action("login")  
	public String login() {
		resultMsg = null;
		// 对用户的输入格式进行验证//应定义在jsp页面javScript
		if ("".equals(username) || username == null) {
			resultMsg = "用户名不能为空";
			return "checkFailure";
		} else if ("".equals(password) || password == null) {
			resultMsg = "密码不能为空";
			return "checkFailure";
		} else {
			if (password.length() < 4 || password.length() > 10) {
				resultMsg = "密码必须在4到10之间";
				return "checkFailure";
			}
		}
		// 数据库查询，根据用户输入与数据库中数据匹配情况
		select select1 = new select();
		int resultInt = select1.selectStatement(username, password);

		if (1 == resultInt) {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			session.put("usernameMsg", username);
			resultMsg = "登录成功";
			return "loginSuccess";
		} else {
			resultMsg = "登录失败";
			return "loginFailure";
		}
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getReg_username() {
		return reg_username;
	}

	public void setReg_username(String reg_username) {
		this.reg_username = reg_username;
	}

	public String getReg_password() {
		return reg_password;
	}

	public void setReg_password(String reg_password) {
		this.reg_password = reg_password;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
