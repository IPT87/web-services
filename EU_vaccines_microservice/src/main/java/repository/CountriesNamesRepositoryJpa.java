package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.CountriesNamesEntity;

public interface CountriesNamesRepositoryJpa extends JpaRepository<CountriesNamesEntity, String> {

}
