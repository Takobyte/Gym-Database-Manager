package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import core.Member;

public class GymDAO {
	
	private Connection myConn;
	
	public GymDAO() throws Exception {
		// Get a connection to database
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym1?useSSL=false", "root", "Qw4295915.");
		
		// Create a statement
		Statement myStmt = myConn.createStatement();

	}
	
	public List<Member> searchMembers(String name) throws Exception {
		List<Member> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			name += "%";
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
