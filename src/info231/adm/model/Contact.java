package info231.adm.model;

/**
 * A Contact object represents a single contact in the app
 * @author eivindelseth
 *
 */
public class Contact {
	protected String firstName;
	protected String lastName;
	protected String company;
	protected String telephoneNr;
	protected String comment;
	
	
	/**
	 * Returns the first name of the contact
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the first name of the contact to the name 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Returns the lastname of the contact
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the last name of the contact 
	 * @param lastName the last name of the contact
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Return the company affiliation of the contact
	 * @return the company affiliation
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * Sets the company affiliation of the contact 
	 * @param company the company the contact is employed at
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * Returns the telephone number
	 * @return the telephone number
	 */
	public String getTelephoneNr() {
		return telephoneNr;
	}
	
	/**
	 * Sets the telephone number of the contact 
	 * @param telephone the telephone number of the contact
	 */
	public void setTelephoneNr(String telephoneNr) {
		this.telephoneNr = telephoneNr;
	}
	
	/**
	 * Returns the comment about this contact
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	
	/**
	 * Sets the comment describing some fact about the contact 
	 * @param comment a description of some fact
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
}
