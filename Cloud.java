/*
Shreyansh Thakral
March 26th 2020
Ms. Basaraba
The Cloud Overloaded Thread
*/
import java.awt.*;
import hsa.Console;

public class Cloud extends Thread
{
    private Console c;
    private Color cloud;
    private int x, y;

    public void drawCloud ()
    {
	for (int i = 0 ; i < 90 ; i++) // animation loop
	{
	    synchronized(c){ 
	    c.setColor (new Color (25, 217, 253)); // sets colour for sky
	    c.fillRect (x - 110 + i, y - 25, 170, 53); // draws patch of sky to cover trail
	    }
	    synchronized(c){
	    c.setColor (Color.black);
	    c.drawArc (x + 15 + i, y, 40, 25, 0, -140); // arcs that outline bottom of cloud
	    c.drawArc (x - 20 + i, y, 40, 25, 0, -140);
	    c.drawArc (x - 55 + i, y, 40, 25, 0, -140);
	    c.drawLine (x - 80 + i, y, x - 60 + i, y); // tail lines
	    c.drawLine (x - 60 + i, y - 12, x - 50 + i, y - 12);
	    c.drawLine (x - 100 + i, y + 12, x - 70 + i, y + 12);
	    }
	    synchronized(c){
	    c.setColor (cloud);
	    c.fillRect (x - 30 + i, y - 10, 60, 20); // base rectangle covers gaps
	    c.fillOval (x - 37 + i, y - 20, 40, 25); // top two ovals of cloud
	    c.fillOval (x - 3 + i, y - 20, 40, 25);
	    c.fillOval (x - 55 + i, y, 40, 25); // bottom three ovals of cloud
	    c.fillOval (x - 20 + i, y, 40, 25);
	    c.fillOval (x + 15 + i, y, 40, 25);
	    }

	    try
	    {
		Thread.sleep (900);
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public Cloud (Console con)  // regular, white cloud at default location
    {
	c = con;
	cloud = Color.white; // default colour
	x = 0;
	y = 70;
    }


    public Cloud (Console con, Color a)  // custom cloud with custom colour and location
    {
	c = con;
	cloud = a; // custom colour
	x = 530; // starting x value
	y = 40; // starting y value
    }


    public Cloud (Console con, int startX, int startY, Color a)  // custom cloud with custom colour and location
    {
	c = con;
	cloud = a; // custom colour
	x = startX; // starting x value
	y = startY; // starting y value
    }


    public void run ()  //starts animation
    {
	drawCloud ();
    }
}



