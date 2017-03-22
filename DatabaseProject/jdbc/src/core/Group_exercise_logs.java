package core;

public class Group_exercise_logs {
String log_no;
String title;
String mid;
String gid;
public Group_exercise_logs(String log_no, String title, String mid, String gid) {
	this.log_no = log_no;
	this.title = title;
	this.mid = mid;
	this.gid = gid;
}
public String getLog_no() {
	return log_no;
}
public void setLog_no(String log_no) {
	this.log_no = log_no;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getMid() {
	return mid;
}
public void setMid(String mid) {
	this.mid = mid;
}
public String getGid() {
	return gid;
}
public void setGid(String gid) {
	this.gid = gid;
}

}
