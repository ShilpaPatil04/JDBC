package com.exmp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Printing the first line of data

public class Example1 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/newdatabase";
		String un = "root";
		String psw = "$hilpaP2001";
	   
		try {
			//adding driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Establishing connection
			Connection con =DriverManager.getConnection(url,un,psw);
			//Creating statement
			Statement sts =con.createStatement();
			//query we need to featch the data from database
			String que = "Select * from employee";
			//Passing query
			ResultSet res =sts.executeQuery(que);
			res.next();
			//Fetching the data from database   
			System.out.println(res.getInt(1)+" "+ res.getString(2)+" "+res.getString(3)+" "+res.getInt(4));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
