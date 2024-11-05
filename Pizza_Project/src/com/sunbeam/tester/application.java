package com.sunbeam.tester;

import java.sql.Connection;
import java.sql.SQLException;

import com.sunbeam.utils.Dbutil;

public class application {

	public static void main(String[] args) 
	{
		try {
			Connection connection = Dbutil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
