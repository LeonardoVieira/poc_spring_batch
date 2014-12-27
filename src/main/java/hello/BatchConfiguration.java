/**
 * 
 */
package hello;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

/**
 * @author Thiago Freitas
 *
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	// tag::readerwriterprocessor[]
	/**
	 * @return inputPerson reader
	 */
	@Bean
	public ItemReader<InputPerson> myReader() {
		FlatFileItemReader<InputPerson> reader = new FlatFileItemReader<InputPerson>();
		reader.setResource(new ClassPathResource("sample-data.csv"));
		reader.setLineMapper(new DefaultLineMapper<InputPerson>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "firstName", "lastName" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<InputPerson>() {
					{
						setTargetType(InputPerson.class);
					}
				});
			}
		});

		return reader;

	}

	/**
	 * @return the writer
	 */
	@Bean
	public ItemWriter<OutputPerson> writer() {
		BeanWrapperFieldExtractor<OutputPerson> extractor = new BeanWrapperFieldExtractor<OutputPerson>();
		extractor.setNames(new String[] {"fullName"});
		
		DelimitedLineAggregator<OutputPerson> aggregator = new DelimitedLineAggregator<OutputPerson>();
		
		aggregator.setFieldExtractor(extractor);
		
		FlatFileItemWriter<OutputPerson> writer = new FlatFileItemWriter<OutputPerson>();
		writer.setResource(new FileSystemResource("saida.csv"));
		writer.setLineAggregator(aggregator);
		return writer;
	}

	/**
	 * @return processor
	 */
	@Bean
	public ItemProcessor<InputPerson, OutputPerson> processor() {
		return new PersonItemProcessor();
	}

	/**
	 * @param dataSource
	 * @return otherWriter
	 */
	public ItemWriter<OutputPerson> oldWriter(DataSource dataSource) {
		JdbcBatchItemWriter<OutputPerson> writer = new JdbcBatchItemWriter<OutputPerson>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<OutputPerson>());
		writer.setSql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)");
		writer.setDataSource(dataSource);
		return writer;
	}

	// end::readerwriterprocessor[]

	// tag::jobstep[]
	/**
	 * @param jobs
	 * @param s1
	 * @return the job
	 */
	@Bean
	public Job importUserJob(JobBuilderFactory jobs, Step s1) {
		Job job = jobs.get("importUserJob").incrementer(new RunIdIncrementer())
				.flow(s1).end().build();

		return job;
	}

	/**
	 * @param stepBuilderFactory
	 * @param reader
	 * @param writer
	 * @param processor
	 * @return the step
	 */
	@Bean
	public Step myPasso(StepBuilderFactory stepBuilderFactory,
			ItemReader<InputPerson> reader, ItemWriter<OutputPerson> writer,
			ItemProcessor<InputPerson, OutputPerson> processor) {
		return stepBuilderFactory.get("thiStep")
				.<InputPerson, OutputPerson> chunk(10).reader(reader)
				.processor(processor).writer(writer).build();
	}

	// end::jobstep[]

}
