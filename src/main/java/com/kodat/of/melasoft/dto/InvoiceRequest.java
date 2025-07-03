package com.kodat.of.melasoft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record InvoiceRequest(
        @Schema(description = "Base64 encoded XML invoice content", example = "PHhtbD48RmFrdHVyYT5...")
        String baseXml) {

}
