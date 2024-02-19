package Formorder;
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


import Orders.Order;

public class Formsorder  implements ActionListener{
	JFrame frame;
	JLabel OrderID_LB=new JLabel("ORDER ID");
	JLabel OrderName_LB=new JLabel("ORDER NAME");
	JLabel OrderDate_LB=new JLabel("ORDER DATE");
	JLabel PaymentMethod_LB=new JLabel("PAYMETHOD");
	
	JTextField OrderID_txf=new JTextField();
	JTextField OrderName_txf=new JTextField();
	JTextField OrderDate_txf=new JTextField();
	JTextField PaymentMethod_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
int w=(int)screensize.getWidth();
int H=(int)screensize.getHeight();

public Formsorder() {
CreateForm();
}
	private void CreateForm() {
	frame=new JFrame();
	frame.setTitle("Order form");
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
		OrderID_LB.setBounds(10,10,100,30);
		OrderName_LB.setBounds(10,50,100,30);
		OrderDate_LB.setBounds(10,90,100,30);
		PaymentMethod_LB.setBounds(10,130,100,30);
		
		OrderID_txf.setBounds(150,10,130,30);
		OrderName_txf.setBounds(150,50,130,30);
		OrderDate_txf.setBounds(150,90,130,30);
		PaymentMethod_txf.setBounds(150,130,130,30);
		
		insert_btn.setBounds(10, 250, 85, 30);
		read_btn.setBounds(110, 250, 85, 30);
		update_btn.setBounds(210, 250, 85, 30);
		delete_btn.setBounds(310, 250, 85, 30);
		 table.setBounds(500, 10, 600, 240);
	}
	private void addcomponentforFrame() {
	frame.add(OrderID_LB);
	frame.add(OrderName_LB);
	frame.add(OrderDate_LB);
	frame.add(PaymentMethod_LB);
	
	frame.add(OrderID_txf);
	frame.add(OrderName_txf);
	frame.add(OrderDate_txf);
	frame.add(PaymentMethod_txf);
	
	
	
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
		Order Fo=new Order();
		if(e.getSource()==insert_btn) {
			Fo.setOrderName(OrderName_txf.getText());
			Fo.setOrderDate(OrderDate_txf.getText());
			Fo.setPaymentMethod(PaymentMethod_txf.getText());
			Fo.insertData();
		
		}
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("OrderID");
            model.addColumn("OrderName");
            model.addColumn("OrderDate");
            model.addColumn("PaymentMethod");
            

            ResultSet resultSet = Order.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                                resultSet.getString(4) });
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
	
	}
	else if (e.getSource()==update_btn) {
		int id=Integer.parseInt(OrderID_txf.getText());
		Fo.setOrderName(OrderName_txf.getText());
		Fo.setOrderDate(OrderDate_txf.getText());
		Fo.setPaymentMethod(PaymentMethod_txf.getText());
		Fo.update(id);
    }
  else {
		int id=Integer.parseInt(OrderID_txf.getText());
		Fo.delete(id);}

  }
	
		public static void main(String[] args) {
			
			Formsorder Fpo= new Formsorder();
				System.out.println(Fpo);
				
			  }	
			}



