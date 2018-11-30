package com.qa;



import javax.jms.ConnectionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.web.client.RestTemplate;

@EnableJms
@SpringBootApplication
public class JmsConsumerApplication {

	 Logger logger = LoggerFactory.getLogger(JmsConsumerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(JmsConsumerApplication.class, args);
	}
	
	  @Bean
	  JmsListenerContainerFactory<?> jmsContainerFactory(ConnectionFactory connectionFactory) {
		  SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
		  factory.setConnectionFactory(connectionFactory);
		  factory.setErrorHandler(t -> {
	    	  logger.error("Error in listener!", t);
	         });
	      return factory;
		  
	  }

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	
}