package tn.esprit.kaddem.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entity.Departement;
import tn.esprit.kaddem.entity.Equipe;
import tn.esprit.kaddem.entity.Universite;
import tn.esprit.kaddem.repository.DepartementRepository;
import tn.esprit.kaddem.repository.UniversiteRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Service("universite1")
public class UniversiteService implements  IUniversiteService {

    public final UniversiteRepository universiteRepository;
    public final DepartementRepository departementRepository;

    @Autowired
    public UniversiteService(UniversiteRepository universiteRepository, DepartementRepository departementRepository) {
        this.universiteRepository = universiteRepository;
        this.departementRepository = departementRepository;
    }


    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniv) {
        return universiteRepository.findById(idUniv).orElse(null);
    }

    @Override
    public List<Universite> retrieveAllUniversites() {
        List<Universite> universites = new ArrayList<>();
        universiteRepository.findAll().forEach(universites::add);
        return universites;
    }

    @Override
    public Universite asignUniversiteDepartement(Integer idUniv, Integer idDepart) {
        Universite u= universiteRepository.findById(idUniv).orElse(null);
        Departement d= departementRepository.findById(idDepart).orElse(null) ;
        if (u.getDepartements()==null){
            Set<Departement> departements= new HashSet<>();
            departements.add(d);
            u.setDepartements(departements);
        }
        else {
            u.getDepartements().add(d);

        }
        return  universiteRepository.save(u);
    }
}
