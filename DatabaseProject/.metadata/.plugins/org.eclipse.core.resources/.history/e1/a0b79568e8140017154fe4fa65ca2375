package managerUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import core.Member;
import jdbc.GymDAO;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import UI.ManagerUI;

import javax.swing.SwingConstants;

//Manager: Employee Dialogue Window
public class MMDialogue extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldTel;
	private JTextField textFieldAddr;
	private JTextField textFieldBranch;
	private JDateChooser dateChooserDob;
	private JDateChooser dateChooserStd;
	private JDateChooser dateChooserPrm;
	
	private ManagerUI managerUI;
	private GymDAO gymDAO;
	
	private Member previousMember = null;
	private boolean updateMode = false;
	
	/**
	 * Launch the application.
	 */
	public MMDialogue(ManagerUI theManagerUI, GymDAO theGymDAO, Member previousMember, boolean updateMode) {
		this();
		managerUI = theManagerUI;
		gymDAO = theGymDAO;
		this.previousMember = previousMember;
		this.updateMode = updateMode;
		if (updateMode) {
			setTitle("Update Member");
			populateGui(previousMember);
		}
		
	}
	
	private void populateGui(Member member) {

		textFieldName.setText(member.getName());
		textFieldTel.setText(member.getTelephone());
		dateChooserDob.setDate(member.getDob());
		textFieldAddr.setText(member.getAddr());
		dateChooserStd.setDate(member.getStdExpDate());
		dateChooserStd.setDate(member.getPrmExpDate());
		textFieldBranch.setText(String.valueOf(member.getBranchId()));
	}

	/**
	 * Create the dialog.
	 */
	public MMDialogue() {
		setTitle("Add Member");
		setBounds(100, 100, 450, 290);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		{
			JLabel lblNewLabel = new JLabel("Name:");
			contentPanel.add(lblNewLabel, "2, 2, right, default");
		}
		{
			textFieldName = new JTextField();
			contentPanel.add(textFieldName, "4, 2, fill, default");
			textFieldName.setColumns(10);
		}
		{
			JLabel lblTelephone = new JLabel("Telephone:");
			contentPanel.add(lblTelephone, "2, 4, right, default");
		}
		{
			textFieldTel = new JTextField();
			contentPanel.add(textFieldTel, "4, 4, fill, default");
			textFieldTel.setColumns(10);
		}
		{
			JLabel lblDateOfBirth = new JLabel("Date of Birth:");
			contentPanel.add(lblDateOfBirth, "2, 6, right, default");
		}
		{
			dateChooserDob = new JDateChooser();
			BorderLayout bl_dateChooserDob = (BorderLayout) dateChooserDob.getLayout();
			contentPanel.add(dateChooserDob, "4, 6, fill, default");
		}
		{
			JLabel lblAddress = new JLabel("Address:");
			contentPanel.add(lblAddress, "2, 8, right, default");
		}
		{
			textFieldAddr = new JTextField();
			contentPanel.add(textFieldAddr, "4, 8, fill, default");
			textFieldAddr.setColumns(10);
		}
		{
			JLabel lblStdExpDate = new JLabel("Std Exp Date:");
			contentPanel.add(lblStdExpDate, "2, 10, right, default");
		}
		{
			dateChooserStd = new JDateChooser();
			contentPanel.add(dateChooserStd, "4, 10, fill, center");
		}
		{
			JLabel lblPrmExpDate = new JLabel("Prm Exp Date:");
			contentPanel.add(lblPrmExpDate, "2, 12, right, default");
		}
		{
			dateChooserPrm = new JDateChooser();
			contentPanel.add(dateChooserPrm, "4, 12, fill, center");
		}
		{
			JLabel lblBranch = new JLabel("Branch");
			contentPanel.add(lblBranch, "2, 14, right, default");
		}
		{
			textFieldBranch = new JTextField();
			contentPanel.add(textFieldBranch, "4, 14, fill, default");
			textFieldBranch.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							saveMember();
						} catch (ParseException e1) {
							// Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// close dialog
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	protected void saveMember() throws ParseException {
		
		// get the employee info from gui
		String name = textFieldName.getText();
		String telephone = textFieldTel.getText();
		Date dob = dateChooserDob.getDate();
		String addr = textFieldAddr.getText();
		Date stdExpDate = dateChooserStd.getDate();
		Date prmExpDate = dateChooserPrm.getDate();
		int branchId;
		if (textFieldBranch.getText().isEmpty()) {
			branchId = -1;
		}
		else {
			branchId = Integer.parseInt(textFieldBranch.getText());
		}

		Member tempMember = null;
		
		if (updateMode) {
			tempMember = previousMember;
			tempMember.setName(name);
			tempMember.setTelephone(telephone);
			tempMember.setDob(dob);
			tempMember.setAddr(addr);
			tempMember.setStdExpDate(stdExpDate);
			tempMember.setPrmExpDate(prmExpDate);
			tempMember.setBranchId(branchId);
			
		}
		else {
			tempMember = new Member(0, name, telephone, dob, addr, stdExpDate, prmExpDate, branchId);
		}
		
		try {
			// save to the database
			if (updateMode) {
				gymDAO.updateMember(tempMember);
			}
			else {
				gymDAO.addMember(tempMember);
			}

			// close dialog
			setVisible(false);
			dispose();

			// refresh gui list
			managerUI.refreshMemberView();
			
			// show success message
			JOptionPane.showMessageDialog(managerUI,
					"Member added succesfully.",
					"Member Added",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(
					managerUI,
					"Error saving member: "
							+ exc.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	

}
