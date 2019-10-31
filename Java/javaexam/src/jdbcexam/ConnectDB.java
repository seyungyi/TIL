package jdbcexam;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class ConnectDB {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 오라클 연동시 jdbc영역에 올리는 명령
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
				"jdbctest", "jdbctest"); // JDBC Oracle 접속정보, DriverManager은 접속관리(=도우미)
										// @IP주소:포트번호:Oracle버전  형식으로 설정(오타주의)
		System.out.println(conn.getClass().getName());
		DatabaseMetaData mdata = conn.getMetaData();
		System.out.println(mdata.getClass().getName());
		System.out.println("접속된 DB 서버 : " + mdata.getDatabaseProductName());
		conn.close();
	}
}
