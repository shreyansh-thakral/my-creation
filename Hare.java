/*
Shreyansh Thakral
March 26th 2020
Ms. Basaraba
The Hare Thread
*/
import java.awt.*;
import hsa.Console;

public class Hare extends Thread
{
    private Console c;
    private int x = -200, y = 400;
    public void drawHare ()
    {
	for (int i = 0 ; i < 450 ; i++)
	{
	    synchronized (c)
	    {
		c.setColor (new Color (163, 117, 65)); // sets colour for path
		c.fillRect (x - 26 + i, y - 32, 30, 54);
		c.setColor (new Color (10, 178, 52)); // sets colour for grass
		c.fillRect (x - 26 + i, y - 32, 30, 12);
	    }
	    synchronized (c)
	    {
		c.setColor (Color.white);
		c.fillRoundRect (x - 6 + i, y - 32, 4, 20, 5, 5); // ears
		c.fillRoundRect (x + i, y - 32, 4, 20, 5, 5);
		c.fillArc (x - 8 + i, y - 15, 10, 15, -90, -180); // back of head
		c.fillArc (x - 19 + i, y - 15, 32, 15, -90, 180); // face
		c.fillOval (x - 8 + i, y - 2, 16, 20); // chest
		c.fillArc (x - 16 + i, y, 32, 20, 90, 180); // back
		c.fillRoundRect (x - 18 + i, y + 5, 26, 15, 15, 20); // base/underside
		c.fillOval (x - 24 + i, y + 10, 10, 10); // tail
		c.fillOval (x + 3 + i, y + 14, 10, 7); // front leg
		c.fillOval (x - 14 + i, y + 15, 10, 7); // back leg
	    }
	    synchronized (c)
	    {
		c.setColor (Color.black);
		c.fillOval (x + i, y - 12, 3, 3); // eye
		c.drawArc (x + 6 + i, y - 10, 10, 5, -90, -60); // mouth

		c.setColor (Color.pink);
		c.fillArc (x + 7 + i, y - 15, 8, 8, -60, -60); // nose
	    }

	    try
	    {
		Thread.sleep (15);
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public Hare (Console con)  // regular, white cloud at default location
    {
	c = con;
    }


    public void run ()  //starts animation
    {
	drawHare ();
    }
}






