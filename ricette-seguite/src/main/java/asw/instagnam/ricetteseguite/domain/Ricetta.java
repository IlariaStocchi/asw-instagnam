package asw.instagnam.ricetteseguite.domain;

import lombok.*; 

/* Ricetta (in formato breve). */ 
@Data @NoArgsConstructor @AllArgsConstructor
public class Ricetta {

	private Long id; 
	private String autore; 
	private String titolo; 
	
}
