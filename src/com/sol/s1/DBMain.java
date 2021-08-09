package com.sol.s1;

import com.sol.s1.employee.EmployeeDAO;
import com.sol.s1.location.LocationDAO;
import com.sol.s1.test.DBTest;

public class DBMain {

	public static void main(String[] args) {
		System.out.println("DB Start");
//		// 클래스명 변수명 = new 생성자()
		DBTest dbTest = new DBTest();
//		// 멤버 사용 방식
//		// 참조 변수명.변수명, 참조 변수명.메서드명()
//		dbTest.connectTest();
		
		LocationDAO locationDAO = new LocationDAO();
//		locationDAO.getList();
		
//		dbTest.getOne();
		
//		locationDAO.getOne(1000);
		
//		dbTest.getCount();
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
//		employeeDAO.getList();
//		employeeDAO.getOne(201);
		employeeDAO.search("e");
//		employeeDAO.getSal(7000, 10000);
		System.out.println("DB Finish");
	}

}
