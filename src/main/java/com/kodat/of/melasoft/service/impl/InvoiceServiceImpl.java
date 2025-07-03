package com.kodat.of.melasoft.service.impl;

import com.kodat.of.melasoft.dto.InvoiceDto;
import com.kodat.of.melasoft.entity.Invoice;
import com.kodat.of.melasoft.exception.InvalidXmlException;
import com.kodat.of.melasoft.mapper.InvoiceMapper;
import com.kodat.of.melasoft.model.Faktura;
import com.kodat.of.melasoft.repository.InvoiceRepository;
import com.kodat.of.melasoft.service.InvoiceService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    private static final JAXBContext JAXB_CONTEXT;
    private static final Schema SCHEMA;

    static {
        try {
            System.setProperty("jdk.xml.totalEntitySizeLimit", "0");
            System.setProperty("jdk.xml.maxOccurLimit", "100000");

            JAXB_CONTEXT = JAXBContext.newInstance(Faktura.class);

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            SCHEMA = schemaFactory.newSchema(new File("src/main/resources/schema.xsd"));

        } catch (Exception e) {
            throw new ExceptionInInitializerError("XML configuration cannot start " + e.getMessage());
        }
    }

    @Override
    public void handleInvoice(String baseXml) {
        try {
            byte[] xmlBytes = Base64.getDecoder().decode(baseXml.trim());
            InputStream xmlStream = new ByteArrayInputStream(xmlBytes);

            // unmarshaller
            Unmarshaller unmarshaller = JAXB_CONTEXT.createUnmarshaller();

            // validation
            unmarshaller.setSchema(SCHEMA);

            Faktura faktura = (Faktura) unmarshaller.unmarshal(xmlStream);

            InvoiceDto invoiceDto = InvoiceMapper.toInvoiceDto(faktura);
            Invoice invoice = InvoiceMapper.toEntity(invoiceDto);

            invoiceRepository.save(invoice);

        } catch (Exception e) {
            throw new InvalidXmlException(e);
        }
    }
}
