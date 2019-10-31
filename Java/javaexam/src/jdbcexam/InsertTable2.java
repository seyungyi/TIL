package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTable2 {
	public static void main(String[] args) throws Exception {
		try {
			//JDBC 드라이버를 로드한다
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//데이터 베이스에 접속한다. 적절한 JDBC URL 설정한다
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest", "jdbctest");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into product values"
					+ "('" + args[0] + "','" + args[1] + "', '" + args[2] + "'," + 
					args[3] + "," + args[4] + ")");
			System.out.println("데이터들을 추가하였습니다.");
			stmt.close();
			conn.close();
		} catch(SQLException e) {
			System.out.println("오류 발생 : " + e);
		}
	}
}
