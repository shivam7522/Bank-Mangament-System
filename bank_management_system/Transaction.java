package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transaction extends JFrame implements ActionListener {
	JLabel jlabel1;
	JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7;
	String pin,cardno;
	Transaction(String pin,String cardno){
		super("Bank Management System");
		this.pin=pin;
		this.cardno=cardno;
		
		JLabel label4 =new  JLabel("");
        ImageIcon imageicon =new ImageIcon(this.getClass().getResource("atm4.jpg"));
        label4.setIcon(imageicon);
        label4.setBounds(0,0,1380,690);
        add(label4);
		
        jlabel1=new JLabel("Please Select Your Transaction");
        jlabel1.setForeground(Color.white);
        jlabel1.setFont(new Font("Raleway",Font.BOLD,22));
        jlabel1.setBounds(360,140,350,30);
        label4.add(jlabel1);
        
        btn1 = new JButton("DEPOSIT");
        btn1.setForeground(Color.white);
        btn1.setBackground(new Color(65,125,128));
        btn1.setBounds(340,220,150,30);
        btn1.addActionListener(this);
        label4.add(btn1);
     
        btn2 = new JButton("CASH WITHDRAWAL");
        btn2.setForeground(Color.white);
        btn2.setBackground(new Color(65,125,128));
        btn2.setBounds(530,220,170,30);
        btn2.addActionListener(this);
        label4.add(btn2);
        
        btn3 = new JButton("FAST CASH");
        btn3.setForeground(Color.white);
        btn3.setBackground(new Color(65,125,128));
        btn3.setBounds(340,258,150,30);
        btn3.addActionListener(this);
        label4.add(btn3);
        
        btn4 = new JButton("MINI STATEMENT");
        btn4.setForeground(Color.white);
        btn4.setBackground(new Color(65,125,128));
        btn4.setBounds(530,258,170,30);
        btn4.addActionListener(this);
        label4.add(btn4);
        
        btn5 = new JButton("BALANCE ENQUIRY");
        btn5.setForeground(Color.white);
        btn5.setBackground(new Color(65,125,128));
        btn5.setBounds(530,300,170,30);
        btn5.addActionListener(this);
        label4.add(btn5);
        
        btn6 = new JButton("PIN CHANGE");
        btn6.setForeground(Color.white);
        btn6.setBackground(new Color(65,125,128));
        btn6.setBounds(340,300,150,30);
        btn6.addActionListener(this);
        label4.add(btn6);
        
        btn7 = new JButton("EXIT");
        btn7.setForeground(Color.white);
        btn7.setBackground(new Color(65,125,128));
        btn7.setBounds(530,340,170,30);
        btn7.addActionListener(this);
        label4.add( btn7);
        
		setLayout(null);
		setSize(1386,768);
		setLocation(0,0);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try { if(e.getSource()==btn1) {
			new Deposit(pin,cardno);
			setVisible(false);
		}else if(e.getSource()==btn7) {
			System.exit(0);
		}else if(e.getSource()==btn2) {
			new Withdrawal(pin,cardno);
			setVisible(false);
			
		}else if(e.getSource()==btn5) {
			new Bal_Enquiry(pin,cardno);
			setVisible(false);
			
		}else if(e.getSource()==btn3) {
			new FastCash(pin,cardno);
			setVisible(false);
			
		}else if(e.getSource()==btn6) {
			new Pin(pin,cardno);
			setVisible(false);
		}else if(e.getSource()==btn4) {
			new Mini(pin);
			setVisible(false);
		}
			
			
		}catch(Exception E){
			E.printStackTrace();
			
		}
	}

	public static void main(String[] args) {
	
		//new Transaction("");
	}

}
