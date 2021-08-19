package pt.amane.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.amane.library.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
