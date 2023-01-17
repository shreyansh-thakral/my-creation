/*
Shreyansh Thakral
March 26th 2020
Ms. Basaraba
The Bird Thread
*/
import java.awt.*;
import hsa.Console;

public class Bird implements Runnable
{
    private Console c;
    private int x = 220, y = 271;
    private void drawTriangle (int x1, int y1, int x2, int y2, int x3, int y3)  // creates a function to draw a triangle as hsa.Console doesn't have one
    {

	c.drawLine (x1, y1, x2, y2);
	c.drawLine (x2, y2, x3, y3);
	c.drawLine (x3, y3, x1, y1);
    }


    public void drawBird ()
    {
	for (int i = 0 ; i < 550 ; i++)
	{
	    synchronized (c)
	    {
		c.setColor (new Color (10, 178, 52));
		c.fillRect (x - 15 - i, y - 20, 45, 35); // erase
	    }
	    synchronized (c)
	    {
		c.setColor (Color.cyan);
		c.fillArc (x - 15 - i, y - 15, 30, 30, 0, -240); // body
		c.fillArc (x - 2 - i, y - 15, 30, 30, 30, -60); // tail
		c.fillRoundRect (x - 15 - i, y - 20, 12, 20, 8, 8); // head
		c.setColor (Color.blue);
		c.fillArc (x - 10 - i, y - 15, 23, 23, 0, -180); // wing

	    }

	    synchronized (c)
	    {
		c.setColor (Color.black);
		c.drawArc (x - 10 - i, y - 15, 23, 23, 0, -180); // wing outline
		for (int j = 0 ; j <= 5 ; j++)
		{
		    drawTriangle (x - 15 - i, y - 12 + j, x - 15 - i, y - 7 - j, x - 22 - i, y - 10); // beak
		}
		c.fillOval (x - 12 - i, y - 13, 3, 3); // eye

	    }
	    try
	    {
		Thread.sleep (100);
	    }
	    catch (Exception e)
	    {
	    }
	}

    }


    public Bird (Console con)  // regular, white cloud at default location
    {
	c = con;
    }


    public void run ()  //starts animation
    {
	drawBird ();
    }
}






