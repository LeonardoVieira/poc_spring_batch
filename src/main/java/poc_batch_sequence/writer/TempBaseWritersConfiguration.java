/**
 * 
 */
package poc_batch_sequence.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import poc_batch_sequence.model.Empresa;

/**
 * @author Thiago Freitas
 *
 */
@Configuration
public class TempBaseWritersConfiguration {

	/**
	 * @return ItemWriter temporário de empresa
	 */
	@Bean
	public ItemWriter<Empresa> tempEmpresaReader() {
		FlatFileItemWriter<Empresa> myWriter = new FlatFileItemWriter<Empresa>();

		BeanWrapperFieldExtractor<Empresa> fieldExtractor = new BeanWrapperFieldExtractor<Empresa>();
		fieldExtractor.setNames(Empresa.FLAT_FILE_ITEMS);

		FileSystemResource resource = new FileSystemResource("target/temp/tempEmpresa.txt");

		DelimitedLineAggregator<Empresa> lineAggregator = new DelimitedLineAggregator<Empresa>();
		lineAggregator.setDelimiter(",");
		lineAggregator.setFieldExtractor(fieldExtractor);

		myWriter.setResource(resource);
		myWriter.setLineAggregator(lineAggregator);
		myWriter.setShouldDeleteIfExists(true);

		return myWriter;
	}

}
