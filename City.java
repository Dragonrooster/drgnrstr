import java.math.*;
import java.util.Objects;

public class City{

    //Defining class level variables used for the constructor
	private String cityName;
	private double x;
	private double y;

	//Constructor for a city
	City(String name, double x, double y){
		cityName = name;
		this.x = x;
		this.y = y;
	}

	//Returns the x coordinate for a city
	public double x(){
	    return x;
	}

    //Returns the y coordinate for a city
	public double y(){
	    return y;
	}
    //Returns the name for a city
	public String name(){
	    return cityName;
	}

	//Computes and returns the distance from one city to another
	public double distanceTo(City other){
		double x1 = Math.pow(Math.abs(x - other.x), 2);
		double y1 = Math.pow(Math.abs(y - other.y), 2);
		double dist = Math.sqrt(x1 + y1);
		
		return dist;
	}


    //Override of equals
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City other = (City) o;
        return ((this.x() == other.x()) && (this.y() == (other.y()) && (this.name() == other.name())));
    }

    //Override of hashCode
    public int hashCode() {

        return Objects.hash(cityName, x, y);
    }

}
