package br.com.gestaovendas.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.gestaovendas.dao.ItensDao;
import br.com.gestaovendas.dao.PedidosDao;
import br.com.gestaovendas.dao.ProdutosDao;
import br.com.gestaovendas.models.Item;
import br.com.gestaovendas.models.Produto;
import br.com.gestaovendas.viewmodels.ClientePedidosVM;
import br.com.gestaovendas.viewmodels.ProdutosItensVM;

@Controller
public class ItensController {

	@Autowired
	private PedidosDao pedidosDao;
	
	@Autowired
	private ProdutosDao produtosDao;
	
	@Autowired
	private ItensDao itensDao;
	
	@GetMapping("/itens/remocao/")
	public String excluir( 	@RequestParam("id") int id,
							@RequestParam("idPedido") int idPedido,
							Model model) {
		try {
			pedidosDao.remover(id);

			return "redirect:/itens/gestao?idpedido=" + idPedido;			
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";						
		}
	}
	
	
	@GetMapping("/itens/gestao")
	public String incluir(	@RequestParam("idpedido") int idPedido,
							Model model) {
		try {
			ClientePedidosVM pedidosVM = pedidosDao.buscarPedido(idPedido);
			model.addAttribute("pedidosVM", pedidosVM);
			
			Collection<Produto> produtos = produtosDao.listar();
			model.addAttribute("produtos", produtos);
			
			Collection<ProdutosItensVM> produtosItensVM = pedidosDao.buscarItensPorPedido(idPedido);
			model.addAttribute("produtosItensVM", produtosItensVM);
			
			double valorTotalPedido = pedidosDao.retornarValorTotalPorPredido(idPedido);
			model.addAttribute("valorTotalPedido", valorTotalPedido);
			
			
			
			return "itens/cadastroItens";
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";						
		}
		
	}
	
	@PostMapping("/caditem")
	public String incluir(Item item, Model model) {
		try {
			
			itensDao.incluir(item);
		
			return "redirect:/itens/gestao?idpedido=" + item.getIdPedido();
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
		
	}
}
