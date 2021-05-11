package br.com.gestaoprojetos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	// Nos Controller, os m�todos s�o chamados de Actions
	
	// "/" definindo a p�gina inicial
	//@RequestMapping(value="/", method = RequestMethod.GET)
	
	@RequestMapping("/")
	public String iniciar() {
		
		return "menu"; // /WEB-INF/views/menu.jsp : prefixo e sufixo, seguindo o arquivo spring_mvc.xml
		
	}
}
