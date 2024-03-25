package util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import lt.viko.eif.nychyporuk.client.modelgen.*;
import lt.viko.eif.nychyporuk.client.util.JaxbUtilGeneric;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class JaxbUtilGenericTest {

    @Test
    void testConvertXMLToPOJO() {
        String xmlFilePath = "src/main/resources/test.xml";
        Tour result = (Tour)JaxbUtilGeneric.convertXMLToPOJO(xmlFilePath, new Tour());

        assertNotNull(result);
        assertEquals("Lithuanian Journey", result.getName());
        assertEquals(2, result.getDuration());
    }

    @Test
    void testConvertPOJOToXML() {
        Guide guide = new Guide("Pavlo", "Nychyporuk", (byte) 3);
        Tour tour = new Tour("Iceland", (byte) 7, guide, (short) 1000);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(os));

        JaxbUtilGeneric.convertPOJOToXML(tour);

        System.setOut(originalOut);

        String xmlOutput = os.toString();
        assertTrue(xmlOutput.contains("<name>Iceland</name>"));
        assertTrue(xmlOutput.contains("<firstName>Pavlo</firstName>"));
        assertTrue(xmlOutput.contains("<lastName>Nychyporuk</lastName>"));
    }
}
