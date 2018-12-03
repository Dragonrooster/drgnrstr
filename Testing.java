public class Testing{

    public static void main(String[] args){
        City[] cityarray = CityGenerator.generate();
        Individual john = new Individual(cityarray);
        printPath(john);
        Individual child = john.reproduce();
        printPath(child);
        System.out.print("Cost is " + child.cost());
        child.mutate();
        printPath(john);
        printPath(child);


        Event ev = new Event(Event.MUTATION, 10.001, john);
        System.out.println("Type is " + ev.type());
        System.out.println("Time is " +ev.time());
        System.out.println("Individual is " + ev.individual());
        System.out.println(ev.toString());
        //Event ev2 = new Event('u', 10.001, john); To test proper implementation of precondition


        City by = new City( "Frede" , 1.01, 4.04);
        System.out.println("Name:" + by.name());
        System.out.println("X is " + by.x());
        System.out.println("Y is " + by.y());

        City by2 = new City( "Odense", 5.05, 4.04);
        System.out.println("Name:" + by2.name());
        System.out.println("X is " + by2.x());
        System.out.println("Y is " + by2.y());
        System.out.println("Distance from " + by.name() + " to " +by2.name() + " is " + by.distanceTo(by2));
    }

    public static void printPath(Individual person){
        System.out.println(" The person's path is");

        int k = 0;
        while( k < (person.path()).length ){

            System.out.print( (person.path())[k].name());

            if( k < (person.path()).length - 1 ){
                System.out.print(" -> ");

            }
            k++;
        }
        System.out.println("");
    }
}
