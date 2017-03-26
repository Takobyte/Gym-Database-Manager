package UI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import core.Gym;

// Manager: Gym JTable Model
public class MGTableModel  extends AbstractTableModel{
	// follow example given by other TableModels
		
		public static final int OBJECT_COL = -1;
		private String[] columnNames = {"branch_id", "name", "address", "open_date", "telephone"};
		private List<Gym> gym;
		
		public MGTableModel(List<Gym> gym) {
			this.gym = gym;
		}

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			return gym.size();
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
			Gym tempGym = gym.get(row);

			switch (col) {
			case 0:
				return tempGym.getBranch_id();
			case 1:
				return tempGym.getName();
			case 2:
				return tempGym.getAddress();
			case 3:
				return tempGym.getOpen_date();
			case 4:
				return tempGym.getTelephone();
			case OBJECT_COL:
				return tempGym;
			default:
				return tempGym.getName();
			}
		}


	}
