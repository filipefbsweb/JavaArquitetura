package br.edu.infnet.appVendaVeiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appVendaVeiculos.service.CarroService;
import br.edu.infnet.appVendaVeiculos.service.MotoService;
import br.edu.infnet.appVendaVeiculos.service.ProdutoService;
import br.edu.infnet.appVendaVeiculos.service.VendedorService;



@Controller
public class AppController {
	
	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private CarroService carroService;
	@Autowired
	private MotoService motoService;

	@GetMapping(value = "/")
	public String showHome(Model model) {
		
		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		model.addAttribute("qtdeCarro", carroService.obterQtde());
		model.addAttribute("qtdeMoto", motoService.obterQtde());

		return "home";
	}
}