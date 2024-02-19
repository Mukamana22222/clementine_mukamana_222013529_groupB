package Formpayment;

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

import Payments.Payment;
import Promotions.Promotion;

public class Formspayment  implements ActionListener{
	JFrame frame;
	JLabel PaymentID_LB=new JLabel("PAYMENTID");
	JLabel PaymentDate_LB=new JLabel("PAYDATE");
	JLabel Amount_LB=new JLabel("AMOUNT");
	JLabel PaymentMethod_LB=new JLabel("PAYMETHOD");
	JLabel OrderID_LB=new JLabel("ODERID");
	
	
	JTextField PaymentID_txf=new JTextField();
	JTextField PaymentDate_txf=new JTextField();
	JTextField Amount_txf=new JTextField();
	JTextField PaymentMethod_txf=new JTextField();
	JTextField OrderID_txf=new JTextField();
	
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
int w=(int)screensize.getWidth();
int H=(int)screensize.getHeight();

public Formspayment() {
CreateForm();
}
	private void CreateForm() {
	frame=new JFrame();
	frame.setTitle("Payment form");
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
		PaymentID_LB.setBounds(10,10,100,30);
		PaymentDate_LB.setBounds(10,50,100,30);
		Amount_LB.setBounds(10,90,100,30);
		PaymentMethod_LB.setBounds(10,130,100,30);
		OrderID_LB.setBounds(10,170,100,30);
		
		
		PaymentID_txf.setBounds(150,10,100,30);
		PaymentDate_txf.setBounds(150,50,100,30);
		Amount_txf.setBounds(150,90,100,30);
		PaymentMethod_txf.setBounds(150,130,100,30);
		OrderID_txf.setBounds(150,170,100,30);
		
		
		insert_btn.setBounds(10, 250, 85, 30);
		read_btn.setBounds(110, 250, 85, 30);
		update_btn.setBounds(210, 250, 85, 30);
		delete_btn.setBounds(310, 250, 85, 30);
		 table.setBounds(500, 10, 600, 240);
	}
	private void addcomponentforFrame() {
	frame.add(PaymentID_LB);
	frame.add(PaymentDate_LB);
	frame.add(Amount_LB);
	frame.add(PaymentMethod_LB);
	frame.add(OrderID_LB);
	
	
	frame.add(PaymentID_txf);
	frame.add(PaymentDate_txf);
	frame.add(Amount_txf);
	frame.add(PaymentMethod_txf);
	frame.add(OrderID_txf);
	
	
	
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
		Payment Fp=new Payment();
		if(e.getSource()==insert_btn) {
			Fp.setPaymentDate(PaymentDate_txf.getText());
			Fp.setAmaunt(Amount_txf.getText());
			Fp.setPaymentMethod(PaymentMethod_txf.getText());
			Fp.setOrderID(OrderID_txf.getText());
			Fp.insertData();
		
		}
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("PaymentID");
            model.addColumn("PaymentDate");
            model.addColumn("Amount");
            model.addColumn("PaymentMethod");
            model.addColumn("OrderID");
           
            

            ResultSet resultSet = Payment.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                  model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)});
                            
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
	
	}
	else if (e.getSource()==update_btn) {
		int id=Integer.parseInt(PaymentID_txf.getText());
		Fp.setPaymentDate(PaymentDate_txf.getText());
		Fp.setAmaunt(Amount_txf.getText());
		Fp.setPaymentMethod(PaymentMethod_txf.getText());
		Fp.setOrderID(OrderID_txf.getText());
		Fp.update(id);
    }
  else {
		int id=Integer.parseInt(PaymentID_txf.getText());
		Fp.delete(id);}

  }
	
		public static void main(String[] args) {
			
			Formspayment Fp= new Formspayment();
				System.out.println(Fp);
				
			  }	
			}


