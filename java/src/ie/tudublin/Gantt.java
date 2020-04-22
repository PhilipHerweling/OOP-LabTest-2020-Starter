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
	
	int expand = 0;
	

	// Initialising gap to be = to 1 tenth of width
	float gap = width * 0.1f;
	// Initialising halfGap to be = to 2 tenths of gap
	float halfGap = gap / 2.0f;
	
	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		//Iterating through csv file
		//and storing data in array
		Table t = loadTable("tasks.csv", "header");
		for (TableRow tr : t.rows()) {
			Task ta = new Task(tr);
			tasks.add(ta);
		}
	}

	public void printTasks() {
		// Iterating through the array
		// and printing values
		for (Task ta : tasks) {
			println(ta);
		}
	}

	public void mousePressed()
	{
		// looping throught the entire array 
		for (int i = 0; i < tasks.size(); i++) {

			Task ta = tasks.get(i);

			// calculating the first x 
			float x1 = map(ta.getStart(), 1, 30, 144, 760);

			// calculating the second x  
			float x2 = map(ta.getEnd(), 1, 30, 144, 760);
			
			// calculating the two y cordinates
			float y1 = map(i, 0, tasks.size(), 109, 534);
			float y2 = y1 + 30;

			//checking if the click is occuring in the rectangle if it is 
			//A message saying clicked is displayed 
			//and the global variable expand stores whch rectangle is being clicked
			if(mouseX >= x1 && mouseX <= x2 
			&& mouseY >= y1   && mouseY <= y2){
				println("clicked");
				expand = i;
			}

		}
		
	}



	public void mouseDragged() {
		println("Mouse dragged");

		//Getting the rectangle which is being clicked

		Task ta = tasks.get(expand);
		
		//These if and if else statements allow the rectangle to be 
		//expanded and shrunk
		if(mouseX > pmouseX && mouseX < width){
			ta.setEnd(ta.getEnd()+1);
		}
		else if(mouseX <  pmouseX && mouseX > 400){
			ta.setStart(ta.getStart()-1);
		}
		else if(pmouseX  > mouseX){
			ta.setEnd(ta.getEnd()-1);
		}
		

	}

	public void setup() {
		// calling load and print methods
		loadTasks();
		printTasks();
	}

	public void draw() {
		background(0);

		// Initialising variables
		// which were setup at the start
		border = width * 0.1f;
		left = width * 0.05f;

		w = width * 0.3f;
		h = height * 0.1f;

		// calling display method
		display();
	}

	// Setting up display method
	public void display() {
		// for loop goes through the tasks array and
		// gets all of the tasks
		for (int i = 0; i < tasks.size(); i++) {
			Task ta = tasks.get(i);

			// intialising y using the map function
			float y = map(i, 0, tasks.size(), border, height - border);

			// Displays the tasks on the screen
			fill(200);
			textAlign(LEFT, CENTER);
			text(ta.getTask(), left + 10, y + (h / 2));
		}

		// Initialising gap to be = to 1 tenth of width
		float gap = width * 0.1f;
		// Initialising halfGap to be = to 2 tenths of gap
		float halfGap = gap / 2.0f;

		// setting the colour of the lines
		// and alligning text to be at the centre of the line
		stroke(200);
		textAlign(CENTER, CENTER);

		// This for goes around 30 times
		// drwaing 30 lines which are evenly spaced
		// and prints out the text over the lines
		for (int i = 1; i <= 30; i++) {

			float x = map(i, -2, 28, gap, width - gap);
			line(x, gap, x, height - gap);
			fill(200);
			text(i, x, halfGap);

		}


		int col = 0;

		for (int i = 0; i < tasks.size(); i++) {
			Task ta = tasks.get(i);

			// calculating the width of the rectangles
			float ww = (ta.getEnd() - ta.getStart()) * 21;

			// calculating the y axis ie this is used to
			// allign the rectangles with the writing
			float y = map(i, 0, tasks.size(), border, height - border);

			// calculating the x axis e.g start point
			float x = map(ta.getStart(), -2, 28, gap, width - gap);

			//setting the colour mode to hsb
			//and colouring the rectangles
			colorMode(HSB);
			noStroke();
			fill((col), 300, 300);

			//using variables that i made up top to create the rectangles
			rect(x, y + (h / 2), ww ,30); // tlx, tly, w, h

			//adding 30 onto col variable so every rectangle is a differnt colour
			col = col +30;
			
		}


	}
}
