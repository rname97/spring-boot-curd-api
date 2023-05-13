package com.blackcode.curdapi.repositories;

import com.blackcode.curdapi.models.MasterProduk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdukRepository extends JpaRepository<MasterProduk, Long> {
}
