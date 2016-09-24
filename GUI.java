import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
//import java.awt.Image;
//import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import javax.swing.event.HyperlinkEvent;
//import javax.swing.event.HyperlinkListener;
//import java.util.Random;

import javax.swing.*;


public class GUI extends JFrame{
    int i=0;
        JButton register,login,help;
        //JLabel Help;
	 JComboBox source;
	 JComboBox destination;
         JCheckBox jb1[]=new JCheckBox[10];
	 JCheckBox clist[]=new JCheckBox[3];
	 JLabel labels[]=new JLabel[3];
	 JFrame tour;
	 JLabel cities;
	 JLabel hotel;
	 JLabel transport;
	 JButton splaces,shotel;
	 //JLabel feedback;
	 JRadioButton THREE;
	 JRadioButton FIVE;
	 JRadioButton SEVEN;
	 JRadioButton bus;
	 JRadioButton train;
	 JRadioButton flight;
	 JPanel p6,p7,p1,p8,p9;
         MActionListener al;
         
	 public GUI(){
             //Image img=new Image("Desktop/tour.jpeg");
             //setIconImage(img);
		 tour=new JFrame("TOUR PLANNER");
		 //setLayout(new FlowLayout());
                 setLayout(new BorderLayout());
		 source=new JComboBox(new String[]{"","Andhra Pradesh(AP)","Arunachal Pradesh(AR)","Assam(AS)","Bihar(BR)","Chattisgarh(CT)","Goa(GA)","Haryan(HR)","Gujarat(GJ)","Himachal Pradesh(HP)","Jammu & Kashmir(JK)","Jharkhand(JRK)","Karnataka(KA)","Kerala(KL)","Madhya Pradesh(MP)","Maharastra(MH)","Manipur(MN)","Megalaya(ML)","Odhisha(OR)","Punjab(PB)","Rajasthan(RJ)","Sikkim(SK)","Tamil Nadu(TN)","Telangana(TG)","Tripura(TR)","Uttarakhand(UT)","Uttar Pradesh(UP)","Mizoram(MZ)","Nagaland(NL)","West Bengal(WB)","Andaman & Nicobar Islands(AN)","Chandigarh(CH)","Dadra & Nagar Haveli(DN)","Delhi(DL)","Daman & Diu(DD)","Lakshadweep(LW)","Puducherry(PY)"});
		 destination=new JComboBox(new String[]{"","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chattisgarh","Goa","Haryana","Gujarat","Himachal Pradesh","Jammu & Kashmir","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharastra","Manipur","Megalaya","Odhisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttarakhand","Uttar Pradesh","Mizoram","Nagaland","West Bengal","Andaman & Nicobar Islands","Chandigarh","Dadra & Nagar Haveli","Delhi","Daman & Diu","Lakshadweep","Puducherry"});
	     
             //feedback=new JButton("FeedBack");
             //add(feedback,BorderLayout.EAST);
             help=new JButton("Help");
             add(help,BorderLayout.EAST);
             //p7.add(Help);
                p8=new JPanel();
                add(p8,BorderLayout.CENTER);
                 //JButton p=new JButton();
             register=new JButton("Register");
             login=new JButton("LOGIN");
             //p.add(login);
             add(register,BorderLayout.NORTH);
              add(login,BorderLayout.WEST);
             al=new MActionListener();
            destination.addActionListener(al);
            //JLabel src=new JLabel("SOURCE");
            //JLabel des=new JLabel("DESTINATION");
            
             JPanel p1=new JPanel();
             p7=new JPanel();
             p9=new JPanel();
             p7.add(new JLabel("SOURCE"));
	     p7.add(source);
             p9.add(new JLabel("DESTINATION"));
             
	     p9.add(destination);
             p1.add(p7);
             p1.add(p9);
	     //add(p1,BorderLayout.CENTER);
             p8.add(p1);
	     JPanel p2=new JPanel();
	     splaces=new JButton("Show Places");
	     p2.add(splaces);
	     //add(p2);
             //add(p2,BorderLayout.CENTER);
             p8.add(p2);
	     JPanel p3=new JPanel();
	     cities=new JLabel();
	     p3.add(cities);
             //add(p3,BorderLayout.CENTER);
	       p8.add(p3);
	        JPanel p4=new JPanel();
		     THREE=new JRadioButton("3STAR");
		     FIVE=new JRadioButton("5STAR");
		     SEVEN=new JRadioButton("7STAR");
		     hotel=new JLabel("Hotel Type : ");
		     p4.add(hotel);
		     p4.add(THREE);
		     p4.add(FIVE);
		     p4.add(SEVEN);
	       ButtonGroup hots=new ButtonGroup();
	       hots.add(THREE);
	       hots.add(FIVE);
	       hots.add(SEVEN);
	       p8.add(p4);
               //add(p4,BorderLayout.CENTER);
               
	      JPanel p5=new JPanel();
	      bus=new JRadioButton("BUS");
		     train=new JRadioButton("TRAIN");
		     flight=new JRadioButton("FLIGHT");
		     transport=new JLabel("Transport Type : ");
		     p5.add(transport);
		     p5.add(bus);
		     p5.add(train);
		     p5.add(flight);
		     ButtonGroup trans=new ButtonGroup();
		       trans.add(THREE);
		       trans.add(FIVE);
		       trans.add(SEVEN);
		       p8.add(p5);
                       //add(p5,BorderLayout.CENTER);
                       p7=new JPanel();
                   p6=new JPanel();
		      
	        setSize(800,500);
                setVisible(true);
	      
		       ItemListener itl=new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						displayplaces();
						
					}
				};  
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            register.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {                 
                    JFrame Register = new JFrame();
                    new Register();
                    dispose();
                }
            }); 
            login.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {                 
                    new LogIn();
                    dispose();
                }
                
            }); 
             help.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {                 
                    JOptionPane.showMessageDialog(help, "Call on : 9461632394 \n \t \t \t \t \t 9829203572\n\n Mail on : peterlnm6@gmail.com");
                    //JOptionPane.showMessageDialog(help, "<html><a href=\"http://google.com/\">peterlnm6@gmail.com</a></html>");
                }
            }); 
            
	     splaces.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                            /* Class.forName("com.ibm.db2.jcc.DB2Driver");
			System.out.println("Connecting to a selected database...");
                        System.out.println((String)destination.getSelectedItem());
			Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/tourpro", "MORENO","password");
			PreparedStatement stmt=con.prepareStatement("select * from tour.vplaces where PINCode=(select PIN from tour.vcities where cname=?)");
			stmt.setString(1,stre);
                        //System.out.println("Hello");
			ResultSet rs=stmt.executeQuery();*/
			int i=0;	//String s=(String) destination.getSelectedItem();
			String vplaces[]=new String[]{"Jal Mahal","Hawa Mahal","Jantar Mantar"};
			JLabel jl[]=new JLabel[10];
                        JPanel jp0=new JPanel();
                        while(i<vplaces.length)
                        {
                            jl[i]=new JLabel(vplaces[i]);
                            jp0.add(jl[i]);
                            i++;
                        }
                        p8.add(jp0);
				//add(p8);
				/*if(s.equals("Andhra Pradesh(AP)")){
			        for(int i=0;i<3;i++){
			        	cities.setText("Cities in "+s+": ");
					    	clist[i]=new JCheckBox(city[i]);
					    	//clist[i].setVisible(true);
					    	 
					    	p3.add(clist[i]);
					  }
			     
				}*/
				
				}
		});
	     
		//for(int i=0;i<3;i++)
		
		THREE.addItemListener(itl);
		FIVE.addItemListener(itl);
		SEVEN.addItemListener(itl);
                bus.addItemListener(itl);
		train.addItemListener(itl);
		flight.addItemListener(itl);
		
	     setVisible(true);
	 }
	 private void displayplaces() {
		 String city[]=new String[]{"Visakhapatnam","Tirupathi","Vijayawada"};
		 String visk="Visakhapatnam :"+"Kailasagiri"+"\n"+"Araku"+"\n"+"Beaches";
			String Tiru="Tirupathi :"+"Balaji Temple";
     	if(clist[1].isSelected()){
     		labels[1]=new JLabel(visk);
     		p6.add(labels[0]);
     	}
     	if(clist[2].isSelected()){
     		labels[2]=new JLabel(Tiru);
     		p6.add(labels[1]);
     	}
     	 p8.add(p6);
        
     	setVisible(true);
        
             
}
         class MActionListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
		  try
		  {
			String stre=(String)destination.getSelectedItem();
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			System.out.println("Connecting to a selected database...");
                        System.out.println((String)destination.getSelectedItem());
			Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/tourpro", "MORENO","password");
			PreparedStatement stmt=con.prepareStatement("select * from tour.vcities where sid=(select sid from tour.places where state=?)");
			stmt.setString(1,stre);
                        //System.out.println("Hello");
			ResultSet rs=stmt.executeQuery();
			JPanel p0=new JPanel();
			while(rs.next())
			{
                            System.out.println(rs.getString("cname"));
				jb1[i]=new JCheckBox(rs.getString("cname"));
				p0.add(jb1[i]);
				i++;
			}
			p0.setLayout(new FlowLayout());
                        JPanel p10=new JPanel();
                        JLabel jl=new JLabel("Visiting Cities in " +stre);
                        p10.add(jl);
                        p10.add(p0);
			p8.add(p10);
		  }
		  catch(Exception se)
		  {
			  System.out.println(se);
		  }
                }
                
         }
         public Insets getInsets(){
             return new Insets(30,10,10,10);
         }
         /*class ButtonHandler implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==help)
                {
                    JOptionPane.showMessageDialog(help, "Call on:9461632394 or mail on peterlnm6@gmail.com");
                }
               
            }
        }*/
         //add(p8,BorderLayout.CENTER);
         
         
	 public static void main(String args[]){
		 GUI gui=new GUI();
		// gui.setSize(800,500);
		 //@@@@@@@gui.setVisible(true);
	 }

    
}


