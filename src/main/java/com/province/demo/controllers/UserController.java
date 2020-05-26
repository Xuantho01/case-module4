package com.province.demo.controllers;

import com.province.demo.models.AppUser;
import com.province.demo.models.UserRole;
import com.province.demo.servicies.IUserRoleService;
import com.province.demo.servicies.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IUserService userService;

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

    @GetMapping("/user")
    public String isLogged(){
        return "theme/index";
    }

}
