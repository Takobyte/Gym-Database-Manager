package core;
import java.util.Date;
public class Gym {
	private int branch_id;
	private String name;
	private String address;
	private Date open_date;
	private String telephone;
	public Gym(int branch_id, String name, String address, Date open_date, String telephone) {
		this.branch_id = branch_id;
		this.name = name;
		this.address = address;
		this.open_date = open_date;
		this.telephone = telephone;
	}
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getOpen_date() {
		return open_date;
	}
	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	       


}
