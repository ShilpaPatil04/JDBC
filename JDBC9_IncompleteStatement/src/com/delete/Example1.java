package com.delete;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

//incomplete query
//Delete data user want to delete(take input from user)
public class Example1 {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet res = null;

		FileInputStream f = null;
		Properties p = null;
		String path = "C:\\Users\\Mohan Jadhav\\OneDrive\\Desktop\\JDBC\\JDBC9_IncompleteStatement\\src\\com\\detail\\Test.properties";
		try {
			f = new FileInputStream(path);
			p = new Properties();
			p.load(f);

			String url = p.getProperty("url");
			String un = p.getProperty("un");
			String psw = p.getProperty("psw");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, un, psw);
			String q = "delete from employee where id =?";
			//creating statement 
			ps = con.prepareStatement(q);
			
			//taking the input from user
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter id you want to delete:");
			int id = sc.nextInt();
			ps.setInt(1, id);
			ps.execute();
			System.out.println("The data has been deleated");
			
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
			Example1.close(con, ps, res);
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
