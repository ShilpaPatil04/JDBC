package com.delete;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Examp {

	public static void main(String[] args) {
		Connection con = null;
		Statement sts = null;
		ResultSet res = null;

		FileInputStream f = null;
		Properties p = null;

		try {
			String path = "C:\\Users\\Mohan Jadhav\\OneDrive\\Desktop\\JDBC\\JDBC8_PasswordInDiffFile\\src\\com\\details\\Test.properties";

			f = new FileInputStream(path);
			p = new Properties();
			p.load(f);

			String url = p.getProperty("url");
			String username = p.getProperty("un");
			String password = p.getProperty("psw");

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			sts = con.createStatement();
			String q = "delete from employee where `id` =5";
			int n = sts.executeUpdate(q);
			System.out.println("no of rows deleated: " + n);
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
			Examp.close(con, sts, res);
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
