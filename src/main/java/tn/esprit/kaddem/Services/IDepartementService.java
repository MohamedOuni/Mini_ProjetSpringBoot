package tn.esprit.kaddem.Services;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.kaddem.entity.Departement;

import java.util.List;

public interface IDepartementService {

    Departement addDepartement(Departement d);
    Departement updateDepartement(Departement d);
    List<Departement> retrieveAllDepartements();

    Departement retrieveDepartement(Integer idDepart);

     List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}
