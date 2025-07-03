package com.kodat.of.melasoft.entity;


import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invoices")
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nip;

    private String p1;
    private String p2;


    public Invoice(String nip, String p1, String p2) {
        this.nip = nip;
        this.p1 = p1;
        this.p2 = p2;
    }
}
