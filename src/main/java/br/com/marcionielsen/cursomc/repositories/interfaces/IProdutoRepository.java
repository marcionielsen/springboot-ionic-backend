package br.com.marcionielsen.cursomc.repositories.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.marcionielsen.cursomc.domain.Categoria;
import br.com.marcionielsen.cursomc.domain.Produto;

@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Long> {
	
// Caso seja usado a Annotation @Query, ela terá precedência sobre o nome do método
//	
//	@Query("SELECT DISTINCT produtos FROM Produto produtos INNER JOIN produtos.categorias cat WHERE produtos.descricao LIKE %:nomeProduto% AND cat IN :listaCategorias")
//	Page<Produto> search(@Param("nomeProduto") String nomeProduto,@Param("listaCategorias") List<Categoria> listaCategorias, Pageable pageRequest);
	
	@Transactional(readOnly = true)
	Page<Produto> findProdutoDistinctByDescricaoContainingAndCategoriasIn(String nomeProduto, List<Categoria> listaCategorias, Pageable pageRequest);
}
