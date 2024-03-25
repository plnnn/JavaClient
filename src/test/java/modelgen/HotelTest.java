package modelgen;

import lt.viko.eif.nychyporuk.client.modelgen.Hotel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    void testHotelSettersAndGetters() {
        String name = "Radisson Blu";
        String address = "Vilnius, Konstitucijos pr. 20";
        byte stars = 5;

        Hotel hotel = new Hotel();
        hotel.setName(name);
        hotel.setAddress(address);
        hotel.setStars(stars);

        assertAll("Hotel setters and getters should work correctly",
                () -> assertEquals(name, hotel.getName(), "Name should match the set value"),
                () -> assertEquals(address, hotel.getAddress(), "Address should match the set value"),
                () -> assertEquals(stars, hotel.getStars(), "Stars should match the set value"));
    }

    @Test
    void testHotelConstructor() {
        String name = "Hestia Hotel Europa";
        String address = "Tallinn, Paadi 5";
        byte stars = 4;

        Hotel hotel = new Hotel(name, address, stars);

        assertAll("Hotel constructor should set all fields correctly",
                () -> assertEquals(name, hotel.getName(), "Name should match"),
                () -> assertEquals(address, hotel.getAddress(), "Address should match"),
                () -> assertEquals(stars, hotel.getStars(), "Stars should match"));
    }

    @Test
    void testToString() {
        String name = "Riga Island";
        String address = "Riga, Kipsalas iela 2";
        byte stars = 4;

        Hotel hotel = new Hotel(name, address, stars);

        String expectedString = String.format("\t\tHotel: \n" +
                "\t\t\tName: %s \n" +
                "\t\t\tAddress: %s \n" +
                "\t\t\tStars: %s \n", name, address, stars);

        assertEquals(expectedString, hotel.toString(), "toString should return the correct string representation");
    }
}
