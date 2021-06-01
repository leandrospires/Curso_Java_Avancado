package br.com.gestaopagamentos.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.gestaopagamentos.dao.PagamentosDao;
import br.com.gestaopagamentos.models.Pagamento;

@Controller
@Transactional
@RequestMapping("/api")
public class PagamentosController {
	
	@Autowired
	private PagamentosDao pagamentosDao;
	
	// CrossOrigin = utilizado para acesso externo
	@CrossOrigin
	@RequestMapping("/pagamentos")
	@ResponseBody
	public List<Pagamento> listar(){
		return pagamentosDao.list();
	}
	
	@CrossOrigin
	@RequestMapping(
			value = "/pagamentos",
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "application/json")
	@ResponseBody
	public Pagamento incluir(@RequestBody Pagamento pagamento) {
		try {
			
			pagamentosDao.save(pagamento);
			
			return pagamento;
			
		} catch (Exception e) {
			return new Pagamento();
		}
	}
	
	@CrossOrigin
	@RequestMapping(
			value = "/pagamentos/status",
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "application/json")
	@ResponseBody
	public int statusPagamento(@RequestBody Pagamento pagamento) {
		
		pagamento = pagamentosDao.get(pagamento.getNumeropedido());
		
		return pagamento.getStatus();
	}
	
	@CrossOrigin
	@RequestMapping(
		value = "/verificar/{pedido}",
		method=RequestMethod.GET,
		produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, String> verificar(@PathVariable("pedido") String pedido) {

		Map<String, String> map = new LinkedHashMap<>();
		
		try {
			if(pagamentosDao.getByOrder(pedido) != null) {
				map.put("response", "pago");
			} else {
				map.put("response", "pendente");
			}
		} catch (Exception e) {
			map.put("response", e.getMessage());
		}
		return map;
	}	
}
