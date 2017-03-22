package core;
import java.util.Date;
public class Group_classes {
	String gid;
	String class_name;
	float price_for_std_member;
	Date start_time;
	Date end_time;
	String rid;
	public Group_classes(String gid, String class_name, float price_for_std_member, Date start_time, Date end_time,
			String rid) {
		this.gid = gid;
		this.class_name = class_name;
		this.price_for_std_member = price_for_std_member;
		this.start_time = start_time;
		this.end_time = end_time;
		this.rid = rid;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public float getPrice_for_std_member() {
		return price_for_std_member;
	}
	public void setPrice_for_std_member(float price_for_std_member) {
		this.price_for_std_member = price_for_std_member;
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
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	

}
