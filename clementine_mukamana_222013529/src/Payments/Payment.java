package Payments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Payment {
	private int PaymentID;
	private String PaymentDate;
	private String Amaunt;
	private String PaymentMethod;
	private String OrderID;
	public Payment() {
		//default constructor
	}
	
public Payment(int paymentID, String paymentDate, String amaunt, String paymentMethod, String orderID) {
		super();
		PaymentID = paymentID;
		PaymentDate = paymentDate;
		Amaunt = amaunt;
		PaymentMethod = paymentMethod;
		OrderID = orderID;
	}

public int getPaymentID() {
	return PaymentID;
}

public void setPaymentID(int paymentID) {
	PaymentID = paymentID;
}




public String getPaymentDate() {
	return PaymentDate;
}




public void setPaymentDate(String paymentDate) {
	PaymentDate = paymentDate;
}




public String getAmaunt() {
	return Amaunt;
}




public void setAmaunt(String amaunt) {
	Amaunt = amaunt;
}




public String getPaymentMethod() {
	return PaymentMethod;
}




public void setPaymentMethod(String paymentMethod) {
	PaymentMethod = paymentMethod;
}




public String getOrderID() {
	return OrderID;
}




public void setOrderID(String orderID) {
	OrderID = orderID;
}




public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/clementine_mukamana_ospms";
    String user = "222013529";
    String password = "222013529";

    // SQL query to insert data
    String sql = "INSERT INTO payment (paymentDate, Amount, PaymentMethod, OrderID) VALUES (?,?,?,?)";
	
    try (
        // Establish the connection
    		Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.PaymentDate);
       preparedStatement.setString(2, this.Amaunt);
       preparedStatement.setString(3, this.PaymentMethod);
       preparedStatement.setString(4, this.OrderID);
       
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

		    String sql = "SELECT *  FROM payment ";

		    try {
		        Connection con = DriverManager.getConnection(host, user, password);
		        PreparedStatement preparedStatement = con.prepareStatement(sql);
		        return preparedStatement.executeQuery();
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return null;
		    }
		}

public void update(int inputpaymentID) {
// JDBC URL, username, and password of MySQL server
String url = "jdbc:mysql://localhost/clementine_mukamana_ospms";
String user = "222013529";
String password = "222013529";

// SQL query to update data
String sql = "UPDATE payment SET  paymentDate=?,Amount=?,PaymentMethod=?,OrderID=? WHERE paymentID= ?";

try (
    // Establish the con
    Connection con = DriverManager.getConnection(url, user, password);

    // Create a prepared statement
    PreparedStatement stm = con.prepareStatement(sql);
) {
    // Set the new values for the update
	  stm.setString(1, this.getPaymentDate());
	  stm.setString(2, this.getAmaunt());
	  stm.setString(3, this.getPaymentMethod());
	  stm.setString(4, this.getOrderID());
	  
     
      stm.setInt(5, inputpaymentID);
   
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
String sql = "DELETE FROM payment WHERE paymentID = ?";

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



