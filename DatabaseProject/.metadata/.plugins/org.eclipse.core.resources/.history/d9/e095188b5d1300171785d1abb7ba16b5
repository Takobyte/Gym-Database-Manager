package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import core.Equipment;
import core.Gym;
import jdbc.GymDAO;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DropMode;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.awt.event.ActionEvent;


public class MEqDialogue extends JDialog {
	
	private ManagerUI managerUI;
	private GymDAO gymDAO;

	private boolean updateMode = false;
	private Equipment previousEq = null;

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldModel;
	private JTextField textFieldPrice;
	private JTextField textFieldNService;
	private JTextField textFieldRoomId;
	private JTextField textFieldSupplierId;
	private JDateChooser dateChooserPDate;
	private JDateChooser dateChooserLSDate;

	/**
	 * Launch the application.
	 */
	public MEqDialogue (ManagerUI theManagerUI, GymDAO theGymDAO, Equipment previousEq, boolean updateMode) {
		this();
		managerUI = theManagerUI;
		gymDAO = theGymDAO;
		this.previousEq = previousEq;
		this.updateMode = updateMode;
		if (updateMode) {
			setTitle("Update Equipment");
			populateGui(previousEq);
		}
		
	}
	
	private void populateGui(Equipment previousEq) {
		textFieldName.setText(previousEq.getName());
		textFieldModel.setText(previousEq.getModel_no());
		textFieldPrice.setText(Float.toString(previousEq.getPrice()));
		dateChooserPDate.setDate(previousEq.getPurchase_date());
		dateChooserLSDate.setDate(previousEq.getLast_service_date());
		textFieldNService.setText(Integer.toString(previousEq.getMonths_to_next_service()));
		textFieldRoomId.setText(Integer.toString(previousEq.getRid()));
		textFieldSupplierId.setText(Integer.toString(previousEq.getSid()));	
		
	}
	
	/**
	 * Create the dialog.
	 */
	public MEqDialogue() {
		setTitle("Add Equipment");
		setBounds(100, 100, 450, 398);
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
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
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
			textFieldName.setDropMode(DropMode.ON);
			contentPanel.add(textFieldName, "4, 2, fill, default");
			textFieldName.setColumns(10);
		}
		{
			JLabel lblModelNo = new JLabel("Model#:");
			contentPanel.add(lblModelNo, "2, 4, right, default");
		}
		{
			textFieldModel = new JTextField();
			textFieldModel.setText("");
			contentPanel.add(textFieldModel, "4, 4, fill, default");
			textFieldModel.setColumns(10);
		}
		{
			JLabel lblPrice = new JLabel("Price:");
			contentPanel.add(lblPrice, "2, 6, right, default");
		}
		{
			textFieldPrice = new JTextField();
			textFieldPrice.setText("");
			contentPanel.add(textFieldPrice, "4, 6, fill, default");
			textFieldPrice.setColumns(10);
		}
		{
			JLabel lblPurchaseDate = new JLabel("Purchase Date:");
			contentPanel.add(lblPurchaseDate, "2, 8, right, default");
		}
		{
			dateChooserPDate = new JDateChooser();
			contentPanel.add(dateChooserPDate, "4, 8, fill, fill");
		}
		{
			JLabel lblLastServiceDate = new JLabel("Last Service Date:");
			contentPanel.add(lblLastServiceDate, "2, 10, right, default");
		}
		{
			dateChooserLSDate = new JDateChooser();
			contentPanel.add(dateChooserLSDate, "4, 10, fill, fill");
		}
		{
			JLabel lblMonthToNext = new JLabel("Month to next service:");
			contentPanel.add(lblMonthToNext, "2, 12, right, default");
		}
		{
			textFieldNService = new JTextField();
			textFieldNService.setText("");
			contentPanel.add(textFieldNService, "4, 12, fill, default");
			textFieldNService.setColumns(10);
		}
		{
			JLabel lblRoomId = new JLabel("Room ID:");
			contentPanel.add(lblRoomId, "2, 14, right, default");
		}
		{
			textFieldRoomId = new JTextField();
			contentPanel.add(textFieldRoomId, "4, 14, fill, default");
			textFieldRoomId.setColumns(10);
		}
		{
			JLabel lblSupplierId = new JLabel("Supplier ID:");
			contentPanel.add(lblSupplierId, "2, 16, right, default");
		}
		{
			textFieldSupplierId = new JTextField();
			contentPanel.add(textFieldSupplierId, "4, 16, fill, default");
			textFieldSupplierId.setColumns(10);
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
							saveEq();
						} catch (ParseException e1) {
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
	protected void saveEq() throws ParseException {
		String name = textFieldName.getText();
		String model = textFieldModel.getText();
		Float price = Float.parseFloat(textFieldPrice.getText());
		Date pDate = dateChooserPDate.getDate();
		Date lsDate = dateChooserLSDate.getDate();
		int nextService = Integer.parseInt(textFieldNService.getText());
		int roomId = Integer.parseInt(textFieldRoomId.getText());
		int supplierId = Integer.parseInt(textFieldSupplierId.getText());

		Equipment tempEq = null;
		
		if (updateMode) {
			tempEq = previousEq;
			tempEq.setName(name);
			tempEq.setModel_no(model);
			tempEq.setPrice(price);
			tempEq.setPurchase_date(pDate);
			tempEq.setLast_service_date(lsDate);
			tempEq.setMonths_to_next_service(nextService);
			tempEq.setRid(roomId);
			tempEq.setSid(supplierId);
			
		}
		else {
			tempEq = new Equipment(0, name, model, price, pDate, lsDate, nextService, roomId, supplierId);
		}
		
		try {
			// save to the database
			if (updateMode) {
				gymDAO.updateEq(tempEq);
			}
			else {
				gymDAO.addEq(tempEq);
			}

			// close dialog
			setVisible(false);
			dispose();

			// refresh gui list
			managerUI.refreshEquipmentView();
			
			// show success message
			JOptionPane.showMessageDialog(managerUI,
					"Equipment added succesfully.",
					"Equipment Added",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(
					managerUI,
					"Error saving equipment: "
							+ exc.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	

}
