package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame{
	private static final long serialVersionUID = -1632314325868245959L;
	
	MiniStatement(String pinNumber){
		setTitle("Mini Statement");
		setLayout(null);
		
		//////////////////////////////////////////////////////////////////////////////
		
		JLabel bank = new JLabel("Bank of Maharashtra");
		bank.setBounds(125,20,200,20);
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		JLabel balance = new JLabel();
		balance.setBounds(20,400,300,20);
		add(balance);
		
		//////////////////////////////////////////////////////////////////////////////
		
		JLabel mini = new JLabel();
		mini.setBounds(20,150,400,200);
		add(mini);
		
		try {
			Conn conn = new Conn();
			String query1 = "Select * from login where pinNumber = '"+pinNumber+"'";
			ResultSet rs = conn.s.executeQuery(query1);
			
			while(rs.next()) {
				card.setText("Card Number: " + rs.getString("cardNumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			Conn conn = new Conn();
			String query = "Select * from bank where pin = '"+pinNumber+"'";
			ResultSet rs = conn.s.executeQuery(query);
			
			int bal = 0;
			while(rs.next()) {
				mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")  + "<br><br><html>");
				
				if(rs.getString("type").equals("Deposit")) {
					bal += Integer.parseInt(rs.getString("amount"));
				}
				else {
					bal -= Integer.parseInt(rs.getString("amount"));
				}
			}
			
			balance.setText("Your current account balance is Rs. " + bal);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		//////////////////////////////////////////////////////////////////////////////

		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fix: Close operation

		setVisible(true);
	}
	
	public static void main(String [] args) {
		new MiniStatement("");
	}

}
