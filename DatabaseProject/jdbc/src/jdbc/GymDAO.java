package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.Employee;
import core.Equipment;
import core.Group_exercise_log;
import core.Gym;
import core.Individual_exercise_log;
import core.Innerjoin_Ind_Grp_Activity;
import core.Innerjoin_Members_Gym;
import core.Member;
import core.Room;
import core.Supplier;

public class GymDAO {

	private Connection myConn;

	public GymDAO() throws Exception {
		// Get a connection to database
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym5?useSSL=false", "root", "password");

		// Create a statement
		Statement myStmt = myConn.createStatement();

	}

	public void delete(int id, String tableName) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			switch (tableName) {
			case "Member":
				myStmt = myConn.prepareStatement("delete from members where mid=?");
				break;
			case "Employee":
				myStmt = myConn.prepareStatement("delete from employees where emp_id=?");
				break;
			case "Gym":
				myStmt = myConn.prepareStatement("delete from gym where branch_id=?");
				break;
			case "Room":
				myStmt = myConn.prepareStatement("delete from room where rid=?");
				break;
			case "Equipment":
				myStmt = myConn.prepareStatement("delete from equipment where eid=?");
				break;
			case "Supplier":
				myStmt = myConn.prepareStatement("delete from suppliers where sid=?");
				break;
			default:
				myStmt = null;
				break;
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
//
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
			try {
			myStmt.setDate(3, new java.sql.Date(member.getDob().getTime()));
			} catch (NullPointerException e) {
				myStmt.setDate(3, null);
			}
			myStmt.setString(4, member.getAddr());
			try {
			myStmt.setDate(5, new java.sql.Date(member.getStdExpDate().getTime()));
			} catch (NullPointerException e) {
				myStmt.setDate(5, null);
			}
			try {
			myStmt.setDate(6, new java.sql.Date(member.getPrmExpDate().getTime()));
			} catch (NullPointerException e) {
				myStmt.setDate(6, null);
			}
			myStmt.setInt(7, member.getBranchId());
			myStmt.setInt(8, member.getMid());

			// execute SQL
			myStmt.executeUpdate();
		}
		finally {
			close(myStmt, null);
		}
	}

	public void updateEmployee(Employee employee) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update employees"
					+ " set name=?, job_title=?, salary=?, address=?, dob=?, telephone=?, manager_flag=?, instructor_flag=?"
					+ " where emp_id=?");

			// set params
			myStmt.setString(1, employee.getName());
			myStmt.setString(2, employee.getJob_title());
			myStmt.setInt(3, employee.getSalary());
			myStmt.setString(4, employee.getAddress());
			try {
			myStmt.setDate(5, new java.sql.Date(employee.getDob().getTime()));
			} catch (NullPointerException e) {
				myStmt.setDate(5, null);
			}
			myStmt.setString(6, employee.getTelephone());
			myStmt.setBoolean(7,employee.getManager_flag());
			myStmt.setBoolean(8,employee.getInstructor_flag());
			myStmt.setInt(9, employee.getEmp_id());
			// execute SQL
			myStmt.executeUpdate();
		}
		finally {
			close(myStmt, null);
		}
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
		String telephone = myRs.getString("telephone");
		boolean manager_flag = myRs.getBoolean("manager_flag");
		boolean instructor_flag = myRs.getBoolean("instructor_flag");
		Employee tempEmployee = new Employee(emp_id,name,job_title,salary,addr,dob,telephone,manager_flag,instructor_flag);
		return tempEmployee;
	}
	public void addEmployee(Employee employee) throws Exception {
		PreparedStatement myStmt = null;
		try {
			// prepare statement
			myStmt = myConn.prepareStatement("insert into employees"
					+ " (name, job_title, salary, address, dob, telephone, manager_flag,instructor_flag)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)");

			// set parameters
			myStmt.setString(1, employee.getName());
			myStmt.setString(2, employee.getJob_title());
			myStmt.setInt(3, employee.getSalary());
			myStmt.setString(4, employee.getAddress());
			try {
			myStmt.setDate(5, new java.sql.Date(employee.getDob().getTime()));
			} catch (NullPointerException e) {
				myStmt.setDate(5, null);
			}
			myStmt.setString(6, employee.getTelephone());
			myStmt.setBoolean(7,employee.getManager_flag());
			myStmt.setBoolean(8,employee.getInstructor_flag());
			// execute SQL
			myStmt.executeUpdate();
		}
		finally {
			close(myStmt,null);
		}
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
			try {
			myStmt.setDate(3, new java.sql.Date(member.getDob().getTime()));
			} catch (NullPointerException e) {
				myStmt.setDate(3, null);
			}
			myStmt.setString(4, member.getAddr());
			try {
			myStmt.setDate(5, new java.sql.Date(member.getStdExpDate().getTime()));
			} catch (NullPointerException e) {
				myStmt.setDate(5, null);
			}
			try {
			myStmt.setDate(6, new java.sql.Date(member.getPrmExpDate().getTime()));
			} catch (NullPointerException e) {
				myStmt.setDate(6, null);
			}
			myStmt.setInt(7, member.getBranchId());

			// execute SQL
			myStmt.executeUpdate();
		}
		finally {
			close(myStmt,null);
		}
	}

	public List<Member> searchMembers(String name) throws SQLException {
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

	public List<Innerjoin_Ind_Grp_Activity> searchActivity() throws SQLException {
		List<Innerjoin_Ind_Grp_Activity> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			myStmt = myConn.prepareStatement("select * from individual_exercise_logs "
					+ "inner join group_exercise_logs on individual_exercise_logs.mid = group_exercise_logs.mid");


			myRs = myStmt.executeQuery();
			while(myRs.next()) {
				Innerjoin_Ind_Grp_Activity tempInnerjoin = convertRowToActivity(myRs);
				list.add(tempInnerjoin);
			}

			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}

	private Innerjoin_Ind_Grp_Activity convertRowToActivity(ResultSet myRs) throws SQLException{
		int mid = myRs.getInt("individual_exercise_logs.mid");
		int gid = myRs.getInt("group_exercise_logs.gid");
		String activityName;
		Date start_time;
		Date end_time;
		String type;

		// If it's group exercise
		if (gid == 0) {
			activityName = myRs.getString("group_exercise_logs.title");
			start_time = myRs.getDate("group_exercise_logs.start_time");
			end_time = myRs.getDate("group_exercise_logs.end_time");
			type = "Group";
		}
		// If it's individual exercise
		else {
			activityName = myRs.getString("individual_exercise_logs.title");
			start_time = myRs.getDate("individual_exercise_logs.start_time");
			end_time = myRs.getDate("individual_exercise_logs.end_time");
			type = "Member";
		}

		Innerjoin_Ind_Grp_Activity tempInnerjoin = new Innerjoin_Ind_Grp_Activity(activityName,start_time,end_time,type);
		return tempInnerjoin;
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

	private Innerjoin_Members_Gym convertRowInnerJoin(ResultSet myRs) throws SQLException {
		int mid = myRs.getInt("members.mid");
		String name = myRs.getString("members.name");
		String telephone = myRs.getString("members.telephone");
		Date dob = myRs.getDate("members.dob");
		String address = myRs.getString("members.address");
		Date std_exp_date = myRs.getDate("members.std_exp_date");
		Date prm_exp_date = myRs.getDate("members.prm_exp_date");
		int branch_id = myRs.getInt("members.branch_id");
		String gym_name = myRs.getString("gym.name");
		String gym_address = myRs.getString("gym.address");
		Date open_date = myRs.getDate("gym.open_Date");
		String gym_telephone = myRs.getString("gym.telephone");

		Innerjoin_Members_Gym tempInnerjoin = new Innerjoin_Members_Gym(mid,name,telephone,dob,address,std_exp_date,
				prm_exp_date, branch_id, gym_name, gym_address, open_date, gym_telephone);

		return tempInnerjoin;
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

	public void updateRoom(Room room) throws SQLException{
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update Room"
					+ " descriptive_name=?, capacity=?, branch_id=?, activity_room_flag=?, main_equipment_room_flag=?"
					+ " where rid=?");

			// set params
			myStmt.setString(1, room.getDescriptive_name());
			myStmt.setInt(2, room.getCapacity());
			myStmt.setInt(3, room.getBranch_id());
			myStmt.setBoolean(4, room.getActivity_room_flag());
			myStmt.setBoolean(5, room.getMain_equipment_room_flag());
			myStmt.setInt(6, room.getRid());

			// execute SQL
			myStmt.executeUpdate();
		}
		finally {
			close(myStmt, null);
		}

	}

	public void addRoom(Room room) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("insert into room"
					+ " (descriptive_name, capacity, branch_id, activity_room_flag, main_equipment_room_flag)"
					+ " values (?, ?, ?, ?, ?)");

			// set parameters
			myStmt.setString(1, room.getDescriptive_name());
			myStmt.setInt(2, room.getCapacity());
			myStmt.setInt(3, room.getBranch_id());
			myStmt.setBoolean(4, room.getActivity_room_flag());
			myStmt.setBoolean(5, room.getMain_equipment_room_flag());

			// execute SQL
			myStmt.executeUpdate();
		}
		finally {
			close(myStmt,null);
		}

	}

	public List<Gym> getAllGyms() throws Exception{
		List<Gym> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from Gym");

			while (myRs.next()) {
				Gym tempGym = convertRowToGym(myRs);
				list.add(tempGym);
			}

			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}

	private Gym convertRowToGym(ResultSet myRs) throws SQLException {
		int bid = myRs.getInt("branch_id");
		String name = myRs.getString("name");
		String address = myRs.getString("address");
		Date open_date = myRs.getDate("open_date");
		String telephone = myRs.getString("telephone");

		Gym tempGym = new Gym(bid,name,address,open_date,telephone);

		return tempGym;
	}

	public List<Room> getAllRooms() throws Exception {
		List<Room> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from Room");

			while (myRs.next()) {
				Room tempRoom = convertRowToRoom(myRs);
				list.add(tempRoom);
			}

			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}

	private Room convertRowToRoom(ResultSet myRs) throws SQLException {
		int rid = myRs.getInt("rid");
		String descriptive_name = myRs.getString("descriptive_name");
		int capacity = myRs.getInt("capacity");
		int branch_id = myRs.getInt("branch_id");
		Boolean activity_room_flag = myRs.getBoolean("activity_room_flag");
		Boolean main_equipment_room_flag = myRs.getBoolean("main_equipment_room_flag");

		Room tempRoom = new Room(rid, descriptive_name, capacity, branch_id, activity_room_flag, main_equipment_room_flag);

		return tempRoom;
	}

	public List<Equipment> getAllEquipments() throws SQLException {
		List<Equipment> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from equipment");

			while (myRs.next()) {
				Equipment tempEq = convertRowToEq(myRs);
				list.add(tempEq);
			}

			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}

	private Equipment convertRowToEq(ResultSet myRs) throws SQLException {
		int equip_id = myRs.getInt("equip_id");
		String name = myRs.getString("name");
		String model_no = myRs.getString("model_no");
		Float price = myRs.getFloat("price");
		Date purchase_date = myRs.getDate("purchase_date");
		Date last_service_date = myRs.getDate("last_service_date");
		int months_to_next_service = myRs.getInt("months_to_next_service");
		int rid = myRs.getInt("rid");
		int sid = myRs.getInt("sid");

		Equipment tempEq = new Equipment(equip_id, name, model_no, price, purchase_date, last_service_date, months_to_next_service,
				rid, sid);

		return tempEq;
	}

	public List<Supplier> getAllSuppliers() throws SQLException {
		List<Supplier> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from Suppliers");

			while (myRs.next()) {
				Supplier tempSupplier = convertRowToSupplier(myRs);
				list.add(tempSupplier);
			}

			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}

	private Supplier convertRowToSupplier(ResultSet myRs) throws SQLException {
		int sid = myRs.getInt("sid");
		String name = myRs.getString("name");
		String telephone = myRs.getString("telephone");
		String address = myRs.getString("address");

		Supplier tempSupplier = new Supplier(sid, name, telephone, address);

		return tempSupplier;
	}

	public List<Room> searchRooms(String name) throws SQLException {
		List<Room> list = new ArrayList<>();
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try {
			name = "%" + name + "%";
			myStmt = myConn.prepareStatement("select * from Room where name like ?");
			myStmt.setString(1, name);
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				Room tempRoom = convertRowToRoom(myRs);
				list.add(tempRoom);
			}
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}

	public List<Gym> searchGyms(String name) throws SQLException {
		List<Gym> list = new ArrayList<>();
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try {
			name = "%" + name + "%";
			myStmt = myConn.prepareStatement("select * from Gym where name like ?");
			myStmt.setString(1, name);
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				Gym tempGym = convertRowToGym(myRs);
				list.add(tempGym);
			}
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}

	public List<Equipment> searchEquipments(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Supplier> searchSuppliers(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateGym(Gym tempGym) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update Gym"
					+ " set name=?, address=?, open_date=?, telephone=?"
					+ " where branch_id=?");

			// set params
			myStmt.setString(1, tempGym.getName());
			myStmt.setString(2, tempGym.getAddress());
			try {
			myStmt.setDate(3, new java.sql.Date(tempGym.getOpen_date().getTime()));
			} catch (NullPointerException e) {
				myStmt.setDate(3, null);
			}
			myStmt.setString(4, tempGym.getTelephone());

			// execute SQL
			myStmt.executeUpdate();
		}
		finally {
			close(myStmt, null);
		}

	}

	public void addGym(Gym tempGym) throws SQLException{
		PreparedStatement myStmt = null;

		try {
			// prepare statement

			myStmt = myConn.prepareStatement("insert into Gym"
					+ " (name, address, open_date, telephone)"
					+ " values (?, ?, ?, ?)");

			// set parameters
			myStmt.setString(1, tempGym.getName());
			myStmt.setString(2, tempGym.getAddress());
			try {
			myStmt.setDate(3, new java.sql.Date(tempGym.getOpen_date().getTime()));
			} catch (NullPointerException e) {
				myStmt.setDate(3, null);
			}
			myStmt.setString(4, tempGym.getTelephone());
			// execute SQL
			myStmt.executeUpdate();
		}
		finally {
			close(myStmt,null);
		}

	}

	public void updateEq(Equipment tempEq) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update Equipment"
					+ " set equip_id=?,name=?, model_no=?, price=?, purchase_date=?, last_service_date=?, months_to_next_service=?, rid=?,sid=?"
					+ " where equip_id=?");

			// set params
			myStmt.setInt(1, tempEq.getEquip_id());
			myStmt.setString(2, tempEq.getName());
			myStmt.setString(3, tempEq.getModel_no());
			myStmt.setFloat(4, tempEq.getPrice());
			myStmt.setDate(5, new java.sql.Date(tempEq.getPurchase_date().getTime()));
			myStmt.setDate(6, new java.sql.Date(tempEq.getLast_service_date().getTime()));
			myStmt.setInt(7,tempEq.getMonths_to_next_service());
			myStmt.setInt(8,tempEq.getRid());
			myStmt.setInt(9, tempEq.getSid());
			// execute SQL
			myStmt.executeUpdate();
		}
		finally {
			close(myStmt, null);
		}

	}

	public void addEq(Equipment tempEq) throws SQLException{
		PreparedStatement myStmt = null;
		try {
			// prepare statement
			myStmt = myConn.prepareStatement("insert into Equipment"
					+ " (name,model_no,price, purchase_date, last_service_date)"
					+ " values (?, ?, ?, ?, ?)");

			// set parameters
			myStmt.setString(1, tempEq.getName());
			myStmt.setString(2, tempEq.getModel_no());
			myStmt.setFloat(3,tempEq.getPrice());
			try {
			myStmt.setDate(4, new java.sql.Date(tempEq.getPurchase_date().getTime()));
			} catch (NullPointerException e) {
				myStmt.setDate(4, null);
			}
			try {
			myStmt.setDate(5, new java.sql.Date(tempEq.getLast_service_date().getTime()));
			} catch (NullPointerException e) {
				myStmt.setDate(5, null);
			}
			// execute SQL
			myStmt.executeUpdate();
		}
		finally {
			close(myStmt,null);
		}

	}

	public int getSum(String colName, String tabName) throws SQLException {

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			myStmt = myConn.prepareStatement("select SUM(" + colName + ") "
					+ "FROM " + tabName);


			myRs = myStmt.executeQuery();
			int sum = 0;
			while(myRs.next()) {
				sum = myRs.getInt(1);
			}
			return sum;

		}
		finally {
			close(myStmt, myRs);
		}
	}

	public int getMin(String colName, String tabName) throws SQLException {

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			myStmt = myConn.prepareStatement("select MIN(" + colName + ") "
					+ "FROM " + tabName);


			myRs = myStmt.executeQuery();
			int min = 0;
			while(myRs.next()) {
				min = myRs.getInt(1);
			}
			return min;

		}
		finally {
			close(myStmt, myRs);
		}
	}

	public int getMax(String colName, String tabName) throws SQLException {

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			myStmt = myConn.prepareStatement("select MAX(" + colName + ") "
					+ "FROM " + tabName);


			myRs = myStmt.executeQuery();
			int max = 0;
			while(myRs.next()) {
				max = myRs.getInt(1);
			}
			return max;

		}
		finally {
			close(myStmt, myRs);
		}
	}

	public int getAvg(String colName, String tabName) throws SQLException {

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			myStmt = myConn.prepareStatement("select AVG(" + colName + ") "
					+ "FROM " + tabName);


			myRs = myStmt.executeQuery();
			int avg = 0;
			while(myRs.next()) {
				avg = myRs.getInt(1);
			}
			return avg;

		}
		finally {
			close(myStmt, myRs);
		}
	}

	public List<Innerjoin_Members_Gym> joinTable() throws SQLException {

		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		List<Innerjoin_Members_Gym> list = new ArrayList<>();
		try {
			myStmt = myConn.prepareStatement("select * from Members "
					+ "inner join Gym on members.branch_id = gym.branch_id");


			myRs = myStmt.executeQuery();
			while(myRs.next()) {
				Innerjoin_Members_Gym tempInnerjoin = convertRowInnerJoin(myRs);
				list.add(tempInnerjoin);
			}

			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}

	public void updateIndAct(Individual_exercise_log indActivity) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update individual_exercise_logs"
					+ " set title=?, individual_activity_name=?, start_time=?, end_time=?"
					+ " where log_no=?");

			// set params
			myStmt.setString(1, indActivity.getTitle());
			myStmt.setString(2, indActivity.getIndividual_activity_name());
			myStmt.setTime(3, indActivity.getStart_time());
			myStmt.setTime(4, indActivity.getEnd_time());
			myStmt.setInt(5, indActivity.getLog_no());

			// execute SQL
			myStmt.executeUpdate();
		}
		finally {
			close(myStmt, null);
		}
	}

	public void addIndAct(Individual_exercise_log tempIndAct) throws SQLException{
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("insert into individual_exercise_logs"
					+ " (mid, title, individual_activity_name, start_time, end_time)"
					+ " values (?, ?, ?, ?, ?)");

			// set parameters
			myStmt.setInt(1, tempIndAct.getMid());
			myStmt.setString(2, tempIndAct.getTitle());
			myStmt.setString(3, tempIndAct.getIndividual_activity_name());
			myStmt.setTime(4, tempIndAct.getStart_time());
			myStmt.setTime(5, tempIndAct.getEnd_time());

			// execute SQL
			myStmt.executeUpdate();
		}
		finally {
			close(myStmt,null);
		}

	}

	public List<Individual_exercise_log> getAllIndAct(int mid) throws SQLException{
		List<Individual_exercise_log> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from individual_exercise_logs where mid = " + mid);

			while (myRs.next()) {
				Individual_exercise_log tempLog = convertRowToIndAct(myRs);
				list.add(tempLog);
			}

			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}

	private Individual_exercise_log convertRowToIndAct(ResultSet myRs) throws SQLException {
		int log_no = myRs.getInt("log_no");
		int mid = myRs.getInt("mid");
		String title = myRs.getString("title");
		String individual_activity_name = myRs.getString("individual_activity_name");
		Time start_time = myRs.getTime("start_time");
		Time end_time = myRs.getTime("end_time");
		Individual_exercise_log tempLog = new Individual_exercise_log(log_no,mid,title,individual_activity_name,start_time
				,end_time);
		return tempLog;
	}

	public Member fetchMember(Member member, int mid) throws SQLException {
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from members where mid = " + mid);

			while (myRs.next()) {
				member.setMid(myRs.getInt("mid"));
				member.setName(myRs.getString("name"));
				member.setTelephone(myRs.getString("telephone"));
				member.setDob(myRs.getDate("dob"));
				member.setAddr(myRs.getString("address"));
				member.setStdExpDate(myRs.getDate("std_exp_date"));
				member.setPrmExpDate(myRs.getDate("prm_exp_date"));
				member.setBranchId(myRs.getInt("branch_id"));
			}

			return member;
		}
		finally {
			close(myStmt, myRs);
		}

	}

	public void updateGrpAct(Group_exercise_log tempGrpAct) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update group_exercise_logs"
					+ " set title=?, gid=?, start_time=?, end_time=?"
					+ " where log_no=?");

			// set params
			myStmt.setString(1, tempGrpAct.getTitle());
			myStmt.setInt(2, tempGrpAct.getGid());
			myStmt.setTime(3, tempGrpAct.getStart_time());
			myStmt.setTime(4, tempGrpAct.getEnd_time());
			myStmt.setInt(5, tempGrpAct.getLog_no());

			// execute SQL
			myStmt.executeUpdate();
		}
		finally {
			close(myStmt, null);
		}
	}

	public void addGrpAct(Group_exercise_log tempGrpAct) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("insert into group_exercise_logs"
					+ " (title, mid, gid, start_time, end_time)"
					+ " values (?, ?, ?, ?, ?)");

			// set parameters
			myStmt.setString(1, tempGrpAct.getTitle());
			myStmt.setInt(2, tempGrpAct.getMid());
			myStmt.setInt(3, tempGrpAct.getGid());
			myStmt.setTime(4, tempGrpAct.getStart_time());
			myStmt.setTime(5, tempGrpAct.getEnd_time());

			// execute SQL
			myStmt.executeUpdate();
		}
		finally {
			close(myStmt,null);
		}

	}

	public List<Group_exercise_log> getAllGrpAct(int mid) throws SQLException{
		List<Group_exercise_log> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from group_exercise_logs where mid = " + mid);

			while (myRs.next()) {
				Group_exercise_log tempLog = convertRowToGrpAct(myRs);
				list.add(tempLog);
			}

			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}

	private Group_exercise_log convertRowToGrpAct(ResultSet myRs) throws SQLException{
		int log_no = myRs.getInt("log_no");
		String title = myRs.getString("title");
		int mid = myRs.getInt("mid");
		int gid = myRs.getInt("gid");
		Time start_time = myRs.getTime("start_time");
		Time end_time = myRs.getTime("end_time");
		Group_exercise_log tempLog = new Group_exercise_log(log_no,title,mid,gid,start_time,end_time);
		return tempLog;
	}
}
