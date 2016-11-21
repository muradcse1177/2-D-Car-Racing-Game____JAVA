import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class car_control extends JPanel{

	JLabel user_car=new JLabel();//user car label
	JLabel car_1=new JLabel();//left car label from right
	JLabel car_2=new JLabel();//2 left car label from right
	JLabel car_3=new JLabel();//3 left car label from right
	JLabel bus=new JLabel();//bus car label
	JLabel score=new JLabel("Score:");
	JLabel score1=new JLabel();//scoring(digit)
	JLabel lane_warning=new JLabel();
	JLabel crash_warning=new JLabel();
	JLabel game_over=new JLabel();
	
	Timer timm=new Timer();
	
	/*this is for counter & cars co-ordinates*/
	
	int crash_counter=1;
	int score_counter=0;
	int x=0,y=350;//user car co-ordinate
	int xx=155,yy=70;//car_1 co-ordinate
	int xxx=220,yyy=-800;//car_2 co-ordinate
	int xxxx=285,yyyy=-1000;//car_3 co-ordinate
	int bposX=110,bposY=744;//bus co-ordinate
  
	/*constructor function*/
	
	public car_control(final road ob1)
{
	setOpaque(false);
	/*adding into panel*/
	add(game_over);
	game_over.setVisible(false);
	add(score);
	add(score1);
	
	add(user_car);
	
	add(lane_warning);
	add(car_1);
	
	
	add(car_2);
	add(car_3);
	
	
	
	add(crash_warning);
	add(bus);
	/*import pic for cars*/
	user_car.setIcon(new ImageIcon("src/user_car.png"));
    car_1.setIcon(new ImageIcon("src/neww2.png"));
    car_2.setIcon(new ImageIcon("src/newcar.png"));
    car_3.setIcon(new ImageIcon("src/newww3.png"));
    game_over.setIcon(new ImageIcon("src/game_over_400.png"));
    bus.setIcon(new ImageIcon("src/bus.png"));
    lane_warning.setFont(new Font("Gill sans",Font.ITALIC,20));
    score.setFont(new Font("Gill sans",Font.ITALIC,20));
    score1.setFont(new Font("Gill sans",Font.ITALIC,20));
    
    lane_warning.setForeground(Color.red);
    crash_warning.setFont(new Font("Gill sans",Font.ITALIC,20));
    crash_warning.setForeground(Color.red);
    score.setForeground(Color.white);
    timm.scheduleAtFixedRate(new TimerTask() {
        /*used for moving cars*/
    	public void run()
    	{
    	   yy+=2;
    	   yyy+=2;
		   yyyy+=3;
		   bposY-=1;
		
		    if(yy>744)
			  yy=-744;
			
		    if(yyy>744)
			  yyy=-500;
			
		    if(yyyy>744)
			  yyyy=-370;
			
		    if(bposY<-160)
			  bposY=1000;
			
		    score_counter++;
			
			/*detect collison if user car try to collison others*/
			
			if((((y<=(yy+136)&&y>=(yy-100))&&(x+50)>=xx&&x<=210))||(((y<(yyy+146))&&(y>(yyy-146))&&((x+77)>xxx&&x<273)))||((y<=(yyyy+146))&&y>=(yyyy-146)&&(x+77>=xxxx))
					||(((y+136>=bposY)&&y<=(bposY+136))&&((x+70)>=bposX&&((x)<=174))))
			{
				       /* detect collison for car_1*/
			    
				if((y<=(yy+136)&&y>=(yy-100))&&((x+50)>xx&&x<210))
					{
						 
						 yy=yy-10;
						 crash_warning.setText("Accident related fine – 500 Tk.");
						 score_counter=0;
						 crash_counter++;
						 
					}
			     
			     /*detect collison for bus*/
			     
			     if((((y+136)>=bposY)&&y<=(bposY+136))&&((x+70)>=bposX&&(x<=174)))
					{
						bposY=bposY+10; 
						crash_warning.setText("Accident related fine – 500 Tk."); 
					    score_counter=0;
					    crash_counter++;
					   
					 }
			    
			     /* detect collison for car_3*/
			     
			     
			     if(((y<=(yyyy+146))&&y>=(yyyy))&&(((x+77)>=xxxx)))
			     {
			    	 yyyy=yyyy-10;
			    	 crash_warning.setText("Accident related fine – 500 Tk."); 
			    	 score_counter=0; 
			    	 crash_counter++;
			    	 
			     }
			     
			    /* detect collison for car_2*/
			     
			     if((((y<=(yyy+146))&&(y>=(yyy)))&&(((x+70)>=xxx&&x<=273))))
			     {
			    	 
			    	 yyy=yyy-10;
			    	 crash_warning.setText("Accident related fine – 500 Tk."); 
			    	 score_counter=0;
			    	 crash_counter++;
			     }
			     
			     /*30 times crash, game is over*/
			     
			     if(crash_counter==30)
			     {
			    	
			    	crash_counter=1;
			    	game_over.setVisible(true);

			    	timm.cancel();
					ob1.tim.cancel();
			     }			  
			}
			
			else
				{
				crash_warning.setText("");
				score1.setText(Integer.toString(score_counter));
				}
    	
    	}
    },100,18);//first value for pre waiting time to execute
              //second one for-how many take time to repeat function
   
}
	/*cars and others location */

	protected void paintComponent(Graphics g)
{
	super.paintComponent(g);
	user_car.setLocation(x,y);
	car_1.setLocation(xx,yy);
	car_2.setLocation(xxx,yyy);
	car_3.setLocation(xxxx,yyyy);
	bus.setLocation(bposX,bposY);
	lane_warning.setLocation(30,300);
	crash_warning.setLocation(30,200);
	score.setVisible(true);
	score.setLocation(200,0);
	score1.setLocation(265,1);
	game_over.setLocation(5,200);
	
	
}

	/*this function is used for moving user car*/
	/*called from main class*/
	
public void changeX(int dx) {
	if(x<0)
		x=0;
 
	else if(x>270)
		x = 270;
	else{
		x = x+dx;
		if(x>100)
		{		
	  lane_warning.setText("Lane violation – 1,000 Tk. Fine");
		}
		if(x<100)
		{
			lane_warning.setText("");
		}
	}
	repaint();
}

/* changing value along y axis*/

public void changeY(int dy){
	  if(y<50)
		 y=50;
	  else if(y>600)
		  y = 600;
	  else 
		  y = y+dy;
	  repaint();
}
}

	

