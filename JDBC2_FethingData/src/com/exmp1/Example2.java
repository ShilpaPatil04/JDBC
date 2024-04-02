package com.exmp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example2 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/newdatabase";
		String un = "root";
		String psw = "$hilpaP2001";

		Connection con = null;
		Statement sts = null;
		ResultSet res = null;

		try {
			//Added driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, un, psw);
			//creating a statement
			sts = con.createStatement();
			String que = "Select * from employee";

			//Executing the query
			res = sts.executeQuery(que);
			
			//calling result method to print data
			Example2.result(res);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//calling close method to close all the connection
			Example2.close(con, sts, res);
		}

	}

	public static void result(ResultSet res) {
		try {
			while (res.next() == true) {
				System.out
						.println(res.getInt(1) + " " + res.getString(2) + " " + res.getString(3) + " " + res.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(Connection con, Statement sts, ResultSet res) {
		if (res != null) {
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (sts != null) {
			try {
				sts.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
