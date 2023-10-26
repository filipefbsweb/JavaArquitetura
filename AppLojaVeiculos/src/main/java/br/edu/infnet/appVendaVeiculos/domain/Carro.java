package br.edu.infnet.appVendaVeiculos.domain;

public class Carro extends Produto {
	private int cavalosPotencia;
	private String tipoCarro;
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s", super.toString(), cavalosPotencia, tipoCarro);
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