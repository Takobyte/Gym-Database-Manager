package UI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import core.Member;

class ManagerMemberTableModel extends AbstractTableModel{
	
	public static final int OBJECT_COL = -1;
	private String[] columnNames = {"ID", "Name", "Telephone", "Date of Birth", "Address", "std_exp_date", "prm_exp_date", "Branch ID"};
	private List<Member> members;
	
	
	
	public ManagerMemberTableModel(List<Member> members) {
		this.members = members;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return members.size();
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
		Member tempMember = members.get(row);

		switch (col) {
		case 0:
			return tempMember.getMid();
		case 1:
			return tempMember.getName();
		case 2:
			return tempMember.getTelephone();
		case 3:
			return tempMember.getDob();
		case 4:
			return tempMember.getAddr();
		case 5:
			return tempMember.getStdExpDate();
		case 6:
			return tempMember.getPrmExpDate();
		case 7:
			return tempMember.getBranchId();
		case OBJECT_COL:
			return tempMember;
		default:
			return tempMember.getName();
		}
	}

}
