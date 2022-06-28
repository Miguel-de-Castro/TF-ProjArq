package com.bcopstein;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bcopstein.Adaptadores.Receiver;


@SpringBootApplication
public class NFApplication {
	static final String topicExchangeName = "spring-boot-exchange";
	static final String queueName = "spring-boot";
  
	@Bean
	Queue queue() {
	  return new Queue(queueName, false);
	}
  
	@Bean
	TopicExchange exchange() {
	  return new TopicExchange(topicExchangeName);
	}
  
	@Bean
	// Define que tipo de mensagens este app vai escutar
	Binding binding(Queue queue, TopicExchange exchange) {
	  return BindingBuilder.bind(queue).to(exchange).with("history.#");
	}
  
	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
		MessageListenerAdapter listenerAdapter) {
	  SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	  container.setConnectionFactory(connectionFactory);
	  container.setQueueNames(queueName);
	  container.setMessageListener(listenerAdapter);
	  return container;
	}
  
	@Bean
	// Define que é a classe que vei receber todas as mensagens (e faz o papel do controller)
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
	  return new MessageListenerAdapter(receiver, "receiveMessage");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HistoryServiceApplication.class, args);
	}
}
