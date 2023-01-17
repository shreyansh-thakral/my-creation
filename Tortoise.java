/*
Shreyansh Thakral
March 26th 2020
Ms. Basaraba
The Tortoise Thread
*/
import java.awt.*;
import hsa.Console;

public class Tortoise extends Thread
{
    private Console c;
    private int x = -100, y = 450;
    public void drawTortoise ()
    {
	for (int i = 0 ; i < 535 ; i++)
	{
	    synchronized (c)
	    {
		c.setColor (new Color (163, 117, 65)); // sets colour for path
		c.fillRect (x - 37 + i, y - 25, 70, 50);
		// redraws finish line so that it is not erased
		c.setColor (new Color (220, 30, 30)); // sets colour for finish line
		for (int j = 0 ; j <= 10 ; j++) // for loop that draws the finish line
		{
		    c.drawLine (403 + j, 380, 440 + j, 500);
		}
	    }
	    synchronized (c)
	    {
		c.setColor (new Color (40, 100, 40)); // dark green
		c.fillRoundRect (x - 22 + i, y + 3, 15, 20, 5, 5);
		c.fillRoundRect (x + 7 + i, y + 3, 15, 20, 5, 5);

		c.setColor (new Color (231, 151, 79)); // tan
		c.fillArc (x - 30 + i, y - 25, 60, 50, 0, 180);
		c.fillRoundRect (x - 35 + i, y, 70, 10, 10, 10);
	    }

	    synchronized (c)
	    {
		c.setColor (new Color (101, 67, 33)); // dark brown
		c.drawArc (x - 30 + i, y - 25, 60, 50, 0, 180);
		c.drawRoundRect (x - 35 + i, y, 70, 10, 10, 10);
		for (int j = 0 ; j < 2 ; j++)
		{
		    c.fillOval (x - 15 + i + j * 16, y - 21, 14, 8);
		}
		for (int j = 0 ; j < 3 ; j++)
		{
		    c.fillOval (x - 22 + i + j * 16, y - 11, 14, 8);
		}
	    }
	    synchronized (c)
	    {
		c.setColor (new Color (40, 100, 40)); // dark green
		c.fillOval (x + 28 + i, y - 7, 15, 15);

		c.setColor (Color.black);
		c.fillOval (x + 37 + i, y - 3, 3, 3);
		c.drawArc (x + 35 + i, y, 10, 5, -90, -60);
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


    public Tortoise (Console con)  // regular, white cloud at default location
    {
	c = con;
    }


    public void run ()  //starts animation
    {
	drawTortoise ();
    }
}







