package com.blackcode.curdapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class ProdukResponse {
    private Long id;
    private String produkName;
    private BigDecimal produkHarga;
    private String produkKategori;
    private Integer produkStok;
}
