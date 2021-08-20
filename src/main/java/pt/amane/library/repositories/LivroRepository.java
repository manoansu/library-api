package pt.amane.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pt.amane.library.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

	@Query("SELECT obj FROM Livro obj where obj.categoria.id = :id_cat ORDER BY titulo")
	List<Livro> findAllByCategoria(@Param(value = "id_cat") Long id_cat);

}
