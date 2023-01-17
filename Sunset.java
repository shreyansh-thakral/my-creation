/*
Shreyansh Thakral
March 26th 2020
Ms. Basaraba
The Sunset Thread
*/
import java.awt.*;
import hsa.Console;

public class Sunset extends Thread
{
    private Console c;
    private Color sun;
    private int x = 380, y = 0; // reference variables allow whole object to be repositioned easily

    private void drawTriangle (int x1, int y1, int x2, int y2, int x3, int y3)  // creates a function to draw a triangle as hsa.Console doesn't have one
    {

	c.drawLine (x1, y1, x2, y2);
	c.drawLine (x2, y2, x3, y3);
	c.drawLine (x3, y3, x1, y1);
    }


    public void drawSun ()
    {
	for (int i = 0 ; i <= 110 ; i++)
	{
	    synchronized (c)
	    {
		c.setColor (new Color (25, 217, 253)); // sets colour for sky
		c.fillOval (x - 61, y - 61 + i, 122, 122); // repeatedly draws patch of sky to erase tail
	    }

	    for (int j = 10 ; j > 0 ; j--) // for loop to make rays solid
	    {
		int k = j - 3;
		synchronized (c)
		{
		    c.setColor (new Color (255, 128, 0)); // orange rays
		    drawTriangle (x - j, y + i, x + j, y + i, x, y + i + 60); // draws lateral rays
		    drawTriangle (x - j, y + i, x + j, y + i, x, y + i - 60);
		    drawTriangle (x, y + i - j, x, y + i + j, x - 60, y + i);
		    drawTriangle (x, y + i - j, x, y + i + j, x + 60, y + i);

		    drawTriangle (x - k, y + i + k, x + k, y + i - k, x - 42, y + i - 42); // draws diagonal rays
		    drawTriangle (x - k, y + i + k, x + k, y + i - k, x + 42, y + i + 42);
		    drawTriangle (x - k, y + i - k, x + k, y + i + k, x + 42, y + i - 42);
		    drawTriangle (x - k, y + i - k, x + k, y + i + k, x - 42, y + i + 42);
		}
	    }

	    synchronized (c)
	    {
	    c.setColor (Color.yellow);
	    c.fillOval (x - 30, y + i - 30, 60, 60); // draws sun
	    c.setColor (Color.black);
	    c.drawArc (x - 23, y + i - 23, 45, 45, -15, 80); // adds perspective
	    }
	    try
	    {
		Thread.sleep (700);
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public Sunset (Console con)  // regular, white cloud at default location
    {
	c = con;
    }


    public void run ()  //starts animation
    {
	drawSun ();
    }
}


