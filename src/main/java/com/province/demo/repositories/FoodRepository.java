package com.province.demo.repositories;

import com.province.demo.models.Category;
import com.province.demo.models.Food;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends PagingAndSortingRepository<Food, Long> {
    List<Food> findAllByTitle(String name);

    List<Food> findAllByCategory(Category category);
}
