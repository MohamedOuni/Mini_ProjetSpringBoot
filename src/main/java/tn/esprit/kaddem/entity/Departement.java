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
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDepartement")
    private Integer idDepart; // Clé primaire
    private String nomDepart;
// Constructeur et accesseurs (getters) et mutateurs (setters)

    @OneToMany( mappedBy = "departement")
    @JsonIgnore
    private Set<Etudiant> etudiants;
}


