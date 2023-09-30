package bank_management_system;


import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JRadioButton r1,r2,m1,m2,m3;
    JButton next;
    JTextField textName ,textFname, textEmail,textAdd,textcity,textState,textPin;
    JDateChooser dateChooser;
    ButtonGroup buttonGroup1;
    Random ran = new Random();
    long first4 =(ran.nextLong() % 9000L) +1000L;
    String first = " " + Math.abs(first4);
    Signup(){
        super ("APPLICATION FORM");
        
        JLabel labelicon =new  JLabel("");
        ImageIcon imageicon =new ImageIcon(this.getClass().getResource("bank7.png"));
        labelicon.setIcon(imageicon);
        labelicon.setBounds(30,20,100,100);
        add(labelicon);
        
        JLabel label1 = new JLabel("APPLICATION FORM NO."+ first);
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Ralway",Font.BOLD, 22));
        label2.setBounds(330,70,600,30);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway", Font.BOLD,22));
        label3.setBounds(290,90,600,30);
        add(label3);

        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Raleway", Font.BOLD, 17));
        labelName.setBounds(100,140,100,27);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD, 12));
        textName.setBounds(300,140,400,27);
        add(textName);

        JLabel labelfName = new JLabel("Father's Name :");
        labelfName.setFont(new Font("Raleway", Font.BOLD, 17));
        labelfName.setBounds(100,180,200,27);
        add(labelfName);

        textFname = new JTextField();
        textFname.setFont(new Font("Raleway",Font.BOLD, 12));
        textFname.setBounds(300,180,400,27);
        add(textFname);

        JLabel DOB = new JLabel("Date of Birth");
        DOB.setFont(new Font("Raleway", Font.BOLD, 17));
        DOB.setBounds(100,280,200,30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,280,400,27);
        add(dateChooser);

        JLabel labelG = new JLabel("Gender");
        labelG.setFont(new Font("Raleway", Font.BOLD, 17));
        labelG.setBounds(100,230,200,27);
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD,12));
        r1.setBackground(new Color(222,255,228));
        r1.setBounds(300,230,60,27);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(new Color(222,255,228));
        r2.setFont(new Font("Raleway", Font.BOLD,12));
        r2.setBounds(450,230,90,27);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel labelEmail = new JLabel("Email address :");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 17));
        labelEmail.setBounds(100,330,200,27);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD, 12));
        textEmail.setBounds(300,330,400,27);
        add(textEmail);


        JLabel labelMs = new JLabel("Marital Status :");
        labelMs.setFont(new Font("Raleway", Font.BOLD, 17));
        labelMs.setBounds(100,380,200,27);
        add(labelMs);

        m1 = new JRadioButton("Married");
        m1.setBounds(300,380,100,27);
        m1.setBackground(new Color(222,255,228));
        m1.setFont(new Font("Raleway", Font.BOLD,12));
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setBackground(new Color(222,255,228));
        m2.setBounds(450,380,100,27);
        m2.setFont(new Font("Raleway", Font.BOLD,12));
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setBackground(new Color(222,255,228));
        m3.setBounds(635,380,100,27);
        m3.setFont(new Font("Raleway", Font.BOLD,12));
        add(m3);

        buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        buttonGroup1.add(m3);

        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Raleway", Font.BOLD, 17));
        labelAdd.setBounds(100,430,200,27);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway",Font.BOLD, 12));
        textAdd.setBounds(300,430,400,27);
        add(textAdd);

        JLabel labelCity = new JLabel("City :");
        labelCity.setFont(new Font("Raleway", Font.BOLD, 17));
        labelCity.setBounds(100,480,200,27);
        add(labelCity);

        textcity = new JTextField();
        textcity.setFont(new Font("Raleway",Font.BOLD, 12));
        textcity.setBounds(300,480,400,27);
        add(textcity);

        JLabel labelPin = new JLabel("Pin Code :");
        labelPin.setFont(new Font("Raleway", Font.BOLD, 17));
        labelPin.setBounds(100,530,200,27);
        add(labelPin);

        textPin = new JTextField();
        textPin.setFont(new Font("Raleway",Font.BOLD, 12));
        textPin.setBounds(300,530,400,27);
        add(textPin);

        JLabel labelstate = new JLabel("State :");
        labelstate.setFont(new Font("Raleway", Font.BOLD, 17));
        labelstate.setBounds(100,580,200,27);
        add( labelstate);

        textState = new JTextField();
        textState.setFont(new Font("Raleway",Font.BOLD, 12));
        textState.setBounds(300,580,400,27);
        add(textState);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD, 12));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,615,80,27);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(800,700);
        setLocation(20,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String formno = first;
        String name = textName.getText();
        String fname = textFname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = "";
        if(r1.isSelected()){
            gender = "Male";
        }else if (r2.isSelected()){
            gender = "Female";
        }
        String email = textEmail.getText();
        String marital ="";
        if (m1.isSelected()){
            marital = "Married";
        } else if (m2.isSelected()) {
            marital = "Unmarried";
        } else if (m3.isSelected()) {
            marital = "Other";
        }

        String address = textAdd.getText();
        String city = textcity.getText();
        String pincode = textPin.getText();
        String state = textState.getText();

        try{
            if (textName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the fields");
           
            }else if (textFname.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the fields");
                
             } else if(gender.equals("")){
            	 JOptionPane.showMessageDialog(null, "Select Your Gender");
            	 
             }
            else if (textFname.getText().equals("")){
                 JOptionPane.showMessageDialog(null, "Fill all the fields");
            	  
              }else if (textEmail.getText().equals("")){
                  JOptionPane.showMessageDialog(null, "Fill all the fields");
                  
              }else if(marital.equals("")) {
            	  JOptionPane.showMessageDialog(null, "Select Marital Status");
            	  
              }
              else  if (textAdd.getText().equals("")){
                  JOptionPane.showMessageDialog(null, "Fill all the fields");
             
              }else if (textcity.getText().equals("")){
                  JOptionPane.showMessageDialog(null, "Fill all the fields");
                  
              }else if (textState.getText().equals("")){
                  JOptionPane.showMessageDialog(null, "Fill all the fields");
            	  
              }else if (textPin.getText().equals("")){
                  JOptionPane.showMessageDialog(null, "Fill all the fields");
           
              } else {
                new Signup2(formno,name,fname,dob,gender,email,marital,address,city,pincode,state);
                setVisible(false);
                 }

        }catch (Exception E){
            E.printStackTrace();
        }

    }
//    private Object isSelected(ButtonGroup buttonGroup12) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public static void main(String[] args) {
       // new Signup("");
    }
}
