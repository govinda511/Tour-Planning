
    
 import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.Random;

import javax.swing.*;


public class Register extends JFrame implements ActionListener{
     JLabel user;
     JLabel pass;
     JLabel conf;
     JTextField un;
     JPasswordField ps;
     JPasswordField confirmps;
     JButton submit;
     JButton clear,back;
     JComboBox state;
     JPanel panel;
     JLabel st;
     JFrame jfr;
     JLabel id;
     JTextField ei;
     
     public Register(){
    	 jfr=new JFrame("Register");
    	// GridBagConstraints gbc=new GridBagConstraints();
    	panel=new javax.swing.JPanel();
 		
 		panel.setBackground(new Color(191,239,255));
 		panel.setLayout(null);
 		jfr.setSize(500,500);
    	 un=new JTextField(20);
    	 ps=new JPasswordField(20);
        back=new JButton("Back");
    	 confirmps=new JPasswordField(20);
    	 ei=new JTextField(20);
         ei.setText("@");
    	 submit=new JButton("Submit");
    	 clear=new JButton("Clear");
         
    	 setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	 
    	 
    	 //username
    	 user=new JLabel("UserName : ");
    	 user.setBounds(100,50,100,20);
    	 panel.add(user);
    	 
    	 un.setBounds(250,50,150,20);
    	 panel.add(un);
    	 
    	 
    	 //emailid
    	 id=new JLabel("Email Id : ");
    	 id.setBounds(100,80,100,20);
    	 panel.add(id);
    	 
    	 ei.setBounds(250,80,150,20);
    	 panel.add(ei);
    
    	 //password
    	 pass=new JLabel("PassWord : ");
    	 pass.setBounds(100,110,100,20);
    	 panel.add(pass);

    	 ps.setBounds(250,110,150,20);
    	 panel.add(ps);
    	 
    	//confirmpassword
    	 conf=new JLabel("Confirm PassWord : ");
    	 conf.setBounds(100,140,150,20);
    	 panel.add(conf);

    	 confirmps.setBounds(250,140,150,20);
    	 panel.add(confirmps);
         //Back
         back=new JButton("Back");
         back.setBounds(50,200,130,20);
         panel.add(back);
    	 back.addActionListener(this);
    	 //submit
    	 submit=new JButton("Submit");
    	 submit.setBounds(150,200, 130, 20);
    	 panel.add(submit);
    	 submit.addActionListener(this);
    	 
    	 //clear
    	 clear=new JButton("Clear");
    	 clear.setBounds(250, 200, 130,20);
    	 panel.add(clear);
    	 clear.addActionListener(this);
    	 
    	 jfr.add(panel);
    	 jfr.setVisible(true);
    	 
     }
    public void actionPerformed(ActionEvent e) 
     {
        if (e.getSource() == submit)
         {
             Random randomGenerator = new Random();
            int x = 0;
            String s1 = un.getText();
            int s = randomGenerator.nextInt(100000);
            String s2 = ei.getText();
            char[] s3 = ps.getPassword();
            char[] s4 = confirmps.getPassword();
            String s5 = new String(s3);
            String s6 = new String(s4);
            
            if(!s1.equals("") || !s2.equals("") || !s5.equals("") || !s6.equals("") )
            {
            if (s5.equals(s6) )
           {
               if(s5.length()>7)
               {
                try
               {
                    
                    x++;
                    if (x > 0) 
                    {
                        
   
                     
                    
                        Class.forName("com.ibm.db2.jcc.DB2Driver");
                        Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/tourpro", "MORENO","password");
                        //System.out.println(">>>>>1");
                        PreparedStatement stmt;
                        stmt=con.prepareStatement("insert into user values(?,?,?,?,?)");
                         
                        stmt.setString(1, s1);
                        stmt.setInt(2, s);
                        stmt.setString(3, s2);
                        stmt.setString(4, s5);
                        stmt.setString(5, s6);
                        stmt.executeUpdate();
                         /*while(rs.next())
                        {
                        System.out.println("Name :"+rs.getString("State"));
                        }*/
                   
                          
              JOptionPane.showMessageDialog(submit, "Data Saved Successfully");
              JOptionPane.showMessageDialog(submit, "Your User Id :  "+s);
              new LogIn();
              dispose();
              
              //JOptionPane.showMessageDialog(submit, s);
                    }
                }
          catch (Exception ex) 
                {
                    System.out.println(ex);
                }
            }
                else
            {
                   JOptionPane.showMessageDialog(submit, "Password length should be more than 7");
            }
           }
            else
            {
                JOptionPane.showMessageDialog(submit, "Fill the required filled");
            }
           }
              
          else   //submit
           {
      JOptionPane.showMessageDialog(submit, "Password Does Not Match");
            } 
            
        } 
        else if(e.getSource()==clear)    //clear
       {
            un.setText("");
            ei.setText("");
            ps.setText("");
            confirmps.setText("");
            
        }
        else{
            new GUI();
            dispose();
        }
    
    
     }
     /*public static void main(String args[]){
    	 Register regi=new Register();
    	//regi.setVisible(true);
     }*/

    
    
}



