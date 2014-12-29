package poc_batch_sequence;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.SimpleStepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import poc_batch_sequence.model.Empresa;

@Configuration
public class FirstJobConfiguration {

	@Autowired
	private JobBuilderFactory jbf;

	@Autowired
	private StepBuilderFactory sbf;

	@Bean
	public Job firstJob() {
		Job firstJob = null;
		JobBuilder jobBuilder = jbf.get("firstJob");
		firstJob = jobBuilder.start(readFirstBaseStep()).build();

		return firstJob;
	}

	@Bean
	public Step readFirstBaseStep() {
		Step myStep = null;
		SimpleStepBuilder<Empresa, Object> stepBuilder = sbf.get("")
				.<Empresa, Object> chunk(2);

		stepBuilder.reader(null).processor(null).writer(null);

		myStep = stepBuilder.build();

		return myStep;
	}
}
