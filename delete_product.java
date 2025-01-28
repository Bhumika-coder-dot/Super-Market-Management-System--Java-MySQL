
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;


public class delete_product extends JFrame implements ActionListener {
	JLabel l1,l2,l3,l4,l5,l6;
	 
	JTextField tf1,tf2,tf3,tf4,tf5;
	  JButton b1,b2,b3,b4;
	 JLabel msg;
	 Color c;
	  delete_product() 
	  {
			setLayout(null);
			c= new Color(255,170,26);
			Container ct=getContentPane();
			Panel p1=new Panel();
			add(p1);
			p1.setBackground(c);
			p1.setBounds(0,0,200,650);
			
			ImageIcon i=new ImageIcon("D:/AJP/delete product ani.gif");
		     l1=new JLabel(i);
		     c= new Color(255,253,210);
				ct.setBackground(c);
			
			Font f1=new Font("Cambria",Font.BOLD,40);
			Font f2=new Font("Cambria",Font.BOLD,20);
			
		     
			
	     	 l2=new JLabel("Product ID");
		   	 l3=new JLabel("Product Name");
		     l4=new JLabel("Rate");
		   	 l5=new JLabel("Description");
		   	 l6=new JLabel("Quantity");
		   	 
		   	 msg=new JLabel("");
		   	 
		   	 l2.setFont(f2);
		   	 l3.setFont(f2);
		   	 l4.setFont(f2);
		   	 l5.setFont(f2);
		     l6.setFont(f2);
		     msg.setFont(f2);
		     
		   	tf1=new JTextField(50);
		   	tf2=new JTextField(70);
		    tf3=new JTextField(70);
		   	tf4=new JTextField(70);
		   	tf5=new JTextField(70);
		   	b1=new JButton("Search");
			b1.setFont(f2);
		   	b2=new JButton("Delete");
		   	b2.setFont(f2);
		   	b3=new JButton("Reset");
		   	b3.setFont(f2);
		   	b4=new JButton("Close");
		   	b4.setFont(f2);
		   	
		   	add(l1);
		   	add(l2);
		   	add(l3);
		   	add(l4);
		   	add(l5);
		   	add(l6);
			add(msg);
			
		   	add(tf1);add(tf2);add(tf3);add(tf4);add(tf5);
		   	add(b1);add(b2); add(b3); add(b4);
		  
		   	l1.setBounds(400,30,300,50);

		   	l2.setBounds(250,140,200,30);
		   	l3.setBounds(250,240,200,30);
		   	l4.setBounds(250,310,200,30);
		   	l5.setBounds(250,380,200,30);
		    l6.setBounds(250, 450, 200,30);
		   
		   	tf1.setBounds(450,140,190,30);
		   	tf2.setBounds(450,240,300,30);
		   	tf3.setBounds(450,310,300,30);
		   	tf4.setBounds(450,380,300,30);
		   	tf5.setBounds(450,450,300,30);
		
		    b1.setBounds(700, 140, 140, 30);
		   	b2.setBounds(250,550,150,30);
			b3.setBounds(450,550,150,30);
			b4.setBounds(650,550,150,30);
			
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			msg.setBounds(150,620,500,30);
		}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		delete_product dp=new delete_product();
		dp.setUndecorated(true);
		  dp.setVisible(true);
		  dp.setSize(900,650);

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
			
			tf2.setText("");
			tf3.setText("");
			tf5.setText("");
			tf4.setText("");
			
			int id=Integer.parseInt(tf1.getText());	
			ResultSet rs=st.executeQuery("select * from details where pid="+id);
			
			if(rs.next())
			{
				
			tf1.setText(rs.getInt(1)+"");
			tf2.setText(rs.getString(2));
			tf3.setText(rs.getInt(3)+"");
			tf5.setText(rs.getInt(4)+"");
			tf4.setText(rs.getString(5));
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Product doesnt Exist");
			}
			
			
			
			
		}
		if(e.getSource()==b2)
		{
			
			PreparedStatement pstmt=con.prepareStatement("delete from details where pid=?");
			
			int id=Integer.parseInt(tf1.getText());
			pstmt.setInt(1,id);
			pstmt.executeUpdate();
			
			 JOptionPane.showMessageDialog(null, "Product Deleted Successfully");
			
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf5.setText("");
			tf4.setText("");
			
		}
		if(e.getSource()==b3)
		{
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf5.setText("");
			tf4.setText("");
			
		}
		if(e.getSource()==b4)
		{
			this.setVisible(false);
			Home h=new Home();
			h.setUndecorated(true);
			h.setSize(980,570);
		    h.setVisible(true);
		}
		st.close();
		con.close();
		}
			
			catch(Exception ex) {
				
			}

}
	}