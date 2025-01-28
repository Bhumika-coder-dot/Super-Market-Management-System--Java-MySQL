import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Billing extends JFrame implements ActionListener
{
  JLabel l1,l2,l3,lb1,lb2,lb3,lb4,lb5,lb6,le1,le2;
  JLabel ll1,ll2;
  JTextField tf1,tf2,tf3,tf4,tf5,tx1;
  JButton b1,b2,b3,b4,sr,bk;
  JTable jt;
  Color cl;
  JLabel im;
  DefaultTableModel model;
  JTable t1;
  Container c;
  int qty2;
  int qt;
 
	Billing()
	{
	
		 c=getContentPane();
		
		Panel p1=new Panel();
		p1.setBounds(0,0,1300,150);
		c.add(p1);
		
		p1.setLayout(null);
		cl= new Color(255,170,26);
		p1.setBackground(cl);
		c.add(p1);
		
		sr=new JButton("Search");
		bk=new JButton("Back");
		
		Font f1=new Font("Cambria",Font.BOLD,40);
		Font f2=new Font("Cambria",Font.BOLD,20);
		Font f3=new Font("Cambria",Font.BOLD,30);
		
		
		 cl= new Color(255,253,210);
			c.setBackground(cl);
			
		setLayout(null);
		  
		
		
//		String row[][]= {};
//		String col[]= {"Name","Description","Rate","Quantity","Total"};
//		JTable t1=new JTable(row,col);      
//		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
//		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
//		JScrollPane s=new JScrollPane(t1,v,h);
//		c.add(s);
//		
		ImageIcon ii1=new ImageIcon("D:/AJP/Billing ani.gif");	
      	
		l1=new JLabel(ii1);
		l1.setFont(f1);
		
		ImageIcon img=new ImageIcon("D:/AJP/bill.png");
		im=new JLabel(img);
		p1.add(im);
		im.setBounds(20,0,250,150);
	
		l2=new JLabel("Date");
		l3=new JLabel("Time");
		ll1=new JLabel("");
		ll2=new JLabel("");
		
		Date date=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yy");
		String str=formatter.format(date);
		ll1.setText(str);
		
		LocalTime time=LocalTime.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("HH:mm:ss");
		ll2.setText(dtf.format(time));
		
		lb1=new JLabel("Product Details");
		lb2=new JLabel("Product ID");
		lb3=new JLabel("Product Name");
		lb4=new JLabel("Rate");
		lb5=new JLabel("Quantity");
		lb6=new JLabel("Description");
		
		ImageIcon i2=new ImageIcon("D:/AJP/add.png");
		b1=new JButton(i2);
		b1.setText("ADD");
		
		ImageIcon i3=new ImageIcon("D:/AJP/save.png");
		b2=new JButton(i3);
		b2.setText("Save");
		
		ImageIcon i4=new ImageIcon("D:/AJP/reset.png");
		b3=new JButton(i4);
		b3.setText("Reset");
		
//		ImageIcon i5=new ImageIcon("D:/AJP/Close jframe.png");
//		b4=new JButton(i5);
//		b4.setBackground(Color.WHITE);
		
		le1=new JLabel("Calculation Details");
		le2=new JLabel("Total");
		
		tf1=new JTextField(30);
		tf2=new JTextField(30);
		tf3=new JTextField(30);
		tf4=new JTextField(30);
		tf5=new JTextField(30);
		
		tx1=new JTextField(30);
		
		l2.setFont(f2);
		l3.setFont(f2);
		
		lb1.setFont(f2);
		ll1.setFont(f2);
		ll2.setFont(f2);
		
		lb2.setFont(f2);
		lb3.setFont(f2);
		lb4.setFont(f2);
		lb5.setFont(f2);
		lb6.setFont(f2);
		b1.setFont(f2);
		b2.setFont(f2);
		b3.setFont(f2);
		
		sr.setFont(f2);
		bk.setFont(f2);
		le1.setFont(f3);
		le2.setFont(f2);
		
		p1.add(l1);p1.add(ll1);p1.add(l2);p1.add(ll2);p1.add(l3);
		add(lb1);add(lb2);add(lb3);add(lb4);add(lb5);add(lb6);p1.add(bk);
		add(tf1);add(tf2);add(tf3);add(tf4);add(tf5);
		add(tx1);
		add(le1);add(le2);
		add(b1);add(b2);add(b3);
		add(sr);
		
		
		l1.setBounds(280,50,300,100);
		l2.setBounds(850,30,100,30);
		l3.setBounds(850,70,100,50);
		
		ll1.setBounds(960,30,100,30);
		ll2.setBounds(960,70,100,50);
		
		lb1.setBounds(50,170,150,30);
		
		lb2.setBounds(50,240,100,25);
		tf1.setBounds(160,240,50,25);
		lb3.setBounds(250,240,150,25);
		tf2.setBounds(390,240,150,25);
		
		lb4.setBounds(570,240,60,25);
		tf3.setBounds(620,240,70,25);
		
		lb5.setBounds(720,240,80,25);
		tf4.setBounds(810,240,70,25);
		
		lb6.setBounds(930,240,150,25);
		tf5.setBounds(1050,240,150,25);
		
		b1.setBounds(1080,300,100,40);
	    bk.setBounds(1100,5,100,30);
		
		
		le1.setBounds(720,450,400,30);
		le2.setBounds(720,500,100,30);
		tx1.setBounds(780,500,100,30);
		
		sr.setBounds(50,300,100,30);
		b2.setBounds(720,620,150,40);
		b3.setBounds(950,620,150,40);
		
		b3.addActionListener(this);
	    b1.addActionListener(this);
	    b2.addActionListener(this);
		bk.addActionListener(this);
		sr.addActionListener(this);
		
		
	}
	public static void main(String args[]) throws Exception
	{
		
		Billing bl=new Billing();
		
		bl.setVisible(true);
		bl.setSize(1220,750);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s=e.getActionCommand();
		Object b=e.getSource();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/ajp_prj","root","Bhumika@1306");
		Statement st=con.createStatement();
		
		if(b==sr)
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
			tf4.setText(rs.getInt(4)+"");
			tf5.setText(rs.getString(5));
			
			tf1.setEditable(false);
			tf2.setEditable(false);
	     	tf3.setEditable(false);
			tf5.setEditable(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Product doesn't Exist");
			}
	}
		
		if(b==bk)
		{
			this.setVisible(false);
			Home h1=new Home();
			h1.setUndecorated(true);
			h1.setSize(980,570);
		    h1.setVisible(true);
		}
		if(s.equals("Reset"))
		{
			   tf1.setEditable(true);
				tf2.setEditable(true);
		     	tf3.setEditable(true);
				tf5.setEditable(true);
				
		   tf1.setText("");
		   tf2.setText("");
		   tf3.setText("");
		   tf4.setText("");
		   tf5.setText("");
		   tx1.setText("");
		   
		}
		if(b==b1)
		{

			int id=Integer.parseInt(tf1.getText());
			int qy=Integer.parseInt(tf4.getText());
			Statement sq=con.createStatement();
			ResultSet r2=sq.executeQuery("select quantity from details where pid="+id);
			
			while(r2.next())
			{
				qt=r2.getInt(1);
			}
			if(qt<=0)
			{
				JOptionPane.showMessageDialog(null, "Product Quantity not available");
			}
			else
			{
			if(qy>qt)
			{
				JOptionPane.showMessageDialog(null, "Available quantity is less than requirement");
			}
			
			else
			{
			PreparedStatement pstmt=con.prepareStatement("insert into bill_tbl values(?,?,?,?,?)");
			String name=tf2.getText();
			String desc=tf5.getText();
			int rate=Integer.parseInt(tf3.getText());
			int qty=Integer.parseInt(tf4.getText());
			int total=Integer.parseInt(tf3.getText())*Integer.parseInt(tf4.getText());
			
			pstmt.setString(1,name);
			pstmt.setString(2,desc);
			pstmt.setInt(3,rate);
			pstmt.setInt(4,qty);
			pstmt.setInt(5,total);
			
			pstmt.executeUpdate();
		
			String [] Column= {"Name","Desccription","Rate","Quantity","Total"};
			String[][] Row= {{"ABC","abc","1200","20","100"}};
			model = new DefaultTableModel(Row,Column);
			 
		       t1=new JTable(model);
		    //    tb1.setBackground(new Color(176,196,222));
		        JScrollPane s1=new JScrollPane(t1);
		        s1.setBounds(100,400,500,200);
		        c.add(s1);
		        
			    String query="select * from bill_tbl";
				ResultSet rs=st.executeQuery("select * from bill_tbl");
				model.setRowCount(0);
				while(rs.next())
				{
					Vector v=new Vector();
					for(int i=1;i<=100;i++)
					{
						
						v.add(rs.getString("name"));
						v.add(rs.getString("description"));
						v.add(rs.getInt("rate"));
						v.add(rs.getInt("quantity"));
						v.add(rs.getInt("total"));
					}
					model.addRow(v);
				}
				
				
				Statement stmt=con.createStatement();
				String qr="SELECT SUM(total) FROM bill_tbl";
				ResultSet rst=stmt.executeQuery(qr);
					while(rst.next())
					{
						int totalsum=rst.getInt(1);
						  tx1.setText(totalsum+"");
					}
				
				
		
		int nm=Integer.parseInt(tf3.getText());

		int qty1=Integer.parseInt(tf4.getText());
		int nm2=Integer.parseInt(tf1.getText());
		Statement stmt2=con.createStatement();
		ResultSet rs2=stmt2.executeQuery("select quantity from details where pid="+nm2);
		
		while(rs2.next())
		{
			qty2=rs2.getInt(1);
		}
		int finalqty=qty2-qty1;
		Statement stmt3=con.createStatement();
		PreparedStatement ptmt=con.prepareStatement("update details set quantity=? where pid="+nm2);
		ptmt.setInt(1, finalqty);
		int x=ptmt.executeUpdate();
		System.out.println(x);
			stmt.close();		
			rs.close();
			st.close();

			con.close();
			
			}
			}
		 }
		if(b==b2)
		{
			
			this.setVisible(false);
			Final_bill h1=new Final_bill();
			h1.setUndecorated(true);
			h1.setSize(800,620);
		    h1.setVisible(true);
		    
			model.setRowCount(0);
			  tx1.setText("");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("delete from bill_tbl");
		
			
		}
		
		}
			catch(Exception ex)
			{
				
			}
		}
		
}

