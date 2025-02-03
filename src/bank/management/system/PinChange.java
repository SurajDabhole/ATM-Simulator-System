package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
	private static final long serialVersionUID = -48788591297682474L;
	
	String pinNumber;
	JPasswordField pin,rePin;
	JButton change,back;
	
	PinChange(String pinNumber){
		this.pinNumber = pinNumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		//////////////////////////////////////////////////////////////////////////////
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setBounds(250,280,500,35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text); // to add text on the image, we have to call the add fn wrt image(by default it is wrt frame)
		
		JLabel pinText = new JLabel("New PIN");
		pinText.setBounds(165,320,180,25);
		pinText.setForeground(Color.white);
		pinText.setFont(new Font("System",Font.BOLD,16));
		image.add(pinText); 
		
		pin = new JPasswordField();
		pin.setFont(new Font("Raleway",Font.BOLD,25));
		pin.setBounds(330,320,180,25);
		image.add(pin);
		
		JLabel rePinText = new JLabel("Re-Enter New PIN");
		rePinText.setBounds(165,360,180,25);
		rePinText.setForeground(Color.white);
		rePinText.setFont(new Font("System",Font.BOLD,16));
		image.add(rePinText);
		
		rePin = new JPasswordField();
		rePin.setFont(new Font("Raleway",Font.BOLD,25));
		rePin.setBounds(330,360,180,25);
		image.add(rePin);
		
		//////////////////////////////////////////////////////////////////////////////

		change = new JButton("CHANGE");
		change.setBounds(355,485,150,30);
		change.addActionListener(this);
		image.add(change);

		back = new JButton("BACK");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		//////////////////////////////////////////////////////////////////////////////

		setSize(900,900);
		setLocation(300,0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fix: Close operation
		setUndecorated(true);
		
		setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == change) {
			try {
				String npin = pin.getText();
				String rpin = rePin.getText();
				
				if(!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Entered PIN does not match");
					return;
				}
				
				if(npin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter the new PIN");
					return;
				}
				
				if(rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
					return;
				}
				
				Conn conn = new Conn();
				
				String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
				String query2 = "update login set pinNumber = '"+rpin+"' where pinNumber = '"+pinNumber+"'";
				String query3 = "update signupthree set pinNumber = '"+rpin+"' where pinNumber = '"+pinNumber+"'";
			
				conn.s.executeUpdate(query1);
				conn.s.executeUpdate(query2);
				conn.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "PIN changed successfully");
				
				setVisible(false);
				new Transactions(npin).setVisible(true);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		else {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
	}
	
	public static void main(String [] args) {
		new PinChange("");
	}
}
