package com.insert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Exmp1 {

	public static void main(String[] args) {

		Connection con = null;
		Statement sts = null;
		ResultSet res = null;

		FileInputStream f = null;
		Properties p = null;

		String path = "C:\\Users\\Mohan Jadhav\\OneDrive\\Desktop\\JDBC\\JDBC8_PasswordInDiffFile\\src\\com\\details\\Test.properties";
		try {
			f = new FileInputStream(path);
			p = new Properties();
			p.load(f);

			String url = p.getProperty("url");
			String username = p.getProperty("un");
			String password = p.getProperty("psw");

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			String q1 = "insert into employee(`id`,`name`,`state`,`mobilenum`) values (10,'Loki','Mumbai',673426)";
			String q2 = "insert into employee(`id`,`name`,`state`,`mobilenum`) values (11,'Kiran','Karnataka',967485)";
			String q3 = "insert into employee(`id`,`name`,`state`,`mobilenum`) values (12,'Appi','MP',673426)";
			String q4 = "insert into employee(`id`,`name`,`state`,`mobilenum`) values (13,'Manvita','Pune',362514)";

			sts = con.createStatement();
			sts.addBatch(q1);
			sts.addBatch(q2);
			sts.addBatch(q3);
			sts.addBatch(q4);

			int[] ar = sts.executeBatch();
			System.out.println("Data has been inserted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Exmp1.close(con, sts, res);
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
