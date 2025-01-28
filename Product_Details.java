import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Product_Details extends JFrame implements ActionListener{
 DefaultTableModel model;
 JTable t1;
 Container c;
 JLabel lb;
 JButton bk;
 Color cr;
	Product_Details()
	{
		c=getContentPane();
		
		bk=new JButton("Back");
		add(bk);
		bk.setBounds(770,650,100,30);
		
		cr= new Color(255,253,210);
		c.setBackground(cr);
		
		ImageIcon img=new ImageIcon("D:/AJP/product details ani.gif");
		lb=new JLabel(img);
		c.add(lb);
		lb.setBounds(200,20,400,100);
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/ajp_prj","root","Bhumika@1306");
		Statement st=con.createStatement();
		
		setLayout(null);
		String [] Column= {"Id","Name","Rate","Quantity","Desccription"};
		String[][] Row= {{"1","abc","1200","20","xyz"}};
		model = new DefaultTableModel(Row,Column);
		 
	       t1=new JTable(model);
	    //    tb1.setBackground(new Color(176,196,222));
	        JScrollPane s1=new JScrollPane(t1);
	        s1.setBounds(50,150,770,200);
	        c.add(s1);
//	        t1.setBackground(cr);
	        
		    String query="select * from details";
			ResultSet rs=st.executeQuery("select * from details");
			model.setRowCount(0);
			while(rs.next())
			{
				Vector v=new Vector();
				for(int i=1;i<=100;i++)
				{
					
					v.add(rs.getInt("pid"));
					v.add(rs.getString("name"));
					v.add(rs.getInt("rate"));
					v.add(rs.getInt("quantity"));
					v.add(rs.getString("description"));
				}
				model.addRow(v);
			}
		
		
		rs.close();
		st.close();
		con.close();
		}
	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	 bk.addActionListener(this);
	}
	
	public static void main(String args[])
 {
	 Product_Details p1=new Product_Details();
	 p1.setVisible(true);
	 p1.setSize(900,750);
 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bk)
		{
			this.setVisible(false);
			Home h=new Home();
			h.setUndecorated(true);
			h.setSize(980,570);
		    h.setVisible(true);
		}
	}

}
