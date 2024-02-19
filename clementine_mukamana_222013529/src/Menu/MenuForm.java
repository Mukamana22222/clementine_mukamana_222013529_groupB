 package Menu;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;

 import javax.swing.JFrame;
 import javax.swing.JMenu;
 import javax.swing.JMenuBar;
 import javax.swing.JMenuItem;

import Formcategory.Formscategory;
import Formcustomer.Formscustomer;
import Formorder.Formsorder;
import Formpayment.Formspayment;
import Formproduct.Formsproduct;
import Formpromotion.Formspromotion;
import Formsupplier.Formssupplier;

 public class MenuForm implements ActionListener {
 	JFrame frame;
 	JMenu home,  supplier, customer,category,payment,promotion,product,order, more;
 	JMenuItem i1, i2, i3, i4, i5, i6, item1, item2,PatientDelete,PatientUpdate,PatientRead;
 	JMenuItem supplierDelete,supplierUpdate,supplierRead;
 	JMenuItem customerDelete,customerUpdate,customerRead;
 	JMenuItem categoryDelete,categoryUpdate,categoryRead;
 	JMenuItem promotiontDelete,promotionUpdate,promotionRead;
 	JMenuItem paymentDelete,paymentUpdate,paymentRead;
 	JMenuItem productDelete,productUpdate,productRead;
 	JMenuItem orderDelete,orderUpdate,ordertRead;
 	
 	
 	public MenuForm (){
 		createWindow();
 	}
 	private void createWindow() {
 		frame = new JFrame("Menu form with main Menu");
 		frame.setSize(400, 400);

 		JMenuBar mb = new JMenuBar(); // Create a new menu bar
 		home = new JMenu("Home");
 		supplier = new JMenu("supplier");
 		customer= new JMenu("customer");
 		category = new JMenu("category");
 		promotion=new JMenu("promotion");
 		payment=new JMenu("payment");
 		product=new JMenu("product");
 		order=new JMenu("order");
 		
 		more = new JMenu("More");
 		i1 = new JMenuItem("Insert");
 		i2 = new JMenuItem("Read");
 		i3 = new JMenuItem("Update");
 		i4 = new JMenuItem("Delete");
 		i5 = new JMenuItem("Item 5");
 		i6 = new JMenuItem("Item 6");
 		more.add(i5);
 		more.add(i6);

 		home.add(i1);
 		home.add(more); // Add the 'more' submenu to the 'home' menu
 		
 		supplierRead = new JMenuItem("Read");
 		supplierUpdate = new JMenuItem("Update");
 		supplierDelete = new JMenuItem("Delete");
 		supplier.add(supplierRead);
 		supplier.add(supplierUpdate);
 		supplier.add(supplierDelete);

 		customerRead =new JMenuItem("Read");
 		customerUpdate =new JMenuItem("Update");
 		customerDelete =new JMenuItem("Delete");
 		
 		customer.add(customerRead);
 		customer.add(customerUpdate);
 		customer.add(customerDelete);
 		
 		categoryRead =new JMenuItem("Read");
 		categoryUpdate =new JMenuItem("Update");
 		categoryDelete =new JMenuItem("Delete");
 		category.add(categoryRead);
 		category.add(categoryUpdate);
 		category.add(categoryDelete);
 		
 		promotionRead =new JMenuItem("Read");
 		promotionUpdate =new JMenuItem("Update");
 		promotiontDelete =new JMenuItem("Update");
 		promotion.add(promotionRead);
 		promotion.add(promotionUpdate);
 		promotion.add(promotiontDelete);
 		
 		productRead =new JMenuItem("Read");
 		productUpdate =new JMenuItem("Update");
 		productDelete =new JMenuItem("Delete");
 		product.add(productRead);
 		product.add(productUpdate);
 		product.add(productDelete);
 		
 		paymentRead =new JMenuItem("Read");
 		paymentUpdate =new JMenuItem("Update");
 		paymentDelete =new JMenuItem("Delete");
 		payment.add(paymentRead);
 		payment.add(paymentUpdate);
 		payment.add(paymentDelete);
 		
 		ordertRead =new JMenuItem("Read");
 		orderUpdate =new JMenuItem("Update");
 		orderDelete =new JMenuItem("Delete");
 		order.add(ordertRead);
 		order.add(orderUpdate);
 		order.add(orderDelete);
 		
 		

 		

 		mb.add(home);
 		mb.add(supplier);
 		mb.add(customer);
 		mb.add(category);
 		mb.add(promotion);
 		mb.add(payment);
 		mb.add(product);
 		mb.add(order);
 		frame.setJMenuBar(mb);// Set the menu bar to the frame

 		frame.setVisible(true);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		componentsOnFrame();

 	}
 	private void componentsOnFrame() {
 		home = new JMenu("Home");
 		supplier = new JMenu("customer");
 		customer = new JMenu("customer");
 		category =new JMenu("category");
 		promotion =new JMenu("promotion");
 		payment=new JMenu("payment");
 		product =new JMenu("product");
 		order=new JMenu("order");
 		
 		
 		more = new JMenu("More");
 		i1 = new JMenuItem("Create");
 		i2 = new JMenuItem("Read");
 		i3 = new JMenuItem("Update");
 		i4 = new JMenuItem("Delete");
 		i5 = new JMenuItem("Item 5");
 		i6 = new JMenuItem("Item 6");
 		more.add(i5);
 		more.add(i6);

 		home.add(i1);
 		home.add(more);
 		supplier.add(i2);
 		supplier.add(i3);
 		supplier.add(i4);
 		customer.add(i2);
 		customer.add(i3);
 		customer.add(i4);
 		category.add(i2);
 		category.add(i3);
 		category.add(i4);
 		promotion.add(i2);
 		promotion.add(i3);
 		promotion.add(i4);
 		payment.add(i2);
 		payment.add(i3);
 		payment.add(i4);
 		product.add(i2);
 		product.add(i3);
 		product.add(i4);
 		order.add(i2);
 		order.add(i3);
 		order.add(i4);
 		addactionEvent();

 		
 		
 	}
 	private void addactionEvent() {
 		supplierRead.addActionListener(this);
 		customerRead.addActionListener(this);
 		categoryRead.addActionListener(this);
 		promotionRead.addActionListener(this);
 		productRead.addActionListener(this);
 		paymentRead.addActionListener(this);
 		ordertRead.addActionListener(this);
 		
 		
 	}
 	public static void main(String[] args) {
 		new MenuForm();

 	}

 	@Override
 	public void actionPerformed(ActionEvent e) {
 		if(e.getSource()==supplierRead) {
 	Formssupplier Fss =new Formssupplier();
 			frame.dispose();
 		}else if (e.getSource()==customerRead) {
 			Formscustomer Fc=new Formscustomer();
 			frame.dispose();
 		}else if (e.getSource()==categoryRead) {
 			Formscategory Formscategory= new Formscategory();
 			frame.dispose();
 		}else if (e.getSource()==promotionRead) {
 			Formspromotion Fpr= new Formspromotion();
 			frame.dispose();
 			}else if (e.getSource()==productRead) {
 				Formsproduct Fcpt= new Formsproduct();
 				frame.dispose();
 				}else if (e.getSource()==paymentRead) {
 					Formspayment Fp= new Formspayment();
 					frame.dispose();
 				}
 					else if (e.getSource()==ordertRead) {
 						Formsorder Fpo= new Formsorder();
 	 					frame.dispose();
 	}

 }
 }