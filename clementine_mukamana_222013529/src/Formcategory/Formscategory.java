package Formcategory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Categorys.Category;

public class Formscategory  implements ActionListener{
	JFrame frame;
	JLabel categoryID_LB=new JLabel("CATEGORYID");
	JLabel categoryName_LB=new JLabel("CATENAME");
	
	JTextField categoryID_txf=new JTextField();
	JTextField CategoryName_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
int w=(int)screensize.getWidth();
int H=(int)screensize.getHeight();

public Formscategory() {
CreateForm();
}
	private void CreateForm() {
	frame=new JFrame();
	frame.setTitle("Category form");
	frame.setBounds(0, 0,w/2, H/2);
	frame.getContentPane().setLayout(null);
	frame.getContentPane().setBackground(Color.LIGHT_GRAY);
	frame.setVisible(true);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(true);
	setLocationSize();
	addcomponentforFrame();
	}
	
	private void setLocationSize() {
		categoryID_LB.setBounds(10,10,100,30);
		categoryName_LB.setBounds(10,50,100,30);
		
		categoryID_txf.setBounds(150,10,100,30);
		CategoryName_txf.setBounds(150,50,100,30);
		
		insert_btn.setBounds(10, 250, 85, 30);
		read_btn.setBounds(110, 250, 85, 30);
		update_btn.setBounds(210, 250, 85, 30);
		delete_btn.setBounds(310, 250, 85, 30);
		 table.setBounds(500, 10, 600, 240);
	}
	private void addcomponentforFrame() {
	frame.add(categoryID_LB);
	frame.add(categoryName_LB);
	
	frame.add(categoryID_txf);
	frame.add(CategoryName_txf);
	
	
	
	frame.add(insert_btn);
	frame.add(read_btn);
	frame.add(update_btn);
	frame.add(delete_btn);
	frame.add(table);
	ActionEvent ();
	}
	

	public void ActionEvent () {
		insert_btn.addActionListener(this);
		read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Category ct=new Category();
		if(e.getSource()==insert_btn) {
			ct.setCategoryName(CategoryName_txf.getText());
			ct.insertData();
				
		}
		else if (e.getSource() == read_btn) {
		    model.setColumnCount(0);
		    model.setRowCount(1);
		    model.addColumn("categoryID");
		    model.addColumn("categoryName");

		    ResultSet resultSet = Category.viewData();
		    if (resultSet != null) {
		        try {
		            while (resultSet.next()) {
		                model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2)});
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		}


		else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(categoryID_txf.getText());
			ct.setCategoryName(CategoryName_txf.getText());
			ct.update(id);
	    }
	  else {
			int id=Integer.parseInt(categoryID_txf.getText());
			ct.delete(id);}

	  }
		
	

public static void main(String[] args) {
	
Formscategory Formscategory= new Formscategory();
	System.out.println(Formscategory);
	
  }	
}
	
