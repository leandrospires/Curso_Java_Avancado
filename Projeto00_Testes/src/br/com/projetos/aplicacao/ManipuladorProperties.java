package br.com.projetos.aplicacao;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ManipuladorProperties {

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				"resource/mensagemBr.properties");
		props.load(file);
		return props;

	}

	public static void exibeValores() throws IOException {
		String tc; //Variavel que guardará o login do servidor.
		String tn; //Variavel que guardará o host do servidor.
		System.out.println("************Teste de leitura do arquivo de propriedades************");

		Properties prop = getProp();

		tc = prop.getProperty("tela.cadastro.cliente");
		tn = prop.getProperty("tela.nome");

		System.out.println("tc = " + tc);
		System.out.println("tn = " + tn);		
	}
	

}