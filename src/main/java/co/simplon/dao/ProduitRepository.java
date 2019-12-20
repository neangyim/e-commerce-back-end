package co.simplon.dao;

import co.simplon.entitie.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit,Long> {
    @RestResource(path = "/selectedProduits")
    public List<Produit> findBySelectedIsTrue();
    @RestResource(path = "/produitsByKeyword")
    public List<Produit>findByNameContains(@Param("mc") String mc);
}
