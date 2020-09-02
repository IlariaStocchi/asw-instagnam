package asw.instagnam.ricetteseguite.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*; 

/* Ricetta (in formato breve). */ 
@Entity 
@Data @NoArgsConstructor @AllArgsConstructor
public class Ricetta {
	
	@Id 
	@GeneratedValue
	private Long id; 
	private String autore; 
	private String titolo; 
	
}
