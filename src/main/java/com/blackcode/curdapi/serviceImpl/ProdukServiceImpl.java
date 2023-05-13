package com.blackcode.curdapi.serviceImpl;

import com.blackcode.curdapi.dtos.ProdukRequest;
import com.blackcode.curdapi.dtos.ProdukResponse;
import com.blackcode.curdapi.models.MasterProduk;
import com.blackcode.curdapi.repositories.ProdukRepository;
import com.blackcode.curdapi.services.ProdukService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdukServiceImpl implements ProdukService {

    private ProdukRepository produkRepository;


    @Transactional
    public ProdukResponse addProduk(ProdukRequest data) {
        MasterProduk prosesProduk = MasterProduk.builder()
                .produkName(data.getProdukName())
                .produkHarga(data.getProdukHarga())
                .produkKategori(data.getProdukKategori())
                .produkStok(data.getProdukStok())
                .build();
        MasterProduk save = produkRepository.save(prosesProduk);
        return ProdukResponse.builder()
                .id(save.getId())
                .produkName(save.getProdukName())
                .produkHarga(save.getProdukHarga())
                .produkKategori(save.getProdukKategori())
                .produkStok(save.getProdukStok())
                .build();
    }

    @Transactional
    public ProdukResponse updateProduk(Long id, ProdukRequest data) {

        Optional<MasterProduk> optionalProduk = produkRepository.findById(id);

        MasterProduk produk = optionalProduk.get();
        produk.setProdukName(data.getProdukName());
        produk.setProdukHarga(data.getProdukHarga());
        produk.setProdukKategori(data.getProdukKategori());
        produk.setProdukStok(data.getProdukStok());
        MasterProduk updateProduct = produkRepository.save(produk);
        return ProdukResponse.builder()
                .id(updateProduct.getId())
                .produkName(updateProduct.getProdukName())
                .produkHarga(updateProduct.getProdukHarga())
                .produkKategori(updateProduct.getProdukKategori())
                .produkStok(updateProduct.getProdukStok())
                .build();
    }

    @Transactional
    public List<ProdukResponse> listAllData() {
        List<MasterProduk> daftarProduk = produkRepository.findAll();
        List<ProdukResponse> daftarResponProduk = new ArrayList<>();

        for(MasterProduk produk : daftarProduk){
            ProdukResponse responseProduk = ProdukResponse.builder()
                    .id(produk.getId())
                    .produkName(produk.getProdukName())
                    .produkHarga(produk.getProdukHarga())
                    .produkKategori(produk.getProdukKategori())
                    .produkStok(produk.getProdukStok())
                    .build();
            daftarResponProduk.add(responseProduk);
        }
        return daftarResponProduk;
    }

    @Transactional
    public void deleteProdukById(Long id) {
        produkRepository.deleteById(id);

    }
}
