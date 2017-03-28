package managerUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import core.Supplier;

//Manager: Supplier JTable Model
public class MSTableModel extends AbstractTableModel {
	// follow example given by other TableModels
	
	public static final int OBJECT_COL = -1;
	private String[] columnNames = {"sid", "name", "telephone", "address"};
	private List<Supplier> supplier;
	
	public MSTableModel(List<Supplier> supplier) {
		this.supplier = supplier;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return supplier.size();
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
		Supplier tempSupplier = supplier.get(row);

		switch (col) {
		case 0:
			return tempSupplier.getSid();
		case 1:
			return tempSupplier.getName();
		case 2:
			return tempSupplier.getTelephone();
		case 3:
			return tempSupplier.getAddress();
		case OBJECT_COL:
			return tempSupplier;
		default:
			return tempSupplier.getName();
		}
	}


}
