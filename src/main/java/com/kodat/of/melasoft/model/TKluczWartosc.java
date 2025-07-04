//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2025.07.03 at 03:53:58 PM TRT 
//


package com.kodat.of.melasoft.model;

import java.math.BigInteger;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Typ złożony, klucz-wartość
 * 
 * <p>Java class for TKluczWartosc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TKluczWartosc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NrWiersza" type="{http://crd.gov.pl/wzor/2023/06/29/12648/}TNaturalny" minOccurs="0"/>
 *         &lt;element name="Klucz" type="{http://crd.gov.pl/wzor/2023/06/29/12648/}TZnakowy"/>
 *         &lt;element name="Wartosc" type="{http://crd.gov.pl/wzor/2023/06/29/12648/}TZnakowy"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TKluczWartosc", namespace = "http://crd.gov.pl/wzor/2023/06/29/12648/", propOrder = {
    "nrWiersza",
    "klucz",
    "wartosc"
})
public class TKluczWartosc {

    @XmlElement(name = "NrWiersza")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger nrWiersza;
    @XmlElement(name = "Klucz", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String klucz;
    @XmlElement(name = "Wartosc", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String wartosc;

    /**
     * Gets the value of the nrWiersza property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNrWiersza() {
        return nrWiersza;
    }

    /**
     * Sets the value of the nrWiersza property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNrWiersza(BigInteger value) {
        this.nrWiersza = value;
    }

    /**
     * Gets the value of the klucz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKlucz() {
        return klucz;
    }

    /**
     * Sets the value of the klucz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKlucz(String value) {
        this.klucz = value;
    }

    /**
     * Gets the value of the wartosc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWartosc() {
        return wartosc;
    }

    /**
     * Sets the value of the wartosc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWartosc(String value) {
        this.wartosc = value;
    }

}
