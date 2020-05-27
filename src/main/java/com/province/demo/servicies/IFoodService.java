package com.province.demo.servicies;

import com.province.demo.models.Category;
import com.province.demo.models.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface IFoodService {
    Page<Food> findAll(Pageable pageable);

    List<Food> findAll();

    Optional<Food> findById(Long id);

    Food save(Food food);

    void remove(Long id);

    List<Food> findAllByTitle(String name);

    List<Food> findAllByCategory(Category id);


}
