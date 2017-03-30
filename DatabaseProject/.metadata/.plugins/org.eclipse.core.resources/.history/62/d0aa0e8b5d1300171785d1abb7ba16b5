package UI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import core.Room;

//Manager: Room JTable Model
public class MRTableModel extends AbstractTableModel{
	// follow example given by other TableModels
	public static final int OBJECT_COL = -1;
	private String[] columnNames = {"rid", "descriptive_name", "capacity", "branch_id", "activity_room_flag", "main_equipment_room_flag"};
	private List<Room> rooms;
	
	public MRTableModel(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return rooms.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Class getColumnClass(int c) {
		Object column = getValueAt(0,c);
		if (column == null) {
			return new Object().getClass();
		} else {
			return column.getClass();
		}
	}

	@Override
	public Object getValueAt(int row, int col) {
		Room tempRoom = rooms.get(row);

		switch (col) {
		case 0:
			return tempRoom.getRid();
		case 1:
			return tempRoom.getDescriptive_name();
		case 2:
			return tempRoom.getCapacity();
		case 3:
			return tempRoom.getBranch_id();
		case 4:
			return tempRoom.getActivity_room_flag();
		case 5:
			return tempRoom.getMain_equipment_room_flag();
		case OBJECT_COL:
			return tempRoom;
		default:
			return tempRoom.getDescriptive_name();
		}
	}


}