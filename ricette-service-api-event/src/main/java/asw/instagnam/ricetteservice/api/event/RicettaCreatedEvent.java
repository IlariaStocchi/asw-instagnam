package asw.instagnam.ricetteservice.api.event;

import asw.instagnam.common.api.event.DomainEvent; 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RicettaCreatedEvent implements DomainEvent {

    private Long id;
	private String autore; 
	private String titolo; 
	 
	
}
