package asw.instagnam.ricetteseguite.domain;

import asw.instagnam.common.api.event.DomainEvent;  
import asw.instagnam.ricetteservice.api.event.*;

import org.springframework.stereotype.Service;

import java.util.logging.*;

@Service
public class RicettaDomainEventConsumer implements DomainEventConsumer{

	private final Logger logger = Logger.getLogger(RicettaDomainEventConsumer.class.toString());

	public void onEvent(DomainEvent event) {
        if (event.getClass().equals(RicettaCreatedEvent.class)) {
			RicettaCreatedEvent cce = (RicettaCreatedEvent) event;
			ricettaCreated(cce); 
		}else {
			logger.info("UNKNOWN EVENT: " + event);			
		}
	}
	
    private void ricettaCreated(RicettaCreatedEvent event) {
		Ricetta ricetta = new Ricetta(event.getId(), event.getTitolo(), event.getAutore());
		//salvare del DB
		logger.info("CREATED  RICETTA: " + ricetta);
	}

}
 
