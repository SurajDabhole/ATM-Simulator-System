package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date; // not using java.util.* because of compile time ambiguity in Date() class

public class FastCash extends JFrame implements ActionListener{
	private static final long serialVersionUID = -7828845257190257213L;

	JButton rs100,rs500,rs1000,rs2000,rs5000,rs10000,back;
	String pinNumber;
	
	FastCash(String pinNumber){
		this.pinNumber = pinNumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		//////////////////////////////////////////////////////////////////////////////

		JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(215,300,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text); // to add text on the image, we have to call the add fn wrt image(by default it is wrt frame)
		
		rs100 = new JButton("Rs 100");
		rs100.setBounds(170,415,150,30);
		rs100.addActionListener(this);
		rs100.add(rs100);
		
		rs500 = new JButton("Rs 500");
		rs500.setBounds(355,415,150,30);
		rs500.addActionListener(this);
		image.add(rs500);
		
		rs1000 = new JButton("Rs 1000");
		rs1000.setBounds(170,450,150,30);
		rs1000.addActionListener(this);
		rs1000.add(rs1000);
		
		rs2000 = new JButton("Rs 2000");
		rs2000.setBounds(355,450,150,30);
		rs2000.addActionListener(this);
		image.add(rs2000);
		
		rs5000 = new JButton("Rs 5000");
		rs5000.setBounds(170,485,150,30);
		rs5000.addActionListener(this);
		image.add(rs5000);
		
		rs10000 = new JButton("Rs 10000");
		rs10000.setBounds(355,485,150,30);
		rs10000.addActionListener(this);
		image.add(rs10000);
		
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
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back) {
			setVisible(true);
			new Transactions(pinNumber).setVisible(true);
		} 
		else{
			String amount = ((JButton) ae.getSource()).getText().substring(3);
			
			Conn c = new Conn();
			
			try {
				ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
				
				int balance = 0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
					}
					else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				
				if(ae.getSource() != back && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				
				Date date = new Date();
				String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdrawl','"+amount+"')";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Rs "+ amount + " debited successfully");
				
				setVisible(true);
				new Transactions(pinNumber).setVisible(true);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		} 
	}
	
	public static void main(String [] args) {
		new FastCash("");
	}
}
