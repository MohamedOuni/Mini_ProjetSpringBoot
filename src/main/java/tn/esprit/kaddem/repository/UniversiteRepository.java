package tn.esprit.kaddem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.kaddem.entity.Universite;

import java.util.List;

public interface UniversiteRepository extends JpaRepository<Universite, Integer> {
}
