package poc_batch_sequence.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.SimpleStepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import poc_batch_sequence.model.Oferta;
import poc_batch_sequence.processor.ExtractOfertaProcessor;

/**
 * @author Thiago Freitas
 *
 */
@Configuration
public class SecondJobConfiguration {

	@Autowired
	private JobBuilderFactory jbf;

	@Autowired
	private StepBuilderFactory sbf;

	@Autowired
	private ItemReader<Oferta> reader;

	@Autowired
	private ItemWriter<Oferta> writer;

	@Autowired
	private ExtractOfertaProcessor processor;

	/**
	 * @return job criado
	 */
	@Bean
	public Job firstJob() {
		Job firstJob = null;
		JobBuilder jobBuilder = jbf.get("secondJob");
		firstJob = jobBuilder.start(readFirstBaseStep()).build();

		return firstJob;
	}

	/**
	 * 
	 * @return passo do job
	 */
	@Bean
	public Step readFirstBaseStep() {
		Step myStep = null;
		SimpleStepBuilder<Oferta, Oferta> stepBuilder = sbf.get("readFirstBaseStep").<Oferta, Oferta> chunk(2);

		stepBuilder.reader(reader).processor(processor).writer(writer);

		myStep = stepBuilder.build();

		return myStep;
	}
}
