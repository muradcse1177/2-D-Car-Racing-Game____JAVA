import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;


public class MAIN extends JFrame 
{	
	
	
	MAIN()
	{
	
		final road r=new road(this);//creating road class object
		this.add(r);
		
		setSize(498,744);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		addKeyListener(new KeyAdapter() {
			
			/*calling function from car control object*/
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_LEFT)
				{
					r.car.changeX(-8);
					
			     }
				if(e.getKeyCode()==KeyEvent.VK_RIGHT)
				{
					r.car.changeX(8);
					
				}
				if(e.getKeyCode()==KeyEvent.VK_UP)
				{
					r.car.changeY(-3);
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN)
				{
					r.car.changeY(5);
					
				}
			}
		});
	}
	
}
