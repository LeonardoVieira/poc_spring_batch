package poc_batch_sequence;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@EnableBatchProcessing
public class Application {

	/**
	 * Objetivo: criar três jobs com dependências O primeiro lê da base e
	 * prepara uma base provisória, o segundo lê de outra base e prepara uma
	 * base provisória. O terceiro lê dessas duas bases, consolida e cria o
	 * resultado final
	 */

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
	}

}
