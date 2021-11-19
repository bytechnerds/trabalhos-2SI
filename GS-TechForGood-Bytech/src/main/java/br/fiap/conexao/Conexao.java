package br.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
	private volatile static Connection connection;
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private static String user = "rm86065";
	private static String password = "220897";

	// construtor privado (n�o permite instancia��o externa)
	private Conexao() {
	}

	// m�todo para conectar e retornar a conex�o
	public static Connection conectar() {
		if (connection == null) {
			synchronized (Conexao.class) {
				if (connection == null) {			
					try {
						Class.forName(driver);
						connection = DriverManager.getConnection(url, user, password);
					} catch (final ClassNotFoundException | SQLException e) {
						System.out.println(e);
					}
				}
			}
		}

		return connection;
	}
}
