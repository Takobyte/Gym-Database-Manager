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
	
	public List<Employee> searchEmployees(String name) throws Exception {
		try {
			//TODO:
			//stub
			return null;
		}
		finally {
			//TODO:
			//stub
		}
	}
	
	public List<Employee> getAllEmployees() throws Exception {
		try {
			//TODO:
			//stub
			return null;
		}
		finally {
			//TODO:
			//stub
		}
	}
	
	private Employee convertRowToEmployee(ResultSet myRs) throws SQLException {
		//TODO
		return null;
	}
	
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
