package pt.amane.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import pt.amane.library.domain.Categoria;
import pt.amane.library.dtos.CategoriaDTO;
import pt.amane.library.repositories.CategoriaRepository;
import pt.amane.library.service.exception.ObjectNotFoundException;

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

	public Categoria create(Categoria categoria) {
		categoria.setId(null);
		return cr.save(categoria);
	}

	public Categoria update(Long id, CategoriaDTO categoriaDTO) {
		Categoria categoria = findById(id); // Verify if element exist in db..
		categoria.setNome(categoriaDTO.getNome());
		categoria.setDescricao(categoriaDTO.getDescricao());
		return cr.save(categoria);
	}

	public void delete(Long id) {
		findById(id);
		try {
			cr.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new pt.amane.library.service.exception.DataIntegrityViolationException(
					"Categoria nao pode ser deletado! Possui livro associado");
		}

	}

}
