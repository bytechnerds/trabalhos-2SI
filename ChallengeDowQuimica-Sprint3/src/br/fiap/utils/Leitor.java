package br.fiap.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Leitor {

	public static Properties getProp() {
		Properties props = new Properties();

		try {
			FileInputStream file = new FileInputStream("./src/dados.properties");
			props.load(file);
		} catch (IOException e) {
			System.out.println(e);
		}
		return props;
	}

}
