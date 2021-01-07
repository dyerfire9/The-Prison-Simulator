import java.awt.*;
import java.io.*;
import javax.swing.*;
import hsa.Console;

public class The_Prisoner
{
    static Console c;
    //input is what player types, askCommand is the message in the gray box,
    //displayItems displays all items when you type displayItems, Room is room number(NOT USED), Counter is the turns/types
    //you type something new in,roomCounter is counter when you enter an new room(NOT USED),
    // Hide is displays hide message(NOT USEFUL IN DEMO), Win stops the loop when
    //you win, itemCounter is the number of items, Move is all movements, Item is all items,
    //Message the message in black block when room change or when you open an box/panel, 
    //itemList is the list of possible items.

    //Variable Declaration
    public static String input, askCommand, displayItems;
    public static int Counter, Take, Hide, Win, itemCounter, Kill;
    public static int[] Open = new int [6], Unlock = new int [6], Move = new int [5];
    public static String[] Item = new String [7], Message = new String [4], itemList = new String [7];
    public static ImageIcon imageSrc;
    public static Image image;
    public static void main (String[] args)
    {
	c = new Console ();
	
	//Input Section
	//
	askCommand = "Go forward by typing, Move Forward: ";
	Message [0] = "";
	Message [1] = "You escaped the room";
	Message [2] = "You lift the board and find a glass shard burried in the dirt.";
	Message [3] = "You open the box and find a new security camera inside.";
	itemList [0] = "Sharp glass";
	itemList [1] = "Key";
	Counter = 0;
	displayItems = "";
	
	//Pocessing Section & Output Section
	//
	for (int i = 0 ; i < 5 ; i++)
	{
	    Open [i] = 0;
	    Unlock [i] = 0;
	}
	for (int i = 0 ; i < 6 ; i++)
	{
	    Item [i] = "Empty";
	}
	for (int i = 0 ; i < 4 ; i++)
	{
	    Move [i] = 0;
	}
	
	itemCounter = 0;
	Take = 0;
	Hide = 0;
	Win = 0;
	
	
	Font font = new Font ("BatangChe", Font.PLAIN, 10);
	c.setFont (font);
	c.setCursor (1, 1);
	c.setColor (Color.black);
	c.fillRect (0, 0, 1000, 100);
	c.setTextBackgroundColor (Color.black);
	c.setTextColor (Color.white);
	c.print ("You wake up groggy and cold, Your in a square room with old stone brick surroding you. Theres only one metal door and no windows. You don't know what happened & where you are.");

	Font font2 = new Font ("Arial", Font.PLAIN, 25);
	c.setFont (font2);
	c.drawString ("The Prisoner Demo", 200, 200);
	Font font3 = new Font ("Arial", Font.PLAIN, 20);
	c.setFont (font3);
	c.drawString ("By Max Belleville & Muhammad Abdul", 150, 250);
	c.setFont (font);

	for (int i = 0 ; i < 2 ; i++)
	{

	    i = 0;

	    c.setTextBackgroundColor (Color.lightGray);
	    c.setTextColor (Color.black);
	    c.setColor (Color.lightGray);
	    c.fillRect (0, 440, 1000, 60);
	    c.setCursor (23, 1);
	    c.print (askCommand);
	    input = c.readLine ();

	    if (Win == 1)
	    {
		i = 6;
		input = "";
	    }

	    Counter++;

	    c.setTextColor (Color.white);
	    c.setTextBackgroundColor (Color.white);
	    c.setColor (Color.white);
	    c.clear ();
	    c.setColor (Color.black);
	    c.fillRect (0, 0, 1000, 100);

	    if (input.equalsIgnoreCase ("Help"))
	    {
		c.setCursor (1, 1);
		c.setColor (Color.black);
		c.fillRect (0, 0, 1000, 100);
		c.setTextBackgroundColor (Color.black);
		c.setTextColor (Color.white);
		c.print ("Commands: Help, Open, Take, Items, Close, Move Left, Move Right, Move Forward, Move Backward, Hide, Use (Item)");
	    }
	    
	    // Output Section
	    else if (input.equalsIgnoreCase ("Move Left"))
	    {
		Move [0]++;
		Move [1] = 0;
	    }
	    else if (input.equalsIgnoreCase ("Move Backward"))
	    {
		Move [2]++;
		Move [3] = 0;
	    }
	    else if (input.equalsIgnoreCase ("Move Forward"))
	    {
		Move [3]++;
		Move [2] = 0;
	    }

	    else if (input.equalsIgnoreCase ("Move Right"))
	    {
		Move [1]++;
		Move [0] = 0;

	    }
	   else if (input.equalsIgnoreCase ("Take"))
	    {
		Take = 1;
		c.setCursor (1, 1);
		c.setColor (Color.black);
		c.fillRect (0, 0, 1000, 100);
		c.setTextBackgroundColor (Color.black);
		c.setTextColor (Color.white);
		c.print ("Nothing here to take.");

	    }

	    else
	    {
		c.setCursor (1, 1);
		c.setColor (Color.black);
		c.fillRect (0, 0, 1000, 100);
		c.setTextBackgroundColor (Color.black);
		c.setTextColor (Color.white);
		c.print ("Invalid command, Commands: Help, Take, Open, Items, Close, Move Left, Move Right, Move Forward, Move Backward, Hide, Use (Item)");
	    }

	    if (input.equalsIgnoreCase ("Hide"))
	    {
		Hide = 1;
		c.setCursor (1, 1);
		c.setColor (Color.black);
		c.fillRect (0, 0, 1000, 100);
		c.setTextBackgroundColor (Color.black);
		c.setTextColor (Color.white);
		c.print ("You are hiding");

	    }

	    else
	    {
		Hide = 0;
	    }

	    if (input.equalsIgnoreCase ("Items") && displayItems.equals (""))
	    {
		c.setCursor (1, 1);
		c.setColor (Color.black);
		c.fillRect (0, 0, 1000, 100);
		c.setTextBackgroundColor (Color.black);
		c.setTextColor (Color.white);
		c.print ("You have no items.");

	    }
	    else if (input.equalsIgnoreCase ("Items"))
	    {
		c.setCursor (1, 1);
		c.setColor (Color.black);
		c.fillRect (0, 0, 1000, 100);
		c.setTextBackgroundColor (Color.black);
		c.setTextColor (Color.white);
		c.print (displayItems);

	    }

	    if ( Move [0] == 1 && Move [3] == 1 ||  Move [3] == 1 && Move [1] == 0 && Move [0] == 0)
	    {
		imageSrc = new ImageIcon ("door.png");
		image = imageSrc.getImage ();
		c.drawImage (image, 150, 100, null);
		c.setCursor (1, 1);
		c.setColor (Color.black);
		c.fillRect (0, 0, 1000, 100);
		c.setTextBackgroundColor (Color.black);
		c.setTextColor (Color.white);
		c.print ("You move to the door.");
		doorCommands (1);
	    }
	    else if (Counter >= 1)
	    {
		askCommand = "Type what you want to do: ";
	    }

	    if ( Move [0] == 1 && Move [2] == 1 ||  Move [0] == 0 && Move [1] == 0 && Move [2] == 1)
	    {
		imageSrc = new ImageIcon ("bed.png");
		image = imageSrc.getImage ();
		c.drawImage (image, 150, 100, null);
		c.setCursor (1, 1);
		c.setColor (Color.black);
		c.fillRect (0, 0, 1000, 100);
		c.setTextBackgroundColor (Color.black);
		c.setTextColor (Color.white);
		c.print ("You are standing near your bed, nothing special here. Althought it does look very uncomfortable");

	    }
	    if ( Move [1] == 1 && Move [3] == 1)
	    {
		imageSrc = new ImageIcon ("edge.png");
		image = imageSrc.getImage ();
		c.drawImage (image, 150, 100, null);
	    }
	    if ( Move [1] == 1 && Move [2] == 1 && itemCounter == 0)
	    {
		imageSrc = new ImageIcon ("panel.png");
		image = imageSrc.getImage ();
		c.drawImage (image, 150, 100, null);
		c.setCursor (1, 1);
		c.setColor (Color.black);
		c.fillRect (0, 0, 1000, 100);
		c.setTextBackgroundColor (Color.black);
		c.setTextColor (Color.white);
		c.print ("As your walking you notice a piece of broken floor board.");
		openObject (0);
	    }
	    
	    for (int i2 = 0 ; i2 < 4 ; i2++)
	    {
		if (Move [i2] == 2)
		{
		    Move [i2] = 1;
		    c.setCursor (1, 1);
		    c.setColor (Color.black);
		    c.fillRect (0, 0, 1000, 100);
		    c.setTextBackgroundColor (Color.black);
		    c.setTextColor (Color.white);
		    c.print ("You bump into an object or wall infront of you.");

		}

	    }
	    if (Counter >= 10 &&  Kill == 0)
	    {
		c.setCursor (1, 1);
		c.setColor (Color.black);
		c.fillRect (0, 0, 1000, 100);
		c.setTextBackgroundColor (Color.black);
		c.setTextColor (Color.white);
		c.print ("A guard opens the door, he is in normal clothing and has a key around his neck");
		Enemy (1);
	    }
	    if (Counter == 20 && Kill == 0)
	    {
		c.setCursor (1, 1);
		c.setColor (Color.red);
		c.fillRect (0, 0, 1000, 1000);
		c.setTextBackgroundColor (Color.red);
		c.setTextColor (Color.white);
		c.print ("You where killed");
		i = 6;
	    }
	    Take = 0;
	}
    }


    public static void openObject (int ObjectNum)
    {
	for (int i = 0 ; i < 2 ; i++)
	{
	    if (input.equalsIgnoreCase ("Open") && ObjectNum == i)
	    {
		c.setCursor (1, 1);
		c.setColor (Color.black);
		c.fillRect (0, 0, 1000, 100);
		c.setTextBackgroundColor (Color.black);
		c.setTextColor (Color.white);
		c.print (Message [ObjectNum + 2]);
		Open [ObjectNum + 2] = 1;
	    }
	    if (Take == 1 && ObjectNum == i && itemCounter == 0 && Open [ObjectNum + 2] == 1)
	    {
		c.setCursor (1, 1);
		c.setColor (Color.black);
		c.fillRect (0, 0, 1000, 100);
		c.setTextBackgroundColor (Color.black);
		c.setTextColor (Color.white);
		c.print ("You collected " + itemList [ObjectNum]);
		Item [itemCounter] = itemList [ObjectNum];
		displayItems = displayItems + Item [itemCounter] + " ";
		itemCounter++;
		Counter = 9;
	    }
	}

    }


    public static void doorCommands (int DoorNum)
    {
	if ( Counter == 1)
	{
	    askCommand = "Try to open the door by typing, Open: ";
	    c.setCursor (1, 1);
	    c.setColor (Color.black);
	    c.fillRect (0, 0, 1000, 100);
	    c.setTextBackgroundColor (Color.black);
	    c.setTextColor (Color.white);
	    c.print ("The first thing you do is walk to the door. It's shiny and dark gray.");
	}
	else
	{
	    askCommand = "Type what you want to do: ";
	}
	if (input.equalsIgnoreCase ("Open") && Unlock [DoorNum] == 0)
	{
	    c.setCursor (1, 1);
	    c.setColor (Color.black);
	    c.fillRect (0, 0, 1000, 100);
	    c.setTextBackgroundColor (Color.black);
	    c.setTextColor (Color.white);
	    c.print ("Door is locked you will need a key..");
	}
	else if (input.equalsIgnoreCase ("Open"))
	{
	    c.setCursor (1, 1);
	    c.setColor (Color.black);
	    c.fillRect (0, 0, 1000, 100);
	    c.setTextBackgroundColor (Color.black);
	    c.setTextColor (Color.white);
	    c.print ("You open the door but realise that your in the middle of a desert and the building that you though you was in was actually just a big wooden box with a metal door");
	    Win = 1;
	}
	for (int i = 0 ; i < 6 ; i++)
	{
	    if (Item [i].equals ("Key") && input.equalsIgnoreCase ("Use Key"))
	    {
		c.setCursor (1, 1);
		c.setColor (Color.black);
		c.fillRect (0, 0, 1000, 100);
		c.setTextBackgroundColor (Color.black);
		c.setTextColor (Color.white);
		c.print ("The key works and the door unlocks.");
		Unlock [DoorNum] = 1;
	    }
	}
    }


    public static void Enemy (int EnemyNum)
    {

	if (Counter > 10&& displayItems.equals(""))
	{
	    c.setCursor (1, 1);
	    c.setColor (Color.black);
	    c.fillRect (0, 0, 1000, 100);
	    c.setTextBackgroundColor (Color.black);
	    c.setTextColor (Color.white);
	    c.print ("He says, \"Tell me about the Golden Egg or you die, Tell me now or you die.\" You have no idea what he is talking about but he just keeps repeating tell me now, tell me NOW. ");

	}

	if (Take == 1 && Counter > 10)
	{
	    c.setCursor (1, 1);
	    c.setColor (Color.black);
	    c.fillRect (0, 0, 1000, 100);
	    c.setTextBackgroundColor (Color.black);
	    c.setTextColor (Color.white);
	    c.print ("Took the guard's " + itemList [EnemyNum] + ".");
	    Item [itemCounter] = itemList [EnemyNum];
	    displayItems = displayItems + Item [itemCounter] + " ";
	    itemCounter++;
	    Counter = 17;
	}

	for (int i = 0 ; i < 6 ; i++)
	{
	    if (Item [i].equals ("Sharp glass") && Counter == 10)
	    {
		Counter = 18;
		c.setCursor (1, 1);
		c.setColor (Color.black);
		c.fillRect (0, 0, 1000, 100);
		c.setTextBackgroundColor (Color.black);
		c.setTextColor (Color.white);
		c.print ("A guard walks in and starts yelling at you because you broke the wooden board, he is rasing his gun at you");
	    }
	    if (Item [i].equals ("Sharp glass") && input.equalsIgnoreCase ("Use Sharp glass") && Counter > 10)
	    {
		c.setCursor (1, 1);
		c.setColor (Color.black);
		c.fillRect (0, 0, 1000, 100);
		c.setTextBackgroundColor (Color.black);
		c.setTextColor (Color.white);
		Kill++;
		c.print ("You fataly stabbed the guard and took his " + itemList [EnemyNum] + ".");
		Item [itemCounter] = itemList [EnemyNum];
		displayItems = displayItems + Item [itemCounter] + " ";
		itemCounter++;
	    }


	}

    }
}

