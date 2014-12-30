/**
 * 
 */
package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Thiago Freitas
 *
 */
@ComponentScan
@EnableAutoConfiguration
public class Hello_Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Hello_Application.class, args);
		
		for (String beanName: ctx.getBeanDefinitionNames())
			System.out.println(beanName);
	}

}
