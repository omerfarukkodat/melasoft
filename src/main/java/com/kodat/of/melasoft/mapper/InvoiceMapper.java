package com.kodat.of.melasoft.mapper;


import com.kodat.of.melasoft.dto.InvoiceDto;
import com.kodat.of.melasoft.entity.Invoice;
import com.kodat.of.melasoft.model.Faktura;

public class InvoiceMapper {

    public static InvoiceDto toInvoiceDto(Faktura faktura) {

        return InvoiceDto.builder()
                .nip(faktura.getPodmiot1().getDaneIdentyfikacyjne().getNIP())
                .p1(faktura.getFa().getP1().toXMLFormat())
                .p2(faktura.getFa().getP2())
                .build();
    }

    public static Invoice toEntity(InvoiceDto invoiceDto) {

        return new Invoice(invoiceDto.getNip(), invoiceDto.getP1(), invoiceDto.getP2());

    }

}
