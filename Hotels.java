
import static com.ibm.db2.jcc.am.GlobalProperties.s;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MORENO
 */
public class Hotels extends JFrame
{
    int i=0;
    ResultSet rs;
    JPanel jp1;
    JLabel jl1[]=new JLabel[4];
    Hotels()
    {
        setLayout(new BorderLayout());
        try
        {
            jp1=new JPanel();
            //jp1.setLayout(new GridLayout());
            //jp1.setBounds(78,90, 100, 89);
          //String s1 = ""; 
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/tourpro", "MORENO","password");
            PreparedStatement stmt;
            stmt=con.prepareStatement("select * from tour.hotel where hpin=(select pin from tour.vcities where cname= ?)");
            stmt.setString(1, "Ranchi");
            rs=stmt.executeQuery();
            while(rs.next())
            {
                String s=rs.getString("hname");
                jl1[i]=new JLabel(rs.getString("hname")+"Cost: "+rs.getString("hprice"));
                //jl1.setBounds(78,90, 100, 89);
                jp1.add(jl1[i]); 
                setVisible(true);
                setSize(400,300);
                System.out.println("Hotel name:"+rs.getString("hname")+"   "+i); i++;
            }
            add(jp1,BorderLayout.EAST);
            //add(jp1,BorderLayout.SOUTH);
        }
        catch(Exception e)
        {
            System.out.println("Something wrong happened!");
        }
    }
        public static void main(String ar[])
        {
            new Hotels();
        }
}
