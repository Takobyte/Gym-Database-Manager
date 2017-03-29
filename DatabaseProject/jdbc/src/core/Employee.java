package core;
import java.util.Date;
public class Employee {
	private  int emp_id;
	private  String name;
	private String job_title;
	private int salary;
	private String address;
	private Date dob;
	private String telephone;
    private Boolean manager_flag;
    private Boolean instructor_flag;

	public Employee(int emp_id, String name, String job_title, int salary, String address, Date dob, String telephone,
			 boolean manager_flag, boolean instructor_flag) {
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
	
	public Employee() {
		this.emp_id = 0;
		this.name = "";
		this.job_title = "";
		this.salary = 0;
		this.address = "";
		this.dob = null;
		this.telephone = "";
		this.manager_flag = false;
		this.instructor_flag = false;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Boolean getManager_flag() {
		return manager_flag;
	}

	public void setManager_flag(Boolean manager_flag) {
		this.manager_flag = manager_flag;
	}

	public Boolean getInstructor_flag() {
		return instructor_flag;
	}

	public void setInstructor_flag(Boolean instructor_flag) {
		this.instructor_flag = instructor_flag;
	}
	
	
}
