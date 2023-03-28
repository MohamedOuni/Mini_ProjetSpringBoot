package tn.esprit.kaddem.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.Services.IContratService;
import tn.esprit.kaddem.entity.Contrat;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

@Tag(name = "Web Services pour la gestion du Contrat")
@RestController
public class ContratController {

    private IContratService contratService;

    @Autowired
    public ContratController(IContratService contratService)
    {
        this.contratService = contratService ;
    }
    @Operation(description = "ceci pour l'ajout du Contrat")
    @PostMapping("/addcontrat")
    Contrat addContrat(@RequestBody Contrat ce)
    {
        return contratService.ajouterOrModifierContrat(ce);
    }

    @Operation(description = "ceci pour suppression du contrat")
    @DeleteMapping("/deletecontrat/{id}")
    void removeContrat(@PathVariable ("id") Integer idContrat){
        contratService.removeContrat(idContrat);
    }

    @Operation(description = "ceci pour l'update du contrat")
    @PutMapping("/updatecontrat")
    Contrat updateContrat(@RequestBody Contrat ce)
    {
        return contratService.ajouterOrModifierContrat(ce);
    }

    @Operation(description = "ceci pour retrieve contrat by id")
    @GetMapping("/getcontrat/{id}")
    Contrat retrieveContrat(@PathVariable("id") Integer idContrat)
    {
        return  contratService.retrieveContrat(idContrat);
    }

    @Operation(description = "ceci pour retrieve tous les contrats")
    @GetMapping("/allcontrat")
    List<Contrat> retrieveAllContrats(){
        return contratService.retrieveAllContrats();
    }


    @PostMapping ("/aseignContratETU")
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce,@RequestParam String nomE,@RequestParam String prenomE)
    {
        return  contratService.affectContratToEtudiant(ce,nomE,prenomE);
    }

    //sinon date : @DateTimeFormat(pattern="yyyy-MM-dd"
    @GetMapping("/archive/{Date}/{date2}")
    public float getChiffreAffaireEntreDeuxDate(@PathVariable("Date") Date startDate,@PathVariable("date2") Date endDate)
    {
        return contratService.getChiffreAffaireEntreDeuxDate(startDate,endDate);
    }



    @GetMapping("/geteers")
    public void retrieveStatusContrat(){
         contratService.retrieveStatusContrat();

    }

    @PostMapping("/getValide/{Date}/{date2}")
    public Integer nbContratsValides(@PathVariable("Date") Date startDate,@PathVariable("date2") Date endDate)
    {
        return contratService.nbContratsValides(startDate, endDate);
    }

   /* @Operation(description = "Nombre des contrat Archive")
    @GetMapping("/nbrFalse")
    public Integer  getNombratContrat(@RequestBody Date startDate,@RequestBody Date endDate)
    {
        return contratService.getNombratContrat(startDate,endDate);
    }*/

    @GetMapping("/ouni/{Date}/{date2}")
    public Integer countContratWhenArchiveIsfalse(@PathVariable("Date") Date startDate,@PathVariable("date2") Date endDate){
        return contratService.countContratWhenArchiveIsfalse(startDate,endDate);
    }



}
