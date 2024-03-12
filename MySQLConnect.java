package FBLALibrary;

import java.util.*;
import java.sql.*;

public class MySQLConnect {
	
	//Objects to execute MySQL queries
	private Connection connect;
	private Statement statement;
	private ResultSet results;
	
	
	//Constructor which initializes connection and statement objects
	public MySQLConnect() {
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost/school_register_schema", "root", "ciNNam0N99"); 
			//The empty double quotes on the previous line are where the MySQL 
			//password for the device should go if the device uses password-protected MySQL
			statement = connect.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Executes a query that returns no result
	public void doQuery(String query) {
		try {
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Error: " + e + " in query " + query);
		}
	}
	
	
	//Executes a query that returns a single result
	public Object singleResQuery(String query) {
		try {
			results = statement.executeQuery(query);
			Object o = results.getObject(0);
			if (o == null) {
				return null;
			}
			return o;
		} catch (Exception e) {
			System.out.println("Error: " + e + " in query " + query);
		}
		return null;
	}
	
	
	//Executes a query that returns results from multiple columns in the form of an ArrayList of ArrayLists
	public ArrayList<ArrayList<Object>> multiColumnQuery(String query, String...columns) {
		try {
			results = statement.executeQuery(query);
			ArrayList<ArrayList<Object>> rows = new ArrayList<ArrayList<Object>>();
			while (results.next()) {
				ArrayList<Object> row = new ArrayList<Object>();
				for(int i = 0; i < columns.length; i++) {
					row.add(results.getObject(columns[i]));
				}
				rows.add(row);
			}
			if (rows.isEmpty()) {
				return null;
			}
			return rows;
		} catch (Exception e) {
			System.out.println("Error: " + e + " in query " + query);
		}
		return null;
	}
}
