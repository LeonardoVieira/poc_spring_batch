/**
 * 
 */
package hello;

import org.springframework.batch.item.ItemProcessor;

/**
 * @author Thiago Freitas
 *
 */
public class PersonItemProcessor implements
		ItemProcessor<InputPerson, OutputPerson> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
	 */
	@Override
	public OutputPerson process(InputPerson person) throws Exception {
		String firstName = person.getFirstName().toUpperCase();
		String lastName = person.getLastName().toUpperCase();

		OutputPerson output = new OutputPerson(firstName, lastName);

		return output;
	}

}
