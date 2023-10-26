package br.edu.infnet.appVendaVeiculos.domain;

public class Produto {
	private String nome;
	private int codigo;
	private float preco;
	private boolean estoque;
	private String cor;
	
	@Override
	public String toString() {
		return String.format("%s - %d - %.2f - %s - %s", nome, codigo, preco, estoque, cor);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String descricao) {
		this.nome = descricao;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public boolean isEstoque() {
		return estoque;
	}
	public void setEstoque(boolean estoque) {
		this.estoque = estoque;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
}
