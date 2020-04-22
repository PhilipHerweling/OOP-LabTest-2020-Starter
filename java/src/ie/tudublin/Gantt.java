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
	}
}
