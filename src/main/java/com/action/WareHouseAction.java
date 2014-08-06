package com.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.entity.Admin;
import com.entity.WareHouse;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.WareHouseService;

@Component("wareHouse")
@Scope("prototype")
public class WareHouseAction extends ActionSupport {
	private static final long serialVersionUID = -2957907486367031745L;
	public int id;
	public String docu_number;
	public String contact_phone;
	public String name;
	public String contact;
	public int total_storage;
	public int flag;

	@Resource
	private WareHouseService wareHouseService;

	/**
	 * 显示所有仓库
	 * 
	 * @return
	 */
	public String list() {
		ActionContext actionContext = ActionContext.getContext();
		List<WareHouse> wareHouses = wareHouseService.findAllByPaging(0, 10);
		if (wareHouses.size() > 0) {
			actionContext.put("wareHouses", wareHouses);
			for (WareHouse wareHouse : wareHouses) {
				System.out.println("仓库名称：" + wareHouse.getName());
			}
			return "wareHouse_list_success";
		} else {
			return "wareHouse_list_error";
		}
	}

	/**
	 * 更新仓库信息
	 * 
	 * @return
	 */
	public String update() {
		System.out.println("仓库：" + id);
		System.out.println("仓库：" + docu_number);
		System.out.println("仓库：" + contact_phone);
		System.out.println("仓库：" + name);
		System.out.println("仓库：" + contact);
		System.out.println("仓库：" + total_storage);
		System.out.println("仓库：" + flag);

		ActionContext actionContext = ActionContext.getContext();
		Admin admin = (Admin) actionContext.getSession().get("LoginAdmin");

		WareHouse wareHouse = new WareHouse();
		wareHouse.setContact(contact);
		wareHouse.setContact_phone(contact_phone);
		wareHouse.setDocu_number(docu_number);
		wareHouse.setFlag(flag);
		wareHouse.setId(id);
		wareHouse.setName(name);
		wareHouse.setTotal_storage(total_storage);
		String msg = wareHouseService.update(admin, wareHouse);

		if (msg == null) {
			// 更新成功
			System.out.println("仓库更新成功！");
			return list();
		} else {
			System.out.println("仓库更新失败！");
			return "wareHouse_update_error";
		}
	}

	/**
	 * 删除指定仓库信息
	 * 
	 * @return
	 */
	public String delete() {
		System.out.println("删除仓库id" + docu_number);
		ActionContext actionContext = ActionContext.getContext();
		Admin admin = (Admin) actionContext.getSession().get("LoginAdmin");
		String msg = wareHouseService.delete(admin, docu_number);
		if (msg == null) {
			// 删除成功
			System.out.println("删除成功！");
			return list();
		} else {
			// 删除失败
			System.out.println("删除失败！");
			return "wareHouse_delete_error";
		}
	}

	/**
	 * 新建仓库信息
	 * 
	 * @return
	 */
	public String save() {
		System.out.println("仓库：" + id);
		System.out.println("仓库：" + docu_number);
		System.out.println("仓库：" + contact_phone);
		System.out.println("仓库：" + name);
		System.out.println("仓库：" + contact);
		System.out.println("仓库：" + total_storage);
		System.out.println("仓库：" + flag);

		ActionContext actionContext = ActionContext.getContext();
		Admin admin = (Admin) actionContext.getSession().get("LoginAdmin");

		WareHouse wareHouse = new WareHouse();
		wareHouse.setContact(contact);
		wareHouse.setContact_phone(contact_phone);
		wareHouse.setDocu_number(docu_number);
		wareHouse.setFlag(1);
		wareHouse.setId(id);
		wareHouse.setName(name);
		wareHouse.setTotal_storage(total_storage);

		String msg = wareHouseService.save(admin, wareHouse);
		if (msg == null) {
			// 保存成功
			System.out.println("仓库新建成功");
			return list();
		} else {
			System.out.println("仓库新建失败");
			return "wareHouse_save_error";
		}
	}
	/**
	 * 得到全部名字
	 * 
	 * @return
	 * @throws IOException 
	 */
	public String getNames() throws IOException{
		boolean result = false;
		ServletActionContext.getResponse().getWriter().print("this is from action");
		List<String> names = wareHouseService.findAllName();
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("warehouseNames", names);
		return null;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocu_number() {
		return docu_number;
	}

	public void setDocu_number(String docu_number) {
		this.docu_number = docu_number;
	}

	public String getContact_phone() {
		return contact_phone;
	}

	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getTotal_storage() {
		return total_storage;
	}

	public void setTotal_storage(int total_storage) {
		this.total_storage = total_storage;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}
