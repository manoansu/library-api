package pt.amane.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.amane.library.domain.Categoria;
import pt.amane.library.domain.Livro;
import pt.amane.library.repositories.LivroRepository;
import pt.amane.library.service.exception.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository lr;
	
	@Autowired
	private CategoriaService cs;

	public Livro findById(Long id) {
		Optional<Livro> livroId = lr.findById(id);
		return livroId.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type " + Livro.class.getName()));
	}

	public List<Livro> findAll(Long id_cat) {
		cs.findById(id_cat);
		return lr.findAllByCategoria(id_cat);
	}
	
	
	public Livro update(Long id, Livro livro2) {
		Livro livro = findById(id);
		livro.setTitulo(livro2.getTitulo());
		livro.setTexto(livro2.getTexto());
		livro.setAutor(livro2.getAutor());
		return lr.save(livro);
	}
	

	public Livro create(Long id_cat, Livro livro) {
		livro.setId(null);
		Categoria cat = cs.findById(id_cat);
		livro.setCategoria(cat);
		return lr.save(livro);
	}
	
	public void delete(Long id) {
		Livro obj = findById(id);
		lr.delete(obj);
	}

}
