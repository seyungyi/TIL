package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	public void connectOracle1() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
		System.out.println("Oracle 서버 접속 : " + conn);
	}
}
