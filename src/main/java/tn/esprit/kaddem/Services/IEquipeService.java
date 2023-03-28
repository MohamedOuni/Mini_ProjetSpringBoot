package tn.esprit.kaddem.Services;

import tn.esprit.kaddem.entity.Equipe;
import tn.esprit.kaddem.entity.Etudiant;

import java.util.List;

public interface IEquipeService {

    List<Equipe> retrieveAllEquipes();

    Equipe addEquipe(Equipe e);

    Equipe updateEquipe (Equipe e);

    Equipe retrieveEquipe (Integer idEquipe);

}
