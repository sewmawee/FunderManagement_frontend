package com.model;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class funder {
	
	//A common method to connect to the DB
	private Connection connect() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadget","root", "");
			
			//for testing
			System.out.println("Successfully connected");
		}
		catch(Exception e) {
			e.printStackTrace();

		}
		
		return con;
	}
	
	
	
	
	//View/Reading funder details
		
	
	public String viewFunders() {
		
		String output = "";
		
		try {
			
			Connection con = connect();
			
			if(con == null) {
				
				return "Error while connecting to the database for the reading";
				
			}
			//,funderName,funderAddress,funderTel,funderEmail,funderGender,funderFund,funderTime,funderDes
			//prepare the HTML table to be displayed
			output = "<table class='container-fluid ' border='1'><tr class='text-center'><th>Funder ID</th>"
					+ "<th>Funder Code</th>"
					+ "<th>Funder Name</th>"
					+ "<th>Funder Address</th>"
					+ "<th>Funder Tel</th>"
					+ "<th>Funder Email</th>"
					+ "<th>Funder Gender</th>"
					+ "<th>Funder Fund</th>"
					+ "<th>Funder Time</th>"
					+ "<th>Funder Description</th>"
					+ "<th>Update</th><th>Remove<tr>";
			
			String query = "select * from funders";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			//iterate through the rows in the result set
			while(rs.next()) {
				
				String funderID = Integer.toString(rs.getInt("funderID"));
				String funderCode = rs.getString("funderCode");
				String funderName = rs.getString("funderName");
				String funderAddress = rs.getString("funderAddress");
				String funderTel = rs.getString("funderTel");
				String funderEmail = rs.getString("funderEmail");
				String funderGender = rs.getString("funderGender");
				String funderFund = Double.toString(rs.getDouble("funderFund"));
				String funderTime = rs.getString("funderTime");
				String funderDes = rs.getString("funderDes");
				
				
				//Add a row into the HTML table
				output += "<tr class='text-center'><td>" + funderID + "</td>";
				output += "<td>" + funderCode + "</td>";
				output += "<td>" + funderName + "</td>";
				output += "<td>" + funderAddress + "</td>";
				output += "<td>" + funderTel + "</td>";
				output += "<td>" + funderEmail + "</td>";
				output += "<td>" + funderGender + "</td>";
				output += "<td>" + funderFund + "</td>";
				output += "<td>" + funderTime + "</td>";
				output += "<td>" + funderDes + "</td>";
				
				//buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
						 + "<td><button class='btnRemove btn btn-danger' name='btnRemove' id ='btnRemove' value='"+ funderID +"' >Remove</button></td></tr>";

			}
			con.close();
			
			//Complete the HTML table
			output += "</table>";
		}
		catch(Exception e) {
			output = "reading Funder Details.";
			System.out.println(e.getMessage());
			System.out.println(e);
			e.printStackTrace();
			//output = "Error while reading.";
			//System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	
	
	//inserting funder details
	
	public String insertFunders(String funderCode , String funderName , String funderAddress , String funderTel , String funderEmail , String funderGender,String funderFund, String funderTime, String funderDes) {
			
			String output = "";
			
			try {
				
				Connection con = connect();
				
				if(con == null) {
					return "Error while connecting to the database for inserting";
				}
				
				//create a prepared statement
				String query = " insert into funders(funderCode,funderName,funderAddress,funderTel,funderEmail,funderGender,funderFund,funderTime,funderDes)" 
				+ " values(?,?,?,?,?,?,?,?,?)";
				
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				//binding values
				//preparedStmt.setInt(1,0);
				preparedStmt.setString(1,funderCode);
				preparedStmt.setString(2,funderName);
				preparedStmt.setString(3,funderAddress);
				preparedStmt.setString(4,funderTel);
				preparedStmt.setString(5,funderEmail);
				preparedStmt.setString(6,funderGender);
				preparedStmt.setDouble(7,Double.parseDouble(funderFund));
				preparedStmt.setString(8,funderTime);
				preparedStmt.setString(9,funderDes);
				
				//execute the statement
				preparedStmt.execute();
				con.close();
				
				String newPost = viewFunders(); 
				output = "{\"status\":\"success\", \"data\": \"" + newPost + "\"}";
				
				//output = "Inserted successfully";
			}
			catch(Exception e) {
				
				output = "{\"status\":\"error\", \"data\": \"Error while inserting the funder details.\"}";
				//output = "Error while inserting";
				//System.err.println(e.getMessage());
				System.out.println(e.getMessage());
				System.out.println(e);
				e.printStackTrace();
				
			}
			
			return output;
			
		}
	
	
	
	

	//Deleting funder details
	
		public String deleteFunders(String funderID) 
		 { 
			String output = ""; 
			
			try
			{ 
				Connection con = connect(); 
				if (con == null) 
				{return "Error while connecting to the database for deleting."; } 
		 
				// create a prepared statement
				String query = "delete from funders where funderID=?"; 
				
				PreparedStatement preparedStmt = con.prepareStatement(query); 
		 
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(funderID)); 
		 
				// execute the statement
				preparedStmt.execute(); 
				con.close(); 
		 
				//output = "Deleted successfully";
				String newPost = viewFunders(); 
				output = "{\"status\":\"success\", \"data\": \"" + newPost + "\"}";
			} 
			catch (Exception e) 
			{ 
				//output = "Error while deleting";
				output = "{\"status\":\"error\", \"data\": \"Error while deleting the funder details.\"}"; 

				System.err.println(e.getMessage()); 
			} 
			
			return output; 
		 }
		
		
		//updating funder details
		
		
		public String updateFunders(String funderID,String funderCode , String funderName , String funderAddress , String funderTel , String funderEmail , String funderGender,String funderFund, String funderTime, String funderDes)
		{ 
			String output = ""; 
			try
			{ 
				Connection con = connect(); 
				if (con == null) 
				{return "Error while connecting to the database for updating."; } 
				
				// create a prepared statement
				String query = "UPDATE funders SET funderCode=?,funderName=?,funderAddress=?,funderTel=?,funderEmail=?,funderGender=?,funderFund=?,funderTime=?,funderDes=?WHERE funderID=?"; 
		
				PreparedStatement preparedStmt = con.prepareStatement(query); 
		
				// binding values
				
				preparedStmt.setString(1,funderCode);
				preparedStmt.setString(2,funderName);
				preparedStmt.setString(3,funderAddress);
				preparedStmt.setString(4,funderTel);
				preparedStmt.setString(5,funderEmail);
				preparedStmt.setString(6,funderGender);
				preparedStmt.setDouble(7,Double.parseDouble(funderFund));
				preparedStmt.setString(8,funderTime);
				preparedStmt.setString(9,funderDes); 
				preparedStmt.setInt(10, Integer.parseInt(funderID)); 
		 
				// execute the statement
				preparedStmt.execute(); 
				con.close(); 
		 
				//output = "Updated successfully"; 
				String newPost = viewFunders(); 
				output = "{\"status\":\"success\", \"data\": \"" + newPost + "\"}"; 
			} 
			catch (Exception e) 
			{ 
				//output = "Error while updating";
				output = "{\"status\":\"error\", \"data\": \"Error while updating the funder details.\"}"; 
				System.err.println(e.getMessage()); 
			} 
			
			return output; 
		 } 
		
		


}
