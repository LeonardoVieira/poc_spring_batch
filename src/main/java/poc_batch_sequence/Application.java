package poc_batch_sequence;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Thiago Freitas
 *
 */
@ComponentScan
@EnableAutoConfiguration
@EnableBatchProcessing
public class Application {

	/**
	 * Objetivo: criar três jobs com dependências O primeiro lê da base e prepara uma base provisória, o segundo lê de
	 * outra base e prepara uma base provisória. O terceiro lê dessas duas bases, consolida e cria o resultado final
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

	}

}
