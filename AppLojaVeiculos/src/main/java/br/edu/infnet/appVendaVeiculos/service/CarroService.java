package br.edu.infnet.appVendaVeiculos.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appVendaVeiculos.domain.Carro;

@Service
public class CarroService {
	private Map<Integer, Carro> mapaCarro = new HashMap<Integer, Carro>();

	public void incluir(Carro carro) {
		mapaCarro.put(carro.getCodigo(), carro);
	}

	public Collection<Carro> obterLista() {
		return mapaCarro.values();
	}
}
