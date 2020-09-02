package asw.instagnam.ricetteseguite.rest.eventlistener;

import asw.instagnam.common.api.event.DomainEvent; 
import asw.instagnam.connessioniservice.api.event.*; 

import asw.instagnam.ricetteseguite.domain.ConnessioneDomainEventConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger;

@Component 
public class ConnessioneDomainEventListener implements DomainEventListener {

    private final Logger logger = Logger.getLogger(ConnessioneDomainEventListener.class.toString());

    @Autowired
    private ConnessioneDomainEventConsumer connessioneDomainEventConsumer;

    
    @KafkaListener(topics = ConnessioniServiceEventChannel.channel)
    public void listen(ConsumerRecord<String, DomainEvent> record) throws Exception {
        logger.info("EVENT LISTENER: " + record.toString());
        DomainEvent event = record.value();
		connessioneDomainEventConsumer.onEvent(event); 
    }

}
