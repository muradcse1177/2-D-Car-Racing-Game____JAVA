import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class road extends JPanel implements ActionListener{
	
	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("File");
	JMenuItem item = new JMenuItem("Exit");

	JLabel j=new JLabel();//for setting road
	JLabel m = new JLabel();//for setting road
	JLabel mor=new JLabel();
	JLabel traffic_light=new JLabel();
	JLabel grass=new JLabel();
	JLabel grass2=new JLabel();
	Timer tim=new Timer();
	
	int x=348,y=0;//object j coordinate
	int yy=-744;//object m coordinate
	int xxx;
	int gposX=348,gposY=0;//grass coordinate
	int gpos2Y=-744;//grass2 coordinate
	
	car_control car;
	
	MAIN ob;


	public road(MAIN ob)
	{
		this.ob = ob;
		menu.add(item);
		menubar.add(menu);
		add(menubar);
		
		item.addActionListener(this);
		
		
		car = new car_control(this);//creating car control class object
		
		setBackground(Color.BLACK);
		
		
		add(car);
		add(j);
		
		add(m);
		add(grass);
		add(grass2);
		
		
		
		j.setIcon(new ImageIcon("src/jjj.png"));
		m.setIcon(new ImageIcon("src/jjj.png"));
		traffic_light.setIcon(new ImageIcon("src/trafficlight.png"));
		grass.setIcon(new ImageIcon("src/jhjfkhfjhf.png"));
        grass2.setIcon(new ImageIcon("src/jhjfkhfjhf.png"));
		tim.scheduleAtFixedRate(new TimerTask() {
			public void run()
			{
				
				y+=5;
				yy+=5;
				gposY+=5;
				gpos2Y+=5;
				
		
				if(y>748||yy>748)
				{
					yy=-4;
					y=-748;
				}
				
				if(gposY>748||gpos2Y>748)
				{
					gpos2Y=-4;
					gposY=-748;
				}
				repaint();
		
			}
			
		},100,18);
	}
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		j.setLocation(0,y);
		m.setLocation(0, yy);
		grass.setLocation(348,gposY);
		grass2.setLocation(348,gpos2Y);
		traffic_light.setLocation(300,0);		
		car.setSize(348, 744);//car_control panel size
		car.setLocation(0, 0);
		
		menubar.setLocation(0, 0);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==item)
		ob.dispose();
		
	}
	
}
