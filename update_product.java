import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class update_product extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6;
	 
	JTextField tf1,tf2,tf3,tf4,tf5;
	  JButton b1,b2,b3,b4;
	  JLabel msg;
	 Color c;
	  update_product()
		{
			setLayout(null);
			Container ct=getContentPane();
			
			c= new Color(255,170,26);
			Panel p1=new Panel();
			add(p1);
			p1.setBackground(c);
			p1.setBounds(0,0,200,650);
			
			Font f1=new Font("Cambria",Font.BOLD,40);
			Font f2=new Font("Cambria",Font.BOLD,20);
			msg=new JLabel();
			
			ImageIcon i=new ImageIcon("D:/AJP/update product ani.gif");
		     l1=new JLabel(i);
		     
		     c= new Color(255,253,210);
				ct.setBackground(c);
			
	     	 l2=new JLabel("Product ID");
		   	 l3=new JLabel("Product Name");
		     l4=new JLabel("Rate");
		   	 l5=new JLabel("Description");
		   	 l6=new JLabel("Quantity");
		   	 l2.setFont(f2);
		   	 l3.setFont(f2);
		   	 l4.setFont(f2);
		   	 l5.setFont(f2);
		     l6.setFont(f2);
		   	tf1=new JTextField(50);
		   	tf2=new JTextField(70);
		    tf3=new JTextField(70);
		   	tf4=new JTextField(70);
		   	tf5=new JTextField(70);
		   	b1=new JButton("Search");
			b1.setFont(f2);
		   	b2=new JButton("Update");
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
		   
		   	tf1.setBounds(450,140,150,30);
		   	tf2.setBounds(450,240,300,30);
		   	tf3.setBounds(450,310,300,30);
		   	tf4.setBounds(450,380,300,30);
		   	tf5.setBounds(450,450,300,30);
		
		    b1.setBounds(700, 140, 140, 30);
			b1.setBackground(new Color(255,200,100));
		   	b2.setBounds(250,550,150,30);
			b3.setBounds(450,550,150,30);
			b4.setBounds(650,550,150,30);
			
			msg.setBounds(260,600,500,30);
			
			b1.addActionListener(this);
			b2.addActionListener(this);
			b4.addActionListener(this);
			b3.addActionListener(this);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		update_product up=new update_product();
		up.setUndecorated(true);
		  up.setVisible(true);
		  up.setSize(900,650);

	}
	
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
			
			PreparedStatement pstmt=con.prepareStatement("update details set name=?,rate=?,quantity=?,Description=? where pid=?");
			
			int id=Integer.parseInt(tf1.getText());
			String name=tf2.getText();
			int rate=Integer.parseInt(tf3.getText());
			int quantity=Integer.parseInt(tf5.getText());
			String desc=tf4.getText();
			
			pstmt.setString(1,name);
			pstmt.setInt(2,rate);
			pstmt.setInt(3,quantity);
			pstmt.setString(4, desc);
			pstmt.setInt(5,id);
					
			int x=pstmt.executeUpdate();
			
		   JOptionPane.showMessageDialog(null, "Product Details Updated");
		   
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