package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Dell
 */
public class Reception extends JFrame implements ActionListener{
     JButton newcust, rooms, department, allemployee, Manager ,customers, search, pending, roomstatus, pickup, checkout;
    Reception(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        newcust = new JButton("New Customer Form");
        newcust.setBounds(10,30,200, 30);
        newcust.setBackground(Color.BLACK);
        newcust.setForeground(Color.WHITE);
        newcust.addActionListener(this);
        add(newcust);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200, 30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
        department = new JButton("Department");
        department.setBounds(10,110,200, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);
        
        allemployee = new JButton("All Employees ");
        allemployee.setBounds(10,150,200, 30);
        allemployee.setBackground(Color.BLACK);
        allemployee.setForeground(Color.WHITE);
        allemployee.addActionListener(this);
        add(allemployee);
        
        customers = new JButton("Customers Info ");
        customers.setBounds(10,190,200, 30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        customers.addActionListener(this);
        add(customers);
        
        Manager = new JButton("Manager Info ");
        Manager.setBounds(10,230,200, 30);
        Manager.setBackground(Color.BLACK);
        Manager.setForeground(Color.WHITE);
        Manager.addActionListener(this);
        add(Manager);
        
        
        checkout = new JButton("Checkout ");
        checkout.setBounds(10,270,200, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        
        pending = new JButton("Update Status ");
        pending.setBounds(10,310,200, 30);
        pending.setBackground(Color.BLACK);
        pending.setForeground(Color.WHITE);
        pending.addActionListener(this);
        add(pending);
        
        roomstatus = new JButton("Update Room Status ");
        roomstatus.setBounds(10,350,200, 30);
        roomstatus.setBackground(Color.BLACK);
        roomstatus.setForeground(Color.WHITE);
        roomstatus.addActionListener(this);
        add(roomstatus);
        
        pickup = new JButton("Pickup Service ");
        pickup.setBounds(10,390,200, 30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);
        
        search = new JButton("Search Room ");
        search.setBounds(10,430,200, 30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);
        
        JButton logout = new JButton("Logout");
        logout.setBounds(10,470,200, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        add(logout);
        
         ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(250,30,500,470);
                add(l1);
        
        setBounds(350, 200, 800, 570);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== newcust){
            setVisible(false);
            new AddCustomer();
        }else if(ae.getSource() == rooms){
          setVisible(false);
          new Room();
        }
        else if(ae.getSource() == department){
          setVisible(false);
          new Department();
        
    }else if(ae.getSource() == allemployee){
        setVisible(false);
        new EmployeeInfo();
    }
    else if(ae.getSource() == Manager){
        setVisible(false);
        new ManagerInfo();
    }else if(ae.getSource() == customers){
        setVisible(false);
        new CustomerInfo();
    }else if(ae.getSource() == search){
        setVisible(false);
        new SearchRoom();
    }else if(ae .getSource() == pending){
        setVisible(false);
        new UpdateCheck();
    
    }else if(ae.getSource() == roomstatus){
        setVisible(false);
        new UpdateRoom();
    }else if(ae.getSource() == pickup){
        setVisible(false);
        new Pickup();
    }else if(ae.getSource() == checkout){
        setVisible(false);
        new Checkout();
    }
        
    }
    
    public static void main(String[] args){
        new Reception();
    }
}
