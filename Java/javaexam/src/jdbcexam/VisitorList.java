package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VisitorList {
	public static void main(String[] args) throws Exception {		
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 오라클 연동시 jdbc영역에 올리는 명령
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
				"jdbctest", "jdbctest"); // JDBC Oracle 접속정보, DriverManager은 접속관리(=도우미)
										// @IP주소:포트번호:Oracle버전  형식으로 설정(오타주의)
		
		Statement stmt = conn.createStatement(); // Statement는 인터페이스, create는 객체생성을 대신해주는 메소드
		String sql = "select name, writedate, memo from visitor"; // 자바소스에서 sql문장에 세미콜론을 붙이면 안된다
		ResultSet rs = stmt.executeQuery(sql); // sql문 실행시 사용(단, select문의 경우만)
		System.out.println(conn.getClass().getName());
		System.out.println(stmt.getClass().getName());
		System.out.println(rs.getClass().getName());
		while(rs.next()) {
			System.out.print(rs.getString("name"));
			System.out.print(rs.getString("writedate"));
			System.out.println(rs.getString("memo"));
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}
