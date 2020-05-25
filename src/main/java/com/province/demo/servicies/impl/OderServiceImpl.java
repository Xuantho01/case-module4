package com.province.demo.servicies.impl;

import com.province.demo.models.Oder;
import com.province.demo.repositories.OderRepository;
import com.province.demo.servicies.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OderServiceImpl implements IOderService {

    @Autowired
    private OderRepository oderRepository;

    @Override
    public Page<Oder> findAll(Pageable pageable) {
        return oderRepository.findAll(pageable);
    }

    @Override
    public List<Oder> findAll() {
        return (List<Oder>) oderRepository.findAll();
    }

    @Override
    public Optional<Oder> findById(Long id) {
        return oderRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        oderRepository.deleteById(id);
    }
}
