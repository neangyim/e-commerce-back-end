package co.simplon.entitie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Entity  // jpa
@Data @NoArgsConstructor @AllArgsConstructor   // lombook generate Automatichiquement lesgetters et setters
public class Produit implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  //jpa
    private Long id;
    private String name;
    private String description;
    private double currentprice;
    private boolean promotion;
    private boolean selected;
    private boolean availiable;
    private String pictureName;
    @ManyToOne
    private Categorie categories;
}
