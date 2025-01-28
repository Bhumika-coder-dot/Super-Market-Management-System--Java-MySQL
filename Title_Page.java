import java.awt.*;
import javax.swing.*;

public class Title_Page extends JFrame{
	JProgressBar jb;
	int i=0;
	Color c;
	JLabel lb,lb2;
	Title_Page()
	{	
		
		Container c1=getContentPane();
	
		ImageIcon i1=new ImageIcon("D:/AJP/SuperMarket_home.png");
		lb=new JLabel(i1);
		c1.add(lb);
		lb.setBounds(300,100,350,400);
			
		Panel p1=new Panel();
		
		c= new Color(255,253,210);
		c1.setBackground(c);
		
		c= new Color(255,170,26);
		//c= new Color(255,170,26);
		p1.setBackground(c);
		c1.add(p1);
		p1.setBounds(0,0,950,100);
		Font f1=new Font("Cambria",Font.BOLD,40);
		
	     JLabel l1=new JLabel("SUPER MARKET MANAGEMENT SYSTEM");
	     l1.setFont(f1);
	     p1.add(l1);
	   	l1.setBounds(50,10,500,50);
		
		jb=new JProgressBar(SwingConstants.HORIZONTAL,0,100);
		jb.setForeground(c);
		jb.setBackground(Color.WHITE);
		
		setLayout(null);
		jb.setStringPainted(true);
		jb.setBounds(50,500,850,30);
		//jb.setValue(100);
		c1.add(jb);		
	}	
	public void iterate()
	{
		while(i<=100)
		{
			jb.setValue(i);
			try {
				Thread.sleep(100);
			}
			catch(Exception e)
			{
				
			}
			i++;
			if(jb.getValue()==100)
			{
				this.setVisible(false);
				Login lg=new Login();
				lg.setUndecorated(true);
				lg.setSize(950,550);
			    lg.setVisible(true);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Title_Page t1=new Title_Page();
		t1.setUndecorated(true);
		t1.setVisible(true);
		
		t1.setSize(950,550);	
		t1.iterate();
	}
}
