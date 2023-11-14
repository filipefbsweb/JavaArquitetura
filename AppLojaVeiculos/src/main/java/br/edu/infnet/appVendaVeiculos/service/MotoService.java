package br.edu.infnet.appVendaVeiculos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appVendaVeiculos.domain.Moto;
import br.edu.infnet.appVendaVeiculos.repository.MotoRepository;



@Service
public class MotoService {

	@Autowired
	private MotoRepository motoRepository;
	
	public void incluir(Moto moto) {
		
		motoRepository.save(moto);
	}
	
	public Collection<Moto> obterLista(){	
		
		return (Collection<Moto>) motoRepository.findAll();
	}
	
	public Long obterQtde() {	
		
		return motoRepository.count();
	}
	
	public void excluir(Integer id) {
		
		motoRepository.deleteById(id);
	}
	
}