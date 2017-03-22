package core;
import java.util.Date;
public class Works_in {
	String emp_id;
	String branchId;
	Date from_date;
	Date  to_date;
	public Works_in(String emp_id, String branch_id, Date from_date, Date to_date) {
	    this.emp_id = emp_id;
		this.branchId = branch_id;
		this.from_date = from_date;
		this.to_date = to_date;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public Date getFrom_date() {
		return from_date;
	}
	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}
	public Date getTo_date() {
		return to_date;
	}
	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}
	

}
