package info231.adm.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/**
 * The CSVContactWriter writes a collection of contact into a CSV file in the following format:
 * firstName lastName company telephoneNumber comment
 * 
 * The entries are separated by the designated separator
 * @author eivindelseth
 *
 */
public class CSVContactWriter implements ContactWriter {
	/**
	 * The separator used to separate values of an entry. Should be a singe character
	 */
	public static final String SEPARATOR = ";";
	public static final String LINE_BREAK = "\n";

	private File contactFile;
	
	@Override
	public void writeContacts(Collection<Contact> contacts) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(contactFile));
		for (Contact contact : contacts) {
			writer.write(contactString(contact));
		}
		writer.close();
	}
	
	private String contactString(Contact contact) throws IOException {
		StringBuilder builder = new StringBuilder();
		
		builder.append(getValueOrBlank(contact.getFirstName()) + SEPARATOR);
		builder.append(getValueOrBlank(contact.getLastName()) + SEPARATOR);
		builder.append(getValueOrBlank(contact.getCompany()) + SEPARATOR);
		builder.append(getValueOrBlank(contact.getTelephoneNr()) + SEPARATOR);
		builder.append(getValueOrBlank(contact.getComment()) + SEPARATOR);
		builder.append(LINE_BREAK);
		return builder.toString();
	}

	private String getValueOrBlank(String value) {
		return value != null ? value.replace(SEPARATOR, "\\" + SEPARATOR) : ""; // Escape the separator if it appears in the string 
	}

	@Override
	public void setFile(File contactFile) {
		this.contactFile = contactFile;
	}

}
