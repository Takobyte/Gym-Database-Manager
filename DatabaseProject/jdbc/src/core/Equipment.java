package core;
import java.util.Date;
public class Equipment {
	String equip_id;
	String name;
	String model_no ;
	float price;
	Date purchase_date;
	int months_to_next_service;
	String rid;
	String sid;
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public Equipment(String equip_id, String name, String model_no, float price, Date purchase_date,
			int months_to_next_service, String rid, String sid) {
		this.equip_id = equip_id;
		this.name = name;
		this.model_no = model_no;
		this.price = price;
		this.purchase_date = purchase_date;
		this.months_to_next_service = months_to_next_service;
		this.rid = rid;
		this.sid = sid;
	}
	public Equipment(String equip_id, String name, String model_no, float price, Date purchase_date,
			int months_to_next_service) {
		this.equip_id = equip_id;
		this.name = name;
		this.model_no = model_no;
		this.price = price;
		this.purchase_date = purchase_date;
		this.months_to_next_service = months_to_next_service;
	}
	public String getEquip_id() {
		return equip_id;
	}
	public void setEquip_id(String equip_id) {
		this.equip_id = equip_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel_no() {
		return model_no;
	}
	public void setModel_no(String model_no) {
		this.model_no = model_no;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}
	public int getMonths_to_next_service() {
		return months_to_next_service;
	}
	public void setMonths_to_next_service(int months_to_next_service) {
		this.months_to_next_service = months_to_next_service;
	}
	
	

}
