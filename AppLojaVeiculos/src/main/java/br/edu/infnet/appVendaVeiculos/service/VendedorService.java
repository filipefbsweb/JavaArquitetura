package br.edu.infnet.appVendaVeiculos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appVendaVeiculos.clients.IEnderecoClient;
import br.edu.infnet.appVendaVeiculos.domain.Endereco;
import br.edu.infnet.appVendaVeiculos.domain.Vendedor;
import br.edu.infnet.appVendaVeiculos.repository.VendedorRepository;


@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private IEnderecoClient enderecoClient;
	
	public Vendedor pesquisar(String cpf) {
		return vendedorRepository.findByCpf(cpf);
	}

	public void incluir(Vendedor vendedor) {
				
		Endereco endereco = enderecoClient.buscarCep(vendedor.getEndereco().getCep());
		
		vendedor.setEndereco(endereco);
		
		vendedorRepository.save(vendedor);
	}
	
	public void excluir(Integer id) {
		vendedorRepository.deleteById(id);
	}
	
	public Collection<Vendedor> obterLista(){	
		return (Collection<Vendedor>) vendedorRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	public long obterQtde() {
		return vendedorRepository.count();
	}
}