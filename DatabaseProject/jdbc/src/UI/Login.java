package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import core.Employee;
import core.Member;
import jdbc.GymDAO;

import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * Author: Jung Wook So
 * GUI for members, employees, managers
 */
public class Login extends JFrame {

	private JPanel loginMainBox;
	private JTextField loginUserText;
	private JTextField loginPassText;
	
	protected GymDAO gymDAO;
	private int mid;
	private int eid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
//					frame.setUndecorated(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		
		try {
			gymDAO = new GymDAO();
		}
		catch (Exception exc){
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 263, 167);
		loginMainBox = new JPanel();
		loginMainBox.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(loginMainBox);
		loginMainBox.setLayout(new BorderLayout(0, 0));
		
		JPanel loginPanel = new JPanel();
		loginMainBox.add(loginPanel, BorderLayout.CENTER);
		loginPanel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(5, 8, 96, 14);
		loginPanel.add(lblUsername);
		
		loginUserText = new JTextField();
		loginUserText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName = loginUserText.getText();
				if (userName.isEmpty()) {
					
				}
			}
		});
		loginUserText.setBounds(102, 5, 119, 20);
		loginPanel.add(loginUserText);
		loginUserText.setColumns(10);
		
		JLabel loginPswrdLbl = new JLabel("Password: ");
		loginPswrdLbl.setBounds(5, 30, 96, 14);
		loginPanel.add(loginPswrdLbl);
		
		loginPassText = new JTextField();
		loginPassText.setEnabled(false);
		loginPassText.setBounds(102, 27, 119, 20);
		loginPanel.add(loginPassText);
		loginPassText.setColumns(10);
		
		final JComboBox loginUserComboBox = new JComboBox();
		loginUserComboBox.setBounds(5, 55, 216, 20);
		loginPanel.add(loginUserComboBox);
		loginUserComboBox.setModel(new DefaultComboBoxModel(new String[] {"Member", "Employee", "Manager"}));
		loginUserComboBox.setMaximumRowCount(3);
		loginUserComboBox.setToolTipText("");
		
		JButton loginBtnSignIn = new JButton("Sign in");
		loginBtnSignIn.requestFocusInWindow();
		loginBtnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (loginUserComboBox.getSelectedItem().equals("Employee") || loginUserComboBox.getSelectedItem().equals("Manager")) {
					try {
						String id = loginUserText.getText(); 
						if (!id.isEmpty()) {
							eid = Integer.parseInt(loginUserText.getText());
							Employee employee = new Employee();
							employee = gymDAO.fetchEmployee(employee,eid);
							if (employee.getEmp_id() == 0) {
								JOptionPane.showMessageDialog(Login.this,
										"Username does not exist.",
										"Error",
										JOptionPane.INFORMATION_MESSAGE);
								return;
							}
							ManagerUI managerUI = new ManagerUI(gymDAO, employee);
							managerUI.setVisible(true);
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(Login.this,
									"Username does not exist.",
									"Error",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(Login.this,
								"Username does not exist.",
								"Error",
								JOptionPane.INFORMATION_MESSAGE);
					}
//					JOptionPane.showMessageDialog(Login.this,
//							"Not available at the moment.",
//							"Error",
//							JOptionPane.INFORMATION_MESSAGE);
//					EmployeeUI employee = new EmployeeUI();
//					employee.setVisible(true);
				}
				else if (loginUserComboBox.getSelectedItem().equals("Member")) {
					try {
						String id = loginUserText.getText();
						if (!id.isEmpty()) {
							mid = Integer.parseInt(loginUserText.getText());
							Member member = new Member(0, "", "", null, "", null, null, 0);
							member = gymDAO.fetchMember(member,mid);
							if (member.getMid() == 0) {
								JOptionPane.showMessageDialog(Login.this,
										"Username does not exist.",
										"Error",
										JOptionPane.INFORMATION_MESSAGE);
								return;
							}
							MemberUI memberUI = new MemberUI(gymDAO, member);
							memberUI.setVisible(true);
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(Login.this,
									"Username does not exist.",
									"Error",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(Login.this,
								"Username does not exist.",
								"Error",
								JOptionPane.INFORMATION_MESSAGE);
					}
					
				}
			}
		});
		loginBtnSignIn.setBounds(5, 84, 86, 23);
		loginPanel.add(loginBtnSignIn);
		loginPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblUsername, loginUserText}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{loginUserText, loginPassText, loginUserComboBox, loginBtnSignIn}));
	}
	public void loginVisibility() {
		setVisible(true);
	}
	
	public void exit() {
		setVisible(false);
		dispose();
		System.exit(1);
	}
	
}
