package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.entity.Admin;
import com.entity.SuperAdmin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.AdminService;
import com.service.SuperAdminService;
import com.vo.User;

@Component("superAdmin")
@Scope("prototype")
public class SuperAdminAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7845060072014799945L;

	private Integer perPageCount = 15;
	public User user;
	private Integer Id;
	private String username;
	private String password;
	private String name;
	private int flag;
	private String introduction;

	private List<Admin> admins;

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	@Resource
	private SuperAdminService superAdminService;

	@Resource
	private AdminService adminService;

	/**
	 * 超级管理员登录
	 * 
	 * @return
	 * @throws Exception
	 * @Description
	 */
	public String login() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		List<SuperAdmin> list = superAdminService.login(user);
		if (list.size() == 1) {
			actionContext.getSession().put("LoginSuperAdmin", list.get(0));
			return "admin_login_success";
		} else {
			actionContext.put("error", "账号或者密码错误");
			return "admin_login_error";
		}
	}

	/**
	 * 添加管理员
	 * 
	 * @return
	 * @Description
	 */
	public String add() {
		System.out.println(username + "<hghjjhfhjfjh<");

		ActionContext actionContext = ActionContext.getContext();
		SuperAdmin superAdmin = (SuperAdmin) actionContext.getSession().get(
				"LoginSuperAdmin");
		System.out.println("【】【】" + superAdmin + "【】【】" + superAdmin.getName());
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		admin.setName(name);
		admin.setFlag(1);
		admin.setIntroduction(introduction);
		String msg = adminService.add(admin, superAdmin);
		if (msg == null) {
			// 添加成功

			List<Admin> admins = adminService.findAllByPaging(0, 15);
			if (admins != null) {
				actionContext.put("admins", admins);
				for (Admin a : admins) {
					System.out.println("【哈】" + a.getUsername());
				}
				return "admin_list_success";
			} else {
				return "admin_list_error";
			}
		} else {
			// 添加失败
			return "admin_add_error";
		}
	}

	/**
	 * 显示所有管理员信息
	 * 
	 * @return
	 * @Description
	 */
	public String list() {
		ActionContext actionContext = ActionContext.getContext();
		SuperAdmin superAdmin = (SuperAdmin) actionContext.getSession().get(
				"LoginSuperAdmin");
		// //////提取这段代码
		List<Admin> admins = adminService.findAllByPaging(0, 15);

		if (admins != null) {
			actionContext.put("admins", admins);
			for (Admin admin : admins) {
				System.out.println("【哈】" + admin.getUsername());
			}
			return "admin_list_success";
		} else {
			return "admin_list_error";
		}
	}

	/**
	 * 分页显示管理员信息
	 * 
	 * @return
	 * @Description
	 */
	public String listByPage() {
		ActionContext actionContext = ActionContext.getContext();
		SuperAdmin superAdmin = (SuperAdmin) actionContext.getSession().get(
				"LoginSuperAdmin");
		// //////提取这段代码
		List<Admin> admins = adminService.findAllByPaging(0, perPageCount);

		if (admins != null) {
			actionContext.put("admins", admins);
			for (Admin admin : admins) {
				System.out.println("【哈】" + admin.getUsername());
			}
			return "admin_list_success";
		} else {
			return "admin_list_error";
		}
	}

	/**
	 * 删除管理员（根据用户名username删除）
	 * 
	 * @return
	 * @Description
	 */
	public String delete() {
		ActionContext actionContext = ActionContext.getContext();
		SuperAdmin superAdmin = (SuperAdmin) actionContext.getSession().get(
				"LoginSuperAdmin");

		System.out.println("【username】" + username);
		String msg = adminService.delete(username, superAdmin);
		if (msg == null) {
			// 删除成功
			System.out.println("【删除成功了】");
			// return "admin_delete_success";
			return list();
		} else {
			System.out.println("【删除失败！】");
			return "admin_delete_error";
		}
	}

	/**
	 * 更新管理员信息
	 * 
	 * @return
	 * @Description
	 */
	public String update() {
		System.out.println("username-->" + username);
		System.out.println("password-->" + password);
		System.out.println("name-->" + name);
		System.out.println("flag-->" + flag);
		System.out.println("introduction-->" + introduction);

		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		admin.setName(name);
		admin.setIntroduction(introduction);
		admin.setFlag(flag);

		admin.setId(Id);

		ActionContext actionContext = ActionContext.getContext();
		SuperAdmin superAdmin = (SuperAdmin) actionContext.getSession().get(
				"LoginSuperAdmin");
		String msg = adminService.update(admin, superAdmin);
		if (msg == null) {
			// 更新成功
			System.out.println("【更新成功！】" + msg + "【】");

			return list();
		} else {
			System.out.println("【更新失败！】" + msg + "【】");
			return "admin_update_error";
		}
	}

	/**
	 * 载入管理员信息编辑页面
	 * 
	 * @return
	 */
	public String update_ui() {

		// 接收前台传入的值，因为后台没有提供相应的根据Id获取 管理员信息 的值的函数所以只能全部传入。

		return "admin_update_ui";
	}

	public int getFlag() {
		return flag;
	}

	public String getIntroduction() {
		return introduction;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public User getUser() {
		return user;
	}

	public String getUsername() {
		return username;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

}
