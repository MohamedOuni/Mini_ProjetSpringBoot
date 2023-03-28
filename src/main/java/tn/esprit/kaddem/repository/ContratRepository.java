package tn.esprit.kaddem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.kaddem.entity.Contrat;

import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat , Integer> {
    List<Contrat> findByDateDebutContratGreaterThanEqualAndDateFinContratLessThanEqual(Date dateDebutContrat, Date dateFinContrat);
    List<Contrat> findContratByArchiveIsFalse();
    Integer countByArchiveIsFalseAndDateDebutContratBetween(Date startDate, Date endDate);
     }
