package bank_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;


public class Withdrawal extends JFrame implements ActionListener {
	JLabel label4 ,jlabel1;
	JTextField jtextfield;
	JButton jbutton,jbutton1;
	String pin,cardno;
	
	
	Withdrawal(String pin,String cardno){
		super("Bank Management System");
		this.pin=pin;
		this.cardno=cardno;
		
		    label4 =new  JLabel("");
	        ImageIcon imageicon =new ImageIcon(this.getClass().getResource("atm4.jpg"));
	        label4.setIcon(imageicon);
	        label4.setBounds(0,0,1380,690);
	        add(label4);
	        
	        jlabel1=new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAWAL");
	        jlabel1.setForeground(Color.white);
	        jlabel1.setFont(new Font("Raleway",Font.BOLD,14));
	        jlabel1.setBounds(360,140,360,35);
	        label4.add(jlabel1);
		
	        jtextfield = new JTextField();
	        jtextfield.setFont(new Font("Raleway",Font.BOLD, 18));
	        jtextfield.setForeground(Color.white);
	        jtextfield.setBackground(new Color(65,125,128));
	        jtextfield.setBounds(360,180,320,27);
	        add(jtextfield);
	        
	        jbutton = new JButton("WITHDRAWAL");
	        jbutton.setFont(new Font("Raleway",Font.BOLD, 16));
	        jbutton.setForeground(Color.white);
	        jbutton.setBackground(new Color(65,125,128));
	        jbutton.setBounds(550,300,150,30);
	        jbutton.addActionListener(this);
	        label4.add(jbutton);
	        
	        jbutton1 = new JButton("BACK");
	        jbutton1.setFont(new Font("Raleway",Font.BOLD, 16));
	        jbutton1.setForeground(Color.white);
	        jbutton1.setBackground(new Color(65,125,128));
	        jbutton1.setBounds(550,340,150,30);
	        jbutton1.addActionListener(this);
	        label4.add(jbutton1);
	        
		setLayout(null);
		setSize(1550,768);
		setLocation(0,0);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource()==jbutton) {
			 String amount=jtextfield.getText();
			 Date date=new Date();
				 if(jtextfield.getText().equals("")) {
					 JOptionPane.showMessageDialog(null,"Plese Enter the Amount You Want to Withdrawal");
				 }else { 
					 Connn c=new Connn();
					 ResultSet resultSet= c.statement.executeQuery("select *from Bank where pin='"+pin+"'");
					 int balance=0;
					 while(resultSet.next()) {
						 if(resultSet.getString("type").equals("Deposit")) {
							 balance +=Integer.parseInt(resultSet.getString("amount"));
						 }else{
							 balance -=Integer.parseInt(resultSet.getString("amount"));
							 
						 }
						 
					 }if(balance <Integer.parseInt(amount)) {
						 JOptionPane.showMessageDialog(null,"Insufficiant Balance ");
						 return;
					 }
					 
					 c.statement.executeUpdate("insert into Bank values('"+pin+"','"+date+"' ,'Withdrawal','"+amount+"','"+cardno+"')");
					 JOptionPane.showMessageDialog(null,"Rs"+amount+" Withdrawal Successfully");
					 setVisible(false);
					 new Transaction(pin,cardno);
					 setVisible(false);
				 }
			}else if(e.getSource()==jbutton1){
				setVisible(false);
				new Transaction(pin,cardno);
				setVisible(false);
				
				
			}
				 
			 }catch(Exception E) {
			E.printStackTrace();
			
		}
	}
		

	public static void main(String[] args) {
		//new Withdrawal("");

	}

}
