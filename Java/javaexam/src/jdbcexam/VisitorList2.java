package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VisitorList2 {
	public static void main(String[] args) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 오라클 연동시 jdbc영역에 올리는 명령
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
					"jdbctest","jdbctest"); // JDBC Oracle 접속정보, DriverManager은 접속관리(=도우미)
									// @IP주소:포트번호:Oracle버전 형식으로 설정(오타주의)

			stmt = conn.createStatement(); // Statement는 인터페이스, create는 객체생성을 대신해주는 메소드
			String sql = "select name, writedate, memo from visitor"; // 자바소스에서 sql문장에 세미콜론을 붙이면 안된다
			rs = stmt.executeQuery(sql); // sql문 실행시 사용(단, select문의 경우만)
			while (rs.next()) {
				System.out.print(rs.getString("name"));
				System.out.print(rs.getString("writedate"));
				System.out.println(rs.getString("memo"));
			}
		} catch (Exception e) {
			System.err.println("오류 발생 : " + e.toString()); // toString은 예외와 메시지 전부
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
