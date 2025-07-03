package com.kodat.of.melasoft.service.impl;

import com.kodat.of.melasoft.entity.Invoice;
import com.kodat.of.melasoft.exception.InvalidXmlException;
import com.kodat.of.melasoft.repository.InvoiceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InvoiceServiceImplTest {

    private InvoiceRepository invoiceRepository;
    private InvoiceServiceImpl invoiceService;

    @BeforeEach
    void setUp() {
        invoiceRepository = mock(InvoiceRepository.class);
        invoiceService = new InvoiceServiceImpl(invoiceRepository);
    }

    @Test
    void handleInvoice_ValidBase64Xml_ShouldSaveInvoice() {

        String exampleXml = """
            <?xml version="1.0" encoding="UTF-8"?>
                <Faktura xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://crd.gov.pl/wzor/2023/06/29/12648/">
                          <Naglowek>
                          <KodFormularza kodSystemowy="FA (2)" wersjaSchemy="1-0E">FA</KodFormularza>
                          <WariantFormularza>2</WariantFormularza>
                          <DataWytworzeniaFa>2023-08-29T12:34:13.7802571Z</DataWytworzeniaFa>
                          <SystemInfo>Samplofaktur</SystemInfo>
                          </Naglowek>
                          <Podmiot1>
                          <DaneIdentyfikacyjne>
                          <NIP>9781399259</NIP>
                          <Nazwa>ABC AGD sp. z o. o.</Nazwa>
                          </DaneIdentyfikacyjne>
                          <Adres>
                          <KodKraju>PL</KodKraju>
                          <AdresL1>ul. Kwiatowa 1</AdresL1>
                          </Adres>
                          <DaneKontaktowe>
                          <Email>example@example.com</Email>
                          </DaneKontaktowe>
                          </Podmiot1>
                          <Podmiot2>
                          <DaneIdentyfikacyjne>
                          <NIP>1250753505</NIP>
                          <Nazwa>CeDeE s.c.</Nazwa>
                          </DaneIdentyfikacyjne>
                          <Adres>
                          <KodKraju>PL</KodKraju>
                          <AdresL1>ulica i numer</AdresL1>
                          </Adres>
                          </Podmiot2>
                          <Fa>
                          <KodWaluty>PLN</KodWaluty>
                          <P_1>2023-08-31</P_1>
                          <P_2>FK2023/08/31</P_2>
                          <P_13_1>0</P_13_1>
                          <P_14_1>0</P_14_1>
                          <P_13_2>0</P_13_2>
                          <P_14_2>0</P_14_2>
                          <P_13_3>0</P_13_3>
                          <P_14_3>0</P_14_3>
                          <P_13_4>0</P_13_4>
                          <P_14_4>0</P_14_4>
                          <P_13_5>0</P_13_5>
                          <P_13_7>4001.49</P_13_7>
                          <P_15>4001.49</P_15>
                          <Adnotacje>
                          <P_16>2</P_16>
                          <P_17>2</P_17>
                          <P_18>2</P_18>
                          <P_18A>2</P_18A>
                          <Zwolnienie>
                          <P_19N>1</P_19N>
                          </Zwolnienie>
                          <NoweSrodkiTransportu>
                          <P_22N>1</P_22N>
                          </NoweSrodkiTransportu>
                          <P_23>2</P_23>
                          <PMarzy>
                          <P_PMarzyN>1</P_PMarzyN>
                          </PMarzy>
                          </Adnotacje>
                          <RodzajFaktury>VAT</RodzajFaktury>
                          <FaWiersz>
                          <NrWierszaFa>1</NrWierszaFa>
                          <P_7>Sprzedaż towarów 23%</P_7>
                          <P_8A>szt.</P_8A>
                          <P_8B>2.323</P_8B>
                          <P_9A>234.24</P_9A>
                          <P_11>544.14</P_11>
                          <P_12>zw</P_12>
                          </FaWiersz>
                          <FaWiersz>
                          <NrWierszaFa>2</NrWierszaFa>
                          <P_7>GTU_1</P_7>
                          <P_8A>-</P_8A>
                          <P_8B>2.561</P_8B>
                          <P_9A>1350.00</P_9A>
                          <P_11>3457.35</P_11>
                          <P_12>zw</P_12>
                          </FaWiersz>
                          </Fa>
                          </Faktura>
            """;
        String base64Xml = Base64.getEncoder().encodeToString(exampleXml.getBytes(StandardCharsets.UTF_8));

        invoiceService.handleInvoice(base64Xml);

        ArgumentCaptor<Invoice> invoiceCaptor = ArgumentCaptor.forClass(Invoice.class);
        verify(invoiceRepository, times(1)).save(invoiceCaptor.capture());

        Invoice savedFaktura = invoiceCaptor.getValue();
        assertNotNull(savedFaktura, "Saved faktura cannot be null");
        assertEquals("9781399259", savedFaktura.getNip(), "NIP does not match");
    }

    @Test
    void handleInvoice_InvalidBase64_ShouldThrowException() {

        String invalidBase64 = "this-is-not-valid-xml";

        assertThrows(InvalidXmlException.class,
                () -> invoiceService.handleInvoice(invalidBase64),
                "Invalid base64");

        verifyNoInteractions(invoiceRepository);
    }

    @Test
    void handleInvoice_InvalidXmlStructure_ShouldThrowException() {
        String invalidXml = """
            <?xml version="1.0" encoding="UTF-8"?>
            <Faktura>
                <MissingParts>Aaaa</MissingParts>
            </Faktura>
            """;
        String base64Xml = Base64.getEncoder().encodeToString(invalidXml.getBytes());

        assertThrows(InvalidXmlException.class,
                () -> invoiceService.handleInvoice(base64Xml),
                "Invalid xml structure");
    }
}