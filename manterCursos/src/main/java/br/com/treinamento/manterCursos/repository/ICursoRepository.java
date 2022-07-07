package br.com.treinamento.manterCursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.treinamento.manterCursos.entities.Curso;








	@Repository
	public interface ICursoRepository extends CrudRepository<Curso,Integer>{
		@Query(value="Select * from curso where idCategoria=?1",nativeQuery= true)
		List<Curso> findByIdCategoria(Integer idCategoria);

	}




