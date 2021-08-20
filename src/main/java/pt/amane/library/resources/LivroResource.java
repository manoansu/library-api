package pt.amane.library.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.amane.library.domain.Categoria;
import pt.amane.library.domain.Livro;
import pt.amane.library.dtos.LivroDTO;
import pt.amane.library.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	
	@Autowired
	private LivroService ls;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Long id){
		Livro catId = ls.findById(id);
		return ResponseEntity.ok().body(catId);
	}
	
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(){
		List<Livro> lista = ls.findAll();
		List<LivroDTO> listDTOs = lista.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTOs);
	}
	
	
	
	
	
//	@PostMapping(value = "/{id}")
//	public ResponseEntity<LivroDTO> update(@PathVariable Long id, @RequestBody Livro livro){
//		findById(id);
//		
//		Livro objLivro = new Livro();
//		objLivro.setAutor(livro.getAutor());
//		objLivro.setTexto(livro.getTexto());
//		objLivro.setTitulo(livro.getTitulo());
//		
//		LivroDTO objDTO = new LivroDTO(objLivro);
//				//ls.update(livro);
//		
//		
//	}
}
