package com.exmp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example1 {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/newdatabase";
		String un = "root";
		String psw = "$hilpaP2001";

		Connection con = null;
		Statement sts = null;
		ResultSet res = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, un, psw);
			sts = con.createStatement();
			String q = "update employee set `name` = 'Piyush' where `id` =1";
			int n = sts.executeUpdate(q);
			System.out.println("the updated: "+ n);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Example1.close(con, sts, res);

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
