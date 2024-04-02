package com.exmp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Inserting data into database
public class Example1 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/newdatabase";
		String psw = "$hilpaP2001";
		String un = "root";

		Connection con = null;
		Statement sts = null;
		ResultSet res = null;

		try {
			// adding driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establishing connection
			con = DriverManager.getConnection(url, un, psw);
			sts = con.createStatement();
			String que = "insert into employee (`id`,`name`,`state`,`mobilenum`) values (6,'Deva','Bihar',123456)";
			//Inserting Data into database
			sts.execute(que);
			System.out.println("Data inserted into database");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				res.close();
				sts.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
