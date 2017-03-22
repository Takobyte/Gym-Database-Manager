package UI;

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

public class ManagerAddMember extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldTel;
	private JTextField textFieldDob;
	private JTextField textFieldAddr;
	private JTextField textFieldStdExp;
	private JTextField textFieldPrmExp;
	private JTextField textFieldBranch;
	
	private ManagerUI managerUI;
	private GymDAO gymDAO;
	/**
	 * Launch the application.
	 */
	public ManagerAddMember(ManagerUI theManagerUI, GymDAO theGymDAO) {
		this();
		managerUI = theManagerUI;
		gymDAO = theGymDAO;
		
	}

	/**
	 * Create the dialog.
	 */
	public ManagerAddMember() {
		setTitle("Add Member");
		setBounds(100, 100, 450, 300);
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
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
			textFieldDob = new JTextField();
			contentPanel.add(textFieldDob, "4, 6, fill, default");
			textFieldDob.setColumns(10);
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
			textFieldStdExp = new JTextField();
			contentPanel.add(textFieldStdExp, "4, 10, fill, default");
			textFieldStdExp.setColumns(10);
		}
		{
			JLabel lblPrmExpDate = new JLabel("Prm Exp Date:");
			contentPanel.add(lblPrmExpDate, "2, 12, right, default");
		}
		{
			textFieldPrmExp = new JTextField();
			contentPanel.add(textFieldPrmExp, "4, 12, fill, default");
			textFieldPrmExp.setColumns(10);
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	protected void saveEmployee() {
		//stub TODO:
	}
	
	protected void saveMember() throws ParseException {
		String dateText;
		
		// get the employee info from gui
		String name = textFieldName.getText();
		String telephone = textFieldTel.getText();
		dateText = textFieldDob.getText();
		DateFormat sdf = new SimpleDateFormat("MMMM d, yyyy");
		Date dob = sdf.parse(dateText);
		String addr = textFieldAddr.getText();
		dateText = textFieldStdExp.getText();
		Date stdExpDate = sdf.parse(dateText);
		dateText = textFieldPrmExp.getText();
		Date prmExpDate = sdf.parse(dateText);
		int branchId = Integer.parseInt(textFieldBranch.getText());

		Member tempMember = new Member(0, name, telephone, dob, addr, stdExpDate, prmExpDate, branchId);
		
		try {
			// save to the database
			gymDAO.addMember(tempMember);

			// close dialog
			setVisible(false);
			dispose();

			// refresh gui list
			managerUI.refreshMemberView();
			
			// show success message
			JOptionPane.showMessageDialog(managerUI,
					"Employee added succesfully.",
					"Employee Added",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(
					managerUI,
					"Error saving employee: "
							+ exc.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

}