
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class AddRooms extends JFrame implements ActionListener{
    JButton b1, b2;
    JTextField t4, tfroom;
    JComboBox cleancombo, typecombo, availablecombo;
    AddRooms(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l10 = new JLabel("Add Rooms");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
	l10.setBounds(194, 10, 120, 22);
	add(l10);
          
       JLabel l1 = new JLabel("Room Number");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	l1.setBounds(60, 80, 120, 30);
	add(l1); 
                
        
        t4 = new JTextField();
	t4.setBounds(200, 80, 150, 30);
	add(t4);
        
        JLabel lavailable = new JLabel("Available");
	lavailable.setForeground(new Color(25, 25, 112));
	lavailable.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lavailable.setBounds(60, 130, 120, 30);
	add(lavailable); 
        
        String availableOptions[] = {"Available", "Occupied"};
        availablecombo = new JComboBox(availableOptions);
        availablecombo.setBounds(200, 130, 150, 30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
         JLabel lclean = new JLabel("Cleaning Status");
	lclean.setForeground(new Color(25, 25, 112));
	lclean.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lclean.setBounds(60, 180, 120, 30);
	add(lclean); 
        
        String cOptions[] = {"Cleaned", "Dirty"};
        cleancombo = new JComboBox(cOptions);
        cleancombo.setBounds(200, 180, 150, 30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);
        
        
        JLabel lprice = new JLabel("Price");
	lprice.setForeground(new Color(25, 25, 112));
	lprice.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lprice.setBounds(60, 230, 120, 30);
	add(lprice); 
                
        
        tfroom = new JTextField();
	tfroom.setBounds(200, 230, 150, 30);
	add(tfroom);
        
        JLabel lbltype = new JLabel("Bed Type");
	lbltype.setForeground(new Color(25, 25, 112));
	lbltype.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lbltype.setBounds(60, 280, 120, 30);
	add(lbltype); 
        
        String typeOptions[] = {"Single Bed", "Double Bed"};
        typecombo = new JComboBox(typeOptions);
        typecombo.setBounds(200, 280, 150, 30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);
        
        
        b1 = new JButton("Add Rooms");
	b1.setBounds(60, 350, 130, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
	add(b1);

        b2 = new JButton("Cancel");
	b2.setBounds(220, 350, 130, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
	add(b2);
        
        
         ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l15 = new JLabel(i2);
                l15.setBounds(400,30,500,370);
                add(l15);
        setBounds(330, 200, 940, 470);
        setVisible(true);       
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String room = t4.getText();
            String available = (String)availablecombo.getSelectedItem();
            String status = (String)cleancombo.getSelectedItem();
            String price  = tfroom.getText();
            String type = (String)typecombo.getSelectedItem();
    
            try{
               Conn conn = new Conn();
               String str = "insert into room values( '"+room+"', '"+available+"', '"+status+"','"+price+"', '"+type+"')";
               
               conn.s.executeUpdate(str);
               JOptionPane.showMessageDialog(null, "Room Successfully Added");
                this.setVisible(false);
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
              
        }
        else{
            setVisible(false);
        }
        
    }
    
    
    public static void main(String[] args){
        new AddRooms();
        
    }
    
}
