package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import core.Employee;
import core.Member;

public class GymDAO {
	
	private Connection myConn;
	
	public GymDAO() throws Exception {
		// Get a connection to database
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym1?useSSL=false", "root", "Qw4295915.");
		
		// Create a statement
		Statement myStmt = myConn.createStatement();

	}
	
	public void delete(int id, String tableName) throws SQLException {
		//TODO: complete each cases
		PreparedStatement myStmt = null;
		
		try {
			// prepare statement
			switch (tableName) {
			case "Member":
				myStmt = myConn.prepareStatement("delete from members where id=?");
			case "Employee":
			case "Gym":
			case "Room":
			case "Equipment":
			case "Supplier":
			default:
				myStmt = null;
			}
			
			// set param
			myStmt.setInt(1, id);
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt,null);
		}
		
	}
	
//	public void deleteMember(int memberId) throws SQLException {
//		PreparedStatement myStmt = null;
//
//		try {
//			// prepare statement
//			myStmt = myConn.prepareStatement("delete from members where id=?");
//			
//			// set param
//			myStmt.setInt(1, memberId);
//			
//			// execute SQL
//			myStmt.executeUpdate();			
//		}
//		finally {
//			close(myStmt,null);
//		}
//	}
//	
//	public void deleteEmployee(int employeeId) throws SQLException {
//		//TODO: Masashi: follow deleteMember
//	}
	
//	public void update(Class<?> table) throws SQLException {
//		
//	}
	
	public void updateMember(Member member) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update Members"
					+ " set name=?, telephone=?, dob=?, address=?, std_exp_date=?, prm_exp_date=?, branch_id=?"
					+ " where mid=?");
			
			// set params
			myStmt.setString(1, member.getName());
			myStmt.setString(2, member.getTelephone());
			myStmt.setDate(3, new java.sql.Date(member.getDob().getTime()));
			myStmt.setString(4, member.getAddr());
			myStmt.setDate(5, new java.sql.Date(member.getStdExpDate().getTime()));
			myStmt.setDate(6, new java.sql.Date(member.getPrmExpDate().getTime()));
			myStmt.setInt(7, member.getBranchId());
			myStmt.setString(8, String.valueOf(member.getMid()));
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt, null);
		}
	}
	
	public void updateEmployee(Employee employee) throws SQLException {
		//TODO: Masashi: follow updateMember function in GymDAO
	}
	
	public List<Employee> searchEmployees(String name) throws Exception {
		List<Employee> list = new ArrayList<>();
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try {
			name = "%" + name + "%";
			myStmt = myConn.prepareStatement("select * from Employees where name like ?");
			myStmt.setString(1, name);
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				Employee tempEmployee = convertRowToEmployee(myRs);
				list.add(tempEmployee);
			}
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> list = new ArrayList<>();
		Statement myStmt = null;
		ResultSet myRs = null;
		try {	
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from Employees");
			while (myRs.next()) {
				Employee tempEmployee = convertRowToEmployee(myRs);
				list.add(tempEmployee);
			}
			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	private Employee convertRowToEmployee(ResultSet myRs) throws SQLException {
		int emp_id = myRs.getInt("emp_id");
		String name = myRs.getString("name");
		String job_title= myRs.getString("job_title");
		int salary= myRs.getInt("salary");
		String addr = myRs.getString("address");
		Date dob = myRs.getDate("dob");
		int telephone = myRs.getInt("telephone");
		int months_to_next_service=myRs.getInt("months_to_next_service");
		boolean manager_flag = myRs.getBoolean("manager_flag");
		boolean instructor_flag = myRs.getBoolean("instructor_flag");
		Employee tempEmployee = new Employee(emp_id,name,job_title,salary,addr,dob,telephone,months_to_next_service,manager_flag,instructor_flag);
		return tempEmployee;
	}
	public void addEmployee(Employee employee) throws Exception {
		//TODO: Masashi: similar to addMember but do not add employee ID
	}
	
//	public <T> void addMember(Class<T> type) throws Exception {
//		Member member = Member<T>
//		Employee employee;
//		
//		PreparedStatement myStmt = null;
//		
//		try {
//			// prepare statement
//			myStmt = myConn.prepareStatement("insert into members"
//					+ " (name, telephone, dob, address, std_exp_date, prm_exp_date, branch_id)"
//					+ " values (?, ?, ?, ?, ?, ?, ?)");
//			
//			// set parameters
//			myStmt.setString(1, member.getName());
//			myStmt.setString(2, member.getTelephone());
//			myStmt.setDate(3, new java.sql.Date(member.getDob().getTime()));
//			myStmt.setString(4, member.getAddr());
//			myStmt.setDate(5, new java.sql.Date(member.getStdExpDate().getTime()));
//			myStmt.setDate(6, new java.sql.Date(member.getPrmExpDate().getTime()));
//			myStmt.setInt(7, member.getBranchId());
//			
//			// execute SQL
//			myStmt.executeUpdate();
//		}
//		finally {
//			close(myStmt,null);
//		}
//	}
	
	public void addMember(Member member) throws Exception {
		PreparedStatement myStmt = null;
		
		try {
			// prepare statement
			myStmt = myConn.prepareStatement("insert into members"
					+ " (name, telephone, dob, address, std_exp_date, prm_exp_date, branch_id)"
					+ " values (?, ?, ?, ?, ?, ?, ?)");
			
			// set parameters
			myStmt.setString(1, member.getName());
			myStmt.setString(2, member.getTelephone());
			myStmt.setDate(3, new java.sql.Date(member.getDob().getTime()));
			myStmt.setString(4, member.getAddr());
			myStmt.setDate(5, new java.sql.Date(member.getStdExpDate().getTime()));
			myStmt.setDate(6, new java.sql.Date(member.getPrmExpDate().getTime()));
			myStmt.setInt(7, member.getBranchId());
			
			// execute SQL
			myStmt.executeUpdate();
		}
		finally {
			close(myStmt,null);
		}
	}
	
	public List<Member> searchMembers(String name) throws Exception {
		List<Member> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			name = "%" + name + "%";
			myStmt = myConn.prepareStatement("select * from Members where name like ?");
			
			myStmt.setString(1, name);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Member tempMember = convertRowToMember(myRs);
				list.add(tempMember);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	public List<Member> getAllMembers() throws Exception {
		List<Member> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from Members");
			
			while (myRs.next()) {
				Member tempMember = convertRowToMember(myRs);
				list.add(tempMember);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	private Member convertRowToMember(ResultSet myRs) throws SQLException {
		
		int mid = myRs.getInt("mid");
		String name = myRs.getString("name");
		String telephone = myRs.getString("telephone");
		Date dob = myRs.getDate("dob");
		String addr = myRs.getString("address");
		Date stdExpDate = myRs.getDate("std_exp_date");
		Date prmExpDate = myRs.getDate("prm_exp_date");
		int branchId = myRs.getInt("branch_id");
		
		Member tempMember = new Member(mid, name, telephone, dob, addr, stdExpDate, prmExpDate, branchId);
		
		return tempMember;
	}

	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}
}
