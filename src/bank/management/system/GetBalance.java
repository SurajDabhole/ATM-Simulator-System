package bank.management.system;

import java.sql.ResultSet;

public class GetBalance{
	public int balanceCheck(String pinNumber) {
		Conn c = new Conn();
		
		int balance = 0;
		try {
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}
				else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return balance;
	}
	public static void main(String [] args) {
		
	}
}