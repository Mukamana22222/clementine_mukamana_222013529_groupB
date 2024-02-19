package Suppliers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;



public class Supplier {
	private int SupplierID;
	private String SupplierName;
	private String Phone;
	private String Email;
	private String Address;
	private String Gender;
	public Supplier() {
		//default constructor
	}
	public Supplier(int SupplierID, String SupplierName, String Phone, String Email, String Address, String Gender) {
		super();
		this.SupplierID = SupplierID;
		this.SupplierName = SupplierName;
		this.Phone = Phone;
		this.Email = Email;
		this.Address = Address;
		this.Gender = Gender;
	}
	
	public int getSupplierID() {
		return SupplierID;
	}
	public void setSupplierID(int supplierID) {
		SupplierID = supplierID;
	}
	public String getSupplierName() {
		return SupplierName;
	}
	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}

	
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/clementine_mukamana_ospms";
	    String user = "222013529";
	    String password = "222013529";

	    // SQL query to insert data
	    String sql = "INSERT INTO Supplier (SupplierName, Phone, Email, Address, gender) VALUES (?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	    		Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.SupplierName);
	       preparedStatement.setString(2, this.Phone);
	       preparedStatement.setString(3, this.Email);
	       preparedStatement.setString(4, this.Address);
	       preparedStatement.setString(5, this.Gender);
	       
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

			    String sql = "SELECT * FROM supplier";

			    try {
			        Connection con = DriverManager.getConnection(host, user, password);
			        PreparedStatement preparedStatement = con.prepareStatement(sql);
			        return preparedStatement.executeQuery();
			    } catch (SQLException e) {
			        e.printStackTrace();
			        return null;
			    }
			}

public void update(int inputSupplierID) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/clementine_mukamana_ospms";
    String user = "222013529";
    String password = "222013529";

    // SQL query to update data
    String sql = "UPDATE Supplier SET  SupplierName=?,Phone=?,Email=?,Address=?,gender=? WHERE SupplierID= ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  stm.setString(1, this.getSupplierName());
    	  stm.setString(2, this.getPhone());
    	  stm.setString(3, this.getEmail());
    	  stm.setString(4, this.getAddress());
    	  stm.setString(5, this.getGender());
         
          stm.setInt(6, inputSupplierID);
       
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
public void delete(int inputSupplierID) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/clementine_mukamana_ospms";
    String user = "222013529";
    String password = "222013529";

    // SQL query to delete data
    String sql = "DELETE FROM Supplier WHERE  SupplierID = ?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1,inputSupplierID); // Assuming there is a column named 'id' for the WHERE clause

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


