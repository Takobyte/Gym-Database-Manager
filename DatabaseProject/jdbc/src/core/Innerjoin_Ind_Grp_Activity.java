package core;

import java.sql.Timestamp;

public class Innerjoin_Ind_Grp_Activity {
	
	String activity_name;
	Timestamp start_time;
	Timestamp end_time;
	String type;
	public Innerjoin_Ind_Grp_Activity(String activity_name, Timestamp start_time, Timestamp end_time, String type) {
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
	public Timestamp getStart_time() {
		return start_time;
	}
	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}
	public Timestamp getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
