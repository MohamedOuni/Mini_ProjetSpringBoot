package tn.esprit.kaddem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
        import java.io.Serializable;
        import java.util.Set;
@ToString
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Equipe  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEquipe")
    private Integer idEquipe; // Clé primaire
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niv;
    @OneToOne
    @JsonIgnore
    private DetailEquipe Detail_Equipe;
    // Constructeur et accesseurs (getters) et mutateurs (setters)
    @ManyToMany(mappedBy="equipes", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Etudiant> etudiants;
}