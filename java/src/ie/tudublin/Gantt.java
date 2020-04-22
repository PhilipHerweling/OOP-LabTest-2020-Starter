package ie.tudublin;

import java.util.ArrayList;
import processing.data.Table;
import processing.data.TableRow;

import processing.core.PApplet;

public class Gantt extends PApplet
{	
	//Task ArrayList 
	ArrayList<Task> tasks = new ArrayList<Task>();

	//Setting up variables
	float border;
    float left;

    float w;
    float h;
	
	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		//Iterating through csv file
		//and storing data in array
		Table t = loadTable("tasks.csv", "header");
        for(TableRow tr:t.rows())
        {
            Task ta = new Task(tr);
            tasks.add(ta);
        }
	}

	public void printTasks()
	{
		//Iterating through the array 
		//and printing values
		for(Task ta:tasks)
        {
			println(ta);
		}
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		//calling load and print methods
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		background(0);

		//Initialising variables 
		//which were setup at the start
		border = width * 0.1f;
        left = width * 0.05f;

        w = width * 0.3f;
		h = height * 0.1f;

		//calling display method
		display();
	}

	//Setting up display method
	public void display()
	{
		//for loop goes through the tasks array and
		//gets all of the tasks
		for(int i = 0 ; i < tasks.size() ; i ++)
        {
            Task ta = tasks.get(i);

			//intialising y using the map function
            float y = map(i, 0, tasks.size(), border, height - border);

			//Displays the tasks on the screen
            fill(200);
            textAlign(LEFT, CENTER);
            text(ta.getTask(), left + 10, y + (h / 2));
		}

		//Initialising gap to be = to 1 tenth of width
		float gap = width * 0.1f;
		//Initialising halfGap to be = to 2 tenths of gap
		float halfGap = gap / 2.0f;

		//setting the colour of the lines
		//and alligning text to be at the centre of the line
		stroke(200);
		textAlign(CENTER, CENTER);

		//This for goes around 30 thimes
		//drwaing 30 lines which are evenly spaced 
		//and prints out the text over the lines
		for(int i = 1 ; i <=30 ; i ++)
		{
			float x = map(i, -2, 28, gap, width -gap);				
			line(x, gap, x, height - gap);
			fill(200);
			text(i, x, halfGap);
			
        }
		


	}
}
