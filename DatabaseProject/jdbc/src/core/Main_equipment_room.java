package core;

public class Main_equipment_room {
String rid;
String descriptive_name;
int capacity;
String branchId;
public Main_equipment_room(String rid, String descriptive_name, int capacity, String branchId) {
	this.rid = rid;
	this.descriptive_name = descriptive_name;
	this.capacity = capacity;
	this.branchId = branchId;
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
public String getBranchId() {
	return branchId;
}
public void setBranchId(String branchId) {
	this.branchId = branchId;
}


}
