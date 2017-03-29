package core;
import java.sql.Timestamp;
import java.util.Date;
public class Group_class {
	int gid;
	String class_name;
	double price_for_std_member;
	Timestamp start_time;
	Timestamp end_time;
	int rid;
	public Group_class(int gid, String class_name, double price_for_std_member, Timestamp start_time, Timestamp end_time,
			int rid) {
		this.gid = gid;
		this.class_name = class_name;
		this.price_for_std_member = price_for_std_member;
		this.start_time = start_time;
		this.end_time = end_time;
		this.rid = rid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public double getPrice_for_std_member() {
		return price_for_std_member;
	}
	public void setPrice_for_std_member(double price_for_std_member) {
		this.price_for_std_member = price_for_std_member;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	

}
