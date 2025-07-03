package com.kodat.of.melasoft.repository;

import com.kodat.of.melasoft.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
