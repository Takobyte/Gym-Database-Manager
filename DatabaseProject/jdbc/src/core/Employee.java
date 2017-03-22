package core;
import java.util.Date;
public class Employee {
	private  String emp_id;
	private  String name;
	private String job_title;
	private int salary;
	private String address;
	private Date dob;
	private int telephone;
    private float manager_flag;
    private float instructor_flag;
	public float getManager_flag() {
		return manager_flag;
	}
	public void setManager_flag(float manager_flag) {
		this.manager_flag = manager_flag;
	}
	public float getInstructor_flag() {
		return instructor_flag;
	}
	public void setInstructor_flag(float instructor_flag) {
		this.instructor_flag = instructor_flag;
	}
	public Employee(String emp_id, String name, String job_title, int salary, String address, Date dob, int telephone,
			int months_to_next_service, float manager_flag, float instructor_flag) {
		this.emp_id = emp_id;
		this.name = name;
		this.job_title = job_title;
		this.salary = salary;
		this.address = address;
		this.dob = dob;
		this.telephone = telephone;
		this.manager_flag = manager_flag;
		this.instructor_flag = instructor_flag;
	}
	public Employee(String emp_id, String name, String job_title, int salary, String address, Date dob, int telephone,
			int months_to_next_service, String rid, String sid) {
		this.emp_id = emp_id;
		this.name = name;
		this.job_title = job_title;
		this.salary = salary;
		this.address = address;
		this.dob = dob;
		this.telephone = telephone;
		
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}


	
	
	
	
}
