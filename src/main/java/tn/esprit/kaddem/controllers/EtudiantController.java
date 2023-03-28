package tn.esprit.kaddem.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.Services.IEquipeService;
import tn.esprit.kaddem.Services.IEtudiantService;
import tn.esprit.kaddem.entity.Etudiant;

import java.util.List;

@Tag(name = "Web Services pour la gestion des Etudiants")
@RestController
public class EtudiantController {

    private IEtudiantService etudiantService;
    private IEquipeService equipeService;

    @Autowired
    public EtudiantController(@Qualifier("etudiant1") IEtudiantService etudiantService){
        this.etudiantService = etudiantService;
    }

    @Operation(description = "ceci pour l'ajout d'un etudiant")
    @PostMapping("/addetudiant")
    Etudiant addEtudiant(@RequestBody Etudiant e)
    {
        return etudiantService.ajouterOrModifierEtudiant(e);
    }

    @Operation(description = "ceci pour la suppression d'un etudiant")
    @DeleteMapping("/deleteetudiant/{id}")
    void removeEtudiant(@PathVariable ("id") Integer idEtudiant)
    {
        etudiantService.removeEtudiant(idEtudiant);

    }

    @Operation(description = "ceci pour l'update d'un etudiant")
    @PutMapping("/updateetudiant")
     Etudiant updateEtudiant(@RequestBody Etudiant e)
    {
        return etudiantService.ajouterOrModifierEtudiant(e);
    }

    @Operation(description = "ceci pour retrive etudiant ById")
    @GetMapping("/alletudiant")
    List<Etudiant> retrieveAllEtudiants()
    {
        return etudiantService.retrieveAllEtudiants();
    }

    @Operation(description = "ceci pour retrieve tous les etudiants")
    @GetMapping("/getetudiant/{id}")
    Etudiant retrieveEtudiant(@PathVariable("id") Integer idEtudiant)
    {
        return  etudiantService.retrieveEtudiant(idEtudiant);
    }

    @Operation(description = "ceci pour l'affectation etudiant departement")
    @PutMapping("/addetudiantdepart/{idEt}/{idDep}")
    Etudiant asignEtudiant(@PathVariable("idEt") Integer idEtudiant ,@PathVariable("idDep")  Integer idDepart )
    {
        return etudiantService.asignEtudiant(idEtudiant,idDepart);

    }

    @Operation(description = "ceci pour l'affectation etudiant equipe")
    @PutMapping("/AddetudiantEqui/{idEt}/{idEqui}")
    Etudiant asignEtuEquipe(@PathVariable("idEt") Integer idEtudiant  , @PathVariable("idEqui")  Integer idEquipe )
    {
        return etudiantService.asignEtuEquipe(idEtudiant,idEquipe);

    }

    @PutMapping("/ouni/{idCon}/{idEq}")
    Etudiant EtuContratEquipe(@RequestBody Etudiant e ,@PathVariable("idCon") Integer idContrat  , @PathVariable("idEq")  Integer idEquipe)
    {
       return  etudiantService.EtuContratEquipe(e,idContrat,idEquipe);
    }

    @GetMapping("/all/{idDepartement}")
    List<Etudiant> getEtudiantsByDepartement (@PathVariable("idDepartement") Integer idDepartement)
    {
       return etudiantService.getEtudiantsByDepartement(idDepartement);
    }



}
