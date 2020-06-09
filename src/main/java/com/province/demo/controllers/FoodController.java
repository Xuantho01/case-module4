package com.province.demo.controllers;

import com.province.demo.models.Food;
import com.province.demo.models.Category;
import com.province.demo.servicies.IFoodService;
import com.province.demo.servicies.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
public class FoodController {

    @Autowired
    private IFoodService foodService1;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IFoodService foodService;

    @GetMapping("/api/food-list")
    public List<Food> showFormCreateFood(){
        return foodService.findAll();
    }

    @PostMapping(value = "/create-food",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createNewFood(@RequestBody Food food){
        foodService.save(food);
        ResponseEntity<Void> res = new ResponseEntity<>(HttpStatus.OK);
        return res;
    }

    @GetMapping("/index")
    public ModelAndView showHome(){
        //fix
        ModelAndView modelAndView = new ModelAndView("theme/index");
        modelAndView.addObject("foods", foodService.findAll());
        return modelAndView;
    }

    @GetMapping("/admin/edit-food-form/{id}")
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

    @PostMapping("/admin/edit-food")
    public String editFood(@ModelAttribute Food food, RedirectAttributes redirectAttributes){
        foodService1.save(food);
        redirectAttributes.addFlashAttribute("message", "create successfully");
        return "redirect:/admin/food-form";
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

//    @PostMapping(value = "/search-food", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Food>> search(@RequestBody Food food){
//        List<Food> list = foodService.findAllByTitle(food.getTitle());
//        return new ResponseEntity<List<Food>>(list,HttpStatus.OK);
//    }

    @GetMapping("/search-food")
    public ModelAndView search(@RequestParam("searchFood") String searchFood) {
        List<Food> list = foodService.findAllByTitle(searchFood);
        ModelAndView modelAndView = new ModelAndView("theme/index");
        modelAndView.addObject("foods", list);
        return modelAndView;
    }

    @GetMapping("/search-category/{id}")
    public ModelAndView searchByCategory(@PathVariable("id") Category category_id) {
        List<Food> list = foodService.findAllByCategory(category_id);
        ModelAndView modelAndView = new ModelAndView("theme/index");
        modelAndView.addObject("foods", list);
        return modelAndView;
    }


//
//    @GetMapping("/blog")
//    public String getBlog(){
//        return "theme/blog";
//    }
//    @GetMapping("/blog-detail")
//    public String getBlogDetail(){
//        return "theme/blog-details";
//    }
//    @GetMapping("/checkout")
//    public String getCheckout(){
//        return "theme/checkout";
//    }
//    @GetMapping("/contact")
//    public String getContact(){
//        return "theme/contact";
//    }
//    @GetMapping("/shop-detail")
//    public String getShopDetail(){
//        return "theme/shop-details";
//    }
//    @GetMapping("/shop-grid")
//    public String getShopGrid(){
//        return "theme/shoping-cart";
//    }

}
