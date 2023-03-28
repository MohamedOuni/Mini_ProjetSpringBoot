package tn.esprit.kaddem.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contrat implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
     Integer idContrat;
     Date dateDebutContrat;
     Date dateFinContrat;
    @Enumerated(EnumType.STRING)
    Specialite sp;
    Boolean archive;
    Integer montantContrat;
    // Constructeur et accesseurs (getters) et mutateurs (setters)
    @ManyToOne(cascade = CascadeType.PERSIST)
    Etudiant etudiant;



}