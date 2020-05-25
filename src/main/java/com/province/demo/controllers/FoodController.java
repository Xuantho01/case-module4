package com.province.demo.controllers;

import com.province.demo.models.Food;
import com.province.demo.models.Category;
import com.province.demo.servicies.IFoodService;
import com.province.demo.servicies.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class FoodController {

    @Autowired
    private IFoodService foodService1;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IFoodService foodService;

    @ModelAttribute("category")
    public List<Category> categories() {
        return categoryService.findAll();}

    @GetMapping("/admin/food-form")
    public ModelAndView showFormCreateFood(){
        ModelAndView modelAndView = new ModelAndView("food/create");
        modelAndView.addObject("foods", new Food());
        return modelAndView;
    }

    @PostMapping("/admin/create-food")
    public String createNewFood(@ModelAttribute Food food, RedirectAttributes redirectAttributes){
        foodService1.save(food);
        redirectAttributes.addFlashAttribute("message", "create successfully");
        return "redirect:/admin/food-form";
    }

    @GetMapping("/list-food")
    public ModelAndView showListFood(){
        ModelAndView modelAndView = new ModelAndView("food/list");
        modelAndView.addObject("foods", foodService.findAll());
        return modelAndView;
    }

    @GetMapping("/admin/edit-food-form")
    public ModelAndView showEditFormFood(){
        ModelAndView modelAndView = new ModelAndView("food/create");
        modelAndView.addObject("foods", new Food());
        return modelAndView;
    }

    @PostMapping("/admin/edit-food")
    public String editFood(@ModelAttribute Food food, RedirectAttributes redirectAttributes){
        foodService1.save(food);
        redirectAttributes.addFlashAttribute("message", "create successfully");
        return "redirect:/admin/food-form";
    }


}
