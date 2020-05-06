package com.healthcare.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;


public class Appointment {
	
	public Connection connect()
	{
		Connection con =null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/healthcare_system", "root", "");
			
			
			//For testing
			System.out.println("Successfully Connected");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
		
	}
	
	//Insert
	public String insertAppointment(String aID, String pName, String dName, String hName, String roomNO, String appNO, String aDate) {
		String output = "";
		
		try {
			
			Connection con = connect();
			
			if (con == null) 
			{ return "Error while connecting to the database for inserting.";}
			
			// create a prepared statement
			String query = " insert into appointment (`ano`,`aID`,`pName`,`dName`,`hName`,`roomNO`, `appNO`,`aDate`)" + " values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, aID);
			preparedStmt.setString(3, pName);
			preparedStmt.setString(4, dName);
			preparedStmt.setString(5, hName);
			preparedStmt.setString(6, roomNO);
			preparedStmt.setString(7, appNO);
			preparedStmt.setString(8, aDate);
			//String localDate = LocalDate.now().toString();
			//preparedStmt.setObject(8 , aDate);
			
			
            //execute the statement
			preparedStmt.execute();
			con.close();
			
			 String newAppointment =readAppointment();
			  output= "{\"status\":\"success\",\"data\": \"" + newAppointment + "\"}";
			  
			  } 
			 catch (Exception e)  { 
				  output = "{\"status\":\"success\",\"data\": \"Error while inserting the appointment.\"}";
			 
				  System.err.println(e.getMessage());
				  } 
		return output;
	}

	//Read
	public String readAppointment() {
		String output = "";
		try {
			Connection con = connect();
			
			if (con == null) 
			{ return "Error while connecting to the database for reading."; }
			
            // Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Appointment Id</th><th>Patient Name</th><th>Doctor Name</th><th>Hospital Name</th><th>Room No</th><th>Appointment Number</th><th>Date</th>"
					+ " <th>Update</th>"
					+ "<th>Remove</th></tr>";
			
			String query = "select * from appointment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// iterate through the rows in the result set
			while (rs.next()) {
				String ano = Integer.toString(rs.getInt("ano"));
				String aID = rs.getString("aID");
				String pName = rs.getString("pName");
				String dName = rs.getString("dName");
				String hName = rs.getString("hName");
				String roomNO = rs.getString("roomNO");
				String appNO = rs.getString("appNO");
				String aDate = rs.getString("aDate");
				
				
				// Add into the html table
				output += "<tr><td><input id='hidanoUpdate' name='hidanoUpdate' type='hidden' value='" + ano 
						+ "'>" + aID + "</td>";
				output += "<td>" + pName + "</td>"; 
				output += "<td>" + dName + "</td>";
				output += "<td>" + hName + "</td>";
				output += "<td>" + roomNO + "</td>";
				output += "<td>" + appNO + "</td>";
				output += "<td>" + aDate + "</td>";
				
				
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
						   + "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-ano='"
					       +  ano + "'  " + "></td></tr>"; 
				
			}
			con.close();
			
			// Complete the html table
			output += "</table>";
			
		} catch (Exception e) {
			output = "Error while reading the appointment.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	//update
	public String updateAppointment(String ano, String aID, String pName, String dName, String hName, String roomNO, String appNO, String aDate) {
		String output = "";
		try {
				Connection con = connect();
			if (con == null) { 
				return "Error while connecting to the database for updating."; 
				}
			
			// create a prepared statement
			String query = "UPDATE appointment SET aID=?,pName=?, dName=?,hName=?,roomNO=?,appNO=?,aDate=? WHERE ano=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setString(1, aID);
			preparedStmt.setString(2, pName);
			preparedStmt.setString(3, dName);
			preparedStmt.setString(4, hName);
			preparedStmt.setString(5, roomNO);
			preparedStmt.setString(6, appNO);
			preparedStmt.setString(7, aDate);
			//String localDate = LocalDate.now().toString();
			//preparedStmt.setObject(7 , aDate);
			preparedStmt.setInt(8, Integer.parseInt(ano));
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			String newAppointment = readAppointment();
			output ="{\"status\":\"success\", \"data\": \"" + newAppointment + "\"}";
			
			
			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while updating the appointment.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	//Delete
	public String deleteAppointment(String ano) {
		String output = "";
		try {
				Connection con = connect();
			if (con == null) 
			{ return "Error while connecting to the database for deleting."; }
			
			// create a prepared statement
			String query = "delete from appointment where ano=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(ano));
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			String newAppointment = readAppointment();
			output = "{\"status\":\"success\", \"data\": \"" + newAppointment + "\"}";
			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the appointment.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}



}
