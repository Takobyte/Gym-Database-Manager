package managerUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UI.ManagerUI;
import core.Member;
import core.Supplier;
import jdbc.GymDAO;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.awt.event.ActionEvent;

public class MSDialogue extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private ManagerUI managerUI;
	private GymDAO gymDAO;
	
	private Supplier previousSupp = null;
	private boolean updateMode = false;
	private JTextField textFieldName;
	private JTextField textFieldTelephone;
	private JTextField textFieldAddress;

	/**
	 * Launch the application.
	 */
	public MSDialogue(ManagerUI theManagerUI, GymDAO theGymDAO, Supplier previousSupp, boolean updateMode) {
		this();
		managerUI = theManagerUI;
		gymDAO = theGymDAO;
		this.previousSupp = previousSupp;
		this.updateMode = updateMode;
		if (updateMode) {
			setTitle("Update Supplier");
			populateGui(previousSupp);
		}
	}
	
	private void populateGui(Supplier previousSupp) {
		textFieldName.setText(previousSupp.getName());
		textFieldTelephone.setText(previousSupp.getTelephone());
		textFieldAddress.setText(previousSupp.getAddress());
	}

	/**
	 * Create the dialog.
	 */
	public MSDialogue() {
		setTitle("Add Supplier");
		setBounds(100, 100, 450, 166);
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
				FormSpecs.DEFAULT_ROWSPEC,}));
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
			JLabel lblTelephone = new JLabel("Telephone:");
			contentPanel.add(lblTelephone, "2, 4, right, default");
		}
		{
			textFieldTelephone = new JTextField();
			contentPanel.add(textFieldTelephone, "4, 4, fill, default");
			textFieldTelephone.setColumns(10);
		}
		{
			JLabel lblAddress = new JLabel("Address:");
			contentPanel.add(lblAddress, "2, 6, right, default");
		}
		{
			textFieldAddress = new JTextField();
			contentPanel.add(textFieldAddress, "4, 6, fill, default");
			textFieldAddress.setColumns(10);
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
							saveSupplier();
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
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	protected void saveSupplier() throws ParseException {
		
		// get the employee info from gui
		String name = textFieldName.getText();
		String telephone = textFieldTelephone.getText();
		String addr = textFieldAddress.getText();
		
		Supplier tempSupp = null;
		
		if (updateMode) {
			tempSupp = previousSupp;
			tempSupp.setName(name);
			tempSupp.setTelephone(telephone);
			tempSupp.setAddress(addr);
		}
		else {
			tempSupp = new Supplier(0, name, telephone, addr);
		}
		
		try {
			// save to the database
			if (updateMode) {
				gymDAO.updateSupplier(tempSupp);
			}
			else {
				gymDAO.addSupplier(tempSupp);
			}

			// close dialog
			setVisible(false);
			dispose();

			// refresh gui list
			managerUI.refreshSupplierView();
			
			// show success message
			JOptionPane.showMessageDialog(managerUI,
					"Supplier added succesfully.",
					"Supplier Added",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(
					managerUI,
					"Error saving supplier: "
							+ exc.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
