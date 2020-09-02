package asw.instagnam.ricetteseguite.eventlistener;

import asw.instagnam.common.api.event.DomainEvent; 
import asw.instagnam.connessioniservice.api.event.*;
import asw.instagnam.ricetteservice.api.event.*;

import asw.instagnam.ricetteseguite.domain.DomainEventConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger;

@Component 
public class DomainEventListener {

    private final Logger logger = Logger.getLogger(DomainEventListener.class.toString());

    @Autowired
    private DomainEventConsumer domainEventConsumer;

    
    @KafkaListener(topics = {ConnessioniServiceEventChannel.channel, RicetteServiceEventChannel.channel})
    public void listen(ConsumerRecord<String, DomainEvent> record) throws Exception {
        logger.info("EVENT LISTENER: " + record.toString());
        DomainEvent event = record.value();
		domainEventConsumer.onEvent(event); 
    }

}
