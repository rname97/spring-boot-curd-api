package com.blackcode.curdapi.controllers;

import com.blackcode.curdapi.dtos.ProdukRequest;
import com.blackcode.curdapi.dtos.ProdukResponse;
import com.blackcode.curdapi.services.ProdukService;
import com.blackcode.curdapi.utils.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/produk")
@AllArgsConstructor
@Slf4j
public class ProdukController {
    private ProdukService produkService;

    @PostMapping(value = "/add")
    public ResponseEntity<ResponseStatus<ProdukResponse>> tambahProduk(@Valid @RequestBody ProdukRequest request, Errors errors){
        ResponseStatus<ProdukResponse> responseData = new ResponseStatus<>();
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setStatus(true);
        responseData.setStatusCode(HttpStatus.OK);
        responseData.setData(produkService.addProduk(request));
        responseData.getMessage().add("Berhasil Menambahkan Data Product");
        log.info("SUCCESSFULLY INSERT - PRODUK DATA : "+ request);
        return ResponseEntity.ok(responseData);

    }

    @PutMapping(value ="/update/{id}")
    public ResponseEntity<ResponseStatus<ProdukResponse>> updateProduk(@Valid @PathVariable(value = "id") Long id, @RequestBody ProdukRequest request, Errors erros){
        ResponseStatus<ProdukResponse> responseData = new ResponseStatus<>();
        if(erros.hasErrors()){
            for (ObjectError error: erros.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setStatusCode(HttpStatus.OK);
        responseData.setData(produkService.updateProduk(id, request));
        responseData.getMessage().add("Update Produk Dengan ID : "+ id + "| Berhasil di update.");
        log.info("SUCCESSFULLY INSERT PRODUK WITH DATA : "+request);
        return ResponseEntity.ok(responseData);

    }

    @GetMapping(value = "/index")
    public ResponseEntity<ResponseStatus<List<ProdukResponse>>> listProduk(){
        List<ProdukResponse> produkResponse = produkService.listAllData();
        ResponseStatus<List<ProdukResponse>> responseData = new ResponseStatus<>();
        if(produkResponse.isEmpty()){
            responseData.setStatus(true);
            responseData.setStatusCode(HttpStatus.OK);
            responseData.getMessage().add("Data tidak di temukan");
            responseData.setData(Collections.emptyList());
        }else{
            responseData.setStatus(true);
            responseData.setStatusCode(HttpStatus.OK);
            responseData.getMessage().add("Data ditemukan, menampilkan data dari database");
            responseData.setData(produkResponse);
        }

        log.info("SUCCESSFULLY GET ALL DATA - ADMINISTRATOR");
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteData(@PathVariable(value = "id") Long id){
        produkService.deleteProdukById(id);
        String message = "Produk dengan ID : "+id+ "| berhasil di hapus";
        log.info(message);
    }
}
