package com.kodat.of.melasoft.controller;

import com.kodat.of.melasoft.dto.InvoiceRequest;
import com.kodat.of.melasoft.service.InvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name = "Invoice API", description = "API for invoice processing")
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;


    @PostMapping
    @Operation(summary = "Add new faktura",
            description = "Take base64 encoded xml's faktura , process and save to database.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "faktura saved successfully",
                            content = @Content(schema = @Schema(implementation = Map.class))),
                    @ApiResponse(responseCode = "400", description = "invalid xml or format error for base64"),
            })
    public ResponseEntity<Map<String, String>> add(@RequestBody InvoiceRequest request) {
        invoiceService.handleInvoice(request.baseXml());
        return ResponseEntity.ok().body(Map.of("message", "Invoice saved successfully"));
    }
}
