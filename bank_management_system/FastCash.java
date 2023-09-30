package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

import javax.swing.*;

public class FastCash extends JFrame implements ActionListener {
	
	JLabel jlabel1;
	JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7;
	String pin,cardno;
	
	FastCash(String pin,String cardno){
		super("Bank Management System");
		this.pin=pin;
		this.cardno=cardno;
		
		JLabel label4 =new  JLabel("");
        ImageIcon imageicon =new ImageIcon(this.getClass().getResource("atm4.jpg"));
        label4.setIcon(imageicon);
        label4.setBounds(0,0,1380,690);
        add(label4);
		
        jlabel1=new JLabel("SELECT WITHDRAWAL AMOUNT");
        jlabel1.setForeground(Color.white);
        jlabel1.setFont(new Font("Raleway",Font.BOLD,20));
        jlabel1.setBounds(360,140,350,30);
        label4.add(jlabel1);
        
        btn1 = new JButton("Rs. 100");
        btn1.setForeground(Color.white);
        btn1.setFont(new Font("Raleway",Font.BOLD,16));
        btn1.setBackground(new Color(65,125,128));
        btn1.setBounds(340,220,150,30);
        btn1.addActionListener(this);
        label4.add(btn1);
     
        btn2 = new JButton("Rs. 500");
        btn2.setForeground(Color.white);
        btn2.setFont(new Font("Raleway",Font.BOLD,16));
        btn2.setBackground(new Color(65,125,128));
        btn2.setBounds(530,220,170,30);
        btn2.addActionListener(this);
        label4.add(btn2);
        
        btn3 = new JButton("Rs. 1000");
        btn3.setForeground(Color.white);
        btn3.setFont(new Font("Raleway",Font.BOLD,16));
        btn3.setBackground(new Color(65,125,128));
        btn3.setBounds(340,258,150,30);
        btn3.addActionListener(this);
        label4.add(btn3);
        
        btn4 = new JButton("Rs. 2000");
        btn4.setForeground(Color.white);
        btn4.setFont(new Font("Raleway",Font.BOLD,16));
        btn4.setBackground(new Color(65,125,128));
        btn4.setBounds(530,258,170,30);
        btn4.addActionListener(this);
        label4.add(btn4);
        
        btn5 = new JButton("Rs. 5000");
        btn5.setForeground(Color.white);
        btn5.setFont(new Font("Raleway",Font.BOLD,16));
        btn5.setBackground(new Color(65,125,128));
        btn5.setBounds(530,300,170,30);
        btn5.addActionListener(this);
        label4.add(btn5);
        
        btn6 = new JButton("Rs. 10000");
        btn6.setForeground(Color.white);
        btn6.setFont(new Font("Raleway",Font.BOLD,16));
        btn6.setBackground(new Color(65,125,128));
        btn6.setBounds(340,300,150,30);
        btn6.addActionListener(this);
        label4.add(btn6);
        
        btn7 = new JButton("BACK");
        btn7.setForeground(Color.white);
        btn7.setFont(new Font("Raleway",Font.BOLD,16));
        btn7.setBackground(new Color(65,125,128));
        btn7.setBounds(530,340,170,30);
        btn7.addActionListener(this);
        label4.add( btn7);
        
		setLayout(null);
		setSize(1386,768);
		setLocation(0,0);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
	        
			if (e.getSource()==btn7) {
	            setVisible(false);
	            new Transaction(pin,cardno);
	        }else {
	            String amount = ((JButton)e.getSource()).getText().substring(4);
	            Connn c = new Connn();
	            Date date = new Date();
	            try{
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
	       					 
	            }catch (Exception E){
	                E.printStackTrace();
	            }
			new Transaction(pin,cardno);
			setVisible(false);
	   
		}
	
	}

	public static void main(String[] args) {
		//new FastCash("");

	}
	
}
