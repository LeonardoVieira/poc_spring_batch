/**
 * 
 */
package hello;

/**
 * @author Thiago Freitas
 *
 */
public class OutputPerson {
	private String fullName;

	/**
	 * @param firstName
	 * @param lastName
	 */
	public OutputPerson(String firstName, String lastName) {
		this.fullName = lastName + ", " + firstName;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
