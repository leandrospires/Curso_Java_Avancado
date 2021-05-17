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
import br.com.gestaoprojetos.entities.Pagamento;
import br.com.gestaoprojetos.entities.Prestador;
import br.com.gestaoprojetos.enumerations.Tipo;

@Controller
public class PagamentosController {

	@RequestMapping("/pagamento/cadastro")
	public String incluir(ModelMap model) {
		try {
			GenericDao<Prestador> dao = new GenericDao<>(Prestador.class);
			List<Prestador> prestador = dao.listar();
			model.addAttribute("listaPrestadores", prestador);
			
			return "forms/cadastroPagamento";
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return  "erro";
		}
	}
	

	@RequestMapping(value= "/cadpagamento", method = RequestMethod.POST)
	public String incluir(	@RequestParam("doc") String doc, 
							@RequestParam("tipo_p") String tipo,
							Pagamento pagamento, 
							ModelMap model) {
		
		try {
			GenericDao<Prestador> dao_pr = new GenericDao<>(Prestador.class);
			Prestador prestador = dao_pr.buscar(doc);
			pagamento.setPrestador(prestador);
			
			// Operador Ternário
			pagamento.setTipo( tipo.equals("Projeto") ? Tipo.PROJETO : Tipo.HORA );
			
			GenericDao<Pagamento> dao_pg = new GenericDao<>(Pagamento.class);
			dao_pg.adicionar(pagamento);
			
		
			//return "menu";
			//return incluir(model);
			//return "redirect:/pagamento/cadastro";
			
			return "redirect:/pagamento/lista/" + doc;
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return  "erro";			
		}
		
		
	}
	
	@RequestMapping("/pagamento/lista/{doc}")
	public String listar(@PathVariable("doc") String documento,
						ModelMap model) {
		try {
			List<Pagamento> listaPagamento = new MetodosDao().listarPagamentosPorPrestador(documento);
			
			Prestador pre = new GenericDao<Prestador>(Prestador.class).buscar(documento);
			
			model.addAttribute("nomePrestador", pre.getNome());
			model.addAttribute("listaPagamento", listaPagamento);
			
			return "listas/listaPagamento";
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return  "erro";				
		}
	}
	
}
