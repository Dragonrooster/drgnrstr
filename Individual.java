import java.util.Arrays;

public class Individual{
	
	private City[] path; 

	//Constructor for an individual taking an array of cities as a path. This path is then scrambled so the cities appear in random order
	public Individual(City[] cityArray){
		path = cityArray.clone();
		int k = 1;
		while(path.length-k > 0){
			City temporary;
			int cityIndexOne = path.length-k;
			int cityIndexTwo = RandomUtils.getRandomValue(path.length-k+1);
			temporary = path[cityIndexOne];

			path[cityIndexOne] = path[cityIndexTwo];
			path[cityIndexTwo] = temporary;

			k++;
		}
	}

	//Basically a getPath method which returns the path however this is named path() because of the contract
	public City[] path(){
		return path;
	} 

	//A method which calculates the distance of an individuals path using the distanceTo method from City.class
	public double cost(){
		double distance = 0;
		
		int k = 0;
		while( k < path.length - 1 ) {
			distance += (path[k]).distanceTo((path[k+1]));
			k++;
		}
		
		distance += (path[0]).distanceTo((path[ path.length - 1 ]));
		
		return distance; 
	}

	//A set-method for path used during reproduction in combination with the empty Individual constructor
	private void setPath(City[] path){
		this.path = path;
	}

	//A private constructor for an individual which will be used during the reproduction method
	private Individual(){
	}

	//Creates a new individual, sets the path to a clone of the parent's path, mutates the path and returns the child individual
	public Individual reproduce(){
		Individual child = new Individual();
		child.setPath(path.clone());
		child.mutate();

		return child;
	}

	//Switches 2 random cities in the individuals path
	public void mutate(){
		City temporary;
		int cityIndexOne = RandomUtils.getRandomValue(path.length);
		int cityIndexTwo = RandomUtils.getRandomValue(path.length);
		temporary = path[cityIndexOne];
		
		path[cityIndexOne] = path[cityIndexTwo];
		path[cityIndexTwo] = temporary;
	}

    //Override of equals
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Individual other = (Individual) o;
        return (this.path() == other.path());
    }

    //Override of hashCode
    public int hashCode() {
        return Arrays.hashCode(path);
    }
}