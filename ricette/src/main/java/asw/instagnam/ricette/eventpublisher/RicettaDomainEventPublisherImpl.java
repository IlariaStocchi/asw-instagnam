package asw.instagnam.ricette.eventpublisher;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.ricetteservice.api.event.RicetteServiceEventChannel; 
import asw.instagnam.ricette.domain.RicettaDomainEventPublisher;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger;

@Component 
public class RicettaDomainEventPublisherImpl implements RicettaDomainEventPublisher {

    private final Logger logger = Logger.getLogger(RicettaDomainEventPublisherImpl.class.toString());

    @Autowired
    private KafkaTemplate<String, DomainEvent> template;

	private String channel = RicetteServiceEventChannel.channel; 

    @Override
    public void publish(DomainEvent event) {
        logger.info("PUBLISHING EVENT: " + event.toString() + " ON CHANNEL: " + channel);
        template.send(channel, event);
    }

}
