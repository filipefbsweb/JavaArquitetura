package br.edu.infnet.appVendaVeiculos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appVendaVeiculos.domain.Carro;
import br.edu.infnet.appVendaVeiculos.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;

	public void incluir(Carro carro) {
		carroRepository.save(carro);
	}
	
	public Collection<Carro> obterLista(){	
		return (Collection<Carro>) carroRepository.findAll();
	}
}