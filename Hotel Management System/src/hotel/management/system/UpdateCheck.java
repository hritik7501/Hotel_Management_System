package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
public class UpdateCheck extends JFrame implements ActionListener{
    Choice customer;
    JTextField tfroom,tfname, tfcheckin, tfpaid, tfpending;
    JButton check, update, back;
    UpdateCheck(){
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(90, 20, 200, 30);
        text.setForeground(Color.BLUE);
        add(text);
        
        
        
        
        
         JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 20);
        add(lblid);
        
        customer = new Choice();
        customer.setBounds(200, 80, 150, 25);
        add(customer);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                customer.add(rs.getString("number"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lbroom = new JLabel("Room Number");
        lbroom.setBounds(30, 120, 100, 20);
        add(lbroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 120, 150, 25);
        add(tfroom);
        
         JLabel lbname = new JLabel("Name");
        lbname.setBounds(30, 160, 100, 20);
        add(lbname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);
        
        
        JLabel lbcheckin = new JLabel("Checkin Time");
        lbcheckin.setBounds(30, 200, 100, 20);
        add(lbcheckin);
        
        tfcheckin = new JTextField();
        tfcheckin.setBounds(200, 200, 150, 25);
        add(tfcheckin);
        
        
        JLabel lbpaid = new JLabel("Amount Paid");
        lbpaid.setBounds(30, 240, 100, 20);
        add(lbpaid);
        
        tfpaid = new JTextField();
        tfpaid.setBounds(200, 240, 150, 25);
        add(tfpaid);
        
         JLabel lbpending = new JLabel("Pending Amount");
        lbpending.setBounds(30, 280, 100, 20);
        add(lbpending);
        
        tfpending = new JTextField();
        tfpending.setBounds(200, 280, 150, 25);
        add(tfpending);
        
        
        check = new JButton ("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,340,100,30);
        check.addActionListener(this);
        add(check);
        
        update= new JButton ("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,340,100,30);
        update.addActionListener(this);
        add(update);
        
        
        back= new JButton ("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,340,100,30);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
                JLabel l1 = new JLabel(i1);
                l1.setBounds(450,70,476,270);
                add(l1);
        
        setBounds(300, 200, 980, 500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       
        if(ae.getSource() == check){
         String id = customer.getSelectedItem();
         String query = "select * from customer where number = '"+id+"'";
         try{
             Conn c = new Conn();
             ResultSet rs =c.s.executeQuery(query);
             while(rs.next()){
                 tfroom.setText(rs.getString("room"));
                 tfname.setText(rs.getString("name"));
                 tfcheckin.setText(rs.getString("checkintime"));
                 tfpaid.setText(rs.getString("deposit"));
                 
                 
                 
             }
             ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
             while(rs2.next()){
                 String price = rs2.getString("price");
                 int amountpaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                 tfpending.setText(""+amountpaid);
             }
         }catch(Exception e){
             e.printStackTrace();
         }
        }else if(ae.getSource()==update){
            String number = customer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tfcheckin.getText();
            String deposit = tfpaid .getText();
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update customer set room = '"+room+"', name = '"+name+"', checkintime = '"+checkin+"', deposit = '"+deposit+"' where number = '"+number+"'");
                JOptionPane.showMessageDialog(null, "Data Updated Sucessfully");
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
                new Reception();
        }
    }
    
    
    
    
    public static void main(String[] args){
        new UpdateCheck();
    }
}