package tech.csm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tech.csm.model.District;

public interface DistrictRepo extends JpaRepository<District, Integer> {

	@Query("From District where state.stateId = :stateId")
	List<District> getStateByCountryId(Integer stateId);

}
