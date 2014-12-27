/**
 * 
 */
package hello;

/**
 * @author Thiago Freitas
 *
 */
public class InputPerson {
	private String lastName;
	private String firstName;

	/**
	 * 
	 */
	public InputPerson() {

	}

	/**
	 * @param firstName
	 * @param lastName
	 */
	public InputPerson(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "firstName: " + firstName + ", lastName: " + lastName;
	}

}
