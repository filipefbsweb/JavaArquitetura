package br.edu.infnet.appVendaVeiculos.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TCarro")
public class Carro extends Produto {
	@NotNull
	private int cavalosPotencia;

	@NotNull
	private String tipoCarro;

	@Override
	public String toString() {
		return String.format("%s - %d - %s", super.toString(), cavalosPotencia, tipoCarro);
	}

	public int getCavalosPotencia() {
		return cavalosPotencia;
	}

	public void setCavalosPotencia(int cavalosPotencia) {
		this.cavalosPotencia = cavalosPotencia;
	}

	public String getTipoCarro() {
		return tipoCarro;
	}

	public void setTipoCarro(String tipoCarro) {
		this.tipoCarro = tipoCarro;
	}

}
