package com.blackcode.curdapi.services;

import com.blackcode.curdapi.dtos.ProdukRequest;
import com.blackcode.curdapi.dtos.ProdukResponse;

import java.util.List;

public interface ProdukService {

    ProdukResponse addProduk(ProdukRequest data);
    ProdukResponse updateProduk(Long id, ProdukRequest data);
    List<ProdukResponse> listAllData();
    void deleteProdukById(Long id);

}
