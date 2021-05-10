package com.paldonenemttin.food.contract;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {

	private static Connection dbConn = null;

	static {

		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "fooduser";
		String password = "fooduser";

		try {
			
			Class.forName(jdbcDriver);
			
			if (dbConn == null) {
				dbConn = DriverManager.getConnection(url, username, password);
			}
			System.out.println("오라클 접속 OK");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버를 찾을 수 없음");
			System.out.println(" Ojdbc.jar오라클 확인 필요");
		} catch (SQLException e) {
			System.out.println("오라클 DBMS 연결 실패");
			
		}

	}
	
	public static Connection getDBConnection() {
		return dbConn;
	}

}
