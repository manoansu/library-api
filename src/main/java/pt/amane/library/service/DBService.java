package pt.amane.library.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.amane.library.domain.Categoria;
import pt.amane.library.domain.Livro;
import pt.amane.library.repositories.CategoriaRepository;
import pt.amane.library.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository cr;
	
	@Autowired
	private LivroRepository lr;
	
	public void instaciarDataBase() {
		
		Categoria cat1 = new Categoria(null, "Informatica", "Livro de TI");
		Categoria cat2 = new Categoria(null, "ficção cientifica", "ficção cientifica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livro de Biografia");
		
		
		Livro l1 = new Livro(null, "Clean code", "Robert Marting", "Lorem Ipson", cat1);
		Livro l2 = new Livro(null, "Engenharia de software", "Lewis V. Costner", "Lorem Ipson", cat1);
		Livro l3 = new Livro(null, "The time Machine", "M.C.Wells", "Lorem Ipson", cat2);
		Livro l4 = new Livro(null, "The war of worlds", "M:C:Wells", "Lorem Ipson", cat2);
		Livro l5 = new Livro(null, "1,Robot", "Issack Asimov", "Lorem Ipson", cat3);
		Livro l6 = new Livro(null, "Macine Learning", "Mark avbert", "Lorem Ipson", cat3);
		
		cat1.getLivros().addAll(Arrays.asList(l1,l2));
		cat2.getLivros().addAll(Arrays.asList(l3,l4));
		cat3.getLivros().addAll(Arrays.asList(l5,l6));
		
		cr.saveAll(Arrays.asList(cat1,cat2,cat3));
		lr.saveAll(Arrays.asList(l1,l2,l3,l4,l5,l6));
	}

}
