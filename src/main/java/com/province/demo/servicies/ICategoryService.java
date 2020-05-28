package com.province.demo.servicies;

import com.province.demo.models.AppUser;
import com.province.demo.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);

    List<Category> findAll();

    Category findById(Long id);

    Category save(Category category);

    void remove(Long id);


}
