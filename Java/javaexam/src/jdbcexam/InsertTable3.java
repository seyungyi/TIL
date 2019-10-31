package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTable3 {
	public static void main(String[] args) throws Exception {
		try {
			//JDBC 드라이버를 로드한다
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//데이터 베이스에 접속한다. 적절한 JDBC URL 설정한다
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest", "jdbctest");
			PreparedStatement pstmt = conn.prepareStatement(
					"insert into product values (?,?,?,?,?)");
			pstmt.setString(1, args[0]);
			pstmt.setString(2, args[1]);
			pstmt.setString(3, args[2]);
			pstmt.setInt(4, Integer.parseInt(args[3]));
			pstmt.setFloat(5, Float.parseFloat(args[4]));
			pstmt.executeUpdate();
			System.out.println("데이터들을 추가하였습니다.");
			pstmt.close();
			conn.close();
		} catch(SQLException e) {
			System.out.println("오류 발생 : " + e);
		}
	}
}
