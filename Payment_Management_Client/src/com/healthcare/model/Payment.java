package com.healthcare.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;


public class Payment {
	
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
	public String insertPayment(String pID, String pName, String dName, String hName, String pDate, String docCharge, String hosCharge, String total) {
		String output = "";
		
		try {
			
			Connection con = connect();
			
			if (con == null) 
			{ return "Error while connecting to the database for inserting.";}
			
			// create a prepared statement
			String query = " insert into payment (`pno`,`pID`,`pName`,`dName`,`hName`,`pDate`,`docCharge`,`hosCharge`,`total`)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, pID);
			preparedStmt.setString(3, pName);
			preparedStmt.setString(4, dName);
			preparedStmt.setString(5, hName);
			String localDate = LocalDate.now().toString();
			preparedStmt.setObject(6 , pDate);
			preparedStmt.setDouble(7, Double.parseDouble(docCharge));
			preparedStmt.setDouble(8, Double.parseDouble(hosCharge));
			preparedStmt.setDouble(9, Double.parseDouble(total));
			
            //execute the statement
			preparedStmt.execute();
			con.close();
			
			 String newPayment =readPayment();
			  output= "{\"status\":\"success\",\"data\": \"" + newPayment + "\"}";
			  
			  } 
			 catch (Exception e)  { 
				  output = "{\"status\":\"success\",\"data\": \"Error while inserting the payment.\"}";
			 
				  System.err.println(e.getMessage());
				  } 
		return output;
	}

	//Read
	public String readPayment() {
		String output = "";
		try {
			Connection con = connect();
			
			if (con == null) 
			{ return "Error while connecting to the database for reading."; }
			
            // Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Payment Id</th><th>Patient Name</th><th>Doctor Name</th><th>Hospital Name</th><th>Payment Date</th><th>Doctor Charge</th><th>Hospital Charge</th><th>Total Payment</th>"
					+ " <th>Update</th>"
					+ "<th>Remove</th></tr>";
			
			String query = "select * from payment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// iterate through the rows in the result set
			while (rs.next()) {
				String pno = Integer.toString(rs.getInt("pno"));
				String pID = rs.getString("pID");
				String pName = rs.getString("pName");
				String dName = rs.getString("dName");
				String hName = rs.getString("hName");
				String pDate = rs.getString("pDate");
				String docCharge = rs.getString("docCharge");
				String hosCharge= rs.getString("hosCharge");
				String total = rs.getString("total");
				
				
				
				// Add into the html table
				output += "<tr><td><input id='hidPaymentIDUpdate' name='hidPaymentIDUpdate' type='hidden' value='" + pno 
						+ "'>" + pID + "</td>";
				output += "<td>" + pName + "</td>"; 
				output += "<td>" + dName + "</td>";
				output += "<td>" + hName + "</td>";
				output += "<td>" + pDate + "</td>";
				output += "<td>" + docCharge + "</td>";
				output += "<td>" + hosCharge + "</td>";
				output += "<td>" + total + "</td>";
				
				
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
						   + "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-pno='"
					       +  pno + "' > " + "></td></tr>"; 
				
			}
			con.close();
			
			// Complete the html table
			output += "</table>";
			
		} catch (Exception e) {
			output = "Error while reading the payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	//update
	public String updatePayment(String pno, String pID, String pName, String dName, String hName, String pDate, String docCharge, String hosCharge, String total) {
		String output = "";
		try {
				Connection con = connect();
			if (con == null) { 
				return "Error while connecting to the database for updating."; 
				}
			
			// create a prepared statement
			String query = "UPDATE payment SET pID=?, pName=?, dName=?, hName=?, pDate=?, docCharge=?, hosCharge=?,total=? WHERE pno=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setString(1, pID);
			preparedStmt.setString(2, pName);
			preparedStmt.setString(3, dName);
			preparedStmt.setString(4, hName);
			String localDate = LocalDate.now().toString();
			preparedStmt.setObject(5 , pDate);
			preparedStmt.setDouble(6, Double.parseDouble(docCharge));
			preparedStmt.setDouble(7, Double.parseDouble(hosCharge));
			preparedStmt.setDouble(8, Double.parseDouble(total));
			preparedStmt.setInt(9, Integer.parseInt(pno));
			
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			String newPayment = readPayment();
			output ="{\"status\":\"success\", \"data\": \"" + newPayment + "\"}";
			
			
			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while updating the payment.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	//Delete
	public String deletePayment(String pno) {
		String output = "";
		try {
				Connection con = connect();
			if (con == null) 
			{ return "Error while connecting to the database for deleting."; }
			
			// create a prepared statement
			String query = "delete from payment where pno=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(pno));
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			String newPayment = readPayment();
			output = "{\"status\":\"success\", \"data\": \"" + newPayment + "\"}";
			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the payment.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}



}
