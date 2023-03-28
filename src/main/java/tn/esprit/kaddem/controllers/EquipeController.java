package tn.esprit.kaddem.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.Services.IEquipeService;
import tn.esprit.kaddem.entity.Equipe;
import tn.esprit.kaddem.entity.Etudiant;

import java.util.List;

@Tag(name = "Web Services pour la gestion des equipes")
@RestController
public class EquipeController {

    private final IEquipeService equipeService;

    @Autowired
    public EquipeController(@Qualifier("equipe1") IEquipeService equipeService) {
        this.equipeService = equipeService;
    }

    @Operation(description = "ceci pour l'ajout d'equipe")
    @PostMapping("/addequipe")
    Equipe addEquipe(@RequestBody Equipe e)
    {
        return equipeService.addEquipe(e);
    }

    @Operation(description = "ceci pour l'update d'equipe")
    @PutMapping("/updateequipe")
    Equipe updateEquipe(@RequestBody Equipe e)
    {
        return equipeService.updateEquipe(e);
    }

    @Operation(description = "ceci pour retrieve equipe ById")
    @GetMapping("/getequipe/{id}")
    Equipe retrieveEquipe(@PathVariable("id") Integer idEquipe)
    {
        return  equipeService.retrieveEquipe(idEquipe);
    }

    @Operation(description = "ceci pour retrieve tous les equipes")
    @GetMapping("/allequipe")
    List<Equipe> retrieveAllEquipes(){
      return  equipeService.retrieveAllEquipes();
    }



}
