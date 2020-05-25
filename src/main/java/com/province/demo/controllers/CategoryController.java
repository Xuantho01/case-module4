package com.province.demo.controllers;

import com.province.demo.models.Category;
import com.province.demo.servicies.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

//    @GetMapping("/")
//    public ModelAndView showListOder(){
//        ModelAndView mvn = new ModelAndView("index");
//        mvn.addObject("oders", iCategoryService.findAll());
//        return mvn;
//    }

    @GetMapping("/user/category-form")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category", new Category());
       return modelAndView;
    }

    @PostMapping("/user/create-category")
    public ModelAndView createCategory(@ModelAttribute Category category){
        iCategoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("message", "create successfully");
        return modelAndView;
    }

}
