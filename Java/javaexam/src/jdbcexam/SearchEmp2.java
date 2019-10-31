package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchEmp2 {
	public static void main(String[] args) throws Exception {
			Class.forName("oracle.jdbc.driver.OracleDriver");		
			Scanner sc = new Scanner(System.in);
			String sql = "select ename from emp e natural join dept d where d.dname=?";
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			boolean bl = true;
			while(bl) {
				System.out.print("검색할 직원의 부서명을 입력하세요 : ");
				String dn = sc.next().toUpperCase();
				pstmt.setString(1, dn);
				ResultSet rs = pstmt.executeQuery();
				if(rs.isBeforeFirst()) {
					if(rs.getString(1) == null) {
						System.out.println(dn + "부서에서 근무하는 직원이 없습니다.");
					} else {
						System.out.println(dn + "부서에서 근무하는 직원들");
						while(rs.next()) {
							System.out.println(rs.getString(1));
						}	
					}
				}
//					System.out.println(dn + "부서에서 근무하는 직원들");
//					do {
//						System.out.println(rs.getString(1));
//					} while(rs.next());
//				} else {
//					String sql2 = "select dname from dept where dname='"+dn+"'";
//					Statement st = conn.createStatement();
//					ResultSet st1 = st.executeQuery(sql2);
//					if(st1.next()) {
//						System.out.println(dn + "부서에서 근무하는 직원이 없습니다.");
//					} else {
//						System.out.println(dn + "부서는 존재하지 않습니다.");
//				}
				else {
					System.out.println(dn + "부서는 존재하지 않습니다.");
				}
				System.out.print("계속(Y) | 종료(N) : ");
				dn = sc.next().toUpperCase();
				if(dn.equals("N")) {
					bl = false;
					System.out.println("검색 종료");
				}
			}
			sc.close();
			pstmt.close();
			conn.close();
	}
}
