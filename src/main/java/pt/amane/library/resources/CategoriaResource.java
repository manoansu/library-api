package pt.amane.library.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.amane.library.domain.Categoria;
import pt.amane.library.dtos.CategoriaDTO;
import pt.amane.library.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService cs;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
		Categoria catId = cs.findById(id);
		return ResponseEntity.ok().body(catId);
	}

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> lista = cs.findAll();
		List<CategoriaDTO> listDTO = lista.stream().map(catobj -> new CategoriaDTO(catobj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

}
