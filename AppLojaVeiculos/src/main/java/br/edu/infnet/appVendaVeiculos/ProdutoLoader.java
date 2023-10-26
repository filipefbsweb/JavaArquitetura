package br.edu.infnet.appVendaVeiculos;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appVendaVeiculos.domain.Produto;
import br.edu.infnet.appVendaVeiculos.service.ProdutoService;

@Order(2)
@Component
public class ProdutoLoader implements ApplicationRunner {

	@Autowired
	private ProdutoService produtoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("files/produtos.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();

		String[] campos = null;

		while (linha != null) {
			campos = linha.split(";");

			Produto produto = new Produto();

			switch (campos[7]) {
			case "C":
				produto.setNome(campos[0]);
				produto.setCodigo(Integer.valueOf(campos[1]));
				produto.setPreco(Float.valueOf(campos[2]));
				produto.setEstoque(Boolean.valueOf(campos[3]));
				produto.setCor(campos[4]);

				produtoService.incluir(produto);
				break;

			case "M":
				produto.setNome(campos[0]);
				produto.setCodigo(Integer.parseInt(campos[1]));
				produto.setPreco(Float.parseFloat(campos[2]));
				produto.setEstoque(Boolean.parseBoolean(campos[3]));
				produto.setCor(campos[4]);

				produtoService.incluir(produto);
				break;

			default:
				break;
			}

			produtoService.incluir(produto);

			linha = leitura.readLine();

		}

		for (Produto produto : produtoService.obterLista()) {
			System.out.println("[Produto] " + produto);
		}

		leitura.close();

	}
}
