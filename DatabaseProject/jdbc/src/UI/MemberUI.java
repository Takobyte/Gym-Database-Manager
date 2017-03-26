package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MemberUI extends JFrame {

	private JPanel contentPane;
	private JTable tableMember;

	/**
	 * Create the frame.
	 */
	public MemberUI() {
		setTitle("Member");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("146px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(46dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("46px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(41dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),}));
		
		JLabel lblName = new JLabel("Name: Your_ Name");
		lblName.setToolTipText("");
		panel.add(lblName, "1, 2, left, center");
		
		JLabel lblPrmstd = new JLabel("PrmStd: Exp_Date");
		panel.add(lblPrmstd, "3, 2, left, default");
		
		JComboBox comboBoxMember = new JComboBox();
		panel.add(comboBoxMember, "8, 2");
		comboBoxMember.setModel(new DefaultComboBoxModel(new String[] {"Group", "Individual"}));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tableMember = new JTable();
		scrollPane.setViewportView(tableMember);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Go back to login
			}
		});
		
		JButton btnPurchase = new JButton("Purchase");
		panel_1.add(btnPurchase);
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseUI purchase = new PurchaseUI();
				purchase.setVisible(true);
			}
		});
		panel_1.add(btnSignOut);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: Close the program
			}
		});
		panel_1.add(btnExit);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(toolBar, BorderLayout.WEST);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		toolBar.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		toolBar.add(btnDelete);
		
		JButton btnEdit = new JButton("Edit");
		toolBar.add(btnEdit);
	}

}
