package br.com.projetos.aplicacao;

import java.io.IOException;

public class AppTestes {

	public static void main(String[] args) {
		
		String tmp = "B";
		
		
		switch (tmp) {
			case "A": System.out.println("letra A"); break;
			case "B": System.out.println("letra B"); break;
			case "C": System.out.println("letra C"); break;
		
		}
		
		
		
		try {
			ManipuladorProperties.exibeValores();
			ManipuladorProperties.testarParametroOpcional(null);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
