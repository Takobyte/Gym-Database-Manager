package core;

public class Member {
	private int mid;
	private String name;
	private int telephone;
	private String dob;
	private String addr;
	private String stdExpDate;
	private String prmExpDate;
	private int branchId;
	
	public Member(int mid, String name, int telephone, String dob, String addr, String stdExpDate, String prmExpDate, int branchId) {
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

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getStdExpDate() {
		return stdExpDate;
	}

	public void setStdExpDate(String stdExpDate) {
		this.stdExpDate = stdExpDate;
	}

	public String getPrmExpDate() {
		return prmExpDate;
	}

	public void setPrmExpDate(String prmExpDate) {
		this.prmExpDate = prmExpDate;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	
	
}
