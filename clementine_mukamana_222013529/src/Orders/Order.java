package Orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Order {
private int OrderID;
private String OrderName;
private String OrderDate;
private String PaymentMethod;
public Order() {
	//default constructor
}

public Order(int orderID, String orderName, String orderDate, String paymentMethod) {
	super();
	this.OrderID = orderID;
	this.OrderName = orderName;
	this.OrderDate = orderDate;
	this.PaymentMethod = paymentMethod;
}

public int getOrderID() {
	return OrderID;
}

public void setOrderID(int orderID) {
	OrderID = orderID;
}

public String getOrderName() {
	return OrderName;
}

public void setOrderName(String orderName) {
	OrderName = orderName;
}

public String getOrderDate() {
	return OrderDate;
}

public void setOrderDate(String orderDate) {
	OrderDate = orderDate;
}

public String getPaymentMethod() {
	return PaymentMethod;
}

public void setPaymentMethod(String paymentMethod) {
	PaymentMethod = paymentMethod;
}

public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/clementine_mukamana_ospms";
    String user = "222013529";
    String password = "222013529";

    // SQL query to insert data
    String sql = "INSERT INTO Order_ (orderName, OrderDate, PaymentMethod) VALUES (?,?,?)";
	
    try (
        // Establish the connection
    		Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.OrderName);
       preparedStatement.setString(2, this.OrderDate);
       preparedStatement.setString(3, this.PaymentMethod);
       
       
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

		    String sql = "SELECT * FROM Order_";

		    try {
		        Connection con = DriverManager.getConnection(host, user, password);
		        PreparedStatement preparedStatement = con.prepareStatement(sql);
		        return preparedStatement.executeQuery();
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return null;
		    }
		}
public void update(int inputOrderID) {
// JDBC URL, username, and password of MySQL server
String url = "jdbc:mysql://localhost/clementine_mukamana_ospms";
String user = "222013529";
String password = "222013529";

// SQL query to update data
String sql = "UPDATE Order_ SET  OrderName=?,OrderDate=?,PaymentMethod=? WHERE OrderID= ?";

try (
    // Establish the con
    Connection con = DriverManager.getConnection(url, user, password);

    // Create a prepared statement
    PreparedStatement stm = con.prepareStatement(sql);
) {
    // Set the new values for the update
	  stm.setString(1, this.getOrderName());
	  stm.setString(2, this.getOrderDate());
	  stm.setString(3, this.getPaymentMethod());

     
      stm.setInt(4, inputOrderID);
   
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
public void delete(int inputOrderID) {
// JDBC URL, username, and password of MySQL server
String url = "jdbc:mysql://localhost/clementine_mukamana_ospms";
String user = "222013529";
String password = "222013529";

// SQL query to delete data
String sql = "DELETE FROM Order_ WHERE OrderID = ?";

try (
    // Establish the 
    Connection con= DriverManager.getConnection(url, user, password);

    // Create a prepared statement
    PreparedStatement pl = con.prepareStatement(sql);
) {
    // Set the value for the WHERE clause
    pl.setInt(1,inputOrderID); // Assuming there is a column named 'id' for the WHERE clause

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







