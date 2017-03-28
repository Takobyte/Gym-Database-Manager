package core;

import java.util.Date;

public class Innerjoin_Members_Gym {
	int mid;
	String name;
	String telephone;
	Date dob;
	String address;
	Date std_exp_date;
	Date prm_exp_date;
	int branch_id;
	String gym_name;
	String gym_address;
	Date open_date;
	String gym_telephone;
	
	public Innerjoin_Members_Gym(int mid, String name, String telephone, Date dob, String address, Date std_exp_date,
			Date prm_exp_date, int branch_id, String gym_name, String gym_address, Date open_date,
			String gym_telephone) {
		super();
		this.mid = mid;
		this.name = name;
		this.telephone = telephone;
		this.dob = dob;
		this.address = address;
		this.std_exp_date = std_exp_date;
		this.prm_exp_date = prm_exp_date;
		this.branch_id = branch_id;
		this.gym_name = gym_name;
		this.gym_address = gym_address;
		this.open_date = open_date;
		this.gym_telephone = gym_telephone;
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getStd_exp_date() {
		return std_exp_date;
	}
	public void setStd_exp_date(Date std_exp_date) {
		this.std_exp_date = std_exp_date;
	}
	public Date getPrm_exp_date() {
		return prm_exp_date;
	}
	public void setPrm_exp_date(Date prm_exp_date) {
		this.prm_exp_date = prm_exp_date;
	}
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	public String getGym_name() {
		return gym_name;
	}
	public void setGym_name(String gym_name) {
		this.gym_name = gym_name;
	}
	public String getGym_address() {
		return gym_address;
	}
	public void setGym_address(String gym_address) {
		this.gym_address = gym_address;
	}
	public Date getOpen_date() {
		return open_date;
	}
	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}
	public String getGym_telephone() {
		return gym_telephone;
	}
	public void setGym_telephone(String gym_telephone) {
		this.gym_telephone = gym_telephone;
	}

}
