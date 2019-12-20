package co.simplon.entitie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@Entity  // JPA
@Data @NoArgsConstructor @AllArgsConstructor //  C'est lombook genérate Automatichiquement les getters et les setters
public class Categorie implements Serializable {
    // les Artribues
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  //jpa
    private Long id;
    private String name;
    private String description;
    // category contient plusieurs priduits  //jpa
    @OneToMany(mappedBy = "categories")
    private Collection<Produit> produits;
}
