import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
public class Login extends JFrame implements ActionListener{
   
	JLabel l1,l3,l4;
 
JTextField tf1;
JPasswordField pf;
  JButton b1,b2;
  JCheckBox c1;
  JLabel lb;
  JCheckBox jc;
  Color c;
	Login()
	{
		setLayout(null);
		
		Container ct=getContentPane();	
        Panel p1=new Panel();
		
		p1.setBounds(0,0,950,100);
		p1.setLayout(null);
		c= new Color(255,170,26);
		//c= new Color(255,170,26);
		p1.setBackground(c);
		ct.add(p1);
		p1.setBounds(0,0,950,100);
		
		c= new Color(255,253,210);
		ct.setBackground(c);
		
		ImageIcon img=new ImageIcon("D:/AJP/login_Page.png");
		lb=new JLabel(img);
		add(lb);
		lb.setBounds(0,0,420,600);
		
		Font f1=new Font("Cambria",Font.BOLD,40);
		Font f2=new Font("Cambria",Font.BOLD,30);
	     l1=new JLabel("SUPER MARKET MANAGEMENT SYSTEM");
	     l1.setFont(f1);
		
     	 l3=new JLabel("Username");
	   	 l4=new JLabel("Password");
	   	 l3.setFont(f2);
	   	 l4.setFont(f2);
	   	 tf1=new JTextField(50);
	   	pf=new JPasswordField(50);
	    pf.setEchoChar('*');
	   	
	   	b1=new JButton("Login");
	   	ImageIcon i5=new ImageIcon("D:/AJP/Close jframe.png");
		b2=new JButton(i5);
	   
	    jc=new JCheckBox("Show Password");
	    add(jc);
	    jc.setBounds(560,340,270,50);
	    jc.setBackground(c);
		jc.addActionListener(this);
		
	   	b1.setFont(f2);
		b2.setFont(f2);
		tf1.setFont(f2);
		pf.setFont(f2);
		  	
	   	p1.add(l1);
	   	
	   	add(l3);
	   	add(l4);
	   	add(tf1);add(pf);add(b1);p1.add(b2);
	  
	   	l1.setBounds(80,40,1000,50);

	   	l3.setBounds(420,180,200,30);
	   	l4.setBounds(420,250,200,30);
	   	tf1.setBounds(660,180,200,35);
	   	pf.setBounds(660,250,200,35);
	   	b1.setBounds(520,400,200,35);
	   	b2.setBounds(860,5,30,30);
		
	   	b1.addActionListener(this);
	   	b2.addActionListener(this);
	   
		
	}
	public static void main(String args[])
  {
	  Login ll1=new Login();
	  ll1.setUndecorated(true);
	  ll1.setVisible(true);
	  ll1.setSize(900,550);
  }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s=e.getActionCommand();
		Object b=e.getSource();
		if(b==b2)
		{
			
			System.exit(0);
		}
		if(b==jc)
		{
			  if(jc.isSelected())
			        {
			           pf.setEchoChar((char)0);
			        }
			        else
			        {
			           pf.setEchoChar('*');
			        }
		}
		 if(s.equals("Login"))
		{
			String s1=tf1.getText();
			String s2=pf.getText();
			if(s1.equals("Admin")&&s2.equals("1234"))
			{
				this.setVisible(false);
				Home lg=new Home();
				lg.setUndecorated(true);
				lg.setSize(950,576);
			    lg.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
				tf1.setText("");
				pf.setText("");
			}
			
		}
	}
	
}

