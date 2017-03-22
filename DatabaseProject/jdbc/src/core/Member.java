package core;

import java.util.Date;

public class Member {
	private int mid;
	private String name;
	private String telephone;
	private Date dob;
	private String addr;
	private Date stdExpDate;
	private Date prmExpDate;
	private int branchId;
	
	public Member(int mid, String name, String telephone, Date dob, String addr, Date stdExpDate, Date prmExpDate, int branchId) {
		this.mid = mid;
		this.name = name;
		this.telephone = telephone;
		this.dob = dob;
		this.addr = addr;
		this.stdExpDate = stdExpDate;
		this.prmExpDate = prmExpDate;
		this.branchId = branchId;
		
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getStdExpDate() {
		return stdExpDate;
	}

	public void setStdExpDate(Date stdExpDate) {
		this.stdExpDate = stdExpDate;
	}

	public Date getPrmExpDate() {
		return prmExpDate;
	}

	public void setPrmExpDate(Date prmExpDate) {
		this.prmExpDate = prmExpDate;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	
	
}
