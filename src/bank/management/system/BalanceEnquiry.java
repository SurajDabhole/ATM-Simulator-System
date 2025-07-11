package bank.management.system;

import javax.swing.*;

import java.awt.Image;
import java.awt.event.*;
//import java.sql.*;
import java.awt.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
	private static final long serialVersionUID = 4657885216024480859L;
	
	String pinNumber;
	JButton back;
	
	BalanceEnquiry(String pinNumber){
		this.pinNumber = pinNumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		//////////////////////////////////////////////////////////////////////////////
		
		back = new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
//		Conn c = new Conn();
//		
//		int balance = 0;
//		try {
//			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
//			while(rs.next()) {
//				if(rs.getString("type").equals("Deposit")) {
//					balance += Integer.parseInt(rs.getString("amount"));
//				}
//				else {
//					balance -= Integer.parseInt(rs.getString("amount"));
//				}
//			}
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
		
		// modularized code to avoid repetition of the same logic, here i needed to check available balance in three
//		different classes , so i made a seperate class/module to get the balance 
		GetBalance gb = new GetBalance();
		int balance = gb.balanceCheck(pinNumber);
		
		JLabel text = new JLabel("Your current account balance is Rs "+balance);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(170,300,400,30);
		image.add(text);
		
		//////////////////////////////////////////////////////////////////////////////

		setSize(900,900);
		setLocation(300,0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fix: Close operation
//		setUndecorated(true);

		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(pinNumber).setVisible(true);
	}
	
	public static void main(String [] args) {
		new BalanceEnquiry("");
	}
}
