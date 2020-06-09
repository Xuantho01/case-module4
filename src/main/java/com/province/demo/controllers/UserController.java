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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IFoodService foodService;

    @PostMapping("/api/register")
    public AppUser registerUser(@RequestBody AppUser appUser){
        return userService.save(appUser);
    }

    @GetMapping("/admin")
    public String isLogged(Model model){
        model.addAttribute("foods",foodService.findAll());
        return "theme/index";
    }

}
