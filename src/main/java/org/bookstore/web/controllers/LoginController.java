package org.bookstore.web.controllers;

import org.apache.log4j.Logger;
import org.bookstore.app.services.LoginService;
import org.bookstore.web.dto.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private Logger logger = Logger.getLogger(LoginController.class);
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping()
    public String login(Model model) {
        logger.info("GET /login returns login_page.html");
        model.addAttribute("loginForm", new LoginForm());
        return "login_page";
    }

    @PostMapping("/auth")
    public String authenticate(LoginForm loginForm, BindingResult result, Model model)  {
        if (result.hasErrors()) {
            model.addAttribute("loginForm", loginForm);
            return "login_page";
        }

        logger.info("login OK redirect to book shelf");
            return "redirect:/books";
    }


}
