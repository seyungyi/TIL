package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VisitorList3 {
	public static void main(String[] args) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver"); 		
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			String sql = "select name, writedate, memo from visitor"; 
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
				"jdbctest","jdbctest");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {

			while (rs.next()) {
				System.out.print(rs.getString("name"));
				System.out.print(rs.getString("writedate"));
				System.out.println(rs.getString("memo"));
			}
		} catch (Exception e) {
			System.err.println("오류 발생 : " + e.toString());
		}
	}
}
