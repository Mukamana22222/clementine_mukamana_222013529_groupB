package Products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Product {
	private int ProductID;
	private String Name;
	private String Description;
	private String Price;
	private String  Quantity;
	private String CatagoryID;
	private String SupplierID;
	public Product() {
		//default constructor
	}
	private Product(int productID, String name, String description, String price, String quantity, String catagoryID,
			String supplierID) {
		super();
		ProductID = productID;
		Name = name;
		Description = description;
		Price = price;
		Quantity = quantity;
		CatagoryID = catagoryID;
		SupplierID = supplierID;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	public String getCatagoryID() {
		return CatagoryID;
	}
	public void setCatagoryID(String catagoryID) {
		CatagoryID = catagoryID;
	}
	public String getSupplierID() {
		return SupplierID;
	}
	public void setSupplierID(String supplierID) {
		SupplierID = supplierID;
	}


public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/clementine_mukamana_ospms";
    String user = "222013529";
    String password = "222013529";

    // SQL query to insert data
    String sql = "INSERT INTO product (Name, Description, Price, Quantity, CategoryID,SupplierID) VALUES (?,?,?,?,?,?)";
	
    try (
        // Establish the connection
    		Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.Name);
       preparedStatement.setString(2, this.Description);
       preparedStatement.setString(3, this.Price);
       preparedStatement.setString(4, this.Quantity);
       preparedStatement.setString(5, this.CatagoryID);
       preparedStatement.setString(6, this.SupplierID);
       
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

		    String sql = "SELECT * FROM product";

		    try {
		        Connection con = DriverManager.getConnection(host, user, password);
		        PreparedStatement preparedStatement = con.prepareStatement(sql);
		        return preparedStatement.executeQuery();
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return null;
		    }
		}
public void update(int inputProductID) {
// JDBC URL, username, and password of MySQL server
String url = "jdbc:mysql://localhost/clementine_mukamana_ospms";
String user = "222013529";
String password = "222013529";

// SQL query to update data
String sql = "UPDATE product SET  Name=?,Description=?,Price=?,Quantity=?,CategoryID=?,SupplierID=? WHERE ProductID= ?";

try (
    // Establish the con
    Connection con = DriverManager.getConnection(url, user, password);

    // Create a prepared statement
    PreparedStatement stm = con.prepareStatement(sql);
) {
    // Set the new values for the update
	  stm.setString(1, this.getName());
	  stm.setString(2, this.getDescription());
	  stm.setString(3, this.getPrice());
	  stm.setString(4, this.getQuantity());
	  stm.setString(5, this.getCatagoryID());
	  stm.setString(6, this.getSupplierID());
     
      stm.setInt(7, inputProductID);
   
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
public void delete(int inputProductID) {
// JDBC URL, username, and password of MySQL server
String url = "jdbc:mysql://localhost/clementine_mukamana_ospms";
String user = "222013529";
String password = "222013529";

// SQL query to delete data
String sql = "DELETE FROM product WHERE ProductID = ?";

try (
    // Establish the 
    Connection con= DriverManager.getConnection(url, user, password);

    // Create a prepared statement
    PreparedStatement pl = con.prepareStatement(sql);
) {
    // Set the value for the WHERE clause
    pl.setInt(1,inputProductID); // Assuming there is a column named 'id' for the WHERE clause

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



