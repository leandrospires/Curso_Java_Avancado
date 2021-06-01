package br.com.gestaovendas.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.gestaovendas.models.User;
import br.com.gestaovendas.security.dao.UsersDao;

@Controller
@Transactional
@RequestMapping("/users")
public class UsersControllers {
	
	@Autowired
	UsersDao usersDao;
	
	@RequestMapping("/cadastro")
	public String incluir() {
		return "users/incluirUsuario";
	}
	
	@RequestMapping(value="/cadusuario", method=RequestMethod.POST)
	public String incluir(User usuario, Model model) {
		try {
			String senha = usuario.getPassword();
			String crypto = new BCryptPasswordEncoder().encode(senha);
			usuario.setPassword(crypto);
			usuario.setEnabled(true);
			
			usersDao.save(usuario);
			
			model.addAttribute("mensagem", "Usuario incluído com sucesso");
			return "users/incluirUsuario";
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}
	
	@RequestMapping("/login")
	public String login() {
		return "users/loginUsuario";
	}
}





