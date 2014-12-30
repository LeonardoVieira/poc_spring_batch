/**
 * 
 */
package poc_batch_sequence.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import poc_batch_sequence.model.Empresa;

/**
 * @author Thiago Freitas
 *
 */
@Configuration
public class BaseReadersConfiguration {

	/**
	 * @return ItemReader de Empresas
	 */
	@Bean
	public ItemReader<Empresa> firstBaseReader() {
		// Criação do itemReader para arquivos flat (necessário mostrar o tipo de objeto que esse reader vai ler)
		FlatFileItemReader<Empresa> myReader = new FlatFileItemReader<Empresa>();

		// Criação de resource (fonte de dados)
		ClassPathResource resource = new ClassPathResource("first_base.txt");

		// Mapeamento de linhas
		DefaultLineMapper<Empresa> lineMapper = new DefaultLineMapper<Empresa>();

		// Regra de como separar os campos da linha. Cria um FieldSet com os nomes dado pelo array
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer(",");
		tokenizer.setNames(Empresa.FLAT_FILE_ITEMS);

		// Mapeamento de objeto
		BeanWrapperFieldSetMapper<Empresa> fieldSetMapper = new BeanWrapperFieldSetMapper<Empresa>();
		fieldSetMapper.setTargetType(Empresa.class);

		lineMapper.setLineTokenizer(tokenizer);

		lineMapper.setFieldSetMapper(fieldSetMapper);

		myReader.setResource(resource);
		myReader.setLineMapper(lineMapper);

		return myReader;
	}

}
