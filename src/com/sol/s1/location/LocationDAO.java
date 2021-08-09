package com.sol.s1.location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationDAO {
	
	public void getOne(int location_id) {
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, location_id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				System.out.println(rs.getString("STREET_ADDRESS"));
			} else {
				System.out.println("LOCATION_ID가 없습니다");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void getList() {
		// LOCATIONS Table을 조회해서 출력
		// 1. 접속 정보
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			// 2. 드라이버 로딩
			Class.forName(driver);
			
			// 3. 접속
			con = DriverManager.getConnection(url, user, password);
			
			// 4. SQL문 생성
			String sql = "SELECT * FROM LOCATIONS";
			
			// 5. SQL문 미리 보내기
			st = con.prepareStatement(sql);
			
			// 7. 최종 전송 후 결과 처리
			rs = st.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getInt("LOCATION_ID")+"\t");
				System.out.print(rs.getString("STREET_ADDRESS")+"\t");
				System.out.print(rs.getString("POSTAL_CODE")+"\t");				
				System.out.print(rs.getString("CITY")+"\t");
				System.out.print(rs.getString("STATE_PROVINCE")+"\t");
				System.out.println(rs.getString("COUNTRY_ID")+"\t");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
