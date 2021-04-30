package br.com.projetogestao.utilities;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.projetogestao.enumerations.Niveis;
import br.com.projetogestao.models.Usuario;
import br.com.projetogestao.repository.Repositorio;

public final class Utils {
	
	public static String verificarMD5(String texto) {		
		try {
	       MessageDigest m = MessageDigest.getInstance("MD5");
	       m.update(texto.getBytes(),0,texto.length());	       
	       return new BigInteger(1,m.digest()).toString(16);
		}catch(Exception e) {
			return null;
		}
	}	
	
	public static Niveis buscarNivel (String nivel) {

		Niveis n = null;
		
		switch(nivel) {
		case "ADM":
			n = Niveis.ADM; break;
		case "CLIENTE":
			n = Niveis.CLIENTE; break;
		case "PREST":
			n = Niveis.PREST; break;
		}
		
		return n;
	}
	
	public static Collection<Usuario> listarUsuariosPorNivel (Niveis n) throws Exception {

		// Utilizando lambda [->] - somente a partir do JAVA 8
		
		Collection<Usuario> listaUsuarios = 
				Repositorio.getUsuariosDao().listar()
				.stream()
				.filter(p -> p.getNivel() == n).collect(Collectors.toList());
		
		return listaUsuarios;
		
	}
	
	public static boolean possuiValor(final Object valor) {

        boolean possuiValor = false;
        if (valor != null) {
            if (valor instanceof String || valor instanceof Character) {
                possuiValor = !valor.toString().trim().equals("");
            } else if (valor instanceof Collection<?>) {
                possuiValor = !((Collection<?>) valor).isEmpty();
            } else if (valor instanceof Map<?, ?>) {
                possuiValor = !((Map<?, ?>) valor).isEmpty();

            } else if (valor instanceof Object[]) {
                possuiValor = ((Object[]) valor).length > 0;
            } else {
                possuiValor = true;
            }
        }
        return possuiValor;
    }	

}
