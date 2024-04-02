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
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,un,psw);
			sts =con.createStatement();
			//adding data in batch (adding multiple data at one time)
			String que1 = "insert into employee (`id`,`name`,`state`,`mobilenum`) values (11,'Jyoti','Andra',123512)";
			String que2 = "insert into employee (`id`,`name`,`state`,`mobilenum`) values (12,'Isha','Assam',963512)";	
			String que3 = "insert into employee (`id`,`name`,`state`,`mobilenum`) values (13,'Laxmi','Chenni',363512)";
			String que4 = "insert into employee (`id`,`name`,`state`,`mobilenum`) values (14,'Tanu','Kerala',857512)";
			sts.addBatch(que1);
			sts.addBatch(que2);
			sts.addBatch(que3);
			sts.addBatch(que4);
			
			//here executing the batch
			int[] arr =sts.executeBatch();
			System.out.println(arr);
		
			System.out.println("Data has been inserted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				sts.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
