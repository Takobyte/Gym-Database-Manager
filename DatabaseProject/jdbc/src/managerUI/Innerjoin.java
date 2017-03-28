package managerUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import core.Innerjoin_Members_Gym;

public class Innerjoin extends AbstractTableModel {
	
	public static final int OBJECT_COL = -1;
	private String[] columnNames = {"mid", "name", "telephone", "dob", "address", "std_exp_date", "prm_exp_date", "branch_id", "gym_name", "gym_address", 
			"open_date", "gym_telephone"};
	private List<Innerjoin_Members_Gym> member_gym;
	
	public Innerjoin(List<Innerjoin_Members_Gym> member_gym) {
		this.member_gym = member_gym;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return member_gym.size();
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
		Innerjoin_Members_Gym tempInnerJoin = member_gym.get(row);

		switch (col) {
		case 0:
			return tempInnerJoin.getMid();
		case 1:
			return tempInnerJoin.getName();
		case 2:
			return tempInnerJoin.getTelephone();
		case 3:
			return tempInnerJoin.getDob();
		case 4:
			return tempInnerJoin.getAddress();
		case 5:
			return tempInnerJoin.getStd_exp_date();
		case 6:
			return tempInnerJoin.getPrm_exp_date();
		case 7:
			return tempInnerJoin.getBranch_id();
		case 8:
			return tempInnerJoin.getGym_name();
		case 9:
			return tempInnerJoin.getGym_address();
		case 10:
			return tempInnerJoin.getOpen_date();
		case 11:
			return tempInnerJoin.getGym_telephone();
		case OBJECT_COL:
			return tempInnerJoin;
		default:
			return tempInnerJoin.getName();
		}
	}


}
