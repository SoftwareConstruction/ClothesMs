package com.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.entity.Admin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.AdminService;
import com.vo.User;
import com.vo.service.LoginVo;

@Component("admin")
@Scope("prototype")
public class AdminAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5495325462902008455L;
	public User user;
	public Admin admin;
	
	private ActionContext actionContext = ActionContext.getContext();
	public String newPassword;
	
	
	@Resource
	private AdminService adminService;

	public String login() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		LoginVo loginVo = adminService.login(user);
		if (loginVo.getErrorWords() == null) {
			actionContext.getSession().put("LoginAdmin", loginVo.getAdmin());
			return "admin_login_success";
		} else {
			actionContext.put("error", loginVo.getErrorWords());
			return "admin_login_error";
		}
	}
	
	
	//管理员修改密码
	public String changePassword(){
		Admin admin = (Admin) actionContext.get("LoginAdmin");
		String error = adminService.changePassword(newPassword, admin.getId());
		if(error == null){
			return "admin_changePassowrd_SUCCESS";
		}
		return "admin_changePassowrd_ERROR";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
