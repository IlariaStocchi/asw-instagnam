package asw.instagnam.connessioni.domain;

import asw.instagnam.common.api.event.DomainEvent; 

public interface ConnessioneDomainEventPublisher {

    public void publish(DomainEvent event);

}
