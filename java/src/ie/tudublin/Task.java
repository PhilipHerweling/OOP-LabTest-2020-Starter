package ie.tudublin;

import processing.data.Table;
import processing.data.TableRow;


public class Task {

    //Setting up initial variables
    private String task;
    private int start, end;

    //Getter and setter methods for all
    //three variables
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    //To String method
    @Override
    public String toString() {
        return task + ", " + start + ", " 
        + end; 
    }

    //Constructor with 3 parameters
    public Task(String task, int start, int end) {
        this.task = task;
        this.start = start;
        this.end = end;
    }

    //Constructor with tr parameter
	public Task(TableRow tr) {
        this(tr.getString("Task"), tr.getInt("Start"), tr.getInt("End"));
	}

}