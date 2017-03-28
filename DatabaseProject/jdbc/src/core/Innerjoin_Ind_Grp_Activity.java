package core;

import java.util.Date;

public class Innerjoin_Ind_Grp_Activity {
	
	String activity_name;
	Date start_time;
	Date end_time;
	String type;
	public Innerjoin_Ind_Grp_Activity(String activity_name, Date start_time, Date end_time, String type) {
		super();
		this.activity_name = activity_name;
		this.start_time = start_time;
		this.end_time = end_time;
		this.type = type;
	}
	public String getActivity_name() {
		return activity_name;
	}
	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}