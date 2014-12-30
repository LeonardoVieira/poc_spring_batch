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

import poc_batch_sequence.model.Empresa;
import poc_batch_sequence.processor.ExtractEmpresaProcessor;

/**
 * @author Thiago Freitas
 *
 */
@Configuration
public class FirstJobConfiguration {

	@Autowired
	private JobBuilderFactory jbf;

	@Autowired
	private StepBuilderFactory sbf;

	@Autowired
	private ItemReader<Empresa> reader;

	@Autowired
	private ItemWriter<Empresa> writer;

	@Autowired
	private ExtractEmpresaProcessor processor;

	/**
	 * @return job criado
	 */
	@Bean
	public Job firstJob() {
		Job firstJob = null;
		JobBuilder jobBuilder = jbf.get("firstJob");
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
		SimpleStepBuilder<Empresa, Empresa> stepBuilder = sbf.get("readFirstBaseStep").<Empresa, Empresa> chunk(2);

		stepBuilder.reader(reader).processor(processor).writer(writer);

		myStep = stepBuilder.build();

		return myStep;
	}
}
