package br.edu.infnet.appVendaVeiculos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appVendaVeiculos.domain.Moto;

@Repository
public interface MotoRepository extends CrudRepository<Moto, Integer> {

}