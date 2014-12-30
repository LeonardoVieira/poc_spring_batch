/**
 * 
 */
package poc_batch_sequence.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import poc_batch_sequence.model.Empresa;

/**
 * @author Thiago Freitas
 *
 */
@Component
public class ExtractEmpresaProcessor implements ItemProcessor<Empresa, Empresa> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
	 */
	@Override
	public Empresa process(Empresa item) throws Exception {

		if (!validaSaldo(item)) {
			return null;
		}

		return item;
	}

	private static boolean validaSaldo(Empresa item) {
		return item.getSaldo() > 0;
	}

}
