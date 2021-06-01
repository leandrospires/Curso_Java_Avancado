package br.com.gestaovendas.security.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.gestaovendas.models.User;

@Repository
public class UsersDao implements UserDetailsService {

	@PersistenceContext
	private EntityManager em;
	
	public void save(User usuario) {
		em.persist(usuario);
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		User usuario = em.find(User.class, username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário " + username + " não encontrado");
		}
		return usuario;
	}

}