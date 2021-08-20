package pt.amane.library.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pt.amane.library.domain.Categoria;
import pt.amane.library.dtos.CategoriaDTO;
import pt.amane.library.service.CategoriaService;

@CrossOrigin("*") // ajuda comunicar com a porta diferente Ex: localhost:4200 que é a porta do angular..
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

	@PostMapping
	public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria categoria) {
		categoria = cs.create(categoria);
		URI url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(categoria.getId())
				.toUri();
		return ResponseEntity.created(url).body(categoria);
	}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Long id, @Valid @RequestBody CategoriaDTO objDto){
		Categoria categoria = cs.update(id, objDto);
		return ResponseEntity.ok().body(new CategoriaDTO(categoria));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		cs.delete(id);
		return ResponseEntity.noContent().build();
	}

}
