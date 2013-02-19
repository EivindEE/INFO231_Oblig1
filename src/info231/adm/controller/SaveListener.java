package info231.adm.controller;

import info231.adm.model.CSVContactWriter;
import info231.adm.model.Contact;
import info231.adm.model.ContactWriter;
import info231.adm.view.ContactGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 * Handles the saving of objects in the contact app
 * When the save option is picked a contact object is created with the given information and added to the contacts collection.
 * When the save as option is picked, all the contacts in the collection are written to that file
 * @author eivindelseth
 *
 */
public class SaveListener implements ActionListener{
	private Collection<Contact> contacts;
	private final JFileChooser fc = new JFileChooser();
	private ContactWriter contactWriter;
	private ContactGUI gui;

	public SaveListener(ContactGUI contactGUI) {
		this.gui = contactGUI;
		this.contacts = new LinkedList<Contact>();
		this.contactWriter = new CSVContactWriter();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("Save")) {
			Contact contact = createContact();
			if (!contact.getFirstName().equals("")){
				this.contacts.add(contact);
				this.gui.clearFields();
			} else {
				JOptionPane.showMessageDialog(null, "All contacts must have a first name. Please try again", "Missing first name" ,JOptionPane.ERROR_MESSAGE );
			}
		} else if (command.equals("Save as")) {
			int returnState = fc.showSaveDialog(null);
			if (returnState == JFileChooser.APPROVE_OPTION) {
				this.contactWriter.setFile(fc.getSelectedFile());
				try {
					this.contactWriter.writeContacts(contacts);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "An error occured while saving. Please try again", "File not found" ,JOptionPane.ERROR_MESSAGE);
				}
			} 
		}
	}


	private Contact createContact() {
		Contact contact = new Contact();
		contact.setFirstName(this.gui.getFirstNameField().getText());
		contact.setLastName(this.gui.getLastNameField().getText());
		contact.setCompany(this.gui.getCompanyField().getText());
		contact.setTelephoneNr(this.gui.getTelephoneField().getText());
		contact.setComment(this.gui.getCommentField().getText());
		return contact;
	}
}
