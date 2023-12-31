package br.edu.infnet.appVendaVeiculos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appVendaVeiculos.domain.Produto;
import br.edu.infnet.appVendaVeiculos.domain.Vendedor;
import br.edu.infnet.appVendaVeiculos.repository.ProdutoRepository;


@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void incluir(Produto produto) {
		
		produtoRepository.save(produto);
	}
	
	public Collection<Produto> obterLista(){	
		
		return (Collection<Produto>) produtoRepository.findAll();
	}
	
	public Collection<Produto> obterLista(Vendedor vendedor){	
		
		return (Collection<Produto>) produtoRepository.obterLista(vendedor.getId());
	}
	
	public Long obterQtde() {	
		
		return produtoRepository.count();
	}
	
	public void excluir(Integer id) {
		
		produtoRepository.deleteById(id);
	}
	
}