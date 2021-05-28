package br.com.gestaopagamentos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = 	{	"br.com.gestaopagamentos.controllers",
									"br.com.gestaopagamentos.dao"
								})
public class AppWebConfiguration {
	
	@Bean
	public InternalResourceViewResolver internalViewResolver () {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setPrefix("WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}

}
