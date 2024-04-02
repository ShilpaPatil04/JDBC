package com.fetch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//when username password and url is present in different package
//Fetching the all data
public class Exmp1 {

	public static void main(String[] args) {

		Connection con = null;
		Statement sts = null;
		ResultSet res = null;

		String path = "C:\\Users\\Mohan Jadhav\\OneDrive\\Desktop\\JDBC\\JDBC8_PasswordInDiffFile\\src\\com\\details\\Test.properties";
		FileInputStream f = null;
		Properties p = null;

		try {
			f = new FileInputStream(path);
			p = new Properties();
			p.load(f);

			String url = p.getProperty("url");
			String username = p.getProperty("un");
			String password = p.getProperty("psw");

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			sts = con.createStatement();
			res = sts.executeQuery("select * from employee");

			Exmp1.result(res);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Exmp1.close(con, sts, res);
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
