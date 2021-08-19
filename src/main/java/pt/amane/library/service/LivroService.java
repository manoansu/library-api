package pt.amane.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.amane.library.domain.Livro;
import pt.amane.library.exception.ObjectNotFoundException;
import pt.amane.library.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository lr;

	public Livro findById(Long id) {
		Optional<Livro> livroId = lr.findById(id);
		return livroId.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type " + Livro.class.getName()));
	}

	public List<Livro> findAll() {
		return lr.findAll();
	}

}
