package Customers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Customer {
	private int CustomerID;
	private String CustomerName;
	private String Phone;
	private String Email;
	private String Address;
	private String gender;
	public Customer() {
		//default constructor
	}
	
public Customer(int customerID, String customerName, String phone, String email, String address, String gender) {
		super();
		this.CustomerID = customerID;
		this.CustomerName = customerName;
		this.Phone = phone;
		this.Email = email;
		this.Address = address;
		this.gender = gender;
	}

public int getCustomerID() {
	return CustomerID;
}

public void setCustomerID(int customerID) {
	CustomerID = customerID;
}

public String getCustomerName() {
	return CustomerName;
}

public void setCustomerName(String customerName) {
	CustomerName = customerName;
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
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/clementine_mukamana_ospms";
    String user = "222013529";
    String password = "222013529";

    // SQL query to insert data
    String sql = "INSERT INTO Customer (CustomerName, Phone, Email, Address, gender) VALUES (?,?,?,?,?)";
	
    try (
        // Establish the connection
    		Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.CustomerName);
       preparedStatement.setString(2, this.Phone);
       preparedStatement.setString(3, this.Email);
       preparedStatement.setString(4, this.Address);
       preparedStatement.setString(5, this.gender);
       
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

		    String sql = "SELECT * FROM Customer";

		    try {
		        Connection con = DriverManager.getConnection(host, user, password);
		        PreparedStatement preparedStatement = con.prepareStatement(sql);
		        return preparedStatement.executeQuery();
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return null;
		    }
		}

public void update(int inputCustomerID) {
// JDBC URL, username, and password of MySQL server
String url = "jdbc:mysql://localhost/clementine_mukamana_ospms";
String user = "222013529";
String password = "222013529";

// SQL query to update data
String sql = "UPDATE Customer SET  CustomerName=?,Phone=?,Email=?,Address=?,gender=? WHERE CustomerID= ?";

try (
    // Establish the con
    Connection con = DriverManager.getConnection(url, user, password);

    // Create a prepared statement
    PreparedStatement stm = con.prepareStatement(sql);
) {
    // Set the new values for the update
	  stm.setString(1, this.getCustomerName());
	  stm.setString(2, this.getPhone());
	  stm.setString(3, this.getEmail());
	  stm.setString(4, this.getAddress());
	  stm.setString(5, this.getGender());
     
      stm.setInt(6, inputCustomerID);
   
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
public void delete(int inputCustomerID) {
// JDBC URL, username, and password of MySQL server
String url = "jdbc:mysql://localhost/clementine_mukamana_ospms";
String user = "222013529";
String password = "222013529";

// SQL query to delete data
String sql = "DELETE FROM Customer WHERE CustomerID = ?";

try (
    // Establish the 
    Connection con= DriverManager.getConnection(url, user, password);

    // Create a prepared statement
    PreparedStatement pl = con.prepareStatement(sql);
) {
    // Set the value for the WHERE clause
    pl.setInt(1,inputCustomerID); // Assuming there is a column named 'id' for the WHERE clause

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



