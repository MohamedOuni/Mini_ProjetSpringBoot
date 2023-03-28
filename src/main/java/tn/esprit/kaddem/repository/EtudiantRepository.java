package tn.esprit.kaddem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.kaddem.entity.Etudiant;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
    Etudiant findByNomEAndPrenomE(String nomE,String prenomE);
    List<Etudiant> findByDepartementIdDepart(Integer idDepart);

}
