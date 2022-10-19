
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class ManagerInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    ManagerInfo(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
                
                
         JLabel l2 = new JLabel("Name");
         l2.setBounds(40, 10, 100, 20);
         add(l2);
         
         JLabel l3 = new JLabel("Age");
         l3.setBounds(170, 10, 100, 20);
         add(l3);
         
         JLabel l4 = new JLabel("Gender");
         l4.setBounds(290, 10, 100, 20);
         add(l4);
         
         JLabel l5 = new JLabel("Job");
         l5.setBounds(400, 10, 100, 20);
         add(l5);
         
         JLabel l6 = new JLabel("Salary");
         l6.setBounds(540, 10, 100, 20);
         add(l6);
         
         JLabel l7 = new JLabel("Phone no");
         l7.setBounds(670, 10, 100, 20);
         add(l7);
         
         JLabel l8 = new JLabel("Aadhar");
         l8.setBounds(790, 10, 100, 20);
         add(l8);
         
         JLabel l9 = new JLabel("Email");
         l9.setBounds(910, 10, 100, 20);
         add(l9);
         
         table = new JTable();
         table.setBounds(0, 40, 1000, 400);
         add(table);
                
         try{
             Conn c = new Conn();
             
	     ResultSet rs = c.s.executeQuery("select * from employee where job = 'Manager'");
	     table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
             e.printStackTrace();
         }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(420, 500, 120, 30);
                add(back);
        
        
        
        setBounds(300, 200, 1000, 600);
        setVisible(true);
        
    }
    
    public void actionPerformed (ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args){
        new ManagerInfo();
    }
    
}
