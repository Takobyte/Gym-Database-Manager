package core;

import java.sql.Time;

public class Group_exercise_log {
	int log_no;
	String title;
	int mid;
	int gid;
	Time start_time;
	Time end_time;

	public Group_exercise_log(int log_no, String title, int mid, int gid, Time start_time, Time end_time) {
		this.log_no = log_no;
		this.title = title;
		this.mid = mid;
		this.gid = gid;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	
	public int getLog_no() {
		return log_no;
	}
	public void setLog_no(int log_no) {
		this.log_no = log_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public Time getStart_time() {
		return start_time;
	}
	public void setStart_time(Time start_time) {
		this.start_time = start_time;
	}
	public Time getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Time end_time) {
		this.end_time = end_time;
	}

}
