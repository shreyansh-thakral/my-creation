/*
Shreyansh Thakral
March 26th 2020
Ms. Basaraba  
Main Class calls background and animated threads  
*/
import java.awt.*;
import hsa.Console;


public class MyCreation
{
    Console c;           // The output console
    //adds the Background thread to MyCreation
    public void background ()
    {
	Background b = new Background (c);// static background
    }


    public void cloud ()  //creates the cloud thread
    {
	Cloud a = new Cloud (c); //1st overload
	a.start (); //starts the thread
	Cloud b = new Cloud (c, Color.gray);  //2st overload
	b.start ();
	Cloud d = new Cloud (c, 200, 20, new Color (200, 200, 200));  //3rd overload
	d.start ();
    }


    public void sunset ()
    {
	Sunset p = new Sunset (c);// creates the sunset thread
	//starts the thread
	p.start ();
    }


    public void hare ()  //creates the Hare thread
    {
	Hare q = new Hare (c); //creates new instance
	q.start (); //starts the thread
    }
    
    public void tortoise ()  //creates the Tortoise thread
    {
	Tortoise r = new Tortoise (c); //creates new instance
	r.start (); //starts the thread
    }
    
    public void monkey ()  //creates the Monkey thread
    {
	Monkey s = new Monkey (c); //creates new instance
	s.start (); //starts the thread
    }
    
    public void bird ()  //creates the Bird thread
    {
	Bird t = new Bird (c); //creates new instance
	t.run (); //starts the thread
    }
    public MyCreation ()
    {
	c = new Console ("The Hare and The Tortoise");// creates a console and adds title
    }


    public static void main (String[] args) // calls all the functions
    {
	MyCreation z = new MyCreation ();
	z.background ();
	z.cloud ();
	z.sunset ();
	z.hare ();
	z.tortoise (); 
	z.monkey ();
	z.bird ();       
    }
} 


