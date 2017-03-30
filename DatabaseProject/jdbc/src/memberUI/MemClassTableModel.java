package memberUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import core.Group_class;
import core.Purchase;

public class MemClassTableModel extends AbstractTableModel {
	public static final int OBJECT_COL = -1;
	private String[] columnNames = {"gid","class_name","price_for_std_member","start_time", "end_time", "rid"};
	private List<Group_class> classes;
	
	public MemClassTableModel(List<Group_class> classes) {
		this.classes = classes;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return classes.size();
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
		Group_class tempClass = classes.get(row);

		switch (col) {
		case 0:
			return tempClass.getGid();
		case 1:
			return tempClass.getClass_name();
		case 2:
			return tempClass.getPrice_for_std_member();
		case 3:
			return tempClass.getStart_time();
		case 4:
			return tempClass.getEnd_time();
		case 5:
			return tempClass.getRid();
		case OBJECT_COL:
			return tempClass;
		default:
			return tempClass.getClass_name();
		}
	}
}