package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc.GymDAO;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import core.Member;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ManagerAddEmployee extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ManagerUI managerUI;
	private GymDAO gymDAO;
	private JTextField textFieldName;
	private JTextField textFieldJob;
	private JTextField textFieldSalary;
	private JTextField textFieldAddr;
	private JTextField textFieldTel;

	/**
	 * Launch the application.
	 */
	public ManagerAddEmployee(ManagerUI theManagerUI, GymDAO theGymDAO) {
		this();
		managerUI = theManagerUI;
		gymDAO = theGymDAO;
	}

	/**
	 * Create the dialog.
	 */
	public ManagerAddEmployee() {
		setResizable(false);
		setTitle("Add Employee");
		setBounds(100, 100, 450, 279);
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
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		{
			JLabel lblName = new JLabel("Name:");
			contentPanel.add(lblName, "2, 2, right, default");
		}
		{
			textFieldName = new JTextField();
			contentPanel.add(textFieldName, "4, 2, fill, default");
			textFieldName.setColumns(10);
		}
		{
			JLabel lblJobTitle = new JLabel("Job Title:");
			contentPanel.add(lblJobTitle, "2, 4, right, default");
		}
		{
			textFieldJob = new JTextField();
			contentPanel.add(textFieldJob, "4, 4, fill, default");
			textFieldJob.setColumns(10);
		}
		{
			JLabel lblSalary = new JLabel("Salary:");
			contentPanel.add(lblSalary, "2, 6, right, default");
		}
		{
			textFieldSalary = new JTextField();
			contentPanel.add(textFieldSalary, "4, 6, fill, default");
			textFieldSalary.setColumns(10);
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
			JLabel lblDateOfBirth = new JLabel("Date of Birth:");
			contentPanel.add(lblDateOfBirth, "2, 10");
		}
		{
			JDateChooser dateChooser = new JDateChooser();
			contentPanel.add(dateChooser, "4, 10, fill, fill");
		}
		{
			JLabel lblTelephone = new JLabel("Telephone:");
			contentPanel.add(lblTelephone, "2, 12, right, default");
		}
		{
			textFieldTel = new JTextField();
			contentPanel.add(textFieldTel, "4, 12, fill, default");
			textFieldTel.setColumns(10);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, "4, 14, fill, fill");
			{
				JRadioButton rdbtnManagerFlag = new JRadioButton("Manager Flag");
				panel.add(rdbtnManagerFlag);
			}
			{
				JRadioButton rdbtnInstructorFlag = new JRadioButton("Instructor Flag");
				panel.add(rdbtnInstructorFlag);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							saveEmployee();
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
					public void actionPerformed(ActionEvent e) {
						//TODO: closes the dialogue box
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	protected void saveEmployee() throws ParseException {
		//TODO: Follow example of ManagerAddMember.java: saveMember()
	}

}
