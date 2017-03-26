package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import core.Employee;
import core.Gym;
import core.Member;
import core.Room;
import core.Equipment;
import core.Supplier;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.JToolBar;

public class ManagerUI extends Login{

	private JFrame managerWindow;
	private JTextField txtbNameMng;
	private JTable tableManager;
	private JComboBox comboBoxMng;
	
	/**
	 * Launch the application.
	 */
	public static void managerUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerUI window = new ManagerUI();
					window.managerWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManagerUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		managerWindow = new JFrame();
		managerWindow.setTitle("Manager");
		managerWindow.setBounds(100, 100, 503, 324);
		managerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		managerWindow.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelBtmMember = new JPanel();
		managerWindow.getContentPane().add(panelBtmMember, BorderLayout.SOUTH);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				managerWindow.dispose();
				loginVisibility();
			}
		});
		panelBtmMember.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// close dialog
				setVisible(false);
				managerWindow.dispose();
				Container tempFrame = btnExit.getParent();
				do {
					tempFrame = tempFrame.getParent();
				} while (!(tempFrame instanceof JFrame)); {
					((JFrame) tempFrame).dispose();
					exit();
				}
				
			}
		});
		panelBtmMember.add(btnExit);
		
		JPanel panelTopMember = new JPanel();
		FlowLayout fl_panelTopMember = (FlowLayout) panelTopMember.getLayout();
		fl_panelTopMember.setAlignment(FlowLayout.LEFT);
		managerWindow.getContentPane().add(panelTopMember, BorderLayout.NORTH);
		
		JLabel lblFilter = new JLabel("Filter:");
		panelTopMember.add(lblFilter);
		
		txtbNameMng = new JTextField();
		panelTopMember.add(txtbNameMng);
		txtbNameMng.setColumns(10);
		
		JButton btnSearchMng = new JButton("Search");
		btnSearchMng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Get last name from text field
				try {
					if (comboBoxMng.getSelectedItem() == "Member List") {
						String name = txtbNameMng.getText();
						List<Member> members = null;
						if (name != null && name.trim().length() > 0) {
							members = gymDAO.searchMembers(name);
						}
						else {
							members = gymDAO.getAllMembers();
						}
						for (Member temp : members) {
							System.out.println(temp);
						}
						
						MMTableModel model = new MMTableModel(members);
						tableManager.setModel(model);
						
					}
					else if (comboBoxMng.getSelectedItem() == "Employee List") {
						String name = txtbNameMng.getText();
						List<Employee> employees = null;
						if (name != null && name.trim().length() > 0) {
							employees = gymDAO.searchEmployees(name);
						}
						else {
							employees= gymDAO.getAllEmployees();
						}
						for (Employee temp :employees) {
							System.out.println(temp);
						}
						
						METableModel model = new METableModel(employees);
						tableManager.setModel(model);
					}
					else if (comboBoxMng.getSelectedItem() == "Gym List") {
						String name = txtbNameMng.getText();
						List<Gym> gyms = null;
						if (name != null && name.trim().length() > 0) {
							gyms = gymDAO.searchGyms(name);
						}
						else {
							gyms= gymDAO.getAllGyms();
						}
						for (Gym temp :gyms) {
							System.out.println(temp);
						}
						
						MGTableModel model = new MGTableModel(gyms);
						tableManager.setModel(model);
					}
					else if (comboBoxMng.getSelectedItem() == "Room List") {
						String name = txtbNameMng.getText();
						List<Room> rooms = null;
						if (name != null && name.trim().length() > 0) {
							rooms = gymDAO.searchRooms(name);
						}
						else {
							rooms= gymDAO.getAllRooms();
						}
						for (Room temp :rooms) {
							System.out.println(temp);
						}
						
						MRTableModel model = new MRTableModel(rooms);
						tableManager.setModel(model);
					}
					else if (comboBoxMng.getSelectedItem() == "Equipment List") {
						String name = txtbNameMng.getText();
						List<Equipment> equipments = null;
						if (name != null && name.trim().length() > 0) {
							equipments = gymDAO.searchEquipments(name);
						}
						else {
							equipments= gymDAO.getAllEquipments();
						}
						for (Equipment temp :equipments) {
							System.out.println(temp);
						}
						
						MEqTableModel model = new MEqTableModel(equipments);
						tableManager.setModel(model);
					}
					else if (comboBoxMng.getSelectedItem() == "Supplier List") {
						String name = txtbNameMng.getText();
						List<Supplier> suppliers = null;
						if (name != null && name.trim().length() > 0) {
							suppliers = gymDAO.searchSuppliers(name);
						}
						else {
							suppliers= gymDAO.getAllSuppliers();
						}
						for (Supplier temp :suppliers) {
							System.out.println(temp);
						}
						
						MSTableModel model = new MSTableModel(suppliers);
						tableManager.setModel(model);
					}
				}
				catch (Exception exc) {
					JOptionPane.showMessageDialog(ManagerUI.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
				}	
			}
		});
		panelTopMember.add(btnSearchMng);
		
		comboBoxMng = new JComboBox();
		comboBoxMng.setModel(new DefaultComboBoxModel(new String[] {"Employee List", "Member List", "Gym List", "Room List", "Equipment List", "Supplier List"}));
		panelTopMember.add(comboBoxMng);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		managerWindow.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		tableManager = new JTable();
		tableManager.setToolTipText("");
		scrollPane.setViewportView(tableManager);
		
		JToolBar toolBarMng = new JToolBar();
		toolBarMng.setOrientation(SwingConstants.VERTICAL);
		managerWindow.getContentPane().add(toolBarMng, BorderLayout.WEST);
		
		JButton btnInsertMng = new JButton("Insert");
		btnInsertMng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxMng.getSelectedItem().equals("Member List")) {
					// create dialog
					MMDialogue dialog = new MMDialogue(ManagerUI.this, gymDAO, null, false);
	
					// show dialog
					dialog.setVisible(true);
				}
				else if (comboBoxMng.getSelectedItem().equals("Employee List")) {
					// create dialog
					MEDialogue dialog = new MEDialogue(ManagerUI.this, gymDAO, null, false);
	
					// show dialog
					dialog.setVisible(true);
				}
				else if (comboBoxMng.getSelectedItem() == "Gym List") {
					MGDialogue dialog = new MGDialogue(ManagerUI.this, gymDAO, null, false);
					dialog.setVisible(true);
				}
				else if (comboBoxMng.getSelectedItem() == "Room List") {
					MRDialogue dialog = new MRDialogue(ManagerUI.this, gymDAO, null, false);
					dialog.setVisible(true);
				}
				else if (comboBoxMng.getSelectedItem() == "Equipment List") {
					MEqDialogue dialog = new MEqDialogue(ManagerUI.this, gymDAO, null, false);
					dialog.setVisible(true);
				}
				//TODO: uncomment this later
//				else if (comboBoxMng.getSelectedItem() == "Supplier List") {
//					MSDialogue dialog = new MSDialogue(ManagerUI.this, gymDAO, null, false);
//					dialog.setVisible(true);
//				}
			}
		});
		btnInsertMng.setBorderPainted(false);
		toolBarMng.add(btnInsertMng);
		
		JButton btnDeleteMng = new JButton("Delete");
		btnDeleteMng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: transform this method so that it edits Member, employee, gym, etc (DO NOT CREATE NEW IF ELSE
				// FOR employee,etc)
				if (comboBoxMng.getSelectedItem().equals("Member List")) {
					try {
						// get the selected row
						int row = tableManager.getSelectedRow();

						// make sure a row is selected
						if (row < 0) {
							JOptionPane.showMessageDialog(ManagerUI.this, 
									"You must select a member", "Error", JOptionPane.ERROR_MESSAGE);				
							return;
						}

						// prompt the user
						int response = JOptionPane.showConfirmDialog(
								ManagerUI.this, "Delete this member?", "Confirm", 
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						if (response != JOptionPane.YES_OPTION) {
							return;
						}

						// get the current member
						Member tempMember = (Member) tableManager.getValueAt(row, MMTableModel.OBJECT_COL);

						// delete the member
						gymDAO.delete(tempMember.getMid(), "Member");

						// refresh GUI
						refreshMemberView();

						// show success message
						JOptionPane.showMessageDialog(ManagerUI.this,
								"Member deleted succesfully.", "Member Deleted",
								JOptionPane.INFORMATION_MESSAGE);

					} catch (Exception exc) {
						JOptionPane.showMessageDialog(ManagerUI.this,
								"Error deleting member: " + exc.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				}
				else if (comboBoxMng.getSelectedItem().equals("Employee List")) {
					try {
						// get the selected row
						int row = tableManager.getSelectedRow();

						// make sure a row is selected
						if (row < 0) {
							JOptionPane.showMessageDialog(ManagerUI.this, 
									"You must select an employee", "Error", JOptionPane.ERROR_MESSAGE);				
							return;
						}

						// prompt the user
						int response = JOptionPane.showConfirmDialog(
								ManagerUI.this, "Delete this employee?", "Confirm", 
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						if (response != JOptionPane.YES_OPTION) {
							return;
						}

						// get the current employee
						Employee tmpEmployee = (Employee) tableManager.getValueAt(row, METableModel.OBJECT_COL);

						// delete the member
						gymDAO.delete(tmpEmployee.getEmp_id(), "Employee");

						// refresh GUI
						refreshEmployeeView();

						// show success message
						JOptionPane.showMessageDialog(ManagerUI.this,
								"Employee deleted succesfully.", "Employee Deleted",
								JOptionPane.INFORMATION_MESSAGE);

					} catch (Exception exc) {
						JOptionPane.showMessageDialog(ManagerUI.this,
								"Error deleting employee: " + exc.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (comboBoxMng.getSelectedItem().equals("Gym List")) {
					try {
						// get the selected row
						int row = tableManager.getSelectedRow();

						// make sure a row is selected
						if (row < 0) {
							JOptionPane.showMessageDialog(ManagerUI.this, 
									"You must select a gym", "Error", JOptionPane.ERROR_MESSAGE);				
							return;
						}

						// prompt the user
						int response = JOptionPane.showConfirmDialog(
								ManagerUI.this, "Delete this gym?", "Confirm", 
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						if (response != JOptionPane.YES_OPTION) {
							return;
						}

						// get the current gym
						Gym tempGym = (Gym) tableManager.getValueAt(row, MGTableModel.OBJECT_COL);

						// delete the member
						gymDAO.delete(tempGym.getBranch_id(), "Gym");

						// refresh GUI
						refreshGymView();

						// show success message
						JOptionPane.showMessageDialog(ManagerUI.this,
								"Gym deleted succesfully.", "Gym Deleted",
								JOptionPane.INFORMATION_MESSAGE);

					} catch (Exception exc) {
						JOptionPane.showMessageDialog(ManagerUI.this,
								"Error deleting gym: " + exc.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnDeleteMng.setBorderPainted(false);
		toolBarMng.add(btnDeleteMng);
		
		JButton btnEditMng = new JButton("Edit");
		btnEditMng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: transform this method so that it edits Member, employee, gym, etc (DO NOT CREATE NEW IF ELSE
				// FOR employee,etc)
				if (comboBoxMng.getSelectedItem().equals("Member List")) {
					// get the selected item
					int row = tableManager.getSelectedRow();
					
					// make sure a row is selected
					if (row < 0) {
						JOptionPane.showMessageDialog(ManagerUI.this, "You must select a Member", "Error",
								JOptionPane.ERROR_MESSAGE);				
						return;
					}
					
					// get the current member
					Member tempMember = (Member) tableManager.getValueAt(row, MMTableModel.OBJECT_COL);
					
					// create dialog
					MMDialogue dialog = new MMDialogue(ManagerUI.this, gymDAO, 
																tempMember, true);

					// show dialog
					dialog.setVisible(true);
				}
				else if (comboBoxMng.getSelectedItem().equals("Employee List")) {
					// get the selected item
					int row = tableManager.getSelectedRow();
					
					// make sure a row is selected
					if (row < 0) {
						JOptionPane.showMessageDialog(ManagerUI.this, "You must select a Employee", "Error",
								JOptionPane.ERROR_MESSAGE);				
						return;
					}
					
					// get the current employee
					Employee tempEmployee = (Employee) tableManager.getValueAt(row, METableModel.OBJECT_COL);
					
					// create dialog
					MEDialogue dialog = new MEDialogue(ManagerUI.this, gymDAO, tempEmployee, true);

					// show dialog
					dialog.setVisible(true);
				}
			}
		});
		btnEditMng.setBorderPainted(false);
		toolBarMng.add(btnEditMng);
	}
	
	public void refreshEmployeeView() {
		try {
			List<Employee> employees = gymDAO.getAllEmployees();
			// create the model and update the "table"
			METableModel model = new METableModel(employees);
			tableManager.setModel(model);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void refreshMemberView() {
		try {
			List<Member> members = gymDAO.getAllMembers();

			// create the model and update the "table"
			MMTableModel model = new MMTableModel(members);

			tableManager.setModel(model);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void refreshGymView() {
		// need new gymDAO method
		try {
			List<Gym> gyms = gymDAO.getAllGyms();

			// create the model and update the "table"
			MGTableModel model = new MGTableModel(gyms);

			tableManager.setModel(model);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void refreshRoomView() {
		try {
			List<Room> rooms = gymDAO.getAllRooms();

			// create the model and update the "table"
			MRTableModel model = new MRTableModel(rooms);

			tableManager.setModel(model);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void refreshEquipmentView() {
		try {
			List<Equipment> equipments = gymDAO.getAllEquipments();

			// create the model and update the "table"
			MEqTableModel model = new MEqTableModel(equipments);

			tableManager.setModel(model);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void refreshSupplierView() {
		try {
			List<Supplier> suppliers = gymDAO.getAllSuppliers();

			// create the model and update the "table"
			MSTableModel model = new MSTableModel(suppliers);

			tableManager.setModel(model);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
