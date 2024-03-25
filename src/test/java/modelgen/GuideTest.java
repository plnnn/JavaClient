package modelgen;

import lt.viko.eif.nychyporuk.client.modelgen.Guide;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GuideTest {

    @Test
    void testGuideSettersAndGetters() {
        String firstName = "Pavlo";
        String lastName = "Nychyporuk";
        byte experience = 4;

        Guide guide = new Guide();
        guide.setFirstName(firstName);
        guide.setLastName(lastName);
        guide.setExperience(experience);

        assertEquals(firstName, guide.getFirstName(), "First name should match the set value");
        assertEquals(lastName, guide.getLastName(), "Last name should match the set value");
        assertEquals(experience, guide.getExperience(), "Experience should match the set value");
    }

    @Test
    void testGuideConstructor() {
        String firstName = "Jane";
        String lastName = "Smith";
        byte experience = 5;

        Guide guide = new Guide(firstName, lastName, experience);

        assertAll("Guide constructor should set all fields correctly",
                () -> assertEquals(firstName, guide.getFirstName(), "First name should match"),
                () -> assertEquals(lastName, guide.getLastName(), "Last name should match"),
                () -> assertEquals(experience, guide.getExperience(), "Experience should match"));
    }

    @Test
    void testToString() {
        String firstName = "Alex";
        String lastName = "Johnson";
        byte experience = 8;

        Guide guide = new Guide(firstName, lastName, experience);

        String expectedString = String.format("\tGuide: \n" +
                "\t\tFirstName: %s \n" +
                "\t\tLastName: %s \n" +
                "\t\tExperience: %s \n", firstName, lastName, experience);

        assertEquals(expectedString, guide.toString(), "toString should return the correct string representation");
    }
}
