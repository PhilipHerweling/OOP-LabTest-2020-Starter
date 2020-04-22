package ie.tudublin;

import java.util.ArrayList;
import processing.data.Table;
import processing.data.TableRow;

import processing.core.PApplet;

public class Gantt extends PApplet
{	
	//Task ArrayList 
	ArrayList<Task> tasks = new ArrayList<Task>();
	
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
	}
}
