package modelgen;

import lt.viko.eif.nychyporuk.client.modelgen.Sight;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SightTest {

    @Test
    void testSightSettersAndGetters() {
        String name = "The Gediminas' Tower";
        byte duration = 2; // Duration in hours, as an example

        Sight sight = new Sight();
        sight.setName(name);
        sight.setDuration(duration);

        assertAll("Sight setters and getters should function correctly",
                () -> assertEquals(name, sight.getName(), "Name should match the set value"),
                () -> assertEquals(duration, sight.getDuration(), "Duration should match the set value"));
    }

    @Test
    void testSightConstructor() {
        String name = "Freedom Monument";
        byte duration = 1; // Duration in hours, as an example

        Sight sight = new Sight(name, duration);

        assertAll("Sight constructor should set all properties correctly",
                () -> assertEquals(name, sight.getName(), "Constructor name should match"),
                () -> assertEquals(duration, sight.getDuration(), "Constructor duration should match"));
    }

    @Test
    void testToString() {
        String name = "Riga Dome Cathedral";
        byte duration = 3; // Duration in hours, as an example

        Sight sight = new Sight(name, duration);

        String expectedString = String.format("\t\tSight: \n" +
                "\t\t\tName: %s \n" +
                "\t\t\tDuration: %s \n", name, duration);

        assertEquals(expectedString, sight.toString(), "toString should return the correct string representation");
    }
}
