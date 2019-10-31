package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class SelectEmp {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE"
				, "scott", "tiger");
		Statement stmt = conn.createStatement();
		String sql = "select ename, to_char(sal, '999,999') as sal"
				+ ", to_char(hiredate, 'yyyy\"년\" mm\"월\" dd\"일\"') as hiredate from emp";
		// 단, 이렇게 되면 한개의 값은 버리게되어 효율이 떨어질수 있다.
		ResultSet rs = stmt.executeQuery(sql);
		// 하나의 Statement 객체에서는 하나의 ResultSet만 받는다. 2개이상이 될경우 이전의 ResultSet은 사라짐
		Random rd = new Random();
		boolean bl = rd.nextBoolean();
		if(bl) {
			while(rs.next()) {
				System.out.printf("%s 직원의 월급은%s원입니다.\n", rs.getString("ename"), rs.getString("sal"));
			}
		} else {
			while(rs.next()) {
				System.out.printf("%s 직원은 %s에 입사하였습니다.\n", rs.getString("ename"), 
						rs.getString("hiredate"));		
			}
		}		
		rs.close();
		stmt.close();
		conn.close();
	}
}
