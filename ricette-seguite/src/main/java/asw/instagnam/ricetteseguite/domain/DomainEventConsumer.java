package asw.instagnam.ricetteseguite.domain;

import asw.instagnam.common.api.event.DomainEvent; 

public interface DomainEventConsumer {

	public void onEvent(DomainEvent event);
	
}
