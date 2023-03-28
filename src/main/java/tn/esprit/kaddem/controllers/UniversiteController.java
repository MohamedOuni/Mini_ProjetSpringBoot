package tn.esprit.kaddem.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.Services.IUniversiteService;
import tn.esprit.kaddem.entity.Universite;

import java.util.List;

@Tag(name = "Web Services pour la gestion des universités")
@RestController
public class UniversiteController {

    private final IUniversiteService universiteService;

    @Autowired
    public UniversiteController(@Qualifier("universite1") IUniversiteService universiteService) {
        this.universiteService = universiteService;
    }

    @Operation(description = "ceci pour l'ajout d'une universite")
    @PostMapping("/adduniversity")
    Universite addUniversite(@RequestBody Universite u)
    {
        return universiteService.addUniversite(u);
    }

    @Operation(description = "ceci pour l'update d'une universite")
    @PutMapping("/updateuniversity")
    Universite updateUniversite(@RequestBody Universite u)
    {
        return universiteService.updateUniversite(u);
    }

    @Operation(description = "ceci pour retrieve universite ById")
    @GetMapping("/getuniversity/{id}")
    Universite retrieveUniversite(@PathVariable("id") Integer idUniv )
    {
        return  universiteService.retrieveUniversite(idUniv);
    }

    @Operation(description = "ceci pour retrieve tous les universites")
    @GetMapping("/alluniversity")
    List<Universite> retrieveAllUniversites()
    {
        return universiteService.retrieveAllUniversites();
    }

    @Operation(description = "ceci pour l'affectation universite departement ")
    @PutMapping("/adduniversityDepart/{idUni}/{idDepar}")
    Universite asignUniversiteDepartement(@PathVariable("idUni") Integer idUniv  , @PathVariable("idDepar")  Integer idDepart )
    {
        return universiteService.asignUniversiteDepartement(idUniv,idDepart);

    }



}
