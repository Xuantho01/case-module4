package com.province.demo.servicies.impl;

import com.province.demo.models.Category;
import com.province.demo.models.Food;
import com.province.demo.repositories.FoodRepository;
import com.province.demo.servicies.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements IFoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public Page<Food> findAll(Pageable pageable) {
        return foodRepository.findAll(pageable);
    }

    @Override
    public List<Food> findAll() {
        return (List<Food>) foodRepository.findAll();
    }

    @Override
    public Optional<Food> findById(Long id) {
        return foodRepository.findById(id);
    }

    @Override
    public Food save(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public void remove(Long id) {
        foodRepository.deleteById(id);
    }

    @Override
    public List<Food> findAllByTitle(String name) {
        return foodRepository.findAllByTitle(name);
    }

    @Override
    public List<Food> findAllByCategory(Category category) {
        return foodRepository.findAllByCategory(category);
    }
}
