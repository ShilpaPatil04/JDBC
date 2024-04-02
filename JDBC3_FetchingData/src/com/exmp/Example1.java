package com.exmp;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//getting all data from database 
//getting meta data like datatype, name of column etc
import java.sql.ResultSetMetaData;

public class Example1 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/newdatabase";
		String un = "root";
		String psw = "$hilpaP2001";
		
		Connection con = null;
		Statement sts = null;
		ResultSet res = null;

		try {
			// Added driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establishing connection
			 con = DriverManager.getConnection(url, un, psw);
			// creating a statement
			sts = con.createStatement();
			// query statement
			String que = "Select * from employee";
			// Executing query
			res = sts.executeQuery(que);

			while (res.next() == true) {
				System.out.println(res.getInt(1) + "   " + res.getString(2) + "     " + res.getString(3) + "     "
						+ res.getInt(4));
			}

			// meta data
			ResultSetMetaData meta = res.getMetaData();
			// here getting column type, column name
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				System.out
						.println(meta.getColumnName(i) + " " + meta.getColumnType(i) + " " + meta.getColumnTypeName(i));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//closing the connection
			try {
				res.close();
				sts.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}

}
