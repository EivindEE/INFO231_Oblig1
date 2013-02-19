package info231.adm.view;

import info231.adm.controller.SaveListener;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class ContactGUI extends JFrame {

	/**
	 * Default generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	// The menu bar and content
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem savaAsItem;
	private JMenuItem closeItem;
	
	// The text fields and their explanations
	private JLabel firstNameLabel;
	private JTextField firstNameField;
	private JLabel lastNameLabel;
	private JTextField lastNameField;
	private JLabel companyLabel;
	private JTextField  companyField;
	private JLabel telephoneLabel;
	private JTextField telephoneField;
	private JLabel commentLabel;
	private JTextField commentField;
	
	/**
	 * The width of the text fields in columns
	 */
	private int columnCount = 10;

	
	/**
	 * Pressing this button should add the contact inputed to the list of contacts that should be saved
	 */
	private JButton saveAndClearButton;

	private ActionListener saveListener;
	
	public ContactGUI() {
		this.init();

	}
	private void init() {
		this.setLayout(new GridLayout(6, 2));
		this.setName("Oblig 1");
		this.initMenuBar();
		this.initContactPanel();
		this.initSaveButton();
		this.initListeners();
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void initListeners() {
		this.saveListener = new SaveListener(this);
		this.saveAndClearButton.addActionListener(this.saveListener);
		this.savaAsItem.addActionListener(saveListener);
		
		this.closeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
	public JTextField getFirstNameField() {
		return firstNameField;
	}
	public JTextField getLastNameField() {
		return lastNameField;
	}
	public JTextField getCompanyField() {
		return companyField;
	}
	public JTextField getTelephoneField() {
		return telephoneField;
	}
	public JTextField getCommentField() {
		return commentField;
	}
	private void initSaveButton() {
		this.saveAndClearButton = new JButton("Save");
		this.add(saveAndClearButton);
		
	}
	private void initContactPanel() {
		this.firstNameLabel = new JLabel("First name:");
		this.firstNameField = new JTextField(columnCount);
		this.add(firstNameLabel);
		this.add(firstNameField);
		
		this.lastNameLabel = new JLabel("Last name:");
		this.lastNameField = new JTextField(columnCount);
		this.add(lastNameLabel);
		this.add(lastNameField);
		
		this.companyLabel = new JLabel("Company name:");
		this.companyField = new JTextField(columnCount);
		this.add(companyLabel);
		this.add(companyField);
		
		this.telephoneLabel = new JLabel("Telephone:");
		this.telephoneField = new JTextField(columnCount);
		this.add(telephoneLabel);
		this.add(telephoneField);
		
		this.commentLabel = new JLabel("Comment:");
		this.commentField = new JTextField(columnCount);
		this.add(commentLabel);
		this.add(commentField);
		
		
	}
	private void initMenuBar() {
		this.menuBar = new JMenuBar();
		this.fileMenu = new JMenu("File");
		
		this.savaAsItem = new JMenuItem("Save as");
		
		this.closeItem = new JMenuItem("Close");
		this.setJMenuBar(menuBar);

		this.menuBar.add(fileMenu);
		this.fileMenu.add(savaAsItem);
		this.fileMenu.add(closeItem);
		
	}
	
	public void clearFields() {
		this.getFirstNameField().setText("");
		this.getLastNameField().setText("");
		this.getCompanyField().setText("");
		this.getTelephoneField().setText("");
		this.getCommentField().setText("");
	}
}
