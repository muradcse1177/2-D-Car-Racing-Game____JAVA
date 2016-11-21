import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FirstStart extends JFrame implements ActionListener{
	
	JButton start = new JButton();
	JButton stop =new JButton();
	JPanel jp=new JPanel();/*a panel into JFrame*/
	JLabel lb =new JLabel();//label for background image
	
	public FirstStart() {
		setLayout(null);
		setSize(498,744);
		//setBackground(Color.darkGray);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		add(jp);
		jp.add(lb);
		jp.setSize(498, 700);
		jp.setLocation(0,50);
		lb.setLocation(0,50);
		lb.setIcon(new ImageIcon("src/background.png"));
		start.setSize(95,37);
		start.setLocation(10,10);
		start.setIcon(new ImageIcon("src/startgame.png"));
		start.setBackground(Color.blue);

		stop.setSize(95,37);
		stop.setLocation(105,10);
		stop.setIcon(new ImageIcon("src/exiiiiiiiitpng.png"));
		stop.setBackground(Color.blue);
		
		
		add(start);
		add(stop);
		
		start.addActionListener(this);
		stop.addActionListener(this);
		
		setBackground(Color.black);
		
	}
	
	
	public static void main(String[] args)
	{
		new FirstStart();
	}


	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==start)
		{
			this.dispose();
			new MAIN();//calling MAIN function
		}
		if(e.getSource()==stop)
		{
			this.dispose();
		}
		
		
	}
	

	

}
