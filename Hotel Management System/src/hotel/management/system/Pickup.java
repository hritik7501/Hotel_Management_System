
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back, submit;
    Choice Typeofcar;
    JCheckBox available;
    Pickup(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
         
        
        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);
                
        
        JLabel lbed = new JLabel("Type of Car");
        lbed.setBounds(50, 100, 100, 20);
        add(lbed);
                
        Typeofcar = new Choice();
        Typeofcar.setBounds(150, 100, 200, 25);
        add(Typeofcar);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                Typeofcar.add(rs.getString("brand"));
            }
        }   catch(Exception e){
            e.printStackTrace();
        }     
                
     
         
         JLabel l2 = new JLabel("Name");
         l2.setBounds(30, 160, 100, 20);
         add(l2);
         
         JLabel l3 = new JLabel("Age");
         l3.setBounds(200, 160, 100, 20);
         add(l3);
         
         JLabel l4 = new JLabel("Gender");
         l4.setBounds(330, 160, 100, 20);
         add(l4);
         
         JLabel l5 = new JLabel("Company");
         l5.setBounds(460, 160, 100, 20);
         add(l5);
         
         JLabel l6 = new JLabel("Brand");
         l6.setBounds(630, 160, 100, 20);
         add(l6);
         
         JLabel l7 = new JLabel("Availavilty");
         l7.setBounds(740, 160, 100, 20);
         add(l7);
         
         JLabel l8 = new JLabel("Location");
         l8.setBounds(890, 160, 100, 20);
         add(l8);
         
         table = new JTable();
         table.setBounds(0, 200, 1000, 300);
         add(table);
                
         try{
             Conn c = new Conn();
             
	     ResultSet rs = c.s.executeQuery("select * from driver");
	     table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
             e.printStackTrace();
         }
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
                submit.setBounds(300, 520, 120, 30);
                add(submit);
                
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
                back.setBounds(500, 520, 120, 30);
                add(back);
        
        
        
        setBounds(300, 200, 1000, 600);
        setVisible(true);
        
    }
    
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == submit){
            try{
                String query1 = "select * from driver where brand = '"+Typeofcar.getSelectedItem()+"'";
                
                Conn conn = new Conn();
                ResultSet rs;
                rs = conn.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
               }catch(Exception e){
                e.printStackTrace();
            }
        }else{
        
        setVisible(false);
        new Reception();
        }
    }
    public static void main(String[] args){
        new Pickup();
    }
    
}

