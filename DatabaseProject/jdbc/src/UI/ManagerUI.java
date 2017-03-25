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
import core.Member;

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
					else if (comboBoxMng.getSelectedItem() == "Gym") {
						//TODO: follow example top
					}
					else if (comboBoxMng.getSelectedItem() == "Room") {
						//TODO: follow example top
					}
					else if (comboBoxMng.getSelectedItem() == "Equipment") {
						//TODO: follow example top
					}
					else if (comboBoxMng.getSelectedItem() == "Supplier") {
						//TODO: follow example top
					}
				}
				catch (Exception exc) {
					JOptionPane.showMessageDialog(ManagerUI.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
				}	
			}
		});
		panelTopMember.add(btnSearchMng);
		
		comboBoxMng = new JComboBox();
		comboBoxMng.setModel(new DefaultComboBoxModel(new String[] {"Employee List", "Member List", "Gym", "Room", "Equipment", "Supplier"}));
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
					MEDialogue dialog = new MEDialogue(ManagerUI.this, gymDAO);
	
					// show dialog
					dialog.setVisible(true);
				}
				else if (comboBoxMng.getSelectedItem() == "Gym") {
					//TODO: create new MGDialogue
				}
				else if (comboBoxMng.getSelectedItem() == "Room") {
					//TODO: create new MRDialogue
				}
				else if (comboBoxMng.getSelectedItem() == "Equipment") {
					//TODO: create new MEqDialogue
				}
				else if (comboBoxMng.getSelectedItem() == "Supplier") {
					//TODO: create new MSDialogue
				}
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
					//TODO: Masashi: Do the same as member
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
					//TODO: Masashi: Do the same as member
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
		//TODO: follow example for member
	}
	
	public void refreshRoomView() {
		//TODO: follow example for member
	}
	
	public void refreshEquipmentView() {
		//TODO: follow example for member
	}
	
	public void refreshSupplierView() {
		//TODO: follow example for member
	}
}
