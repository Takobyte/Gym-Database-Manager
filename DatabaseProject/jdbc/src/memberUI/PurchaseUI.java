package memberUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import UI.MemberUI;
import core.Group_class;
import core.Member;
import jdbc.GymDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;

public class PurchaseUI extends JFrame {

	private JPanel contentPane;
	private JTable tableClass;
	private GymDAO gymDAO;
	private Member member;
	private MemberUI memberUI;
	
	private JRadioButton rdbtnStandard;
	private JRadioButton rdbtnPremium;
	private JCheckBox chckbxClass;
	
	/**
	 * Create the frame.
	 */
	public PurchaseUI(MemberUI memberUI, GymDAO gymDAO, Member member) {
		this.memberUI = memberUI;
		this.gymDAO = gymDAO;
		this.member = member;
		setTitle("Purchase");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("115px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("151px"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblGroupClasses = new JLabel("Group Classes:");
		panel.add(lblGroupClasses, "2, 2");
		
		chckbxClass = new JCheckBox("Class");
		panel.add(chckbxClass, "4, 2, left, top");
		if (memberUI.isPremium()) {
			chckbxClass.setEnabled(false);
		}
		
		JLabel lblMembership = new JLabel("Membership:");
		panel.add(lblMembership, "2, 4");
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if it is a premium member
				if (memberUI.isPremium()) {
					if (rdbtnPremium.isSelected()) {
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
						Date tempDate = member.getPrmExpDate();
						java.sql.Date sqlDate = new java.sql.Date(tempDate.getTime());
						LocalDate incDate = sqlDate.toLocalDate().plusMonths(1);
						tempDate = java.sql.Date.valueOf(incDate);
						member.setPrmExpDate(tempDate);
						try {
							gymDAO.updateMember(member);
							memberUI.getLblPrmstd().setText("Premium: " + dtf.format(incDate));
							
						} catch (Exception exc) {
							setVisible(false);
							dispose();
							JOptionPane.showMessageDialog(
									memberUI,
									"Error purchasing: "
											+ exc.getMessage(), "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				// if it is a standard member or a non-member
				else { 
					// Premium selection
					if (rdbtnPremium.isSelected()) {
						// if member has no premium membership
						if (member.getPrmExpDate() == null) {
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
							LocalDate incDate = LocalDate.now().plusMonths(1);
							
							member.setPrmExpDate(java.sql.Date.valueOf(incDate));
							try {
								gymDAO.updateMember(member);
								memberUI.getLblPrmstd().setText("Premium: " + dtf.format(incDate));
							
							} catch (Exception exc) {
								setVisible(false);
								dispose();
								JOptionPane.showMessageDialog(
										memberUI,
										"Error purchasing: "
												+ exc.getMessage(), "Error",
										JOptionPane.ERROR_MESSAGE);
							}
						}
//						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//						Date tempDate = member.getPrmExpDate();
//						java.sql.Date sqlDate = new java.sql.Date(tempDate.getTime());
//						LocalDate incDate = sqlDate.toLocalDate().plusMonths(1);
//						tempDate = java.sql.Date.valueOf(incDate);
//						member.setPrmExpDate(tempDate);
//						try {
//							gymDAO.updateMember(member);
//							memberUI.getLblPrmstd().setText("Premium: " + dtf.format(incDate));
//							
//						} catch (Exception exc) {
//							setVisible(false);
//							dispose();
//							JOptionPane.showMessageDialog(
//									memberUI,
//									"Error purchasing: "
//											+ exc.getMessage(), "Error",
//									JOptionPane.ERROR_MESSAGE);
//						}
					}
					// standard selection
					else if (rdbtnStandard.isSelected()) {
						// if member has no standard membership
						if (member.getStdExpDate() == null) {
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
							LocalDate incDate = LocalDate.now().plusMonths(1);
							member.setStdExpDate(java.sql.Date.valueOf(incDate));
							try {
								gymDAO.updateMember(member);
								memberUI.getLblPrmstd().setText("Standard: " + dtf.format(incDate));
							
							} catch (Exception exc) {
								setVisible(false);
								dispose();
								JOptionPane.showMessageDialog(
										memberUI,
										"Error purchasing: "
												+ exc.getMessage(), "Error",
										JOptionPane.ERROR_MESSAGE);
							}
						}
						// if member is extending standard membership
						else {
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
							Date tempDate = member.getStdExpDate();
							java.sql.Date sqlDate = new java.sql.Date(tempDate.getTime());
							LocalDate incDate = sqlDate.toLocalDate().plusMonths(1);
							member.setStdExpDate(java.sql.Date.valueOf(incDate));
							try {
								gymDAO.updateMember(member);
								memberUI.getLblPrmstd().setText("Standard: " + dtf.format(incDate));
								
							} catch (Exception exc) {
								setVisible(false);
								dispose();
								JOptionPane.showMessageDialog(
										memberUI,
										"Error purchasing: "
												+ exc.getMessage(), "Error",
										JOptionPane.ERROR_MESSAGE);
							}
						
						}
					}
					else if (chckbxClass.isSelected()) {
						// get the selected item
						int row = tableClass.getSelectedRow();
						
						// make sure a row is selected
						if (row < 0) {
							JOptionPane.showMessageDialog(PurchaseUI.this, "You must select a class", "Error",
									JOptionPane.ERROR_MESSAGE);				
							return;
						}
						
						// get the current class
						try {
							Group_class tempClass = (Group_class) tableClass.getValueAt(row, MemClassTableModel.OBJECT_COL);
							
							saveClass(tempClass);
						} catch (Exception exc) {
							setVisible(false);
							dispose();
							JOptionPane.showMessageDialog(
									memberUI,
									"Error purchasing: "
											+ exc.getMessage(), "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				
				// close dialog
				setVisible(false);
				dispose();
				
				// show success message
				JOptionPane.showMessageDialog(memberUI,
						"Purchase successful.",
						"Purchase Successful",
						JOptionPane.INFORMATION_MESSAGE);
				
				
				
//				if (chckbxClass.isSelected() && !memberUI.isPremium() && !rdbtnPremium.isSelected()) {
//					// get the selected item
//					int row = tableClass.getSelectedRow();
//					
//					// make sure a row is selected
//					if (row < 0) {
//						JOptionPane.showMessageDialog(PurchaseUI.this, "You must select a class", "Error",
//								JOptionPane.ERROR_MESSAGE);				
//						return;
//					}
//					
//					// get the current class
//					Group_class tempClass = (Group_class) tableClass.getValueAt(row, MemClassTableModel.OBJECT_COL);
//					
//					saveClass(tempClass);
//				}
//				if (rdbtnPremium.isSelected() && !chckbxClass.isSelected()) {
//					if (member.getPrmExpDate() == null) {
//						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//						LocalDate incDate = LocalDate.now().plusMonths(1);
//						
//						member.setPrmExpDate(java.sql.Date.valueOf(dtf.format(incDate)));
//						try {
//							gymDAO.updateMember(member);
//							memberUI.getLblPrmstd().setText("Premium: " + dtf.format(incDate));
//						
//						} catch (Exception e1) {
//							e1.printStackTrace();
//						}
//					}
//					else {
//						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//						Date tempDate = member.getPrmExpDate();
//						java.sql.Date sqlDate = new java.sql.Date(tempDate.getTime());
//						LocalDate incDate = sqlDate.toLocalDate().plusMonths(1);
//						tempDate = java.sql.Date.valueOf(incDate);
//						member.setPrmExpDate(tempDate);
//						try {
//							gymDAO.updateMember(member);
//							memberUI.getLblPrmstd().setText("Premium: " + dtf.format(incDate));
//							
//						} catch (Exception e1) {
//							e1.printStackTrace();
//						}
//					}
//				}
//				else if (rdbtnStandard.isSelected()) {
//					if (member.getPrmExpDate() != null) {
//						return;
//					}
//					if (member.getStdExpDate() == null) {
//						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//						LocalDate incDate = LocalDate.now().plusMonths(1);
//						member.setStdExpDate(java.sql.Date.valueOf(incDate));
//						try {
//						gymDAO.updateMember(member);
//						memberUI.getLblPrmstd().setText("Standard: " + dtf.format(incDate));
//						
//						} catch (Exception e1) {
//							e1.printStackTrace();
//						}
//					}
//					else {
//						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//						Date tempDate = member.getStdExpDate();
//						java.sql.Date sqlDate = new java.sql.Date(tempDate.getTime());
//						LocalDate incDate = sqlDate.toLocalDate().plusMonths(1);
//						member.setStdExpDate(java.sql.Date.valueOf(incDate));
//						try {
//							gymDAO.updateMember(member);
//							memberUI.getLblPrmstd().setText("Standard: " + dtf.format(incDate));
//							
//						} catch (Exception e1) {
//							e1.printStackTrace();
//						}
//					
//					}
//				}
			}
		});
		
		rdbtnStandard = new JRadioButton("Standard");
		panel.add(rdbtnStandard, "4, 4");
		if (memberUI.isPremium()) {
			rdbtnStandard.setEnabled(false);
		}
		
		rdbtnPremium = new JRadioButton("Premium");
		panel.add(rdbtnPremium, "4, 6");
		panel.add(btnPurchase, "2, 10, fill, top");
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnStandard);
		group.add(rdbtnPremium);
		group.add(chckbxClass);
		
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		panel.add(btnNewButton, "2, 12, fill, default");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tableClass = new JTable();
		scrollPane.setViewportView(tableClass);
		try {
			List<Group_class> tempClass = null;
			tempClass = gymDAO.getAllClass();
			
			MemClassTableModel model = new MemClassTableModel(tempClass);
			tableClass.setModel(model);
			tableClass.getColumnModel().getColumn(3).setCellRenderer(new TimestampCellRenderer());
			tableClass.getColumnModel().getColumn(4).setCellRenderer(new TimestampCellRenderer());
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(PurchaseUI.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
	}


	protected void saveClass(Group_class tempClass) {
		// save to the database
		try {
			gymDAO.addClassPurchase(member, tempClass);
				
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(
					memberUI,
					"Error purchasing : "
							+ exc.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			// close dialog
			setVisible(false);
			dispose();
		}
		
		
	}

}
