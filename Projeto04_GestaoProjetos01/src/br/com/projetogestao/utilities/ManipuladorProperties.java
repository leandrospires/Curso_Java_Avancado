package br.com.projetogestao.utilities;

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

}
