package tn.esprit.kaddem.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

@ToString
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private int idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option op;
    // Constructeur et accesseurs (getters) et mutateurs (setters)
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Equipe> equipes;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="etudiant")
    @JsonIgnore
    private Set<Contrat> contrats;

    @ManyToOne
    Departement departement;

}