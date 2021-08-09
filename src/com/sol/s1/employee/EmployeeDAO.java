package com.sol.s1.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.ldap.StartTlsRequest;

import com.sol.s1.util.DBConnect;

public class EmployeeDAO {
	// DB 연결
	private DBConnect dbConnect;
	
	// DB 연결 생성자
	public EmployeeDAO() {
		dbConnect = new DBConnect();
	}
	
	// 전체 정보 출력
	public void getList() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = dbConnect.getConnection();
			
			// SQL문 생성
			String sql = "SELECT * FROM EMPLOYEES";
			// SQL문 미리 보내기
			st = con.prepareStatement(sql);
			// 최종 전송 후 결과 처리
			rs = st.executeQuery();
			
			while(rs.next()) {
				// EMPLOYEE_ID
				System.out.print(rs.getInt(1)+"\t");
				// FIRST_NAME
				System.out.print(rs.getString(2)+"\t");
				// LAST_NAME
				System.out.print(rs.getString(3)+"\t");
				// EMAIL
				System.out.print(rs.getString(4)+"\t");
				// PHONE_NUMBER
				System.out.print(rs.getString(5)+"\t");
				// HIREDATE
				System.out.print(rs.getDate(6)+"\t");
				// JOB_ID
				System.out.print(rs.getString(7)+"\t");
				// SALARY
				System.out.print(rs.getInt(8)+"\t");
				// COMMISSION_PCT
				System.out.print(rs.getDouble(9)+"\t");
				// MANAGER_ID
				System.out.print(rs.getInt(10)+"\t");
				// DEPARTMENT_ID
				System.out.println(rs.getInt(11)+"\t");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnect.disConnect(rs, st, con);
		}
	}
	
	// 사원 번호를 받아서 사원 한 명의 정보 출력
	public void getOne(int employee_id) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
				
		try {
			con = dbConnect.getConnection();
			// SQL문 생성			
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
			// 미리 전송
			st = con.prepareStatement(sql);
			// ? 값 설정
			st.setInt(1, employee_id);
			// 최종 전송 후 결과 처리
			rs = st.executeQuery();
			
			if (rs.next()) {
				// EMPLOYEE_ID
				System.out.print(rs.getInt(1)+"\t");
				// FIRST_NAME
				System.out.print(rs.getString(2)+"\t");
				// LAST_NAME
				System.out.print(rs.getString(3)+"\t");
				// EMAIL
				System.out.print(rs.getString(4)+"\t");
				// PHONE_NUMBER
				System.out.print(rs.getString(5)+"\t");
				// HIREDATE
				System.out.print(rs.getDate(6)+"\t");
				// JOB_ID
				System.out.print(rs.getString(7)+"\t");
				// SALARY
				System.out.print(rs.getInt(8)+"\t");
				// COMMISSION_PCT
				System.out.print(rs.getDouble(9)+"\t");
				// MANAGER_ID
				System.out.print(rs.getInt(10)+"\t");
				// DEPARTMENT_ID
				System.out.println(rs.getInt(11)+"\t");
			} else {
				System.out.println("해당 사원 번호가 없습니다.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnect.disConnect(rs, st, con);
		}
	}
	
	// Last_name이 포함된 사원들을 출력
	public void search (String name) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = dbConnect.getConnection();
			String sql = "SELECT LAST_NAME FROM EMPLOYEES WHERE LAST_NAME LIKE ?";
			st = con.prepareStatement(sql);
			st.setString(1, "%"+name+"%");
			rs = st.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("LAST_NAME"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnect.disConnect(rs, st, con);
		}
	}
	
	// 급여가 min 이상, max 이하인 사원들을 출력
	public void getSal(int min, int max) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = dbConnect.getConnection();
			String sql = "SELECT FIRST_NAME, LAST_NAME, SALARY FROM EMPLOYEES WHERE SALARY BETWEEN ? AND ?";
			st = con.prepareStatement(sql);
			st.setInt(1, min);
			st.setInt(2, max);
			rs = st.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getString(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.println(rs.getInt(3));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnect.disConnect(rs, st, con);
		}
		
	}
}
