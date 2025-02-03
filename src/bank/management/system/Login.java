package bank.management.system;

import javax.swing.*; // importing the swing package from extended java libraries
					// swing is used for making frames
import java.awt.*;
import java.awt.event.*; // to handle the events using ActionListener
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	private static final long serialVersionUID = 3394143871196151059L;
	
	JButton login, signup, clear; // globally defining buttons so that we can use them everywhere in the class without worrying about the scope
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	Login(){
		setTitle("Automated Teller Machine : ATM"); // setting the title for the frame
		
		setLayout(null); // changes the default layout of border type, now we customize our layout
		
		// adding the image icon on the frame
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); // The ImageIcon class is used to create an icon from an image file. This line creates an ImageIcon object using the URL of the resource (logo.jpg).
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2); // changing image to imageIcon because we cannot pass image to JLabel
		JLabel label = new JLabel(i3); // A JLabel is a Swing component used to display text or images. In this case, the JLabel is being created with the ImageIcon object, meaning it will display the image (logo.jpg).
		label.setBounds(70, 10, 100, 100); // setting the boundaries (left,up,height,width) => left and up wrt frame
		add(label); // This adds the JLabel (containing the image) to the current container (e.g., a JFrame or JPanel). The add() method is part of the Container class in Swing, and it places the component (in this case, the label with the image) into the UI.
		
		// adding a new text label to the frame
		JLabel text = new JLabel("Welcome to ATM"); 
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(200,40,400,40);
		add(text);
		
		// adding the text cardno
		JLabel cardno = new JLabel("Card No:"); 
		cardno.setFont(new Font("Raleway",Font.BOLD,28));
		cardno.setBounds(120,150,150,30);
		add(cardno);
		
		// adding the text field for card number
		cardTextField = new JTextField();
		cardTextField.setBounds(300,150,230,30);
		cardTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(cardTextField);
		
		// adding the text PIN
		JLabel pin = new JLabel("PIN:"); 
		pin.setFont(new Font("Raleway",Font.BOLD,28));
		pin.setBounds(120,220,250,30);
		add(pin);
		
		// adding the text field for PIN
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300,220,230,30);
		pinTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(pinTextField);
		
		// adding the sign-in, sign-up buttons
		login = new JButton("SIGN IN");
		login.setBounds(300,300,100,30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this); // to check if any activity is performed using buttons
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(430,300,100,30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this); // to check if any activity is performed using buttons
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(300,350,230,30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.addActionListener(this); // to check if any activity is performed using buttons
		add(signup);
		
		// setting the bg-color of the frame to white
		getContentPane().setBackground(Color.white); 
		
		setSize(800,480); // sets the length and width of the frame 
		setVisible(true); // makes the frame visible to the user, it is set to false by default
		setLocation(350,200); // sets the starting location of the frame
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fix: Close operation
	}
	
	// overwriting the abstract methods of ActionListener interface
	public void actionPerformed(ActionEvent ae) {
		// clears the contents of input field upon the click on clear button
		if(ae.getSource() == clear) {
			cardTextField.setText(""); 
			pinTextField.setText("");
		} 
		else if(ae.getSource() == login) {
			Conn conn = new Conn();
			
			String cardNumber = cardTextField.getText();
			
			@SuppressWarnings("deprecation")
			String pinNumber = pinTextField.getText();
			
			String query = "select * from login where cardNumber = '"+cardNumber+"' and pinNumber = '"+pinNumber+"'";
			
			try {
				ResultSet rs = conn.s.executeQuery(query); // we are running ddl command this time
				
				if(rs.next()) {
					setVisible(false);
					new Transactions(pinNumber).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
		} 
		else if(ae.getSource() == signup) {
			setVisible(false);
			new SignupOne().setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new Login(); // making an object of the class 		
	}
}
