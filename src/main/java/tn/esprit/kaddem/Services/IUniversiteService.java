package tn.esprit.kaddem.Services;

import tn.esprit.kaddem.entity.Universite;

import java.util.List;

public interface IUniversiteService {

    Universite addUniversite(Universite u);
    Universite updateUniversite(Universite u);

    Universite retrieveUniversite(Integer idUniv);

    List<Universite> retrieveAllUniversites();
    Universite asignUniversiteDepartement(Integer idUniv, Integer idDepart);
}
