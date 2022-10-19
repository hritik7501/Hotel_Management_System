
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class AddDriver extends JFrame implements ActionListener{
    JButton b1, b2;
    JTextField tname, tfcompany, tage, tfmodel, tflocation;
    JComboBox agecombo, typecombo, availablecombo,available2;
    AddDriver(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l10 = new JLabel("Add Driver");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
	l10.setBounds(150, 10, 120, 22);
	add(l10);
          
       JLabel l1 = new JLabel("Name");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	l1.setBounds(60, 70, 120, 30);
	add(l1); 
                
        
        tname = new JTextField();
	tname.setBounds(200, 70, 150, 30);
	add(tname);
        
        JLabel lavailable = new JLabel("Age");
	lavailable.setForeground(new Color(25, 25, 112));
	lavailable.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lavailable.setBounds(60, 110, 150, 30);
	add(lavailable); 
        
        tage = new JTextField();
	tage.setBounds(200, 110, 150, 30);
	add(tage);
        
       
         JLabel lclean = new JLabel("Gender");
	lclean.setForeground(new Color(25, 25, 112));
	lclean.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lclean.setBounds(60, 150, 120, 30);
	add(lclean); 
        
        String cOptions[] = {"Male", "Female"};
        agecombo = new JComboBox(cOptions);
        agecombo.setBounds(200, 150, 150, 30);
        agecombo.setBackground(Color.WHITE);
        add(agecombo);
        
        
        JLabel lprice = new JLabel("Car Company");
	lprice.setForeground(new Color(25, 25, 112));
	lprice.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lprice.setBounds(60, 190, 120, 30);
	add(lprice); 
                
        
        tfcompany = new JTextField();
	tfcompany.setBounds(200, 190, 150, 30);
	add(tfcompany);
        
        JLabel lbltype = new JLabel("Car Model");
	lbltype.setForeground(new Color(25, 25, 112));
	lbltype.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lbltype.setBounds(60, 230, 120, 30);
	add(lbltype); 
        
        tfmodel = new JTextField();
	tfmodel.setBounds(200, 230, 150, 30);
	add(tfmodel);
        
        JLabel lltype = new JLabel("Availability");
	lltype.setForeground(new Color(25, 25, 112));
	lltype.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lltype.setBounds(60, 270, 120, 30);
	add(lltype); 
        
        String driverOptions[] = {"Available", "busy"};
        available2 = new JComboBox(driverOptions);
        available2.setBounds(200, 270, 150, 30);
        available2.setBackground(Color.WHITE);
        add(available2);
        
        
        JLabel lbllocation = new JLabel("Location");
	lbllocation.setForeground(new Color(25, 25, 112));
	lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lbllocation.setBounds(60, 310, 120, 30);
	add(lbllocation); 
        
        tflocation = new JTextField();
	tflocation.setBounds(200, 310, 150, 30);
	add(tflocation);
        
        
        
        b1 = new JButton("Add Driver");
	b1.setBounds(60, 370, 130, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
	add(b1);

        b2 = new JButton("Cancel");
	b2.setBounds(220, 370, 130, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
	add(b2);
        
        
         ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l15 = new JLabel(i2);
                l15.setBounds(400,30,500,370);
                add(l15);
        setBounds(300, 200, 980, 470);
        setVisible(true);       
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String name = tname.getText();
            String age = tage.getText();
            String gender = (String)agecombo.getSelectedItem();
            String company  = tfcompany.getText();
            String brand = tfmodel.getText();
            String available = (String)available2.getSelectedItem();
            String location  = tflocation.getText();
    
            try{
               Conn conn = new Conn();
               String str = "insert into driver values( '"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+brand+"', '"+available+"', '"+location+"')";
               
               conn.s.executeUpdate(str);
               JOptionPane.showMessageDialog(null, "New Driver Successfully Added");
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
        new AddDriver();
        
    }
    
}
