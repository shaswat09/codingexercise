package com.example.demo;

import java.util.Arrays;
import java.util.Locale;

//import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcProperties.LocaleResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CodingExerciseApplication implements CommandLineRunner{

	/*@Autowired
	DataSource dataSource;*/
	
	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(CodingExerciseApplication.class, args);
	String[] names=context.getBeanDefinitionNames();
	Arrays.sort(names);
	for(String bean:names){
		System.out.println(bean); // magic of spring boot autoconfiguration
	}
	}
	
	@Bean
	public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2)
	.select()
	.apis(RequestHandlerSelectors.any())
	.paths(PathSelectors.any()).build();
	}
	
	@Bean
	public org.springframework.web.servlet.LocaleResolver localeResolver(){
		SessionLocaleResolver s=new SessionLocaleResolver();
		s.setDefaultLocale(Locale.US);
		return s;
	}
	
	public ReloadableResourceBundleMessageSource messageSource(){
		ReloadableResourceBundleMessageSource r=new ReloadableResourceBundleMessageSource();
		r.setBasenames("messsages");
		r.setUseCodeAsDefaultMessage(true);
		return r;
	
	}

	/*@Override
	public void run(String... args) throws Exception {
		System.out.println(dataSource);
		
	}*/
}
