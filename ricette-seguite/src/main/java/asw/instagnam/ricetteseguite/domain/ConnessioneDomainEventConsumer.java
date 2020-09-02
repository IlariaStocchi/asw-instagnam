package asw.instagnam.ricetteseguite.domain;

import asw.instagnam.common.api.event.DomainEvent;  
import asw.instagnam.connessioniservice.api.event.*;

import org.springframework.stereotype.Service;

import java.util.logging.*;

@Service
public class ConnessioneDomainEventConsumer implements DomainEventConsumer{

	private final Logger logger = Logger.getLogger(ConnessioneDomainEventConsumer.class.toString());

	public void onEvent(DomainEvent event) {
        if (event.getClass().equals(ConnessioneCreatedEvent.class)) {
			ConnessioneCreatedEvent cce = (ConnessioneCreatedEvent) event;
			connessioneCreated(cce); 
		}else {
			logger.info("UNKNOWN EVENT: " + event);			
		}
	}
	
    private void connessioneCreated(ConnessioneCreatedEvent event) {
		Connessione connessione = new Connessione(event.getId(), event.getFollower(), event.getFollowed());
		//salvare del DB
		logger.info("CREATED  CONNESSIONE: " + connessione);
	}

}
