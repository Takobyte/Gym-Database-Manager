package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import core.Member;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.JToolBar;

public class ManagerUI extends Login{

	private JFrame managerWindow;
	private JTextField txtbNameMng;
	private JTable tableMember;
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
							System.out.println(temp.getName());
						}
						
						ManagerTableModel model = new ManagerTableModel(members);
						tableMember.setModel(model);
						tableMember.createDefaultColumnsFromModel();
					}
					else if (comboBoxMng.getSelectedItem() == "Employee List") {
						// stub
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
		
		tableMember = new JTable();
		tableMember.setToolTipText("");
		scrollPane.setViewportView(tableMember);
		
		JToolBar toolBarMng = new JToolBar();
		toolBarMng.setOrientation(SwingConstants.VERTICAL);
		managerWindow.getContentPane().add(toolBarMng, BorderLayout.WEST);
		
		JButton btnInsertMng = new JButton("Insert");
		btnInsertMng.setBorderPainted(false);
		toolBarMng.add(btnInsertMng);
		
		JButton btnDeleteMng = new JButton("Delete");
		btnDeleteMng.setBorderPainted(false);
		toolBarMng.add(btnDeleteMng);
		
		JButton btnEditMng = new JButton("Edit");
		btnEditMng.setBorderPainted(false);
		toolBarMng.add(btnEditMng);
	}
}
