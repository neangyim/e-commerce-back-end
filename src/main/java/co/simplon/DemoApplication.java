package co.simplon;

import co.simplon.dao.CategorieRepository;
import co.simplon.dao.ProduitRepository;
import co.simplon.entitie.Categorie;
import co.simplon.entitie.Produit;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired  // pour injection despandent
	private CategorieRepository categoriesRepository;
	@Autowired
	private ProduitRepository produitRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		categoriesRepository.save(new Categorie(null,"Computeur",null,null));
		categoriesRepository.save(new Categorie(null,"Printer",null,null));
		categoriesRepository.save(new Categorie(null,"Smar phone",null,null));
		categoriesRepository.save(new Categorie(null,"Protection écran",null,null));
		categoriesRepository.save(new Categorie(null,"Sumsung Glaxy12",null,null));
		categoriesRepository.save(new Categorie(null,"Imprimente",null,null));
		categoriesRepository.save(new Categorie(null,"Télévision",null,null));
		categoriesRepository.save(new Categorie(null,"Windows 10",null,null));
			Random rnd=new Random();
		categoriesRepository.findAll().forEach(c->{
			for (int i=0;i<10;i++){
				Produit p=new Produit();
				p.setName(RandomString.make(18));
				p.setCurrentprice(100+rnd.nextInt(1000));
				p.setAvailiable(rnd.nextBoolean());
				p.setPromotion(rnd.nextBoolean());
				p.setSelected(rnd.nextBoolean());
				p.setCategories(c);
				p.setPictureName("unknown.png");
				produitRepository.save(p);
			}
		});
	}
}
