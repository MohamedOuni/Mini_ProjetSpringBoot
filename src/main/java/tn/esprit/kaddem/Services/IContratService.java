package tn.esprit.kaddem.Services;

import tn.esprit.kaddem.entity.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {

    Contrat ajouterOrModifierContrat(Contrat ce);
    void removeContrat(Integer idContrat);
    Contrat retrieveContrat(Integer idContrat);
    List<Contrat> retrieveAllContrats();
    Contrat affectContratToEtudiant (Contrat ce, String nomE,String prenomE);

    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
    Integer nbContratsValides(Date startDate, Date endDate);

    void retrieveStatusContrat();
    //Integer getNombratContrat(Date startDate, Date endDate );
    Integer countContratWhenArchiveIsfalse(Date startDate, Date endDate);
}
