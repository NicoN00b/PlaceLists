import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Guest on 8/9/17.
 */
public class Place {

    private String name;
    private String location;
    private LocalDateTime createdAt;
    private String dateVisited;
    private Boolean status;
    private static ArrayList<Place> funPlaces = new ArrayList<>();
    private int id;

    public Place(String name, String location, String dateVisited){
        this.name = name;
        this.location = location;
        this.createdAt = LocalDateTime.now();
        this.dateVisited = dateVisited;
//        this.status = false;
        funPlaces.add(this);
        this.id = funPlaces.size();
    }

    public static void clearAllPlaces(){
        funPlaces.clear();
    }

    public boolean getStatus(){
        return status;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getName(){
        return name;
    }

    public static ArrayList<Place> getAll(){
        return funPlaces;
    }

    public int getId() {
        return id;
    }

    public static Place findById(int id) {
        return funPlaces.get(id-1);
    }

    public void update(String name, String location, String dateVisited) {
        this.name = name;
        this.location = location;
        this.dateVisited = dateVisited;

    }
    public void deletePlace(){
        funPlaces.remove(id-1); //same reason
    }

    public String getLocation() {
        return location;
    }

    public String getDateVisited() {
        return dateVisited;
    }

    public static ArrayList<Place> getFunPlaces() {
        return funPlaces;
    }


}
