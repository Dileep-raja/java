package com.cc.context;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionThreadLocalContext {
	private static ConnectionThreadLocalContext instance;
	private ThreadLocal<Connection> connectionsThreadLocal;

	private String driverClass, url, username, password;

	private ConnectionThreadLocalContext() {
		Properties props = new Properties();

		connectionsThreadLocal = new ThreadLocal<Connection>();
		try {
			props.load(this.getClass().getClassLoader()
					.getResourceAsStream("db.properties"));

			driverClass = props.getProperty("db.driverClass");
			url = props.getProperty("db.url");
			username = props.getProperty("db.username");
			password = props.getProperty("db.password");

		} catch (IOException e) {
			driverClass = "oracle.jdbc.driver.OracleDriver";
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			username = "Hib_user";
			password = "decipher";
		}

	}

	public static synchronized ConnectionThreadLocalContext getInstance() {

		if (instance == null) {
			instance = new ConnectionThreadLocalContext();
		}

		return instance;
	}

	public Connection getConnection() {
		Connection con = null;

		if (connectionsThreadLocal.get() == null) {

			try {
				Class.forName(driverClass);
				con = DriverManager.getConnection(url, username, password);
				con.setAutoCommit(false);
				connectionsThreadLocal.set(con);
			} catch (SQLException | ClassNotFoundException e) {
				System.out.println("Connection Creation Failed.....");
			}

		}
		return connectionsThreadLocal.get();
	}

	public void closeConnection(){
		Connection con = null;

		if (connectionsThreadLocal.get() != null) {
			con = connectionsThreadLocal.get();
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Connection Closure Failed.....");
			}

		}
		connectionsThreadLocal.set(null);
	}
}
