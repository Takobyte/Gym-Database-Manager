package core;

public class Supplier {
	int sid;
	String name;
	String telephone;
	String address;
	public Supplier(int sid, String name, String telephone, String address) {
		this.sid = sid;
		this.name = name;
		this.telephone = telephone;
		this.address = address;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
