//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2025.07.03 at 03:53:58 PM TRT 
//


package com.kodat.of.melasoft.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Informacje opisujące adres
 * 
 * <p>Java class for TAdres complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAdres">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="KodKraju" type="{http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2022/01/05/eD/DefinicjeTypy/}TKodKraju"/>
 *         &lt;element name="AdresL1" type="{http://crd.gov.pl/wzor/2023/06/29/12648/}TZnakowy512"/>
 *         &lt;element name="AdresL2" type="{http://crd.gov.pl/wzor/2023/06/29/12648/}TZnakowy512" minOccurs="0"/>
 *         &lt;element name="GLN" type="{http://crd.gov.pl/wzor/2023/06/29/12648/}TGLN" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAdres", namespace = "http://crd.gov.pl/wzor/2023/06/29/12648/", propOrder = {
    "kodKraju",
    "adresL1",
    "adresL2",
    "gln"
})
@XmlSeeAlso({
    com.kodat.of.melasoft.model.Faktura.Podmiot1 .AdresKoresp.class
})
public class TAdres {

    @XmlElement(name = "KodKraju", required = true)
    @XmlSchemaType(name = "normalizedString")
    protected TKodKraju kodKraju;
    @XmlElement(name = "AdresL1", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String adresL1;
    @XmlElement(name = "AdresL2")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String adresL2;
    @XmlElement(name = "GLN")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String gln;

    /**
     * Gets the value of the kodKraju property.
     * 
     * @return
     *     possible object is
     *     {@link TKodKraju }
     *     
     */
    public TKodKraju getKodKraju() {
        return kodKraju;
    }

    /**
     * Sets the value of the kodKraju property.
     * 
     * @param value
     *     allowed object is
     *     {@link TKodKraju }
     *     
     */
    public void setKodKraju(TKodKraju value) {
        this.kodKraju = value;
    }

    /**
     * Gets the value of the adresL1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresL1() {
        return adresL1;
    }

    /**
     * Sets the value of the adresL1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresL1(String value) {
        this.adresL1 = value;
    }

    /**
     * Gets the value of the adresL2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresL2() {
        return adresL2;
    }

    /**
     * Sets the value of the adresL2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresL2(String value) {
        this.adresL2 = value;
    }

    /**
     * Gets the value of the gln property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGLN() {
        return gln;
    }

    /**
     * Sets the value of the gln property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGLN(String value) {
        this.gln = value;
    }

}
