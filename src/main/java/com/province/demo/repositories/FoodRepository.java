package com.province.demo.repositories;

import com.province.demo.models.Food;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends PagingAndSortingRepository<Food, Long> {
}
