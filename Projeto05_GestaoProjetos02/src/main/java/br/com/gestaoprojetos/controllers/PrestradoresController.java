package br.com.gestaoprojetos.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gestaoprojetos.dao.GenericDao;
import br.com.gestaoprojetos.entities.Prestador;

@Controller
public class PrestradoresController {

	@RequestMapping("/prestadores/lista")
	public String listarPrestradores(ModelMap model) {
		try {
			GenericDao<Prestador> dao = new GenericDao<>(Prestador.class);
			List<Prestador> prestador = dao.listar();
			model.addAttribute("listaPrestadores", prestador);
			
			return "listas/listaPrestadores";
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return  "erro";
		}
	}	
	
}
