package core;

public class Room {
	int rid;
	String descriptive_name;
	int capacity;
	int branch_id;
	Boolean activity_room_flag;
	Boolean main_equipment_room_flag;
	public Room(int rid, String descriptive_name, int capacity, int branch_id, Boolean activity_room_flag, Boolean main_equipment_room_flag) {
		this.rid = rid;
		this.descriptive_name = descriptive_name;
		this.capacity = capacity;
		this.branch_id = branch_id;
		this.activity_room_flag = activity_room_flag;
		this.main_equipment_room_flag = main_equipment_room_flag;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getDescriptive_name() {
		return descriptive_name;
	}
	public void setDescriptive_name(String descriptive_name) {
		this.descriptive_name = descriptive_name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	};

	public Boolean getActivity_room_flag() {
		return activity_room_flag;
	}

	public void setActivity_room_flag(Boolean activity_room_flag) {
		this.activity_room_flag = activity_room_flag;
	}

	public Boolean getMain_equipment_room_flag() {
		return main_equipment_room_flag;
	}

	public void setMain_equipment_room_flag(Boolean main_equipment_room_flag) {
		this.main_equipment_room_flag = main_equipment_room_flag;
	}
}