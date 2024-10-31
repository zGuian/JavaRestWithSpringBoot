package com.estudos.JavaRestWithSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@SpringBootApplication
public class JavaRestWithSpringBootApplication {

	public static void main(String[] args) {
//			String url = "jdbc:postgresql://localhost:25433/JavaSpringRest";
//			String usuario = "postgres";
//			String senha = "postgres";
//			try {
//				Connection conexao = DriverManager.getConnection(url, usuario, senha);
//				System.out.println("Conexão estabelecida com sucesso!");
//				conexao.close();
//			} catch (SQLException e) {
//				System.out.println("Erro ao estabelecer conexão: " + e.getMessage());
//				System.exit(1);
//			}
		SpringApplication.run(JavaRestWithSpringBootApplication.class, args);
	}
}
