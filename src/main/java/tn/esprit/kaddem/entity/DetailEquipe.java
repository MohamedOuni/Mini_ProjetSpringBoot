package tn.esprit.kaddem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

       import javax.persistence.*;
        import java.io.Serializable;
        import lombok.Getter;
        import lombok.Setter;
        import lombok.ToString;

@ToString
@Setter
@Getter
@Entity
@Table( name = "DetailEquipe")
public class DetailEquipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDetailEquipe")
    private Integer idDetailEquipe; // Clé primaire
    private int salle;
    private String thematique;
    @OneToOne(mappedBy="Detail_Equipe")
    @JsonIgnore
    private Equipe equipe;
}