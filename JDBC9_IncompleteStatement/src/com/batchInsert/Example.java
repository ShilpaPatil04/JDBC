package com.batchInsert;

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

import com.insert.Example1;

public class Example {

	public static void main(String[] args) {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet res = null;
	    
		String path = "C:\\Users\\Mohan Jadhav\\OneDrive\\Desktop\\JDBC\\JDBC9_IncompleteStatement\\src\\com\\detail\\Test.properties";
		FileInputStream f = null;
		Properties p = null;
		
		try {
			f = new FileInputStream(path);
			p = new Properties();
			p.load(f);
			
			String url= p.getProperty("url");
			String un = p.getProperty("un");
			String psw = p.getProperty("psw");
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,un,psw);
			String q = "insert into employee (`id`,`name`,`state`,`mobilenum`) values (?,?,?,?)";
			ps =con.prepareStatement(q);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enet n value:");
			int n = sc.nextInt();
			
			con.setAutoCommit(false);
			for(int i=1; i <=n;i++) {
				System.out.println("Enter id");
				int id = sc.nextInt();
				
				System.out.println("Enetr name");
				String name = sc.next();
				
				System.out.println("Enetr state");
				String state = sc.next();
				
				System.out.println("Enter mobile number");
				int mobilenum = sc.nextInt();
				
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, state);
				ps.setInt(4, mobilenum);
				
				ps.execute();
			}
			con.commit();
		
			System.out.println("Data has been inserted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
