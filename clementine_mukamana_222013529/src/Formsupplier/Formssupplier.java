package Formsupplier;

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

import Suppliers.Supplier;

public class Formssupplier implements ActionListener {
    JFrame frame;
    JLabel SupplierID_LB = new JLabel("SUPPLIERID");
    JLabel SupplierName_LB = new JLabel("SUPPLIERNAME");
    JLabel Phone_LB = new JLabel("PHONE");
    JLabel Email_LB = new JLabel("EMAIL");
    JLabel Address_LB = new JLabel("ADDRESS");
    JLabel Gender_LB = new JLabel("GENDER");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    JTextField SupplierID_txf = new JTextField();
    JTextField SupplierName_txf = new JTextField();
    JTextField Phone_txf = new JTextField();
    JTextField Email_txf = new JTextField();
    JTextField Address_txf = new JTextField();
    JTextField Gender_txf = new JTextField();

    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");

    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int H = (int) screensize.getHeight();

    public Formssupplier() {
        CreateForm();
    }

    private void CreateForm() {
        frame = new JFrame();
        frame.setTitle("Supplier form");
        frame.setBounds(0, 0, w / 2, H / 2);
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
        SupplierID_LB.setBounds(10, 10, 100, 30);
        SupplierName_LB.setBounds(10, 50, 100, 30);
        Phone_LB.setBounds(10, 90, 100, 30);
        Email_LB.setBounds(10, 130, 100, 30);
        Address_LB.setBounds(10, 170, 100, 30);
        Gender_LB.setBounds(10, 210, 100, 30);

        SupplierID_txf.setBounds(150, 10, 100, 30);
        SupplierName_txf.setBounds(150, 50, 100, 30);
        Phone_txf.setBounds(150, 90, 100, 30);
        Email_txf.setBounds(150, 130, 100, 30);
        Address_txf.setBounds(150, 170, 100, 30);
        Gender_txf.setBounds(150, 210, 100, 30);

        insert_btn.setBounds(10, 250, 85, 30);
        read_btn.setBounds(110, 250, 85, 30);
        update_btn.setBounds(210, 250, 85, 30);
        delete_btn.setBounds(310, 250, 85, 30);
        table.setBounds(500, 10, 600, 240);
    }

    private void addcomponentforFrame() {
        frame.add(SupplierID_LB);
        frame.add(SupplierName_LB);
        frame.add(Phone_LB);
        frame.add(Email_LB);
        frame.add(Address_LB);
        frame.add(Gender_LB);
        frame.add(SupplierID_txf);
        frame.add(SupplierName_txf);
        frame.add(Phone_txf);
        frame.add(Email_txf);
        frame.add(Address_txf);
        frame.add(Gender_txf);

        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);

    }

    public void ActionEvent() {
        insert_btn.addActionListener(this);
        read_btn.addActionListener(this);
        update_btn.addActionListener(this);
        delete_btn.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        Supplier Fss = new Supplier();
        if (e.getSource() == insert_btn) {
            Fss.setSupplierName(SupplierName_txf.getText());
            Fss.setPhone(Phone_txf.getText());
            Fss.setEmail(Email_txf.getText());
            Fss.setAddress(Address_txf.getText());
            Fss.setGender(Gender_txf.getText());
            Fss.insertData();
        } else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("SupplierID");
            model.addColumn("SupplierName");
            model.addColumn("Phone");
            model.addColumn("Email");
            model.addColumn("Address");
            model.addColumn("Gender");

            ResultSet resultSet = Supplier.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                                resultSet.getString(4), resultSet.getString(5), resultSet.getString(6) });
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == update_btn) {
            int id = Integer.parseInt(SupplierID_txf.getText());
            Fss.setSupplierName(SupplierName_txf.getText());
            Fss.setPhone(Phone_txf.getText());
            Fss.setEmail(Email_txf.getText());
            Fss.setAddress(Address_txf.getText());
            Fss.setGender(Gender_txf.getText());
            Fss.update(id);
        } else {
            int id = Integer.parseInt(SupplierID_txf.getText());
            Fss.delete(id);
        }

    }

    public static void main(String[] args) {

        Formssupplier Fss = new Formssupplier();
        

    }
}
