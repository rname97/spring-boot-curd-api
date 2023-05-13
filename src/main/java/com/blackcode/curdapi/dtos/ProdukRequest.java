package com.blackcode.curdapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class ProdukRequest {

    @NotEmpty(message = "Nama produk Tidak boleh kosong")
    private String produkName;

    @NotNull(message = "Harga Tidak boleh null")
    @Min(value = 1, message = "Harga Produk harus lebih dari 0")
    private BigDecimal produkHarga;

    @NotEmpty(message = "Kategori produk tidak boleh kosong")
    private String produkKategori;

    @NotNull(message = "Stok tidak boleh null")
    @Min(value = 0, message = "Stok tidak boleh kosong")
    private Integer produkStok;
}
