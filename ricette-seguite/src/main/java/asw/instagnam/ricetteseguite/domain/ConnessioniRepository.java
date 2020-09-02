package asw.instagnam.ricetteseguite.domain;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface ConnessioniRepository extends CrudRepository<Connessione, Long> {

	public Collection<Connessione> findAll();

	public Collection<Connessione> findAllByFollower(String follower);

}
