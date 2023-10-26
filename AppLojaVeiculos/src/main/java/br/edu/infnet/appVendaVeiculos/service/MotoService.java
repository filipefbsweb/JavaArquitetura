package br.edu.infnet.appVendaVeiculos.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appVendaVeiculos.domain.Moto;

@Service
public class MotoService {
	private Map<Integer, Moto> mapaMoto = new HashMap<Integer, Moto>();

	public void incluir(Moto moto) {
		mapaMoto.put(moto.getCodigo(), moto);
	}

	public Collection<Moto> obterLista() {
		return mapaMoto.values();
	}
}
