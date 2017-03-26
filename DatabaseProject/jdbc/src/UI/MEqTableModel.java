package UI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import core.Equipment;

// Manager: Equipment JTable Model
public class MEqTableModel extends AbstractTableModel {
	// follow example given by other TableModels
	public static final int OBJECT_COL = -1;
	private String[] columnNames = {"equip_id", "name","model_no", "price", "purchase_date","last_service_date","months_to_next_service", "rid", "sid"};
	private List<Equipment> equipment;
	
	public MEqTableModel(List<Equipment> equipment) {
		this.equipment = equipment;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return equipment.size();
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
		Equipment tempEquipment = equipment.get(row);

		switch (col) {
		case 0:
			return tempEquipment.getEquip_id();
		case 1:
			return tempEquipment.getName();
		case 2:
			return tempEquipment.getModel_no();
		case 3:
			return tempEquipment.getPrice();
		case 4:
			return tempEquipment.getPurchase_date();	
		case 5:
			return tempEquipment.getLast_service_date();
		case 6:
			return tempEquipment.getMonths_to_next_service();
		case 7:
			return tempEquipment.getRid();
		case 8:
			return tempEquipment.getSid();
		case OBJECT_COL:
			return tempEquipment;
		default:
			return tempEquipment.getName();
		}
	}
}
