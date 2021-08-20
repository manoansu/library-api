package pt.amane.library.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pt.amane.library.domain.Livro;
import pt.amane.library.dtos.LivroDTO;
import pt.amane.library.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService ls;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Long id) {
		Livro catId = ls.findById(id);
		return ResponseEntity.ok().body(catId);
	}

	// http://localhost:8080/livros?categoria=1
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Long id_car) {
		List<Livro> lista = ls.findAll(id_car);
		List<LivroDTO> listDTOs = lista.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTOs);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livro) {
		Livro newLivro = ls.update(id, livro);
		return ResponseEntity.ok().body(newLivro);
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<Livro> updatePatch(@PathVariable Long id, @RequestBody Livro livro) {
		Livro newLivro = ls.update(id, livro);
		return ResponseEntity.ok().body(newLivro);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		ls.delete(id);
		return ResponseEntity.noContent().build();

	}

	// http://localhost:8080/livros?categoria=1
	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Long id_cat,
			@RequestBody Livro livro) {
		Livro newLivro = ls.create(id_cat, livro);
		URI url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/id")
				.buildAndExpand(newLivro.getId()).toUri();
		return ResponseEntity.created(url).body(newLivro);
	}

}
