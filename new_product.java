import java.awt.*;
import java.sql.*;
import java.util.regex.Pattern;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class new_product extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6;
	JLabel rl; 
	JTextField tf1,tf2,tf3,tf4,tf5;
	  JButton b1,b2,b3;
	  JTextField cb;
	  JLabel lb,gb,img3,img2;
	  Color c;
	  new_product()
		{
		 
			setLayout(null);
			
			Container ct=getContentPane();	
	        Panel p1=new Panel();
			
			p1.setBounds(0,0,300,900);
			c= new Color(255,170,26);
			//c= new Color(255,170,26);
			p1.setLayout(null);
			p1.setBackground(c);
			ct.add(p1);
			
			c= new Color(255,253,210);
			ct.setBackground(c);
			
			ImageIcon ig=new ImageIcon("D:/AJP/sp_mob.png");
			gb=new JLabel(ig);
			p1.add(gb);
			gb.setBounds(50, 40, 180, 100);
			
			ImageIcon im=new ImageIcon("D:/AJP/hit.png");
			img2=new JLabel(im);
			p1.add(img2);
			img2.setBounds(10,150,250,300);
			
			ImageIcon img=new ImageIcon("D:/AJP/super111.png");
			img3=new JLabel(img);
			p1.add(img3);
			img3.setBounds(10,400,280,300);
			
			Font f1=new Font("Cambria",Font.BOLD,40);
			Font f2=new Font("Cambria",Font.BOLD,20);
			
			ImageIcon i1=new ImageIcon("D:/AJP/new product.png");
			lb=new JLabel(i1);
			add(lb);
			lb.setBounds(420,30,100,100);
			
			ImageIcon i=new ImageIcon("D:/AJP/New Product ani.gif");
		     l1=new JLabel(i);
		     
			   l1.setBounds(540,30,200,100);

	
		   
	     	 l2=new JLabel("Product ID");
		   	 l3=new JLabel("Product Name");
		     l4=new JLabel("Rate");
		   	 l5=new JLabel("Description");
		   	 l6=new JLabel("Quantity");
		   	 rl=new JLabel("");
		   	 
		   	 l2.setFont(f2);
		   	 l3.setFont(f2);
		   	 l4.setFont(f2);
		   	 l5.setFont(f2);
		     l6.setFont(f2);
		     rl.setFont(f2);
		     
		   	tf1=new JTextField(70);
		   	tf2=new JTextField(70);
		    tf3=new JTextField(70);
		   	tf4=new JTextField(70);
		   	tf5=new JTextField(70);
		   	
		   	b1=new JButton("save");
		   	b1.setFont(f2);
		   	b2=new JButton("Reset");
		   	b2.setFont(f2);
		   	b3=new JButton("Close");
		   	b3.setFont(f2);
		   	
		   	add(l1);
		   	add(l2);
		   	add(l3);
		   	add(l4);
		   	add(l5);
			add(l6);
		   	add(tf1);add(tf2);add(tf3);add(tf4);add(tf5);
		   	add(b1);add(b2); add(b3);
		   	add(rl);
		
		   	l2.setBounds(350,160,200,30);
		   	l3.setBounds(350,230,200,30);
		   	l4.setBounds(350,290,200,30);
		   	l5.setBounds(350,370,200,30);
		    l6.setBounds(350,440,200,30);
		   
		   	tf1.setBounds(560,160,300,30);
		   	tf2.setBounds(560,230,300,30);
		   	tf3.setBounds(560,290,300,30);
		   	tf4.setBounds(560,370,300,30);
		   	tf5.setBounds(560,440,300,30);
		   
		   	b1.setBounds(360,550,100,30);
			b2.setBounds(520,550,100,30);
			b3.setBounds(680,550,100,30); 
			
			rl.setBounds(350,640,500,30);
			
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
		}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		new_product np=new new_product();
		np.setUndecorated(true);
		  np.setVisible(true);
		  np.setSize(950,700);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/ajp_prj","root","Bhumika@1306");
		Statement st=con.createStatement();
		
		
		if(e.getSource()==b1)
		{
			
			if(!Pattern.matches("^[0-9]+$",tf1.getText()))
			{
				JOptionPane.showMessageDialog(null, "Enter Valid ID");
			}
			else if(!Pattern.matches("^[A-Za-z]+$",tf2.getText()))
			{
				JOptionPane.showMessageDialog(null, "Enter Valid Product Name");
			}
			else if(!Pattern.matches("^[0-9]+$",tf3.getText()))
			{
				JOptionPane.showMessageDialog(null, "Enter Valid Rate");
			}
			else if(!Pattern.matches("^[A-Za-z]+$",tf4.getText()))
			{
				JOptionPane.showMessageDialog(null, "Enter Valid Description");
			}
			else if(!Pattern.matches("^[0-9]+$",tf5.getText()))
			{
				JOptionPane.showMessageDialog(null, "Enter Valid Quantity");
			}
			
			
			
		PreparedStatement pstmt=con.prepareStatement("insert into details values(?,?,?,?,?)");
		
		int id=Integer.parseInt(tf1.getText());
		String name=tf2.getText();
		int rate=Integer.parseInt(tf3.getText());
		String desc=tf4.getText();
		int qty=Integer.parseInt(tf5.getText());
		
		pstmt.setInt(1,id);
		pstmt.setString(2,name);
		pstmt.setInt(3,rate);
		pstmt.setInt(4,qty);
		pstmt.setString(5,desc);
		
		pstmt.executeUpdate();
		JOptionPane.showMessageDialog(null, "Product Added Successfully");
		}
		  tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf5.setText("");
			tf4.setText("");
			
		con.close();
		}
		catch(Exception ex)
		{
			
		}
		//rl.setText("Product Added Successfully");
		
		
	
	if(e.getSource()==b2)
		{
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf5.setText("");
			tf4.setText("");
			
		}
		
		if(e.getSource()==b3)
		{
			this.setVisible(false);
			Home h=new Home();
			h.setUndecorated(true);
			h.setSize(980,570);
		    h.setVisible(true);
		}
		
	}

}