package tn.esprit.kaddem.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Universite implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idUniversite")
    private Integer idUniv; // Clé primaire
    private String nomUniv;
    // Constructeur et accesseurs (getters) et mutateurs (setters)
    @OneToMany(cascade = {CascadeType.ALL,CascadeType.REMOVE})
    private Set<Departement> departements;
}