package asw.instagnam.connessioniservice.api.event;

import asw.instagnam.common.api.event.DomainEvent; 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnessioneCreatedEvent implements DomainEvent {

	private Long id; 
	private String follower; 
	private String followed; 
	
}
