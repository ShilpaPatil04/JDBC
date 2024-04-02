package com.exmp;

import java.sql.DriverManager;
import java.sql.SQLException;

//Basic connection

public class Example1 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/newdatabase";
		String un = "root";
		String psw = "$hilpaP2001";
		try {
			//adding driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver added succesfully");
			//Establishing connection
			DriverManager.getConnection(url, un, psw);
			System.out.println("Connection established");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
