package com.bilgeadam.boost.course02.plainsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.bilgeadam.boost.course02.model.UserEntity;

public class PlainSQLTest {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String     url   = "jdbc:postgresql://localhost:5432/hiber_db";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "root");
		ArrayList<UserEntity> users = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, props); 
			System.out.println("connection established");

			Statement stmt = conn.createStatement();
			String    sql  = "SELECT * FROM users;";
			ResultSet rs   = stmt.executeQuery(sql);
			
			UserEntity user;

			while (rs.next()) {
				long id = rs.getLong(1);
				String email = rs.getString(2);
				String firstName = rs.getString(3);
				String lastName = rs.getString(4);
				user = new UserEntity(firstName, lastName);
				user.setEmail(email);
				users.add(user);
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		for (UserEntity user : users) {
			System.out.println(user);
		}
		long stop = System.currentTimeMillis();
		System.out.println("Duration : " + (stop-start));
	}
}
