package br.edu.infnet.appVendaVeiculos.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appVendaVeiculos.domain.Produto;


@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

	@Query("from Produto p where p.vendedor.id = :vendedorId")
	Collection<Produto> obterLista(Integer vendedorId);	
}