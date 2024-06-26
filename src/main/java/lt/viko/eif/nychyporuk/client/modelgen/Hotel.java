//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package lt.viko.eif.nychyporuk.client.modelgen;

import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for hotelType complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="hotelType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="name">
 *           <simpleType>
 *             <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               <enumeration value="Radisson Blu"/>
 *               <enumeration value="Riga Island"/>
 *               <enumeration value="Hestia Hotel Europa"/>
 *             </restriction>
 *           </simpleType>
 *         </element>
 *         <element name="address">
 *           <simpleType>
 *             <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               <enumeration value="Vilnius, Konstitucijos pr. 20"/>
 *               <enumeration value="Riga, Kipsalas iela 2"/>
 *               <enumeration value="Tallinn, Paadi 5"/>
 *             </restriction>
 *           </simpleType>
 *         </element>
 *         <element name="stars" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlType(propOrder = {"name", "address", "stars"})
public class Hotel {

    protected String name;
    protected String address;
    protected byte stars;

    /**
     * Default constructor.
     */
    public Hotel() {
    }

    /**
     * Constructs a new Hotel with specified name, address, and star rating.
     *
     * @param name The name of the hotel.
     * @param address The address of the hotel.
     * @param stars The star rating of the hotel.
     */
    public Hotel(String name, String address, byte stars) {
        this.name = name;
        this.address = address;
        this.stars = stars;
    }

    /**
     * Writes object's data into string
     *
     * @return String with object's data
     */
    @Override
    public String toString() {
        return String.format("\t\tHotel: \n" +
                "\t\t\tName: %s \n" +
                "\t\t\tAddress: %s \n" +
                "\t\t\tStars: %s \n", this.name, this.address, this.stars);
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the stars property.
     * 
     */
    public byte getStars() {
        return stars;
    }

    /**
     * Sets the value of the stars property.
     * 
     */
    public void setStars(byte value) {
        this.stars = value;
    }

}
