package pt.amane.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.amane.library.domain.Categoria;
import pt.amane.library.exception.ObjectNotFoundException;
import pt.amane.library.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository cr;

	public Categoria findById(Long id) {
		Optional<Categoria> catId = cr.findById(id);
		return catId.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return cr.findAll();
	}

}
