import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.Statement;
import java.sql.*;

//import java.util.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LogIn extends JFrame implements ActionListener
{
        JLabel jl1,jl2,jl3,jl4,jl5;
        JTextField txtuserid,txtpass;
        JButton login,Forgot_Password,cancel;
        JPanel jp1,jp2,jp3,jp4;
        JPasswordField p;
        //ResultSet rs;
        LogIn ()
             {
                    //setLayout(new FlowLayout());
                    setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
                    jl1=new JLabel("User ID");
                    jl2=new JLabel("Password");
                    //jl3=new JLabel("Budget");
                    
                    txtuserid=new JTextField(30);
                    //txtpass=new JTextField(30);
                    p=new JPasswordField();
                    
                    jp1=new JPanel();
                    jp1.setLayout(new BoxLayout(jp1,BoxLayout.X_AXIS));
                    jp1.add(jl1);
                    jp1.add(txtuserid);
                    jp2=new JPanel();
                    jp2.setLayout(new BoxLayout(jp2,BoxLayout.X_AXIS));
                    jp2.add(jl2);
                    //jp2.add(txtpass);
                    jp2.add(p);
                    login=new JButton("LOGIN");
                    Forgot_Password=new JButton("Forgot Password");
                    cancel=new JButton("Cancel");
                    
                    jp4=new JPanel();
                    jp4.setLayout(new FlowLayout());
                    jp4.add(login);
                    jp4.add(cancel);
                    jp4.add(Forgot_Password);
                    add(jp1);
                    add(jp2);
                    add(jp4);
                    
                    setSize(400,130);
                    setVisible(true);
                    //setDefaultCloseOperation(EXIT_ON_CLOSE);
                    
                     login.addActionListener(this); 
                     Forgot_Password.addActionListener(this);
                     cancel.addActionListener(this); 
                    } 
                    public void actionPerformed(ActionEvent e) 
                    {
                        JFrame f1 = new JFrame();
                         JLabel l, l0;
                        if(e.getSource()==login){
                            ResultSet rs;
                           System.out.println(">>>>>12");  
                    try
                    { 
                        String s3;
                        String s=txtuserid.getText();
                        char[] s2 = p.getPassword();
                        String s1 = new String(s2);
                        System.out.println(">>>>>10");
                         Class.forName("com.ibm.db2.jcc.DB2Driver");
                         //System.out.println(">>>>>11");
                        Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/tourpro", "MORENO","password");
                        System.out.println(">>>>>1");
                        PreparedStatement stmt;
                        stmt=con.prepareStatement("select * from user where ? = uid and ? = pass");
                         System.out.println(">>>>>11");
                        stmt.setString(1, s);
                        stmt.setString(2, s1);
                        rs=stmt.executeQuery();
                        System.out.println(">>>>>12");
                        if (rs.next())
                         {  s3=rs.getString("uname");
                             System.out.println(">>>>>13");
                            //DGUI dgui;
                            //dgui = new DGUI();
                            DGUI dgui = new DGUI(s3,s);
                             System.out.println(">>>>>14");
                                dgui.setSize(900,500);
                                 dgui.setVisible(true);
                                 System.out.println(">>>>>15");
                                 dispose();
 
                             } else
                                        {
                                JOptionPane.showMessageDialog(null,
                                         "Incorrect Login-Id or password..Try Again with correct detail");
                                    }
                                    con.close();
                                     rs.close();
                    }
                    catch(Exception se)
                    {
                        System.out.println(se);
                    } 
                        }
                        else if(e.getSource()==Forgot_Password){
                            if(txtuserid.getText().equals(""))
                            {
                            JOptionPane.showMessageDialog(Forgot_Password, "Enter User ID");
                            }
                            else{
                    ResultSet rs;
                    try
                    { 
                        String s=txtuserid.getText();
                        String s1 = ""; 
                        Class.forName("com.ibm.db2.jcc.DB2Driver");
                        Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/tourpro", "MORENO","password");
                        PreparedStatement stmt;
                        stmt=con.prepareStatement("select * from user where ? = uid");
                        stmt.setString(1, s);
                        rs=stmt.executeQuery();
                        while(rs.next())
                        {
                            s1=rs.getString("pass");
                            System.out.println(rs.getString("Uname")+" "+rs.getString("pass"));
                        }
                        if(s1.equals("")){
                            JOptionPane.showMessageDialog(Forgot_Password, "You have entered wrong user id");
                            }
                         else {
                        JOptionPane.showMessageDialog(Forgot_Password, "Your Password :" + s1);
                        
                        }
                        con.close();
                        rs.close();
                    }
                    catch(Exception se)
                    {
                        System.out.println(se);
                    } 
                        }
                        }
                    else
                     {
                         new GUI();
           
                         this.dispose();
                     }
            }
                    
        
                
                    public static void main(String ar[])
                    {
                        LogIn li=new LogIn();
                    }
}
