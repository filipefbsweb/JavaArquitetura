package br.edu.infnet.appVendaVeiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appVendaVeiculos.service.MotoService;

@Controller
public class MotoController {

	@Autowired
	private AppController appController;
	
	@Autowired
	private MotoService motoService;


	@GetMapping(value = "/moto/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		motoService.excluir(id);
		
		return "redirect:/moto/lista";
	}
	
	@GetMapping(value = "/moto/lista")
	public String obterLista(Model model) {
		
		model.addAttribute("rota", "moto");
		model.addAttribute("titulo", "Motos:");
		model.addAttribute("listagem", motoService.obterLista());

		return appController.showHome(model);
	}
}