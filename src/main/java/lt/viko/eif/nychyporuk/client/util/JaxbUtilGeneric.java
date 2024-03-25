package lt.viko.eif.nychyporuk.client.util;

import jakarta.xml.bind.*;

import java.io.File;
import java.io.OutputStream;

/**
 * This utility class provides methods for marshalling Java objects to XML
 * and unmarshalling XML back into Java objects using JAXB.
 */
public class JaxbUtilGeneric {

    /**
     * Default constructor.
     */
    public JaxbUtilGeneric() {
    }

    /**
     * Converts an XML file to a POJO (Plain Old Java Object) using JAXB unmarshalling.
     *
     * @param <T> The type of the object to be returned.
     * @param xmlFilePath The file path of the XML to be converted.
     * @param object An instance of the class to which the XML is to be converted.
     *               This parameter is used to specify the type of the object to unmarshal.
     * @return An object of type <T> that represents the unmarshalled XML.
     * @throws RuntimeException If a {@link JAXBException} occurs during unmarshalling.
     */
    public static <T> Object convertXMLToPOJO(String xmlFilePath, Object object) {
        try {
            File xmlFile = new File(xmlFilePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Object unmarshalledObject = jaxbUnmarshaller.unmarshal(xmlFile);
            return unmarshalledObject;

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts a POJO (Plain Old Java Object) to XML using JAXB marshalling
     * and outputs the XML to the standard output stream.
     *
     * @param <T> The type of the object to be converted to XML.
     * @param object The object to be marshalled to XML.
     * @throws RuntimeException If a {@link JAXBException} occurs during marshalling.
     */
    public static <T> void convertPOJOToXML(T object) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            OutputStream os = System.out;
            marshaller.marshal(object, os);

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
