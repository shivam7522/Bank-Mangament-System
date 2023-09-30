package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Bal_Enquiry extends JFrame implements ActionListener{
	
	JLabel jlabel1,jlabel2;
	JTextField jtextfield;
	JButton btn1;
	int balance=0;
	
	String pin,cardno;
	
	Bal_Enquiry(String pin,String cardno){
		super("Bank Management System");
		this.pin=pin;
		this.cardno=cardno;
		
		JLabel label4 =new  JLabel();
        ImageIcon imageicon =new ImageIcon(this.getClass().getResource("atm4.jpg"));
        label4.setIcon(imageicon);
        label4.setBounds(0,0,1380,690);
        add(label4);
        
        jlabel1=new JLabel("Your Current Balance is Rs.");
        jlabel1.setForeground(Color.white);
        jlabel1.setFont(new Font("Raleway",Font.BOLD,16));
        jlabel1.setBounds(360,140,350,30);
        label4.add(jlabel1);
        
        jlabel2=new JLabel("");
        jlabel2.setForeground(Color.white);
        jlabel2.setFont(new Font("Raleway",Font.BOLD,16));
        jlabel2.setBounds(360,180,350,30);
        label4.add(jlabel2);
       
        btn1 = new JButton("BACK");
        btn1.setForeground(Color.white);
        btn1.setBackground(new Color(65,125,128));
        btn1.setBounds(530,340,170,30);
        btn1.addActionListener(this);
        label4.add(  btn1);
        
        try {
			
			Connn c=new Connn();
			ResultSet resultSet=c.statement.executeQuery("select *from Bank where pin='"+pin+"'");
			while(resultSet.next()) {
				if(resultSet.getString("type").equals("Deposit")) {
					 balance +=Integer.parseInt(resultSet.getString("amount"));
				 }else{
					 balance -=Integer.parseInt(resultSet.getString("amount"));
					 
				 }	
			}
			
		}catch(Exception E) {
			E.printStackTrace();
		}
         
       jlabel2.setText(""+balance);
	
	
		setLayout(null);
		setSize(1550,768);
		setLocation(0,0);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Transaction(pin,cardno);
		setVisible(false);
	}

	public static void main(String[] args) {
		//new Bal_Enquiry("");

	}

}
