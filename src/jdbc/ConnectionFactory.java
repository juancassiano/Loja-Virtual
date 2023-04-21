package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ConnectionFactory {
	public DataSource datasource;
	
	
	public Connection criarConexao(){
		Connection connection;
		try {
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
							"root", "111093");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return connection;
	}

}
