package lt.viko.eif.nychyporuk.client;

import lt.viko.eif.nychyporuk.client.modelgen.Tour;
import lt.viko.eif.nychyporuk.client.util.JaxbUtilGeneric;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * This class represents a client that connects to a server to receive and
 * process XML data related to tours. It demonstrates handling network connections,
 * XML processing, and user interactions through a simple CLI menu.
 */
public class JavaClient {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private Tour tour = new Tour();

    /**
     * Establishes a connection to the server at the specified IP address and port number.
     *
     * @param ip   The IP address of the server.
     * @param port The port number of the server.
     * @throws IOException If an I/O error occurs when creating the socket.
     */
    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    /**
     * Closes the connection to the server and releases associated resources.
     */
    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("I/O exception occurred: " + e.getMessage());
        }
    }

    /**
     * Displays a menu for user interaction and returns the user's selection.
     *
     * @param input A Scanner object for reading the user's input.
     * @return An integer representing the user's menu choice.
     */
    public static int displayMenu(Scanner input) {
        System.out.println();
        System.out.println("Make a selection");
        System.out.println("----------------");
        System.out.printf("1. %s\n", "Get XML");
        System.out.printf("2. %s\n", "Unmarshal received XML");
        System.out.printf("3. %s\n", "Marshal generated POJO");
        System.out.printf("0. %s\n", "Quit");
        System.out.println();
        return input.nextInt();
    }

    /**
     * Processes the user's menu choice and performs the corresponding action.
     */
    public static void processUserChoice() {
        JavaClient client = new JavaClient();
        try {
            client.startConnection("localhost", 1337);

            Scanner input = new Scanner(System.in);

            int userChoice;
            do {
                userChoice = displayMenu(input);
                switch (userChoice) {
                    case 1:
                        client.getXML("test.xml");
                        client.validateXML("test.xml", "generated.xsd");
                        break;
                    case 2:
                        client.tour = (Tour)JaxbUtilGeneric.convertXMLToPOJO("test.xml", client.tour);
                        System.out.println(client.tour);
                        break;
                    case 3:
                        JaxbUtilGeneric.convertPOJOToXML(client.tour);
                        break;
                    case 0:
                        client.stopConnection();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("No such action");
                        break;
                }
            } while (true);

        } catch (IOException e) {
            System.out.println("I/O exception occurred: " + e.getMessage());
        } finally {
            client.stopConnection();
        }
    }

    /**
     * Receives a file from the server and writes it to a specified FileOutputStream.
     *
     * @param fos The FileOutputStream to write the received file to.
     * @param dis The DataInputStream to read the file from.
     * @throws IOException If an I/O error occurs while receiving the file.
     */
    private void receiveFile(FileOutputStream fos, DataInputStream dis) throws IOException {
        int fileSize = dis.readInt();
        byte[] buffer = new byte[1024];
        int bytesRead;
        int totalBytesRead = 0;

        while ((bytesRead = dis.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
            totalBytesRead += bytesRead;
            if (totalBytesRead >= fileSize) {
                break;
            }
        }
    }

    /**
     * Requests an XML file from the server and saves it locally.
     *
     * @param xmlFileName The name of the file to save the received XML as.
     * @throws IOException If an I/O
     * error occurs during file operations or network communication.
     */
    private void getXML(String xmlFileName) throws IOException {
        out.println("xml");

        FileOutputStream fos = new FileOutputStream(xmlFileName);
        DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
        receiveFile(fos, dis);

        System.out.println("Received xml file");
    }

    /**
     * Validates an XML file against a specified XML Schema Definition (XSD).
     *
     * @param xmlFileName The name of the XML file to validate.
     * @param xsdFileName The name of the XSD file against which the XML file is validated.
     */
    public void validateXML(String xmlFileName, String xsdFileName) {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = factory.newSchema(new File(xsdFileName));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFileName)));

            System.out.println("XML is valid");

        } catch (SAXException e) {
            System.out.println("XML is not valid because: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading XML file: " + e.getMessage());
        }
    }

    /**
     * The main method to run the JavaClient application. It processes user choices
     * for interacting with the server and managing XML data.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        processUserChoice();
    }
}
