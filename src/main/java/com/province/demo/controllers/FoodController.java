package com.province.demo.controllers;

import com.province.demo.models.Food;
import com.province.demo.models.Category;
import com.province.demo.servicies.IFoodService;
import com.province.demo.servicies.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

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
        ModelAndView modelAndView = new ModelAndView("food/addnew");
        modelAndView.addObject("foods", new Food());
        return modelAndView;
    }

    @PostMapping("/admin/create-food")
    public String createNewFood(@ModelAttribute Food food, RedirectAttributes redirectAttributes){
        foodService1.save(food);
        redirectAttributes.addFlashAttribute("message", "create successfully");
        return "redirect:/admin/food-form";
    }

    @GetMapping("/index")
    public ModelAndView showHome(){
        //fix
        ModelAndView modelAndView = new ModelAndView("theme/index");
        modelAndView.addObject("foods", foodService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit-food-form/{id}")
    public ModelAndView showEditFormFood(@PathVariable("id") Long id){

        Optional<Food> food = foodService.findById(id);
        if(food != null) {
            ModelAndView modelAndView = new ModelAndView("food/edit");
            modelAndView.addObject("foods", food);
            return modelAndView;

        }
        ModelAndView modelAndView = new ModelAndView("food/edit");
        modelAndView.addObject("message", "try again");
        return modelAndView;
    }


    @PostMapping("/edit-food")
    public String editFood(@ModelAttribute Food food, RedirectAttributes redirectAttributes){
        foodService1.save(food);
        redirectAttributes.addFlashAttribute("message", "create successfully");
        return "redirect:/food-form";
    }

    // detail
    @GetMapping("/see-detail/{id}")
    public ModelAndView seeDetail(@PathVariable("id") Long id){

        Optional<Food> foodDetail = foodService.findById(id);

        if(foodDetail != null) {
            ModelAndView modelAndView = new ModelAndView("theme/shop-details");
            modelAndView.addObject("foodDetail", foodDetail.get());
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("theme/index");
        modelAndView.addObject("message", "try again");
        return modelAndView;
    }


    @GetMapping("/blog")
    public String getBlog(){
        return "theme/blog";
    }
    @GetMapping("/blog-detail")
    public String getBlogDetail(){
        return "theme/blog-details";
    }
    @GetMapping("/checkout")
    public String getCheckout(){
        return "theme/checkout";
    }
    @GetMapping("/contact")
    public String getContact(){
        return "theme/contact";
    }
    @GetMapping("/shop-detail")
    public String getShopDetail(){
        return "theme/shop-details";
    }
    @GetMapping("/shop-grid")
    public String getShopGrid(){
        return "theme/shoping-cart";
    }

}
