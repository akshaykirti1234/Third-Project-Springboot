package tech.csm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.csm.model.Country;

public interface CountryRepo extends JpaRepository<Country, Integer> {

}
