import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class Final_bill extends JFrame implements ActionListener{
TextArea t1;
Container ct;
Color c;
JButton bk,cs;
Final_bill()
	{
	
	
	
	
	ct=getContentPane();
	

	bk=new JButton("Back");
	ct.add(bk);
	bk.setBounds(700,570,70,30);
	bk.addActionListener(this);
	
  	
   	ImageIcon i5=new ImageIcon("D:/AJP/Close jframe.png");
	cs=new JButton(i5);
	ct.add(cs);
	cs.setBounds(770,0,30,30);
	cs.addActionListener(this);
	
	
	c= new Color(255,170,26);
	
	ct.setBackground(c);
	
	JLabel l1=new JLabel("BILL");
	Font f1=new Font("Cambria",Font.BOLD,40);
	l1.setFont(f1);
	add(l1);
	l1.setBounds(350,20,200,50);
	
	
	setLayout(null);
	t1=new TextArea(" ",10,10,TextArea.SCROLLBARS_NONE);
	t1.setEditable(false);
	add(t1);
	t1.setBounds(40,80,700,470);
	
	c= new Color(255,253,210);
	t1.setBackground(c);
	
	
	int tt=0;
	t1.setText(t1.getText()+"\n\n\tName\t\tDescription\t\tRate\t\tQuantity\t\tTotal\n\n\t==================================================================================\n");
	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/ajp_prj","root","Bhumika@1306");
			Statement st=con.createStatement();
			String query="select * from bill_tbl";
			ResultSet rs=st.executeQuery("select * from bill_tbl");
			while(rs.next())
			{
				String name=rs.getString(1);
				String des=rs.getString(2);
				int rate=rs.getInt(3);
				int qty=rs.getInt(4);
				int total=rs.getInt(5);
				tt+=total;
				t1.setText(t1.getText()+"\n\t"+name+"\t\t"+des+"\t\t\t"+rate+"\t\t"+qty+"\t\t"+total);
				
				
			}
			t1.setText(t1.getText()+"\n\n\n\t----------------------------------------------------------------------------------------------------------------------------------------------");
			t1.setText(t1.getText()+"\t\t\t\t\t\t\t\t\t\tTotal="+tt);
		}
			catch(Exception e)
			{
				
			}

			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Final_bill f1=new Final_bill();
		f1.setUndecorated(true);
		f1.setSize(800,620);
		f1.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object b=e.getSource();
		if(b==bk)
		{
			this.setVisible(false);
			Billing lg=new Billing();
			lg.setUndecorated(true);
			lg.setSize(1230,750);
		    lg.setVisible(true);
		}
		if(b==cs)
		{
			System.exit(0);

		}
	}

}
