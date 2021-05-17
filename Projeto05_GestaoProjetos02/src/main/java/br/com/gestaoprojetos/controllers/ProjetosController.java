package br.com.gestaoprojetos.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.gestaoprojetos.dao.GenericDao;
import br.com.gestaoprojetos.dao.MetodosDao;
import br.com.gestaoprojetos.entities.Cliente;
import br.com.gestaoprojetos.entities.Projeto;

@Controller
public class ProjetosController {
	
	@RequestMapping("/projetos/cadastro")
	public String incluir(ModelMap model) {
		try {
			GenericDao<Cliente> dao = new GenericDao<>(Cliente.class);
			List<Cliente> clientes = dao.listar();
			model.addAttribute("listaClientes", clientes);
			
			return "forms/cadastroProjeto";
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return  "erro";
		}
	}
	
	@RequestMapping(value= "/cadprojeto", method = RequestMethod.POST)
	public String incluir(@RequestParam("idcliente") int idc, 
						  Projeto projeto, 
						  ModelMap model) {
		
		try {
			GenericDao<Cliente> dao_c = new GenericDao<>(Cliente.class);
			Cliente cliente = dao_c.buscar(idc);
			projeto.setCliente(cliente);
			
			GenericDao<Projeto> dao_p = new GenericDao<>(Projeto.class);
			dao_p.adicionar(projeto);
			
		
			//return "menu";
			//return incluir(model);
			//return "redirect:/projetos/cadastro";
			
			return "redirect:/projetos/lista/" + idc;
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return  "erro";			
		}
		
		
	}
	
	@RequestMapping("/projetos/lista/{id}")
	public String listar(@PathVariable("id") int idCliente,
						ModelMap model) {
		try {
			List<Projeto> listaProjetos = new MetodosDao().listarProjetosPorCliente(idCliente);
			
			Cliente cli = new GenericDao<Cliente>(Cliente.class).buscar(idCliente);
			
			model.addAttribute("nomeCliente", cli.getNome());
			model.addAttribute("listaProjetos", listaProjetos);
			
			return "listas/listaProjetos";
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return  "erro";				
		}
	}
	

}
