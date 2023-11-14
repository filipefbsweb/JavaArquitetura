package br.edu.infnet.appVendaVeiculos.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TMoto")
public class Moto extends Produto {
	@NotNull
	private boolean incluiCapacete;

	@NotNull
	private int potenciaCilindradas;
	
	@Override
	public String toString() {
		return String.format("%s - %s - %d", super.toString(), incluiCapacete, potenciaCilindradas);
	}
	
	public boolean isIncluiCapacete() {
		return incluiCapacete;
	}
	public void setIncluiCapacete(boolean incluiCapacete) {
		this.incluiCapacete = incluiCapacete;
	}
	public int getPotenciaCilindradas() {
		return potenciaCilindradas;
	}
	public void setPotenciaCilindradas(int cilindradasPotencia) {
		this.potenciaCilindradas = cilindradasPotencia;
	}
	
	
}
