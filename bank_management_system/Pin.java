package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Pin extends JFrame implements ActionListener{
	JLabel jlabel1,jlabel2,jlabel3;
	JPasswordField jpassword,jpassword1;
	JButton jbutton,jbutton1;
	String pin,cardno;
	Pin(String pin,String cardno){
		super("Bank Management System");
		this.pin=pin;
		this.cardno=cardno;
		
		   JLabel label4 =new  JLabel("");
	        ImageIcon imageicon =new ImageIcon(this.getClass().getResource("atm4.jpg"));
	        label4.setIcon(imageicon);
	        label4.setBounds(0,0,1380,690);
	        add(label4);
		
	        jlabel1=new JLabel("CHANGE YOUR PIN");
	        jlabel1.setForeground(Color.white);
	        jlabel1.setFont(new Font("Raleway",Font.BOLD,18));
	        jlabel1.setBounds(420,150,350,30);
	        label4.add(jlabel1);
	        
	        jlabel2=new JLabel("NEW PIN");
	        jlabel2.setForeground(Color.white);
	        jlabel2.setFont(new Font("Raleway",Font.BOLD,16));
	        jlabel2.setBounds(340,220,350,30);
	        label4.add(jlabel2);
	       
	        jlabel3=new JLabel("RE-ENTER PIN");
	        jlabel3.setForeground(Color.white);
	        jlabel3.setFont(new Font("Raleway",Font.BOLD,16));
	        jlabel3.setBounds(340,260,350,30);
	        label4.add(jlabel3);
		
	        jpassword = new JPasswordField();
	        jpassword.setFont(new Font("Raleway",Font.BOLD, 18));
	        jpassword.setForeground(Color.white);
	        jpassword.setBackground(new Color(65,125,128));
	        jpassword.setBounds(480,222,150,25);
	        add(jpassword);
	        
	        jpassword1 = new JPasswordField();
	        jpassword1.setFont(new Font("Raleway",Font.BOLD, 18));
	        jpassword1.setForeground(Color.white);
	        jpassword1.setBackground(new Color(65,125,128));
	        jpassword1.setBounds(480,260,150,25);
	        add( jpassword1);
	        
	        jbutton = new JButton("CHANGE PIN");
	        jbutton.setFont(new Font("Raleway",Font.BOLD, 16));
	        jbutton.setForeground(Color.white);
	        jbutton.setBackground(new Color(65,125,128));
	        jbutton.setBounds(550,300,150,27);
	        jbutton.addActionListener(this);
	        label4.add(jbutton);
	        
	        jbutton1 = new JButton("BACK");
	        jbutton1.setFont(new Font("Raleway",Font.BOLD, 16));
	        jbutton1.setForeground(Color.white);
	        jbutton1.setBackground(new Color(65,125,128));
	        jbutton1.setBounds(550,340,150,27);
	        jbutton1.addActionListener(this);
	        label4.add(jbutton1);
		
		setLayout(null);
		setSize(1386,768);
		setLocation(0,0);
		setVisible(true);
		
	}
	  public void actionPerformed(ActionEvent e) {
		  try {
			  String pin1=jpassword.getText();
			  String pin2=jpassword1.getText();
			  if(!pin1.equals(pin2)) {
				  JOptionPane.showMessageDialog(null, "Entered PIN does not match");
				  return;
			  }
			  if(e.getSource()==jbutton) {
				  if(pin1.equals("")) {
					  JOptionPane.showMessageDialog(null, "Enter new PIN");
					  return;
				  }
				  if(pin2.equals("")) {
					  JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
					  return; 
				  }
				  Connn c= new Connn();
				  String q1="update Bank set pin='"+pin1+"' where pin ='"+pin+"'and cardno= '"+cardno+"'";
				  String q2="update Login set pin='"+pin1+"' where pin ='"+pin+"'and cardno='"+cardno+"'";
				  String q3="update Signup3 set pin='"+pin1+"' where cardno ='"+cardno+"'";
				  
				  c.statement.executeUpdate(q1);
				  c.statement.executeUpdate(q2);
				  c.statement.executeUpdate(q3);
				  
				  JOptionPane.showMessageDialog(jbutton, "PIN Change Succssesfully");
				  setVisible(false);
				  new Transaction(pin,cardno);
				  setVisible(false);
			 
			  }else if(e.getSource()==jbutton1) {
				  new Transaction(pin,cardno);
				  setVisible(false);
			  }
			  
		  }catch(Exception E) {
			  E.printStackTrace();
		  }
		
	}

	public static void main(String[] args) {
		
	//	new Pin();
	}

}
