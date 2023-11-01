package br.edu.infnet.appVendaVeiculos;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appVendaVeiculos.domain.Carro;
import br.edu.infnet.appVendaVeiculos.domain.Moto;
import br.edu.infnet.appVendaVeiculos.domain.Produto;
import br.edu.infnet.appVendaVeiculos.domain.Vendedor;
import br.edu.infnet.appVendaVeiculos.service.ProdutoService;
import br.edu.infnet.appVendaVeiculos.service.VendedorService;

@Order(2)
@Component
public class ProdutoLoader implements ApplicationRunner {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private VendedorService vendedorService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("files/produtos.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();

		String[] campos = null;
		
		Vendedor vendedor = new Vendedor();


		while (linha != null) {
			campos = linha.split(";");

			switch (campos[7]) {
			case "C":
				Carro carro = new Carro();
				carro.setNome(campos[0]);
				carro.setCodigo(Integer.valueOf(campos[1]));
				carro.setPreco(Float.valueOf(campos[2]));
				carro.setEstoque(Boolean.valueOf(campos[3]));
				carro.setCor(campos[4]);
				carro.setCavalosPotencia(Integer.valueOf(campos[5]));
				carro.setTipoCarro(campos[6]);

				vendedor.setId(Integer.valueOf(campos[8]));

				carro.setVendedor(vendedor);

				produtoService.incluir(carro);
				break;

			case "M":
				Moto moto = new Moto();
				moto.setNome(campos[0]);
				moto.setCodigo(Integer.valueOf(campos[1]));
				moto.setPreco(Float.valueOf(campos[2]));
				moto.setEstoque(Boolean.valueOf(campos[3]));
				moto.setCor(campos[4]);
				moto.setIncluiCapacete(Boolean.valueOf(campos[5]));
				moto.setPotenciaCilindradas(Integer.valueOf(campos[6]));
				
				vendedor.setId(Integer.valueOf(campos[8]));

				moto.setVendedor(vendedor);

				produtoService.incluir(moto);
				break;

			default:
				break;
			}

			linha = leitura.readLine();

		}

		for(Vendedor v : vendedorService.obterLista()) {
			for(Produto produto : produtoService.obterLista(v) ) {
				System.out.println("[Produto] " + produto);				
			}			
		}
		leitura.close();

	}
}
