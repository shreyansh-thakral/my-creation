/*
Shreyansh Thakral
March 26th 2020
Ms. Basaraba
The Monkey Thread
*/
import java.awt.*;
import hsa.Console;

public class Monkey extends Thread
{
    private Console c;
    private int x = -190, y = 440;
    public void drawMonkey ()
    {
	for (int i = 0 ; i < 550 ; i++)
	{
	    synchronized (c)
	    {
		c.setColor (new Color (163, 117, 65)); // sets colour for path
		c.fillRect (x + i - 31, y - 15, 63, 100);  // erase
	    }
	    synchronized (c)
	    {
		c.setColor (new Color (71, 42, 25)); // sets color for base
		c.fillRoundRect (x + i - 20, y - 15, 40, 30, 15, 15);  // face/head
		c.fillArc (x + i - 14, y + 8, 28, 15, 0, -180);  // face/chin
		c.fillOval (x + i - 10, y + 19, 20, 40);  // body
		c.fillRect (x + i - 7, y + 50, 5, 30);  // legs
		c.fillRect (x + i + 2, y + 50, 5, 30);
		c.fillRect (x + i - 25, y + 30, 50, 5); // arms
	    }

	    synchronized (c)
	    {
		c.setColor (new Color (229, 203, 144));
		c.fillOval (x + i - 16, y - 10, 17, 22); // face accents
		c.fillOval (x + i - 2, y - 10, 17, 22);
		c.fillOval (x + i - 9, y + 8, 17, 12);
		c.fillArc (x + i - 26, y - 8, 12, 15, 90, 180);  // ears
		c.fillArc (x + i + 14, y - 8, 12, 15, 90, -180);
		c.fillOval (x + i - 12, y + 73, 12, 9);  // feet
		c.fillOval (x + i + 1, y + 73, 12, 9);
	    }
	    synchronized (c)
	    {
		c.setColor (Color.white);
		c.fillOval (x + i - 14, y - 4, 12, 12);  // eyes
		c.fillOval (x + i, y - 4, 12, 12);
		c.setColor (Color.black);
		c.drawArc (x + i - 9, y + 6, 15, 10, -30, -110);  // mouth
		c.fillOval (x + i - 10, y - 1, 6, 6);  // pupils
		c.fillOval (x + i + 4, y - 1, 6, 6);
		c.setColor (new Color (40, 100, 40));
		c.fillOval (x + i - 30, y + 26, 12, 17); // pompoms
		c.fillOval (x + i + 20, y + 26, 12, 17);
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
    public Monkey (Console con)  // regular, white cloud at default location
    {
	c = con;
    }


    public void run ()  //starts animation
    {
	drawMonkey ();
    }
}






