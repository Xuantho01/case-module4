package com.province.demo.servicies;

import com.province.demo.models.Oder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface IOderService {
    Page<Oder> findAll(Pageable pageable);

    List<Oder> findAll();

    Optional<Oder> findById(Long id);

    void remove(Long id);
}
