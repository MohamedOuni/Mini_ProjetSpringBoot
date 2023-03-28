package tn.esprit.kaddem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.kaddem.entity.Equipe;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {

}
