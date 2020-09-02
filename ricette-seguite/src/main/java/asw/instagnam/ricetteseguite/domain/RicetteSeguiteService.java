package asw.instagnam.ricetteseguite.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.ricetteservice.api.event.RicettaCreatedEvent;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*; 

@Service 
@Transactional
public class RicetteSeguiteService {
	
	@Autowired
	private ConnessioniRepository connessioniRepository;
	
	@Autowired
	private RicetteRepository ricetteRepository;

	/* Trova le ricette (in formato breve) degli utenti seguiti da utente. */ 
	public Collection<Ricetta> getRicetteSeguite(String utente) {
		Collection<Ricetta> ricette = new ArrayList<>(); 
		Collection<Connessione> connessioni = this.getConnessioniByFollower(utente); 
		for (Connessione connessione : connessioni) {
			String followed = connessione.getFollowed();
			Collection<Ricetta> ricetteByFollowed = this.getRicetteByAutore(followed);
			ricette.addAll(ricetteByFollowed);
		}
		return ricette; 
	}

 	public Connessione createConnessione(Long id, String follower, String followed) {
		Connessione connessione = new Connessione(id, follower, followed); 
		connessione = connessioniRepository.save(connessione);
		return connessione;
	}

 	public Connessione getConnessione(Long id) {
		Connessione connessione = connessioniRepository.findById(id).orElse(null);
		return connessione;
	}

 	public Collection<Connessione> getConnessioni() {
		Collection<Connessione> connessioni = connessioniRepository.findAll();
		return connessioni;
	}

	public Collection<Connessione> getConnessioniByFollower(String follower) {
		Collection<Connessione> connessioni = connessioniRepository.findAllByFollower(follower);
		return connessioni;
	}
	
 	public Ricetta createRicetta(Long id, String autore, String titolo) {
		Ricetta ricetta = new Ricetta(id, autore, titolo); 
		ricetta = ricetteRepository.save(ricetta);
		return ricetta;
	}

 	public Ricetta getRicetta(Long id) {
		Ricetta ricetta = ricetteRepository.findById(id).orElse(null);
		return ricetta;
	}

	public Collection<Ricetta> getRicette() {
		Collection<Ricetta> ricette = ricetteRepository.findAll();
		return ricette;
	}

	public Collection<Ricetta> getRicetteByAutore(String autore) {
		Collection<Ricetta> ricette = ricetteRepository.findAllByAutore(autore);
		return ricette;
	}
	
}
