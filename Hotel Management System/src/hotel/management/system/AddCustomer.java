package hotel.management.system;

import javax.swing.*;
import java.awt.*;


import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox comboid;
    JTextField t1,t2,t3,t4;
    JRadioButton r1, r2;
    Choice croom;
    JLabel checkintime;
    JButton add, back;
    AddCustomer(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
                JLabel lblName = new JLabel("NEW CUSTOMER FORM");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 260, 53);
		add(lblName);
                
                JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 76, 200, 14);
                lblId.setFont(new Font("Raleway", Font.BOLD, 14));
		add(lblId);
                
                String options[] = {"Passport", "Aadhar Card", "Voter Id", "Driving license"};
                comboid = new JComboBox(options);
		comboid.setBounds(271, 73, 150, 20);
                comboid.setBackground(Color.WHITE);
		add(comboid);
                
                
                JLabel l2 = new JLabel("Number :");
		l2.setBounds(35, 111, 200, 14);
                l2.setFont(new Font("Raleway", Font.BOLD, 14));
		add(l2);
                
                t1 = new JTextField();
		t1.setBounds(271, 111, 150, 20);
		add(t1);
		
                
                JLabel lname = new JLabel("Name :");
		lname.setBounds(35, 151, 200, 14);
                lname.setFont(new Font("Raleway", Font.BOLD, 14));
		add(lname);
                
                t2 = new JTextField();
		t2.setBounds(271, 151, 150, 20);
		add(t2);
		
                JLabel lgender = new JLabel("Gender :");
		lgender.setBounds(35, 191, 200, 14);
                lgender.setFont(new Font("Raleway", Font.BOLD, 14));
		add(lgender);
                
                r1 = new JRadioButton("Male");
                r1.setFont(new Font("Raleway", Font.BOLD, 14));
                r1.setBackground(Color.WHITE);
                r1.setBounds(271, 191, 80, 12);
                add(r1);
                
                r2 = new JRadioButton("Female");
                r2.setFont(new Font("Raleway", Font.BOLD, 14));
                r2.setBackground(Color.WHITE);
                r2.setBounds(350, 191, 100, 12);
		add(r2);
                
                
                JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 231, 200, 14);
                lblCountry.setFont(new Font("Raleway", Font.BOLD, 14));
		add(lblCountry);
                
                
                t3 = new JTextField();
		t3.setBounds(271, 231, 150, 20);
		add(t3);
                
                
                JLabel lblroom = new JLabel("Allocated Room Number :");
		lblroom.setBounds(35, 271, 200, 14);
                lblroom.setFont(new Font("Raleway", Font.BOLD, 14));
		add(lblroom);
                
                croom = new Choice();
                try{
                    Conn conn = new Conn();
                    String query = "select * from room where availability = 'Available'";
                    ResultSet rs = conn.s.executeQuery(query);
                    while(rs.next()){
                        croom.add(rs.getString("roomnumber"));
                    }
                    
                }catch(Exception e){
                    e.printStackTrace();
                }
                
                croom.setBounds(271, 270, 150, 20);
                add(croom);
                
                JLabel lblCheckInStatus = new JLabel("Checked-In :");
		lblCheckInStatus.setBounds(35, 316, 200, 14);
                lblCheckInStatus.setFont(new Font("Raleway", Font.BOLD, 14));
		add(lblCheckInStatus);
                
                Date date = new Date();
                
		
		checkintime = new JLabel(" "+ date);
		checkintime.setBounds(271, 316, 200, 14);
                checkintime.setFont(new Font("Raleway", Font.BOLD, 14));
		add(checkintime);
                
                JLabel lblDeposite = new JLabel("Deposit :");
		lblDeposite.setBounds(35, 359, 200, 14);
                 lblDeposite.setFont(new Font("Raleway", Font.BOLD, 14));
		add(lblDeposite);
                
		t4 = new JTextField();
		t4.setBounds(271, 359, 150, 20);
		add(t4);
                
		add = new JButton("Add");
                add.setBackground(Color.BLACK);
                add.setForeground(Color.WHITE);
                add.setBounds(50, 410, 120, 30);
                add.addActionListener(this);
                add(add);
                
                
                back = new JButton("Back");
                back.setBackground(Color.BLACK);
                back.setForeground(Color.WHITE);
                back.setBounds(200, 410, 120, 30);
                back.addActionListener(this);
                add(back);
        
         ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
                Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(480,10,300,500);
                add(l1);
        
        
        setBounds(350, 200, 800, 550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
         String id = (String) comboid.getSelectedItem();   
         String number =  t1.getText();
	 String name =  t2.getText();
         String gender =  null;
         if(r1.isSelected()){
             gender = "Male";
         }else{
             gender = "Female";
         }
	 String country =  t3.getText();
	 String room  =  croom.getSelectedItem();
         String time =  checkintime.getText();
         String deposit = t4.getText();
         try{
             String query = "insert into customer values('"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+room+"', '"+time+"', '"+deposit+"' )";
             String query2 = "update room set availability = 'Occupied' where roomnumber = '"+room+"'";
             
             
             Conn conn = new Conn();
             
             conn.s.executeUpdate(query);
             conn.s.executeUpdate(query2);
             
             JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
             setVisible(false);
             new Reception();
             
         }catch(Exception e){
             e.printStackTrace();
         }
        }else if(ae.getSource()==back){
            setVisible(false);
             new Reception();
        }
    }
    
    public static void main(String[] args){
        new AddCustomer();
    }
}
