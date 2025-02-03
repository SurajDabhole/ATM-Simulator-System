package bank.management.system;

import javax.swing.*;
import java.awt.Color; // to set background color of the frame
import java.awt.Font;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
	private static final long serialVersionUID = -4216056330929718529L;
	
	JTextField pan,aadhar;
	JButton next;
	JRadioButton male,female,other,married,unmarried;
	JComboBox<String> religion,category,occupation,education,income;
	JRadioButton syes,sno,eyes,eno;
	String formno;
	
    SignupTwo(String formno) {
    	this.formno = formno;
    	
        // Creating the frame
    	setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setSize(850, 800);
        setLocation(350, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fix: Close operation
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel _religion = new JLabel("Religion:");
        _religion.setFont(new Font("Raleway", Font.BOLD, 20));
        _religion.setBounds(100, 140, 100, 30);
        add(_religion);

        String [] valReligion = {"Hindu","Muslim","Christian","Buddha","Other"};
        religion = new JComboBox<>(valReligion);  // this is for making the drop-down
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);

        JLabel _category = new JLabel("Category:");
        _category.setFont(new Font("Raleway", Font.BOLD, 20));
        _category.setBounds(100, 190, 200, 30);
        add(_category);

        String valCategory [] = {"General","OBC","SC","ST","EWS","Other"};
        category = new JComboBox<>(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);

        JLabel _income = new JLabel("Income:");
        _income.setFont(new Font("Raleway", Font.BOLD, 20));
        _income.setBounds(100, 240, 200, 30);
        add(_income);
        
        String incCategory [] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","< 10,00,000",">= 10,00,000"};
        income = new JComboBox<>(incCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.white);
        add(income);
        
        JLabel _education = new JLabel("Educational");
        _education.setFont(new Font("Raleway", Font.BOLD, 20));
        _education.setBounds(100, 290, 200, 30);
        add(_education);

        JLabel _qualification = new JLabel("Qualification:");
        _qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        _qualification.setBounds(100, 315, 200, 30);
        add(_qualification);

        String [] educationValues = {"Non-Graduate","Graduate","Post-Graduate","Docterate","Other"};
        education = new JComboBox<>(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.white);
        add(education);
        
        JLabel _occupation = new JLabel("Occupation:");
        _occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        _occupation.setBounds(100, 390, 200, 30);
        add(_occupation);

        String [] occupationValues = {"Salaried","Self-Employed","Business","Student","Retired","Other"};
        occupation = new JComboBox<>(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.white);
        add(occupation);
        
        JLabel _panNo = new JLabel("PAN Number:");
        _panNo.setFont(new Font("Raleway", Font.BOLD, 20));
        _panNo.setBounds(100, 440, 200, 30);
        add(_panNo);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel _aadharNo = new JLabel("Aadhar Number:");
        _aadharNo.setFont(new Font("Raleway", Font.BOLD, 20));
        _aadharNo.setBounds(100, 490, 200, 30);
        add(_aadharNo);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.white);
        add(sno);
        
        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);
        
        JLabel pinCode = new JLabel("Existing Account:");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        pinCode.setBounds(100, 590, 200, 30);
        add(pinCode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.white);
        add(eno);
        
        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(eyes);
        accountGroup.add(eno);

        next = new JButton("Next");
        next.setBackground(new Color(145,160,123));
        next.setForeground(Color.black);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        // Set visibility at the end
        setVisible(true);
	}
	
    
 // extracting user entered values and storing them in the database
 	public void actionPerformed(ActionEvent ae) {
 		String sreligion = (String) religion.getSelectedItem(); // extracting the value from drop-down
 		String scategory = (String) category.getSelectedItem();
 		String sincome = (String) income.getSelectedItem(); // extracting the date
 		String seducation = (String) education.getSelectedItem();
 		String soccupation = (String) occupation.getSelectedItem();
 		
 		String seniorCitizen = null;
 		if(syes.isSelected()) seniorCitizen = "Yes";
 		else if (sno.isSelected())seniorCitizen = "No";
 	
 		String existingAccount = null;
 		if(eyes.isSelected()) existingAccount = "Yes";
 		else if(eno.isSelected()) existingAccount = "No";
 		
 		String span = pan.getText();
 		String saadhar = aadhar.getText();
 		
 		try {
 			if(sreligion.equals("")) {
 				JOptionPane.showMessageDialog(null, "Religion is required");
 			} else if(scategory.equals("")) {
 				JOptionPane.showMessageDialog(null, "Category is required");
 			} else if(sincome.equals("")) {
 				JOptionPane.showMessageDialog(null, "Income is required");
 			} else if(seducation.equals("")) {
 				JOptionPane.showMessageDialog(null, "Educational qualification is required");
 			} else if(soccupation.equals("")) {
 				JOptionPane.showMessageDialog(null, "Occupation is required");
 			} else if(seniorCitizen.equals("")) {
 				JOptionPane.showMessageDialog(null, "Senior citizen is required");
 			} else if(existingAccount.equals("")) {
 				JOptionPane.showMessageDialog(null, "Existing account is required");
 			} else if(span.equals("")) {
 				JOptionPane.showMessageDialog(null, "Pan number is required");
 			} else if(saadhar.equals("")) {
 				JOptionPane.showMessageDialog(null, "Aadhar number is required");
 			} else {
 				Conn c = new Conn();
 				String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+seniorCitizen+"','"+existingAccount+"','"+span+"','"+saadhar+"')";
 				c.s.executeUpdate(query);
 				
 				setVisible(false);
 				new SignupThree(formno).setVisible(true);
 			}
 		}
 		catch(Exception e) {
 			System.out.println(e);
 		}
 	}
 	
    
	public static void main(String [] args) {
		new SignupTwo("");
	}
}
