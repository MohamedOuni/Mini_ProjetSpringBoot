package tn.esprit.kaddem.Services;

import tn.esprit.kaddem.entity.Equipe;
import tn.esprit.kaddem.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {


    Etudiant ajouterOrModifierEtudiant(Etudiant e);
    void removeEtudiant(Integer idEtudiant);
    Etudiant retrieveEtudiant(Integer idEtudiant);
    List<Etudiant> retrieveAllEtudiants();
    Etudiant asignEtudiant(Integer idEtudiant , Integer idDepart );
    Etudiant asignEtuEquipe(Integer idEquipe, Integer idEtudiant );

    Etudiant EtuContratEquipe(Etudiant e,Integer idContrat, Integer idEquipe );

    List<Etudiant> getEtudiantsByDepartement(Integer idDepartement);

}
