package com.province.demo.controllers;

import com.province.demo.models.AppUser;
import com.province.demo.models.Category;
import com.province.demo.models.UserRole;
import com.province.demo.servicies.ICategoryService;
import com.province.demo.servicies.IFoodService;
import com.province.demo.servicies.IUserRoleService;
import com.province.demo.servicies.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @ModelAttribute("category")
    public List<Category> categories() {
        return categoryService.findAll();}

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IFoodService foodService;

    @GetMapping("/register-form")
    public ModelAndView showRegisterUserForm(){

        List<UserRole> list = userRoleService.findAll();
        ModelAndView modelAndView = new ModelAndView("theme/checkout");
        modelAndView.addObject("appUser", new AppUser());
        modelAndView.addObject("roleList", list);
        return modelAndView;

    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute AppUser appUser,  RedirectAttributes redirectAttributes){
        userService.save(appUser);
        redirectAttributes.addFlashAttribute("message", "register successfully added.");
        return "redirect:/register-form";
    }

    @GetMapping("/admin")
    public String isLogged(Model model){
        model.addAttribute("foods",foodService.findAll());
        return "theme/index";
    }

}
