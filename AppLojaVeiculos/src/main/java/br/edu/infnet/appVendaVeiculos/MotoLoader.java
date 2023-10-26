package br.edu.infnet.appVendaVeiculos;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appVendaVeiculos.domain.Moto;
import br.edu.infnet.appVendaVeiculos.service.MotoService;

@Order(3)
@Component
public class MotoLoader implements ApplicationRunner {
	
	@Autowired
	private MotoService motoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/motos.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while (linha != null)
		{
			campos = linha.split(";");
			
			Moto moto = new Moto();
			
			moto.setNome(campos[0]);
			moto.setCodigo(Integer.parseInt(campos[1]));
			moto.setPreco(Float.parseFloat(campos[2]));
			moto.setEstoque(Boolean.parseBoolean(campos[3]));
			moto.setCor(campos[4]);
			moto.setIncluiCapacete(Boolean.parseBoolean(campos[5]));
			moto.setPotenciaCilindradas(Integer.parseInt(campos[6]));
			
			motoService.incluir(moto);
			
			linha = leitura.readLine();
			
		}
		
		for (Moto moto: motoService.obterLista()) {
			System.out.println("[Moto] " + moto);
		}
		
		leitura.close();
		
	}
}
