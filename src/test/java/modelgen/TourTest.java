package modelgen;

import lt.viko.eif.nychyporuk.client.modelgen.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class TourTest {

    @Test
    void testTourSettersAndGetters() {
        String name = "Historical Lithuania";
        byte duration = 120;
        short price = 50;
        Guide guide = new Guide("Pavlo", "Nychyporuk", (byte) 3);
        Hotel hotel = new Hotel("Hotel", "Address", (byte) 5);
        Visit visit1 = new Visit("Lithuania", "Vilnius", (byte) 3, hotel);
        Visit visit2 = new Visit("Lithuania", "Kaunas", (byte) 2, hotel);

        Tour tour = new Tour();
        tour.setName(name);
        tour.setDuration(duration);
        tour.setGuide(guide);
        tour.setPrice(price);
        tour.setVisits(Arrays.asList(visit1, visit2));

        assertAll("Tour setters and getters should function correctly",
                () -> assertEquals(name, tour.getName(), "Name should match the set value"),
                () -> assertEquals(duration, tour.getDuration(), "Duration should match the set value"),
                () -> assertEquals(guide, tour.getGuide(), "Guide should match the set value"),
                () -> assertEquals(price, tour.getPrice(), "Price should match the set value"),
                () -> assertEquals(2, tour.getVisits().size(), "Visits should contain two elements"),
                () -> assertTrue(tour.getVisits().contains(visit1), "Visits should include visit1"),
                () -> assertTrue(tour.getVisits().contains(visit2), "Visits should include visit2"));
    }

    @Test
    void testTourConstructor() {
        String name = "Discover Riga";
        byte duration = 90;
        short price = 75;
        Guide guide = new Guide("Pavlo", "Nychyporuk", (byte) 3);

        Tour tour = new Tour(name, duration, guide, price);

        assertAll("Tour constructor should set all properties correctly",
                () -> assertEquals(name, tour.getName(), "Constructor name should match"),
                () -> assertEquals(duration, tour.getDuration(), "Constructor duration should match"),
                () -> assertEquals(guide, tour.getGuide(), "Constructor guide should match"),
                () -> assertEquals(price, tour.getPrice(), "Constructor price should match"));
    }

    @Test
    void testToString() {
        Guide guide = new Guide("Pavlo", "Nychyporuk", (byte) 3);
        Tour tour = new Tour("Explore Tallinn", (byte)180, guide, (short)100);
        String result = tour.toString();

        assertNotNull(result, "toString should not return null");
        assertTrue(result.contains("Explore Tallinn"), "toString result should contain the tour name");
    }
}
