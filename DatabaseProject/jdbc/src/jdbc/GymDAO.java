package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import core.Member;

public class GymDAO {
	
	private Connection myConn;
	
	public GymDAO() throws Exception {
		// Get a connection to database
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb?useSSL=false", "root", "password");
		
		// Create a statement
		Statement myStmt = myConn.createStatement();
		
		// Execute SQL query
//			ResultSet myRs = myStmt.executeQuery("SELECT * FROM sakila.actor");
		
		// Process the result set
//			while (myRs.next()) {
//				System.out.println(myRs.getString("actor_id") + ", " + myRs.getString("first_name") + ", " + myRs.getString("last_name"));
//			}

	}
	
	public List<Member> searchMembers(String lastName) throws Exception {
		List<Member> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			lastName += "%";
			myStmt = myConn.prepareStatement("select * from Member where last_name like ?");
			
			myStmt.setString(1, lastName);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Member tempMember = convertRowToMember(myRs);
				list.add(tempMember);
			}
			
			return list;
		}
		finally {
			myRs.close();
		}
	}
	
	public List<Member> getAllMembers() throws Exception {
		List<Member> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from Member");
			
			while (myRs.next()) {
				Member tempMember = convertRowToMember(myRs);
				list.add(tempMember);
			}

			return list;		
		}
		finally {
			myRs.close();
		}
	}
	
	private Member convertRowToMember(ResultSet myRs) throws SQLException {
		
		int mid = myRs.getInt("mid");
		String name = myRs.getString("name");
		int telephone = myRs.getInt("telephone");
		String dob = myRs.getString("dob");
		String addr = myRs.getString("address");
		String stdExpDate = myRs.getString("std_exp_date");
		String prmExpDate = myRs.getString("prm_exp_date");
		int branchId = myRs.getInt("branch_id");
		
		Member tempMember = new Member(mid, name, telephone, dob, addr, stdExpDate, prmExpDate, branchId);
		
		return tempMember;
	}

}
