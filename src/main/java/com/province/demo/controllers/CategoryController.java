package com.province.demo.controllers;

import com.province.demo.models.Category;
import com.province.demo.servicies.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

//    @GetMapping("/")
//    public ModelAndView showListOder(){
//        ModelAndView mvn = new ModelAndView("index");
//        mvn.addObject("oders", iCategoryService.findAll());
//        return mvn;
//    }

    @GetMapping("/api/category-form")
    public List<Category> showCreate(){
        List<Category> categories = iCategoryService.findAll();
       return categories;
    }

    @PostMapping("/user/create-category")
    public ModelAndView createCategory(@ModelAttribute Category category){
        iCategoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("message", "create successfully");
        return modelAndView;
    }

}
