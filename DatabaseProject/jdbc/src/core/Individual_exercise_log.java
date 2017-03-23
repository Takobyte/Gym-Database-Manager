package core;
import java.util.Date;

public class Individual_exercise_log {
String log_no;
String mid;
String title;
String individual_activity_name ;
Date start_time;
Date end_time;
public Individual_exercise_log(String log_no, String mid, String title, String individual_activity_name,
		Date start_time, Date end_time) {
	this.log_no = log_no;
	this.mid = mid;
	this.title = title;
	this.individual_activity_name = individual_activity_name;
	this.start_time = start_time;
	this.end_time = end_time;
}
public String getLog_no() {
	return log_no;
}
public void setLog_no(String log_no) {
	this.log_no = log_no;
}
public String getMid() {
	return mid;
}
public void setMid(String mid) {
	this.mid = mid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getIndividual_activity_name() {
	return individual_activity_name;
}
public void setIndividual_activity_name(String individual_activity_name) {
	this.individual_activity_name = individual_activity_name;
}
public Date getStart_time() {
	return start_time;
}
public void setStart_time(Date start_time) {
	this.start_time = start_time;
}
public Date getEnd_time() {
	return end_time;
}
public void setEnd_time(Date end_time) {
	this.end_time = end_time;
}

}
