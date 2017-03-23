package core;

public class Group_exercise_type {
String pid;
String name;
Float monthly_fee;
public Group_exercise_type(String pid, String name, Float monthly_fee) {
	this.pid = pid;
	this.name = name;
	this.monthly_fee = monthly_fee;
}
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Float getMonthly_fee() {
	return monthly_fee;
}
public void setMonthly_fee(Float monthly_fee) {
	this.monthly_fee = monthly_fee;
}

}
