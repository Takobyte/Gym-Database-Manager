package memberUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import core.Group_exercise_log;

public class MemGrpActTableModel extends AbstractTableModel {
	
	public static final int OBJECT_COL = -1;
	private String[] columnNames = {"log_no","title","activity_name", "gid", "start_time", "end_time"};
	private List<Group_exercise_log> activityLog;
	
	public MemGrpActTableModel(List<Group_exercise_log> activityLog) {
		this.activityLog = activityLog;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return activityLog.size();
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
		Group_exercise_log tempActivity = activityLog.get(row);

		switch (col) {
		case 0:
			return tempActivity.getLog_no();
		case 1:
			return tempActivity.getTitle();
		case 2:
			return tempActivity.getActivity_name();
		case 3:
			return tempActivity.getGid();
		case 4:
			return tempActivity.getStart_time();
		case 5:
			return tempActivity.getEnd_time();
		case OBJECT_COL:
			return tempActivity;
		default:
			return tempActivity.getTitle();
		}
	}
}
