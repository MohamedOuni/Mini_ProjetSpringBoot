package tn.esprit.kaddem.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entity.Equipe;
import tn.esprit.kaddem.entity.Etudiant;
import tn.esprit.kaddem.repository.EquipeRepository;
import tn.esprit.kaddem.repository.EtudiantRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Service("equipe1")
public class EquipeService implements IEquipeService{

    private  final EtudiantRepository etudiantRepository;
    private final EquipeRepository equipeRepository ;

@Autowired
    public EquipeService(EtudiantRepository etudiantRepository, EquipeRepository equipeRepository) {
    this.etudiantRepository = etudiantRepository;
    this.equipeRepository = equipeRepository;
    }

    @Override
    public List<Equipe> retrieveAllEquipes() {
        List<Equipe>  equipes = new ArrayList<>();
        equipeRepository.findAll().forEach(equipes::add);
        return equipes;
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).orElse(null);
    }


}
