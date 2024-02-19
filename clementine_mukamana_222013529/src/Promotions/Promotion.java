package Promotions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Promotion {
	private int PromotionID;
	private String DiscountAmaunt;
	private String ExpirationDate;
	public Promotion() {
		//default constructor
	}
	
	
	
	public Promotion(int promotionID, String discountAmaunt, String expirationDate) {
		super();
		PromotionID = promotionID;
		DiscountAmaunt = discountAmaunt;
		ExpirationDate = expirationDate;
	}



	public int getPromotionID() {
		return PromotionID;
	}



	public void setPromotionID(int promotionID) {
		PromotionID = promotionID;
	}



	public String getDiscountAmaunt() {
		return DiscountAmaunt;
	}



	public void setDiscountAmaunt(String discountAmaunt) {
		DiscountAmaunt = discountAmaunt;
	}



	public String getExpirationDate() {
		return ExpirationDate;
	}



	public void setExpirationDate(String expirationDate) {
		ExpirationDate = expirationDate;
	}



	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/clementine_mukamana_ospms";
	    String user = "222013529";
	    String password = "222013529";

	    // SQL query to insert data
	    String sql = "INSERT INTO promotion (DiscountAmount,ExpirationDate) VALUES (?,?)";
		
	    try (
	        // Establish the connection
	    		Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.DiscountAmaunt);
	       preparedStatement.setString(2, this.ExpirationDate);
	     
	       
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data registered successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	
	}
	 
			public static ResultSet viewData() {
			    String host = "jdbc:mysql://localhost/clementine_mukamana_ospms";
			    String user = "222013529";
			    String password = "222013529";

			    String sql = "SELECT * FROM promotion";

			    try {
			        Connection con = DriverManager.getConnection(host, user, password);
			        PreparedStatement preparedStatement = con.prepareStatement(sql);
			        return preparedStatement.executeQuery();
			    } catch (SQLException e) {
			        e.printStackTrace();
			        return null;
			    }
			}
	public void update(int inputPromotionID) {
	// JDBC URL, username, and password of MySQL server
	String url = "jdbc:mysql://localhost/clementine_mukamana_ospms";
	String user = "222013529";
	String password = "222013529";

	// SQL query to update data
	String sql = "UPDATE promotion SET  DiscountAmount=?,ExpirationDate=? WHERE PromotionID= ?";

	try (
	    // Establish the con
	    Connection con = DriverManager.getConnection(url, user, password);

	    // Create a prepared statement
	    PreparedStatement stm = con.prepareStatement(sql);
	) {
	    // Set the new values for the update
		  stm.setString(1, this.getDiscountAmaunt());
		  stm.setString(2, this.getExpirationDate());
		 
		  
	     
	      stm.setInt(3, inputPromotionID);
	   
	    // Execute the update
	    int rowsAffected = stm.executeUpdate();

	    // Check the result
	    if (rowsAffected > 0) {
	        System.out.println("Data updated successfully!");
	        JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	    } else {
	        System.out.println("Failed to update data. No matching record found.");
	        JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}   
	}
	public void delete(int inputPromotionID) {
	// JDBC URL, username, and password of MySQL server
	String url = "jdbc:mysql://localhost/clementine_mukamana_ospms";
	String user = "222013529";
	String password = "222013529";

	// SQL query to delete data
	String sql = "DELETE FROM promotion WHERE PromotionID = ?";

	try (
	    // Establish the 
	    Connection con= DriverManager.getConnection(url, user, password);

	    // Create a prepared statement
	    PreparedStatement pl = con.prepareStatement(sql);
	) {
	    // Set the value for the WHERE clause
	    pl.setInt(1,inputPromotionID); // Assuming there is a column named 'id' for the WHERE clause

	    // Execute the delete
	    int rowsAffected = pl.executeUpdate();

	    // Check the result
	    if (rowsAffected > 0) {
	        System.out.println("Data deleted successfully!");
	        JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	    } else {
	        System.out.println("Failed to delete data. No matching record found.");
	        JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}

	}
	}




