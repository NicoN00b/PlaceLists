import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void getStatus_isFalseAfterInstantiation_false() throws Exception {
        Place place = setupNewPlace();
        assertEquals(false, place.getStatus());
    }

    @Test
    public void PostInstantiatesWithContent_true() throws Exception {
        Place post = new Place("HK");
        assertEquals("HK", post.getName());
    }


}