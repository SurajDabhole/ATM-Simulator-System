package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
	private static final long serialVersionUID = -5592348808561564356L;

	JRadioButton savings,fixedDeposit,current,recurringDeposit;
	JCheckBox atm,internetBanking,mobileBanking,sms,chequeBook,eStatement,acknowledgement;
	JButton submit,cancel;
	String formno;
	
	SignupThree(String formno){
		this.formno = formno;
		
		setLayout(null);
		
		JLabel l1 = new JLabel("Page3 : Account Details");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(280,40,400,40);
		add(l1);
		
		//////////////////////////////////////////////////////////////////////////////
		JLabel type = new JLabel("Account Type");
		type.setFont(new Font("Raleway",Font.BOLD,22));
		type.setBounds(100,140,200,30);
		add(type);
		
		savings = new JRadioButton("Saving Account");
		savings.setFont(new Font("Raleway",Font.BOLD,16));
		savings.setBackground(Color.white);
		savings.setBounds(100,180,180,20);
		add(savings);
		
		fixedDeposit = new JRadioButton("Fixed Deposit Account");
		fixedDeposit.setFont(new Font("Raleway",Font.BOLD,16));
		fixedDeposit.setBackground(Color.white);
		fixedDeposit.setBounds(350,180,250,20);
		add(fixedDeposit);
		
		current = new JRadioButton("Current Account");
		current.setFont(new Font("Raleway",Font.BOLD,16));
		current.setBackground(Color.white);
		current.setBounds(100,220,180,20);
		add(current);
		
		recurringDeposit = new JRadioButton("Recurring Deposit Account");
		recurringDeposit.setFont(new Font("Raleway",Font.BOLD,16));
		recurringDeposit.setBackground(Color.white);
		recurringDeposit.setBounds(350,220,250,20);
		add(recurringDeposit);
		
		ButtonGroup groupAccount = new ButtonGroup();
		groupAccount.add(current);
		groupAccount.add(fixedDeposit);
		groupAccount.add(recurringDeposit);
		groupAccount.add(savings);
		
		//////////////////////////////////////////////////////////////////////////////
		
		JLabel card = new JLabel("Card Number:");
		card.setFont(new Font("Raleway",Font.BOLD,22));
		card.setBounds(100,300,200,30);
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-1602");
		number.setFont(new Font("Raleway",Font.BOLD,22));
		number.setBounds(330,300,300,30);
		add(number);
		
		JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
		cardDetail.setFont(new Font("Raleway",Font.BOLD,12));
		cardDetail.setBounds(100,330,300,20);
		add(cardDetail);

		//////////////////////////////////////////////////////////////////////////////

		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway",Font.BOLD,22));
		pin.setBounds(100,370,200,30);
		add(pin);
		
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway",Font.BOLD,22));
		pnumber.setBounds(330,370,300,30);
		add(pnumber);
		
		JLabel pinDetail = new JLabel("Your 4 Digit Password");
		pinDetail.setFont(new Font("Raleway",Font.BOLD,12));
		pinDetail.setBounds(100,400,300,20);
		add(pinDetail);
		
		//////////////////////////////////////////////////////////////////////////////
		
		JLabel services = new JLabel("Services Required");
		services.setFont(new Font("Raleway",Font.BOLD,22));
		services.setBounds(100,450,200,30);
		add(services);
		
		atm = new JCheckBox("ATM CARD");
		atm.setBackground(Color.white);
		atm.setFont(new Font("Raleway",Font.BOLD,16));
		atm.setBounds(100,500,200,30);
		add(atm);
		
		internetBanking = new JCheckBox("Internet Banking");
		internetBanking.setBackground(Color.white);
		internetBanking.setFont(new Font("Raleway",Font.BOLD,16));
		internetBanking.setBounds(350,500,200,30);
		add(internetBanking);
		
		mobileBanking = new JCheckBox("Mobile Banking");
		mobileBanking.setBackground(Color.white);
		mobileBanking.setFont(new Font("Raleway",Font.BOLD,16));
		mobileBanking.setBounds(100,550,200,30);
		add(mobileBanking);
		
		sms = new JCheckBox("EMAIL & SMS Alerts");
		sms.setBackground(Color.white);
		sms.setFont(new Font("Raleway",Font.BOLD,16));
		sms.setBounds(350,550,200,30);
		add(sms);
		
		chequeBook = new JCheckBox("Cheque Book");
		chequeBook.setBackground(Color.white);
		chequeBook.setFont(new Font("Raleway",Font.BOLD,16));
		chequeBook.setBounds(100,600,200,30);
		add(chequeBook);
		
		eStatement = new JCheckBox("E-Statement");
		eStatement.setBackground(Color.white);
		eStatement.setFont(new Font("Raleway",Font.BOLD,16));
		eStatement.setBounds(350,600,200,30);
		add(eStatement);
		
		acknowledgement = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
		acknowledgement.setBackground(Color.white);
		acknowledgement.setFont(new Font("Raleway",Font.BOLD,14));
		acknowledgement.setBounds(100,660,700,30);
		add(acknowledgement);
		
		//////////////////////////////////////////////////////////////////////////////

		submit = new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setFont(new Font("Raleway",Font.BOLD,14));
		submit.setBounds(250,720,100,30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Raleway",Font.BOLD,14));
		cancel.setBounds(420,720,100,30);
		cancel.addActionListener(this);
		add(cancel);
		
		//////////////////////////////////////////////////////////////////////////////

		getContentPane().setBackground(Color.white);
	
		setSize(850,820);
		setLocation(350,0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fix: Close operation
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit) {
			String accountType = null;
			if(savings.isSelected()) accountType = "Saving Account";
			else if(fixedDeposit.isSelected()) accountType = "Fixed Deposit Account";
			else if(current.isSelected()) accountType = "Current Account";
			else if(recurringDeposit.isSelected()) accountType = "Recurring Deposit Account";
			
			Random random = new Random();
			
			String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 1602050400000000L);
			String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
			
			String facility = "";
			if(atm.isSelected()) facility = facility + " ATM_Card";
			if(internetBanking.isSelected()) facility = facility + " Internet_Banking";
			if(mobileBanking.isSelected()) facility = facility + " Mobile_Banking";
			if(sms.isSelected()) facility = facility + " EMAIL_&_SMS_Alerts";
			if(chequeBook.isSelected()) facility = facility + " Cheque_Book";
			if(eStatement.isSelected()) facility = facility + " E-Statement";
			
			try {
				if(accountType.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type is required");
				} else if(cardNumber.equals("")) {
					JOptionPane.showMessageDialog(null, "Card Number is required");
				} else if(pinNumber.equals("")) {
					JOptionPane.showMessageDialog(null, "PIN is required");
				} else if(facility.equals("")) {
					JOptionPane.showMessageDialog(null, "Select atleast one facility");
				} else {
					Conn conn = new Conn();
					
					String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
					String query2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
					
					conn.s.executeUpdate(query1);
					conn.s.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null, "Your Card Number is:" + cardNumber + "\nYour Password is :"+ pinNumber + "\n Please remember your credientials");
				
					setVisible(false);
					new Deposit(pinNumber).setVisible(true);
				}
			} 
			catch(Exception e) {
				System.out.println(e);
			}
		}
		else if(ae.getSource() == cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
	}
	
	public static void main(String [] args) {
		new SignupThree("");
	}
}