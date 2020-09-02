package asw.instagnam.ricetteseguite.rest.eventlistener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import asw.instagnam.common.api.event.DomainEvent; 

public interface DomainEventListener {

    public void listen(ConsumerRecord<String, DomainEvent> record) throws Exception;
    
}
