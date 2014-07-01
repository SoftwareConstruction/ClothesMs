package com.action;

import java.util.List;

import javax.annotation.Resource;
import javax.mail.Flags.Flag;
import javax.swing.CellEditor;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.entity.Admin;
import com.entity.Clothes;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ClothesService;

@Component("clothes")
@Scope("prototype")
public class ClothesAction extends ActionSupport {
	private static final long serialVersionUID = -5219469633492741982L;

	private int id;
	private String docuNum;
	private String color;
	private int size;
	private String commodity_name;
	private int ex_factory_price;
	// private Admin operator;
	private int retail_price;
	private String out_material;
	private String in_material;
	private int flag;

	@Resource
	private ClothesService clothesService;

	/**
	 * 显示货号列表
	 * 
	 * @author ANGELEN
	 * @return
	 */
	public String list() {
		ActionContext actionContext = ActionContext.getContext();
		System.out.println("jiiiiiiiiiiiiiiiiii");
		List<Clothes> clothes = clothesService.findAllByPaging(0, 15);

		if (clothes.size() > 0) {
			actionContext.put("clothes", clothes);
			for (Clothes c : clothes) {
				System.out.println("货号：" + c.getColor());
			}
			return "clothes_list_success";
		} else {
			return "clother_list_error";
		}
	}

	/**
	 * 删除货号
	 * 
	 * @author ANGELEN
	 * @return
	 */
	public String delete() {
		System.out.println("【删除管理员-->start】");
		ActionContext actionContext = ActionContext.getContext();
		Admin admin = (Admin) actionContext.getSession().get("LoginAdmin");

		System.out.println("【删除管理员-->pre】");
		String msg = clothesService.delete(docuNum, admin);
		System.out.println("【删除管理员-->after】");
		if (msg == null) {
			// 删除成功
			System.out.println("删除成功！");
			return list();
		} else {
			// 删除失败
			System.out.println("删除失败！");
			return "clothes_delete_error";
		}

	}
	
	public String update() {
		
		String msg ;
		
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocuNum() {
		return docuNum;
	}

	public void setDocuNum(String docuNum) {
		this.docuNum = docuNum;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getCommodity_name() {
		return commodity_name;
	}

	public void setCommodity_name(String commodity_name) {
		this.commodity_name = commodity_name;
	}

	public int getEx_factory_price() {
		return ex_factory_price;
	}

	public void setEx_factory_price(int ex_factory_price) {
		this.ex_factory_price = ex_factory_price;
	}

	// public Admin getOperator() {
	// return operator;
	// }
	//
	// public void setOperator(Admin operator) {
	// this.operator = operator;
	// }

	public int getRetail_price() {
		return retail_price;
	}

	public void setRetail_price(int retail_price) {
		this.retail_price = retail_price;
	}

	public String getOut_material() {
		return out_material;
	}

	public void setOut_material(String out_material) {
		this.out_material = out_material;
	}

	public String getIn_material() {
		return in_material;
	}

	public void setIn_material(String in_material) {
		this.in_material = in_material;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
