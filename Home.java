import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener{
	
	JButton l1,l2,l3,l4,l5,l6; 
	JLabel lb1,lb2,lb3,lb4,lb5,lb6;
	JLabel im;
	Color c;

	Home()  
      {
		Container ct=getContentPane();
		setLayout(null);
		Font f1=new Font("Cambria",Font.BOLD,20);
		c= new Color(255,253,210);
		ct.setBackground(c);
		
		
		lb1=new JLabel("New Product");
		lb2=new JLabel("Update Product");
		lb3=new JLabel("Delete Product");
		lb4=new JLabel("Product Details");
		lb5=new JLabel("Billing");
		lb6=new JLabel("Logout");
		
		ImageIcon ii1=new ImageIcon("D:/AJP/new product.png");	
      	l1=new JButton(ii1);
      	
      	ImageIcon ii2=new ImageIcon("D:/AJP/update product.png");	
      	l2=new JButton(ii2);
      	
      	ImageIcon ii3=new ImageIcon("D:/AJP/delete product.png");	
      	l3=new JButton(ii3);
      	
      	ImageIcon ii4=new ImageIcon("D:/AJP/details product.png");	
      	l4=new JButton(ii4);
      	
      	ImageIcon ii5=new ImageIcon("D:/AJP/billing.png");	
      	l5=new JButton(ii5);
      	
      	ImageIcon ii6=new ImageIcon("D:/AJP/logout.png");	
      	l6=new JButton(ii6);
	    	
      	ImageIcon img=new ImageIcon("D:/AJP/bkimg.png");
      	im=new JLabel(img);
      	add(im);
      	im.setBounds(200,200,600,400);
      	
        l1.setBackground(Color.WHITE);
        l2.setBackground(Color.WHITE);
        l3.setBackground(Color.WHITE);
        l4.setBackground(Color.WHITE);
        l5.setBackground(Color.WHITE);
        l6.setBackground(Color.WHITE);
      	
      	lb1.setFont(f1);
      	lb2.setFont(f1);
      	lb3.setFont(f1);
      	lb4.setFont(f1);
      	lb5.setFont(f1);
      	lb6.setFont(f1);
      	
      	add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);
      	add(lb1);add(lb2);add(lb3);add(lb4);add(lb5);add(lb6);
      	
      	l1.setBounds(50,50,80,80);
      	l2.setBounds(200,50,80,80);
      	l3.setBounds(350,50,80,80);
      	l4.setBounds(520,50,80,80);
      	l5.setBounds(700,50,80,80);
      	l6.setBounds(850,50,80,80);
      	
      	lb1.setBounds(30,110,120,80);
      	lb2.setBounds(170,110,160,80);
      	lb3.setBounds(330,110,160,80);
      	lb4.setBounds(490,110,160,80);
      	lb5.setBounds(710,110,160,80);
      	lb6.setBounds(860,110,160,80);
      	
      l1.addActionListener(this);
      l2.addActionListener(this);
      l3.addActionListener(this);
      l4.addActionListener(this);
      l5.addActionListener(this);
      l6.addActionListener(this);
      }
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Home h1=new Home();
		h1.setUndecorated(true);
      h1.setVisible(true);
      h1.setSize(980,570);
	}

	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		 Object s=e.getSource();
		if(s==l6)
		{
			this.setVisible(false);
		Login lg=new Login();
		lg.setUndecorated(true);
		lg.setSize(900,500);
	    lg.setVisible(true);	
	    }
		else if(s==l5)
		{
			this.setVisible(false);
			Billing lg=new Billing();
			lg.setUndecorated(true);
			lg.setSize(1230,750);
		    lg.setVisible(true);
		}
		else if(s==l1)
		{
			this.setVisible(false);
			new_product lg=new new_product();
			lg.setUndecorated(true);
			lg.setSize(900,750);
		    lg.setVisible(true);
		}
		else if(s==l2)
		{
			this.setVisible(false);
			update_product lg=new update_product();
			lg.setUndecorated(true);
			lg.setSize(900,750);
		    lg.setVisible(true);
		}
		else if(s==l3)
		{
			this.setVisible(false);
			delete_product lg=new delete_product();
			lg.setUndecorated(true);
			lg.setSize(900,750);
		    lg.setVisible(true);
		}
		else if(s==l4)
		{
			this.setVisible(false);
			Product_Details lg=new Product_Details();
			lg.setUndecorated(true);
			lg.setSize(900,750);
		    lg.setVisible(true);
		}
	
	}

}
