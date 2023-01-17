/*
Shreyansh Thakral
March 26th 2020
Ms. Basaraba
Draws the static background
*/
import java.awt.*;
import hsa.Console;

public class Background
{
    Console c;
    public Background (Console con)
    {
	c = con;
	base ();
	mountains ();
	plants ();
	name ();
    }


    private void drawTriangle (int x1, int y1, int x2, int y2, int x3, int y3)  // creates a function to draw a triangle as hsa.Console doesn't have one
    {

	c.drawLine (x1, y1, x2, y2);
	c.drawLine (x2, y2, x3, y3);
	c.drawLine (x3, y3, x1, y1);
    }


    private void drawBush (int x, int y, int numberOfBushes)  // creates a function to draw a straight line of bush components, parallel to the x-axis, that can be used for bushes, tree tops, etc.
    {
	for (int j = 0 ; j < numberOfBushes * 20 ; j += 20) // for loop that draws the required ammount of bushes: count is added to all the x values to repeat the commands to draw the bushes every 20 pixels,
	{
	    for (int i = 0 ; i <= 20 ; i++) // for loop that makes the bush component a solid object
	    {
		c.drawRect (x + j, y, 20 - i, 20 - i); // draws bush component in reference to provided coordinates and count variables: the constants are used to specify the x and y value of each shape relative to the input given,  while i
		c.drawOval (x - 15 + j + i, y, 30 - 2 * i, 20);
		c.drawOval (x + 8 + j + i, y, 30 - 2 * i, 20);
		c.drawOval (x - 5 + j + i, y - 8, 30 - 2 * i, 20);
	    }
	}
    }


    public void base ()
    {

	for (int i = 0 ; i <= 640 ; i++) // makes rectangles solid
	{
	    c.setColor (new Color (25, 217, 253)); // sets colour for sky
	    c.drawRect (0, 0, i, 240); // draws sky
	    c.setColor (new Color (10, 178, 52)); // sets colour for grass
	    c.drawRect (0, 240, i, 380); // draws ground
	    c.setColor (new Color (163, 117, 65)); // sets colour for path
	    c.drawRect (0, 380, i, 500); // draws path
	}

	c.setColor (new Color (17, 141, 214)); // sets colour for river
	for (int i = 0 ; i <= 150 ; i++) // for loop that draws the river
	{
	    int j = (int) Math.round (i * 0.1); // calculates the count for the back part of the river making it smaller to add perspective
	    c.drawLine (430 + j, 240, 530 + i, 500);
	}
	c.setColor (new Color (220, 30, 30)); // sets colour for finish line
	for (int i = 0 ; i <= 10 ; i++) // for loop that draws the finish line
	{
	    c.drawLine (403 + i, 380, 440 + i, 500);
	}

    }


    public void mountains ()
    {
	c.setColor (new Color (71, 42, 25)); // sets colour for further mountains (dull)
	for (int i = 0 ; i <= 100 ; i++) // makes mountains solid
	{
	    drawTriangle (0 + i, 240, 100, 140 + i, 200 - i, 240); //draws further mountains
	    drawTriangle (370 + i, 240, 460, 100 + i, 530 - i, 240);
	}

	c.setColor (new Color (61, 32, 15)); // sets colour for closer mountains (vivid)
	for (int i = 0 ; i <= 130 ; i++) // different for loop needed as the count needed to fill the 2nd mountain is too big to be executed on the 1st mountain
	{
	    drawTriangle (140 + i, 240, 260, 100 + i, 400 - i, 240); //draws closer mountains
	    drawTriangle (480 + i, 240, 600, 120 + i, 700 - i, 240);
	}



	for (int i = 0 ; i <= 40 ; i++) // for loop to draw snow on mountains
	{
	    c.setColor (new Color (230, 225, 225)); // sets colour for snow on further mountains (dull)
	    drawTriangle (60 + i, 180, 100, 140 + i, 140 - i, 180); // draws snow capped peaks
	    drawTriangle (434 + i, 140, 460, 100 + i, 480 - i, 140);
	    c.setColor (new Color (240, 235, 235)); // sets colour for snow on closer mountains (vivid)
	    drawTriangle (225 + i, 140, 260, 100 + i, 300 - i, 140);
	    drawTriangle (560 + i, 160, 600, 120 + i, 634 - i, 160);
	}
    }


    public void plants ()
    {
	c.setColor (new Color (139, 69, 19)); // sets colour for tree trunk
	for (int i = 0 ; i <= 23 ; i++)
	{
	    c.drawRect (280, 320, 23 - i, 80); // draws trunk
	}

	c.setColor (new Color (48, 97, 39)); // sets colour for furthest bushes (very dull)
	drawBush (0, 230, 32);
	c.setColor (new Color (38, 97, 29)); // sets colour for middle bushes (slightly dull)
	drawBush (370, 280, 2);
	drawBush (180, 300, 1);
	drawBush (570, 310, 2);
	drawBush (30, 290, 1);
	drawBush (20, 300, 2);
	drawBush (120, 345, 1);
	drawBush (410, 330, 1);
	c.setColor (new Color (28, 97, 19)); // sets colour for closest bushes (vivid)
	drawBush (270, 280, 2);
	drawBush (260, 295, 3);
	drawBush (270, 305, 2);
	drawBush (253, 390, 2);
    }


    public void name ()
    {
	c.setColor (Color.white);
	c.drawString ("Shreyansh", 550, 470);
    }
}
