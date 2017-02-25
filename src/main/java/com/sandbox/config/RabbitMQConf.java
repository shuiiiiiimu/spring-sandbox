package com.sandbox.config;

import com.sandbox.service.MqReceiverService;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mike on 2017/2/25.
 */
@Configuration
public class RabbitMQConf {

    final static String QUEUE_NAME = "queue.sandbox";
    final static String EXCHANGE_NAME = "exchange.sandbox";
    final static String ROUTING_KEY="sandbox";

//    @Value("${rabbit.app.routing_key:sandbox}")
//    private String ROUTING_KEY;
//    private String QUEUE_NAME = String.format("queue.%s", ROUTING_KEY);
//    private String EXCHANGE_NAME = String.format("exchange.%s", ROUTING_KEY);

    @Value("${rabbitmq.host}")
    private String mqRabbitHost;

    @Value("${rabbitmq.port}")
    private Integer mqRabbitPort;

    @Value("${rabbitmq.username}")
    private String mqRabbitUsername;

    @Value("${rabbitmq.password}")
    private String mqRabbitPassword;

    @Value("${rabbitmq.virtual-host}")
    private String mqRabbitVirtualHost;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(mqRabbitHost, mqRabbitPort);
        connectionFactory.setUsername(mqRabbitUsername);
        connectionFactory.setPassword(mqRabbitPassword);
        connectionFactory.setVirtualHost(mqRabbitVirtualHost);
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public Queue myQueue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MqReceiverService mqReceiverService) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(new String[]{QUEUE_NAME});
        container.setMessageListener(mqReceiverService);

        return container;
    }

    @Bean
    MqReceiverService receiver() {
        return new MqReceiverService();
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
}
