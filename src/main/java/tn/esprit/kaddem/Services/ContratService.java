package tn.esprit.kaddem.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entity.Contrat;
import tn.esprit.kaddem.entity.Etudiant;
import tn.esprit.kaddem.repository.ContratRepository;
import tn.esprit.kaddem.repository.EtudiantRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Service
@Component
@AllArgsConstructor
public class ContratService implements IContratService {

    private final EtudiantRepository etudiantRepository;

    private final ContratRepository contratRepository;



    @Override
    public Contrat ajouterOrModifierContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public void removeContrat(Integer idContrat) {
        contratRepository.deleteById(idContrat);

    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public List<Contrat> retrieveAllContrats() {
        List<Contrat> contrats = new ArrayList<>();
        contratRepository.findAll().forEach(contrats::add);
        return contrats;
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
       Etudiant e = etudiantRepository.findByNomEAndPrenomE(nomE,prenomE);
        if (e != null) {
            if (e.getContrats().size() < 5)
                ce.setEtudiant(e);
        }
        return contratRepository.save(ce);
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        float montants = 0;
        float mois = endDate.getMonth() - startDate.getMonth();
        if (mois > 0) {
            for (Contrat contrat : contratRepository.findByDateDebutContratGreaterThanEqualAndDateFinContratLessThanEqual(startDate, endDate)) {

                if (!contrat.getArchive()) {
                    switch (contrat.getSp()) {
                        case IA:
                            montants += 300 * mois;break;
                        case RESEAUX:
                            montants +=350 * mois;break;
                        case CLOUD:
                            montants += 400 *mois;break;
                        case SECURITE:
                            montants += 450 * mois;break;
                    }
                }
            }
        }
        return montants;
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        return contratRepository.findByDateDebutContratGreaterThanEqualAndDateFinContratLessThanEqual(startDate, endDate).size();
    }

    @Override
    @Scheduled(cron = "0 0 1 ? * *")
    public void retrieveStatusContrat() {
        List<Contrat> C = retrieveAllContrats();
        LocalDate localDate = LocalDate.now();
        for (int d = 0; d < C.size(); d++) {
            Contrat S = C.get(d);
            long diff = localDate.getDayOfMonth() - S.getDateFinContrat().getTime();
            long diffs = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            if (diffs <= 0) {
                LOGGER.info("Contrat " + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
                S.setArchive(true);
                contratRepository.save(S);
            } else if (diffs <= 15) {
                LOGGER.info("Contrat expirer " + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
            }
        }
    }

    /*@Override
    public Integer getNombratContrat(Date startDate, Date endDate) {
            int nbContrat=0;
            List<Contrat> ListContrat = contratRepository.findByDateDebutContratGreaterThanEqualAndDateFinContratLessThanEqual(startDate, endDate);        for (Contrat contrat : contratRepository.findByDateDebutContratGreaterThanEqualAndDateFinContratLessThanEqual(startDate, endDate)){
            for(Contrat c : ListContrat){
                if(contrat.getArchive()==false){
                nbContrat++ ;
                }
            }
        }
       return nbContrat;
    } */

    public Integer countContratWhenArchiveIsfalse(Date startDate, Date endDate){
        return contratRepository.countByArchiveIsFalseAndDateDebutContratBetween(startDate,endDate);
    }


}
