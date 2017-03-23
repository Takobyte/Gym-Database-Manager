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
		managerWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
				}
				
			}
		});
		panelBtmMember.add(btnExit);
		
		JPanel panelTopMember = new JPanel();
		FlowLayout fl_panelTopMember = (FlowLayout) panelTopMember.getLayout();
		fl_panelTopMember.setAlignment(FlowLayout.LEFT);
		managerWindow.getContentPane().add(panelTopMember, BorderLayout.NORTH);
		
		JLabel lblEnterName = new JLabel("Enter Name:");
		panelTopMember.add(lblEnterName);
		
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
						
						ManagerMemberTableModel model = new ManagerMemberTableModel(members);
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
						
						ManagerEmployeeTableModel model = new ManagerEmployeeTableModel(employees);
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
		comboBoxMng.setModel(new DefaultComboBoxModel(new String[] {"Employee List", "Member List"}));
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
					ManagerAddMember dialog = new ManagerAddMember(ManagerUI.this, gymDAO);
	
					// show dialog
					dialog.setVisible(true);
				}
				else if (comboBoxMng.getSelectedItem().equals("Employee List")) {
					// create dialog
					ManagerAddEmployee dialog = new ManagerAddEmployee(ManagerUI.this, gymDAO);
	
					// show dialog
					dialog.setVisible(true);
				}
			}
		});
		btnInsertMng.setBorderPainted(false);
		toolBarMng.add(btnInsertMng);
		
		JButton btnDeleteMng = new JButton("Delete");
		btnDeleteMng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: Delete a selected Object using comboBoxMng.getSelectedItem()
			}
		});
		btnDeleteMng.setBorderPainted(false);
		toolBarMng.add(btnDeleteMng);
		
		JButton btnEditMng = new JButton("Edit");
		btnEditMng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: Edit a selected Object using comboBoxMng.getSelectedItem()
			}
		});
		btnEditMng.setBorderPainted(false);
		toolBarMng.add(btnEditMng);
	}
	
	public void refreshEmployeeView() {
		try {
			List<Employee> employees = gymDAO.getAllEmployees();
			// create the model and update the "table"
			ManagerEmployeeTableModel model = new ManagerEmployeeTableModel(employees);
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
			ManagerMemberTableModel model = new ManagerMemberTableModel(members);

			tableManager.setModel(model);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
