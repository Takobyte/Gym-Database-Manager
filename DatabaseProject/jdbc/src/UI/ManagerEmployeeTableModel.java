package UI;

import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import core.Class_purchase;
import core.Employee;

public class ManagerEmployeeTableModel extends AbstractTableModel {
	
	private String[] columnNames = {"Emp_id", "Name", "Job_Title", "Salary", "Address", "Day of Birth","Telephone", "Manager_Flag", "Instructor_Flag"};
	private List<Employee> employees;
	
	public ManagerEmployeeTableModel(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return employees.size();
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
		Employee tempEmployee = employees.get(row);

		switch (col) {
		case 0:
			return tempEmployee.getEmp_id();
		case 1:
			return tempEmployee.getName();
		case 2:
			return tempEmployee.getJob_title();
		case 3:
			return tempEmployee.getSalary();
		case 4:
			return tempEmployee.getAddress();
		case 5:
			return tempEmployee.getDob();
		case 6:
			return tempEmployee.getTelephone();
		case 7:
			return tempEmployee.getManager_flag();
		case 8:
			return tempEmployee.getInstructor_flag();
		default:
			return tempEmployee.getName();
		}
	}


}
