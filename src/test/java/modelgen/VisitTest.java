package modelgen;

import lt.viko.eif.nychyporuk.client.modelgen.Hotel;
import lt.viko.eif.nychyporuk.client.modelgen.Sight;
import lt.viko.eif.nychyporuk.client.modelgen.Visit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class VisitTest {
    private Visit visit;
    private Hotel hotel;
    private Sight sight1, sight2;

    @BeforeEach
    void setUp() {
        hotel = new Hotel("Hotel", "Address", (byte) 5);
        sight1 = new Sight("The Gediminas' Tower", (byte)1);
        sight2 = new Sight("Freedom Monument", (byte)1);

        visit = new Visit("Lithuania", "Vilnius", (byte)2, hotel);
        visit.setSights(Arrays.asList(sight1, sight2));
    }

    @Test
    void testVisitSettersAndGetters() {
        String country = "Latvia";
        String city = "Riga";
        byte duration = 3;
        Hotel newHotel = new Hotel("Hotel", "Address", (byte) 5);
        Sight newSight1 = new Sight("Riga Dome Cathedral", (byte)2);
        Sight newSight2 = new Sight("Tallinn Old Town", (byte)3);
        List<Sight> newSights = Arrays.asList(newSight1, newSight2);

        visit.setCountry(country);
        visit.setCity(city);
        visit.setDuration(duration);
        visit.setHotel(newHotel);
        visit.setSights(newSights);

        assertAll("Visit setters and getters should function correctly",
                () -> assertEquals(country, visit.getCountry(), "Country should match the set value"),
                () -> assertEquals(city, visit.getCity(), "City should match the set value"),
                () -> assertEquals(duration, visit.getDuration(), "Duration should match the set value"),
                () -> assertEquals(newHotel, visit.getHotel(), "Hotel should match the set value"),
                () -> assertEquals(newSights, visit.getSights(), "Sights should contain the new elements"));
    }

    @Test
    void testToString() {
        String result = visit.toString();

        assertNotNull(result, "toString should not return null");
        assertTrue(result.contains("Vilnius"), "toString result should contain the city name");
    }
}
