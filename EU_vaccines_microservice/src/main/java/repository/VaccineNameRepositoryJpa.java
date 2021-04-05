package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.VaccineNamesEntity;

public interface VaccineNameRepositoryJpa extends JpaRepository<VaccineNamesEntity, String> {

}
