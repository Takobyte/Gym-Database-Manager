package core;

public class Activity_room {
	String rid;
	String descriptive_name;
	int capacity;
	String branch_id;
	public Activity_room(String rid, String descriptive_name, int capacity, String branch_id) {
		this.rid = rid;
		this.descriptive_name = descriptive_name;
		this.capacity = capacity;
		this.branch_id = branch_id;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getDescriptive_name() {
		return descriptive_name;
	}
	public void setDescriptive_name(String descriptive_name) {
		this.descriptive_name = descriptive_name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	};

}
