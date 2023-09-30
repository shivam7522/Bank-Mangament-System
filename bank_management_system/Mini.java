package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini extends JFrame implements ActionListener {
    String pin;
    JButton button;
    Mini(String pin){
        this.pin = pin;
        getContentPane().setBackground(new Color(255,204,204));
        setSize(400,600);
        setLocation(20,20);
        setLayout(null);

        JLabel label1 = new JLabel();
        label1.setBounds(20,140,400,200);
        label1.setFont(new Font("System", Font.BOLD,14));
        add(label1);

        JLabel label2 = new JLabel("BANK STATEMENT");
        label2.setFont(new Font("System", Font.BOLD,16));
        label2.setBounds(110,20,200,20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setFont(new Font("System", Font.BOLD,16));
        label3.setBounds(20,0,300,200);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setFont(new Font("System", Font.BOLD,16));
        label4.setBounds(20,450,300,20);
        add(label4);

        try{
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("select * from login where pin = '"+pin+"'");
            while (resultSet.next()){
                label3.setText("Card Number:  "+ resultSet.getString("cardno").substring(0,4) + "XXXXXXXX"+ resultSet.getString("cardno").substring(12));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

        try{
            int balance =0;
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("select * from Bank where pin = '"+pin+"'");
            while (resultSet.next()){

                label1.setText(label1.getText() + "<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+ "<br><html>");

                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            label4.setText("Your Total Balance is Rs "+balance);
        }catch (Exception e){
            e.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
	public static void main(String[] args) {
		new Mini("");

	}

}
