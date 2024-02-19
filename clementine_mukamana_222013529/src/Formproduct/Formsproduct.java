package Formproduct;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import Products.Product;
import Promotions.Promotion;


public class Formsproduct  implements ActionListener{
	JFrame frame;
	JLabel ProductID_LB=new JLabel("PRODUCTID");
	JLabel Name_LB=new JLabel("NAME");
	JLabel Description_LB=new JLabel("DESCRIPTION");
	JLabel price_LB=new JLabel("PRICE");
	JLabel Quantity_LB=new JLabel("QUANTITY");
	JLabel CategoryID_LB=new JLabel("CATEGORYID");
	JLabel SupplierID_LB=new JLabel("SUPPLIERID");
	
	JTextField ProductID_txf=new JTextField();
	JTextField Name_txf=new JTextField();
	JTextField Description_txf=new JTextField();
	JTextField Price_txf=new JTextField();
	JTextField quantity_txf=new JTextField();
	JTextField CategoryID_txf=new JTextField();
	JTextField SupplierID_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
int w=(int)screensize.getWidth();
int H=(int)screensize.getHeight();

public Formsproduct() {
CreateForm();
}
	private void CreateForm() {
	frame=new JFrame();
	frame.setTitle("Product form");
	frame.setBounds(0, 0,w/2, H/2);
	frame.getContentPane().setLayout(null);
	frame.getContentPane().setBackground(Color.LIGHT_GRAY);
	frame.setVisible(true);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(true);
	setLocationSize();
	addcomponentforFrame();
	ActionEvent();
	
}
	
	private void setLocationSize() {
		ProductID_LB.setBounds(10,10,100,30);
		Name_LB.setBounds(10,50,100,30);
		Description_LB.setBounds(10,90,100,30);
		price_LB.setBounds(10,130,100,30);
		Quantity_LB.setBounds(10,170,100,30);
		CategoryID_LB.setBounds(10,210,100,30);
		SupplierID_LB.setBounds(10,250,100,30);
		
		ProductID_txf.setBounds(150,10,100,30);
		Name_txf.setBounds(150,50,100,30);
		Description_txf.setBounds(150,90,100,30);
		Price_txf.setBounds(150,130,100,30);
		quantity_txf.setBounds(150,170,100,30);
		CategoryID_txf.setBounds(150,210,100,30);
		SupplierID_txf.setBounds(150,250,100,30);
		
		
		insert_btn.setBounds(10, 300, 85, 30);
		read_btn.setBounds(110, 300, 85, 30);
		update_btn.setBounds(210, 300, 85, 30);
		delete_btn.setBounds(310, 300, 85, 30);
		 table.setBounds(500, 10, 600, 240);
	}
	private void addcomponentforFrame() {
	frame.add(ProductID_LB);
	frame.add(Name_LB);
	frame.add(Description_LB);
	frame.add(price_LB);
	frame.add(Quantity_LB);
	frame.add(CategoryID_LB);
	frame.add(SupplierID_LB);
	
	frame.add(ProductID_txf);
	frame.add(Name_txf);
	frame.add(Description_txf);
	frame.add(Price_txf);
	frame.add(quantity_txf);
	frame.add(CategoryID_txf);
	frame.add(SupplierID_txf);
	
	
	
	frame.add(insert_btn);
	frame.add(read_btn);
	frame.add(update_btn);
	frame.add(delete_btn);
	frame.add(table);
	
	}
	

	private void ActionEvent() {
		insert_btn.addActionListener(this);
		read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		Product Fcp=new Product();
		if(e.getSource()==insert_btn) {
			Fcp.setName(Name_txf.getText());
			Fcp.setDescription(Description_txf.getText());
			Fcp.setPrice(Price_txf.getText());
			Fcp.setQuantity(quantity_txf.getText());
			Fcp.setCatagoryID(CategoryID_txf.getText());
			Fcp.setSupplierID(SupplierID_txf.getText());
			Fcp.insertData();
		
		}
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("ProductID");
            model.addColumn("Name");
            model.addColumn("Description");
            model.addColumn("Price");
            model.addColumn("quantity");
            model.addColumn("CategoryID");
            model.addColumn("SupplierID");
           
            ResultSet resultSet = Product.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                  model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                		  resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7)}); 
                		 
                            
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
	
	}
	else if (e.getSource()==update_btn) {
		int id=Integer.parseInt(ProductID_txf.getText());
		Fcp.setName(Name_txf.getText());
		Fcp.setDescription(Description_txf.getText());
		Fcp.setPrice(Price_txf.getText());
		Fcp.setQuantity(quantity_txf.getText());
		Fcp.setCatagoryID(CategoryID_txf.getText());
		Fcp.setSupplierID(SupplierID_txf.getText());
		Fcp.update(id);
    }
  else {
		int id=Integer.parseInt(ProductID_txf.getText());
		Fcp.delete(id);}

  }
	
		public static void main(String[] args) {
			
			Formsproduct Fcpt= new Formsproduct();
				System.out.println(Fcpt);
				
			  }	
			}






