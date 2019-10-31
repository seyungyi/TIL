package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchEmp {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
				"scott", "tiger");
		PreparedStatement pstmt = conn.prepareStatement("select upper(ename) ename, "
				+ "to_char(hiredate, 'yyyy\"년\" mm\"월\"') hiredate, deptno from emp where deptno=?");
		Scanner scn = new Scanner(System.in);
		boolean bl = true;
		while(bl) {
			System.out.print("검색할 직원의 부서번호를 입력하시오 : ");
			String deptno = scn.next();
			pstmt.setString(1, deptno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
				System.out.println(rs.getString("ename") + " 직원은 근무중입니다.");
				System.out.println(rs.getString("hiredate") + "에 입사했고 현재 " + rs.getString("deptno") + "부서에서 근무하고 있습니다.");
				} while(rs.next());
			}
			else {
				System.out.println(deptno + "직원은 근무하지 않습니다.");
			}
			System.out.print("계속(1) | 종료(1빼고) : ");
			int n = scn.nextInt();
			if(n != 1)
				bl = false;
			System.out.println("검색 끝");
		}
		scn.close();
		pstmt.close();
		conn.close();
	}
}
