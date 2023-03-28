package tn.esprit.kaddem.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.Services.DepartementService;
import tn.esprit.kaddem.Services.IContratService;
import tn.esprit.kaddem.Services.IDepartementService;
import tn.esprit.kaddem.entity.Departement;

import java.util.List;

@Tag(name = "Web Services pour la gestion des Departement")
@RestController
public class DepartementController {

    private final IDepartementService departementService;

    @Autowired
    public DepartementController(@Qualifier("departement2") IDepartementService departementService){
        this.departementService = departementService;
    }

    @Operation(description = "ceci pour l'ajout du département")
    @PostMapping("/adddepartement")
    Departement addDepartement(@RequestBody Departement d)
    {
        return departementService.addDepartement(d);
    }

    @Operation(description = "ceci pour l'update du département")
    @PutMapping("/updatedepartement")
    Departement updateDepartement(@RequestBody Departement d)
    {
        return departementService.updateDepartement(d);
    }

    @Operation(description = "ceci pour retrieve département ByID")
    @GetMapping("/getdepartement/{id}")
    Departement retrieveDepartement(@PathVariable("id") Integer idDepart)

    {
        return  departementService.retrieveDepartement(idDepart);
    }

    @Operation(description = "ceci pour retrieve tous les départements")
    @GetMapping("/alldepartement")
    List<Departement> retrieveAllDepartements()
    {
        return departementService.retrieveAllDepartements();
    }

    @GetMapping("/allDep/{idUniversite}")
    public List<Departement> retrieveDepartementsByUniversite( @PathVariable("idUniversite") Integer idUniversite)
    {
        return departementService.retrieveDepartementsByUniversite(idUniversite);
    }
}
