package info231.adm.model;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
/**
 * The contact writer should write a collection of contacts
 * @author eivindelseth
 *
 */
public interface ContactWriter {
	/**
	 * Writes the contacts in the collection to a file
	 * @param contacts, the collections of contacts that should be written to file
	 * @throws IOException if error occured when writing to file
	 */
	public void writeContacts(Collection<Contact> contacts) throws IOException;
	
	/**
	 * Sets the file the contacts should be written to
	 * @param contactFile
	 */
	public void setFile(File contactFile);
}
