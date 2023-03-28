package tn.esprit.kaddem.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entity.Departement;
import tn.esprit.kaddem.repository.DepartementRepository;
import tn.esprit.kaddem.repository.UniversiteRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@Service("departement2")
public class DepartementService implements IDepartementService {

    private final UniversiteRepository universiteRepository;
    private final DepartementRepository departementRepository;

    @Autowired
    public DepartementService(UniversiteRepository universiteRepository, DepartementRepository departementRepository) {
        this.universiteRepository = universiteRepository;
        this.departementRepository = departementRepository;
    }


    @Override
    public Departement addDepartement(Departement d)
    {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d)
    {
        return departementRepository.save(d);
    }

    @Override
    public List<Departement> retrieveAllDepartements() {
        List<Departement> departements = new ArrayList<>();
        departementRepository.findAll().forEach(departements::add);
        return departements;
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        return departementRepository.findById(idDepart).orElse(null);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
       List<Departement> departementss = new ArrayList<>();
        universiteRepository.findById(idUniversite).orElse(null).getDepartements().forEach(departementss::add);
        return departementss;
    }
}
