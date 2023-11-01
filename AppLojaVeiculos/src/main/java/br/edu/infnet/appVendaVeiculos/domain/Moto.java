package br.edu.infnet.appVendaVeiculos.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TMoto")
public class Moto extends Produto {
	private boolean incluiCapacete;
	private int potenciaCilindradas;
	
	@Override
	public String toString() {
		return String.format("%s - %s", super.toString(), incluiCapacete);
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
