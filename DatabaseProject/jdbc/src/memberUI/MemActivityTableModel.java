package memberUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import core.Innerjoin_Ind_Grp_Activity;

// Manager: Equipment JTable Model
public class MemActivityTableModel extends AbstractTableModel {
	// follow example given by other TableModels
	public static final int OBJECT_COL = -1;
	private String[] columnNames = {"title","start_time","end_time", "type"};
	private List<Innerjoin_Ind_Grp_Activity> activityLog;
	
	public MemActivityTableModel(List<Innerjoin_Ind_Grp_Activity> activityLog) {
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
		Innerjoin_Ind_Grp_Activity tempActivity = activityLog.get(row);

		switch (col) {
		case 1:
			return tempActivity.getActivity_name();
		case 2:
			return tempActivity.getStart_time();
		case 3:
			return tempActivity.getEnd_time();
		case 4:
			return tempActivity.getType();
		case OBJECT_COL:
			return tempActivity;
		default:
			return tempActivity.getActivity_name();
		}
	}
}
