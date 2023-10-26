package br.edu.infnet.appVendaVeiculos;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appVendaVeiculos.domain.Carro;
import br.edu.infnet.appVendaVeiculos.service.CarroService;

@Order(4)
@Component
public class CarroLoader implements ApplicationRunner {
	
	@Autowired
	private CarroService carroService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/carros.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while (linha != null)
		{
			campos = linha.split(";");
			
			Carro carro = new Carro();
			
			carro.setNome(campos[0]);
			carro.setCodigo(Integer.valueOf(campos[1]));
			carro.setPreco(Float.valueOf(campos[2]));
			carro.setEstoque(Boolean.valueOf(campos[3]));
			carro.setCor(campos[4]);
			carro.setCavalosPotencia(Integer.valueOf(campos[5]));
			carro.setTipoCarro(campos[6]);
			
			carroService.incluir(carro);
			
			linha = leitura.readLine();
			
		}
		
		for (Carro carro: carroService.obterLista()) {
			System.out.println("[Carro] " + carro);
		}
		
		leitura.close();
		
	}
}
