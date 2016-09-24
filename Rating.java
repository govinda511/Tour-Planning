import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;





 class Rating extends JFrame
 {
        String cmt;
        JRadioButton rate[]=new JRadioButton[5];
        JButton submit,cancel;
        JPanel jp,jp1,jp2,jp3,jp4;
        JTextField jtxt;
        JTextField jtxt1;
        JLabel jl;
        //String s[]={"Woa","Kashish"};
        //JRadioButton r=new JRadioButton(s);
    Rating(String s){
         jp=new JPanel();
         jp3=new JPanel();
         jp4=new JPanel();
         String star[]=new String[]{"1*","2*","3*","4*","5*"};
         for(int i=0;i<5;i++)
            {
		rate[i]=new JRadioButton(star[i]);
		rate[i].setVisible(true);
		jp4.add(rate[i]);
            }
         jp2=new JPanel();
         setLayout(new BorderLayout());
         jp2.setLayout(new BorderLayout());
         jp1=new JPanel();
         //jp1.setLayout(new FlowLayout());
         jl =new JLabel("User ID:");
         jp1.add(jl);
         jp.setLayout(new FlowLayout());
         jtxt=new JTextField(20);
         jtxt.setText(s);
         jp1.add(jtxt);
         //add(jp1);
         jtxt1=new JTextField(50);
         jtxt1.setSize(500, 100);
         jtxt1.setText("Write your Comments. We appreciate bad comments also");
         submit=new JButton("submit");
         cancel=new JButton("Cancel");
         jp3.add(jtxt1);
         jp.add(submit);
         jp.add(cancel);
         jp2.add(jp1,BorderLayout.NORTH);
         jp2.add(jp3,BorderLayout.CENTER);
         jp2.add(jp4,BorderLayout.LINE_END);
         jp2.add(jp,BorderLayout.SOUTH);
         add(jp2,BorderLayout.CENTER);
         
         //add(jp1);
         setSize(900, 500);
         setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    for(int i=0;i<5;i++)
    {
        rate[i].addItemListener(new ItemListener()
        {
           // @Override
           public void itemStateChanged(ItemEvent e)
           {
  	
                String s="";
                if(e.getSource()==rate[0])
                {
                    s=rate[0].getLabel();
                }
                else if(e.getSource()==rate[1])
                {
                     s=rate[1].getLabel();
                }
                else if(e.getSource()==rate[2])
                {
                    s=rate[2].getLabel();
                } 
                else if(e.getSource()==rate[3])
                {
                      s=rate[3].getLabel();
                }
                else if(e.getSource()==rate[4])
                {
                     s=rate[4].getLabel();
                } 
                System.out.println("Get Selected time:"+s);
            }
        } );
    }
    
    submit.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e)
         {
             String str=jtxt.getText();
            String st=jtxt1.getText();
           
            try{
                
                    /*FileWriter fw=new FileWriter("stu.txt"); 
                    fw.write(str);
                    fw.write(st);
                    System.out.println(st);
                    JOptionPane.showMessageDialog(jtxt1, "Saved");
                    fw.close(); */
                        Class.forName("com.ibm.db2.jcc.DB2Driver");
                         //System.out.println(">>>>>11");
                        Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/tourpro", "MORENO","password");
                        System.out.println(">>>>>1");
                        PreparedStatement stmt;
                        stmt=con.prepareStatement("insert into tour.feedback values(? , ? , ? )");
                         System.out.println(">>>>>11");
                        stmt.setString(1, jtxt.getText());
                        stmt.setString(2, jtxt1.getText());
                        //stmt.setString(3,s);
                        for(int i=0;i<5;i++)
                        {
                            if(rate[i].isSelected())
                            {
                                stmt.setString(3,rate[i].getLabel());
                            }
                        }
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(jtxt1, "Saved.\nThanks for your response.");
            }
            catch(Exception p){
                    p.printStackTrace();   
            }
         }
            });
   
    cancel.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e)
         {
             dispose();
         } 
            });
   
}
    

        
    /*public static void main(String args[])  {
        Feedback fb=new Feedback();
        fb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fb.setVisible(true);
}*/
}