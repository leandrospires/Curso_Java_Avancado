package br.com.gestaoprojetos.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gestaoprojetos.dao.GenericDao;
import br.com.gestaoprojetos.dao.MetodosDao;
import br.com.gestaoprojetos.entities.Cliente;
import br.com.gestaoprojetos.viewmodels.ClientesProjetosVM;

@Controller
public class ClientesControler {
	
	@RequestMapping("/clientes/lista")
	public String listarClientes(ModelMap model) {
		try {
			GenericDao<Cliente> dao = new GenericDao<>(Cliente.class);
			List<Cliente> clientes = dao.listar();
			model.addAttribute("listaClientes", clientes);
			
			return "listas/listaClientes";
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return  "erro";
		}
	}
	
	@RequestMapping("/clientes/listaProjetos")
	public ModelAndView listarProjetosPorCliente(Model model) {
		try {
			List<ClientesProjetosVM> cli = new MetodosDao().listarQuantProjetos();
			model.addAttribute("listaQuantClientes", cli);
			return new ModelAndView("listas/listaQuantProjetos");
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return new ModelAndView("erro");
		}
		
	}
}
