package tn.esprit.kaddem.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entity.Contrat;
import tn.esprit.kaddem.entity.Departement;
import tn.esprit.kaddem.entity.Equipe;
import tn.esprit.kaddem.entity.Etudiant;
import tn.esprit.kaddem.repository.ContratRepository;
import tn.esprit.kaddem.repository.DepartementRepository;
import tn.esprit.kaddem.repository.EquipeRepository;
import tn.esprit.kaddem.repository.EtudiantRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Service("etudiant1")
@AllArgsConstructor
public class EtudiantService  implements IEtudiantService{

    private final ContratRepository contratRepository;

    private final EquipeRepository equipeRepository;
    private  final DepartementRepository departementRepository;

    private final EtudiantRepository etudiantRepository ;

    @Override
    public Etudiant ajouterOrModifierEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {

        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();
        etudiantRepository.findAll().forEach(etudiants::add);
        return etudiants;
    }

    @Override
    public Etudiant asignEtudiant(Integer idEtudiant, Integer idDepart )
    {
        Etudiant e= etudiantRepository.findById(idEtudiant).orElse(null);
         Departement d= departementRepository.findById(idDepart).orElse(null) ;
         e.setDepartement(d);
         return etudiantRepository.save(e);
    }
    @Override
    public Etudiant asignEtuEquipe(Integer idEquipe, Integer idEtudiant )
    {
        Etudiant e= etudiantRepository.findById(idEtudiant).orElse(null);
        Equipe eq= equipeRepository.findById(idEquipe).orElse(null) ;
        if (e.getEquipes()==null){
            Set<Equipe> equipes= new HashSet<>();
            equipes.add(eq);
            e.setEquipes(equipes);
        }
        else {
            e.getEquipes().add(eq);

        }
        return  etudiantRepository.save(e);
    }

    @Override
    public Etudiant EtuContratEquipe(Etudiant e, Integer idContrat, Integer idEquipe) {
        Equipe eq= equipeRepository.findById(idEquipe).orElse(null) ;
        if (e.getEquipes()==null){
            Set<Equipe> equipes= new HashSet<>();
            equipes.add(eq);
            e.setEquipes(equipes);
        }
        else {
            e.getEquipes().add(eq);

        }
        Etudiant etudiant = etudiantRepository.save(e);

        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        contrat.setEtudiant(e);
        contratRepository.save(contrat);
        return etudiant;
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        return etudiantRepository.findByDepartementIdDepart(idDepartement);
    }


}
