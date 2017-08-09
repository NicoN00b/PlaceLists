import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/9/17.
 */
public class PlaceTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Place.clearAllPlaces();
    }

    @Test
    public void NewPlaceObjectGetsCorrectlyCreated_true() throws Exception {
        Place place = setupNewPlace();
        assertEquals(true, place instanceof Place);
    }
    public Place setupNewPlace(){
        return new Place("HK");
    }

//    @Test
//    public void getStatus_isFalseAfterInstantiation_false() throws Exception {
//        Place place = setupNewPlace();
//        assertEquals(false, place.getStatus());
//    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() throws Exception{
        Place place =  setupNewPlace(); //see below
        assertEquals(LocalDateTime.now().getDayOfWeek(), place.getCreatedAt().getDayOfWeek());
    }

    @Test
    public void PlaceInstantiatesWithContent_true() throws Exception {
        Place place = new Place("HK");
        assertEquals("HK", place.getName());
    }
    @Test
    public void AllPlacesAreCorrectlyReturned_true() {
        Place place = new Place("HK");
        Place otherPlace = new Place ("UK");
        assertEquals(2, Place.getAll().size());
    }

    @Test
    public void AllPlacesContainsAllPlaces_true() {
        Place place = new Place("HK");
        Place otherPlace = new Place("UK");
        assertTrue(Place.getAll().contains(place));
        assertTrue(Place.getAll().contains(otherPlace));
    }
    @Test
    public void getId_placesInstantiateWithAnID_1() throws Exception {
        Place.clearAllPlaces();  // Remember, the test will fail without this line! We need to empty leftover Places from previous tests!
        Place place = new Place("HK");
        assertEquals(1, place.getId());
    }
    @Test
    public void findReturnsCorrectPlace() throws Exception {
        Place place = setupNewPlace();
        assertEquals(1, Place.findById(place.getId()).getId());
    }
    @Test
    public void findReturnsCorrectPlaceWhenMoreThanOnePlaceExists() throws Exception {
        Place place = setupNewPlace();
        Place otherPlace = new Place("UK");
        assertEquals(2, Place.findById(otherPlace.getId()).getId());
    }

    @Test
    public void updateChangesPlaceContent() throws Exception {
        Place place = setupNewPlace();
        String formerName = place.getName();
        LocalDateTime formerDate = place.getCreatedAt();
        int formerId = place.getId();

        place.update("China", "Asia", "January 2017");

        assertEquals(formerId, place.getId());
        assertEquals(formerDate, place.getCreatedAt());
        assertNotEquals(formerName, place.getName());
    }

    @Test
    public void deleteDeletesASpecificPlace() throws Exception {
        Place post = setupNewPlace();
        Place otherPlace = new Place("UK");
        post.deletePlace();
        assertEquals(1, Place.getAll().size());
        assertEquals(Place.getAll().get(0).getId(), 2);
    }

    @Test
    public void deleteAllPlacesDeletesAllPlaces() throws Exception {
        Place post = setupNewPlace();
        Place otherPlace = setupNewPlace();
        Place.clearAllPlaces();
        assertEquals(0, Place.getAll().size());
    }

}