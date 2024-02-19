package Formpromotion;

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

import Promotions.Promotion;

public class Formspromotion  implements ActionListener{
	JFrame frame;
	JLabel PromotionID_LB=new JLabel("PROMOTIONID");
	JLabel DiscountAmount_LB=new JLabel("DISCOAMOUNT");
	JLabel ExpirationDate_LB=new JLabel("EXPIRATIONDATE");
	
	
	JTextField PromotionID_txf=new JTextField();
	JTextField DiscountAmount_txf=new JTextField();
	JTextField ExpirationDate_txf=new JTextField();

	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
int w=(int)screensize.getWidth();
int H=(int)screensize.getHeight();

public Formspromotion() {
CreateForm();
}
	private void CreateForm() {
	frame=new JFrame();
	frame.setTitle("Promotion form");
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
		PromotionID_LB.setBounds(10,10,100,30);
		DiscountAmount_LB.setBounds(10,50,100,30);
		ExpirationDate_LB.setBounds(10,90,100,30);
		
		
		PromotionID_txf.setBounds(150,10,130,30);
		DiscountAmount_txf.setBounds(150,50,130,30);
		ExpirationDate_txf.setBounds(150,90,130,30);
		
		
		insert_btn.setBounds(10, 250, 85, 30);
		read_btn.setBounds(110, 250, 85, 30);
		update_btn.setBounds(210, 250, 85, 30);
		delete_btn.setBounds(310, 250, 85, 30);
		 table.setBounds(500, 10, 600, 240);
	}
	private void addcomponentforFrame() {
	frame.add(PromotionID_LB);
	frame.add(DiscountAmount_LB);
	frame.add(ExpirationDate_LB);
	
	frame.add(PromotionID_txf);
	frame.add(DiscountAmount_txf);
	frame.add(ExpirationDate_txf);
	
	
	
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
		Promotion Fpr=new Promotion ();
		if(e.getSource()==insert_btn) {
			Fpr.setDiscountAmaunt(DiscountAmount_txf.getText());
			Fpr.setExpirationDate(ExpirationDate_txf.getText());
			Fpr.insertData();
		
		}
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("PromotionID");
            model.addColumn("DiscountAmount");
            model.addColumn("ExpirationDate");
           
            

            ResultSet resultSet = Promotion.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                  model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)});
                            
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
	
	}
	else if (e.getSource()==update_btn) {
		int id=Integer.parseInt(PromotionID_txf.getText());
		Fpr.setDiscountAmaunt(DiscountAmount_txf.getText());
		Fpr.setExpirationDate(ExpirationDate_txf.getText());
		Fpr.update(id);
    }
  else {
		int id=Integer.parseInt(PromotionID_txf.getText());
		Fpr.delete(id);}

  }
	
		public static void main(String[] args) {
			
			Formspromotion Fpr= new Formspromotion();
				System.out.println(Fpr);
				
			  }	
			}






