import java.util.ArrayList;

/**
 * Created by Guest on 8/9/17.
 */
public class Place {
    private String name;
    private String location;
    private String dateVisited;
    private Boolean status;
    private static ArrayList<Place> funPlaces = new ArrayList<>();
    private int id;

    public Place(String name){
        this.name = name;
        this.location = location;
        this.dateVisited = dateVisited;
        this.status = false;
        funPlaces.add(this);
        this.id = funPlaces.size();
    }

    public static void clearAllPlaces(){
        funPlaces.clear();
    }

    public boolean getStatus(){
        return status;
    }
    public String getName(){
        return name;
    }
}
