package jdbcexam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Prob {	 
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
                  Class.forName("oracle.jdbc.driver.OracleDriver");		
     	          kaja("E");	  
	}
	
	public static void kaja(String fn)  {
		//여기에 구현하시오
		String sql = "select first_name, last_name, to_char(salary, '99,999') salary from employees where first_name like ?";
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, fn.toUpperCase()+"%");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					System.out.println(rs.getString("first_name")
							+ "(" + rs.getString("last_name") + ")" + rs.getString("salary") + "원");
				} while(rs.next());
			}
		} catch(SQLException e) {
			System.out.println("DB연동 오류 발생 : " + e.getMessage());
		}
	}
}