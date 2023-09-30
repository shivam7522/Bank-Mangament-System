package bank_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener {
	JLabel label4 ,jlabel1;
	JTextField jtextfield;
	JButton jbutton,jback;
	int balance;
	String pin,cardno;
	Deposit(String pin, String cardno){
		super("Bank Management System");
		this.pin=pin;
		this.cardno=cardno;
		
		    label4 =new  JLabel("");
	        ImageIcon imageicon =new ImageIcon(this.getClass().getResource("atm4.jpg"));
	        label4.setIcon(imageicon);
	        label4.setBounds(0,0,1380,690);
	        add(label4);
	        
	        jlabel1=new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
	        jlabel1.setForeground(Color.white);
	        jlabel1.setFont(new Font("Raleway",Font.BOLD,16));
	        jlabel1.setBounds(360,140,350,30);
	        label4.add(jlabel1);
		
	        jtextfield = new JTextField();
	        jtextfield.setFont(new Font("Raleway",Font.BOLD, 18));
	        jtextfield.setForeground(Color.white);
	        jtextfield.setBackground(new Color(65,125,128));
	        jtextfield.setBounds(360,180,320,27);
	        add(jtextfield);
	        
	        jbutton = new JButton("DEPOSIT");
	        jbutton.setFont(new Font("Raleway",Font.BOLD, 16));
	        jbutton.setForeground(Color.white);
	        jbutton.setBackground(new Color(65,125,128));
	        jbutton.setBounds(590,300,110,25);
	        jbutton.addActionListener(this);
	        label4.add(jbutton);
	        
	        jback = new JButton("BACK");
	        jback.setFont(new Font("Raleway",Font.BOLD, 16));
	        jback.setForeground(Color.white);
	        jback.setBackground(new Color(65,125,128));
	        jback.setBounds(590,340,110,25);
	        jback.addActionListener(this);
	        label4.add(jback);
	        
		setLayout(null);
		setSize(1386,768);
		setLocation(0,0);
		setVisible(true);
		
	}
	 @Override
	    public void actionPerformed(ActionEvent e) {
		 try {
			 String amount=jtextfield.getText();
			 Date date=new Date();
			 if(e.getSource()==jbutton) {
				 if(jtextfield.getText().equals("")) {
					 JOptionPane.showMessageDialog(null,"Plese Enter the Amount You Want to Deposit");
				 }else { 
					 Connn c=new Connn();
					 c.statement.executeUpdate("insert into Bank values('"+pin+"','"+date+"' ,'Deposit','"+amount+"','"+cardno+"')");
					 JOptionPane.showMessageDialog(null,"Rs "+amount+" Deposit successfully"); 
					 setVisible(false);
					 new Transaction(pin,cardno);
				 }
			 }else if(e.getSource()==jback){
				 setVisible(false);
				new Transaction(pin,cardno);
				 
			 }
			 
			 
		 }catch (Exception E){
	            E.printStackTrace();
	        }

	    }

	public static void main(String[] args) {
		//new Deposit("");

	}

}
