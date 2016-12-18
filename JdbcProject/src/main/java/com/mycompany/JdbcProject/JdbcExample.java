package com.mycompany.JdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {

	public static void main(String[] args) {
		/**
		 * 1. Register the driver class 2.Creating connection 3. Creating statement
		 * 4. Executing queries 5. Closing connection
		 */

		try {
			/* 1 */Class.forName("com.mysql.jdbc.Driver");

			/* 2 */Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "ravi");
			
			/* 3 */Statement stm = con.createStatement();

			/* 4 */ResultSet rs = stm.executeQuery("Select * from employee order by id");
			
			
			
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+ rs.getString(2) +" "+ rs.getString(3));
			}
			
			/********************************************************************************/
			//update records
			Statement stm1 = con.createStatement();
			//int result = stm1.executeUpdate("insert into employee values(11, 'Riyan', 'Delhi')");
			
			//System.out.println(result +" records are inserted.");
			
			//using prepared statement
			PreparedStatement ps  = con.prepareStatement("select * from employee where id=? and name=?");
			ps.setInt(1, 1);
			ps.setString(2,"ravi");
			ResultSet rs2 = ps.executeQuery();
			while(rs2.next()){
				System.out.println(rs2.getInt(1)+" "+rs2.getString(2)+" "+rs2.getString(3));
			}
			
			
			con.close();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
