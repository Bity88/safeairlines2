package edu.mum.cs.cs452.safeairlines.controller;


import edu.mum.cs.cs452.safeairlines.model.Role;
import edu.mum.cs.cs452.safeairlines.model.User;
import edu.mum.cs.cs452.safeairlines.service.RoleService;
import edu.mum.cs.cs452.safeairlines.service.UserService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/public")
public class SignupController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping("/signup")
    public String getSignupForm(@ModelAttribute("newUser") User user) {
        return "public/signup";
    }


    @PostMapping("add")
    public String addPassenger(@Valid @ModelAttribute("newUser") User user, Model model, BindingResult result) {
        System.out.println("==================================" + user.getEmail());
        if (result.hasErrors()) {

            return "public/signup";
        }

        Role role = roleService.getRoleById(1l);
        System.out.println("=================> " + role.getRoleType());
        user.addRole(role);
        userService.save(user);

        return "redirect:/login";
    }


}
