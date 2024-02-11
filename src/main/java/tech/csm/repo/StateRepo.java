package tech.csm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tech.csm.model.State;

public interface StateRepo extends JpaRepository<State, Integer> {

	@Query("From State where country.countryId = :countryId")
	List<State> getStateByCountryId(Integer countryId);

}
