package ru.geekbrains.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geekbrains.controllers.repr.UserRepr;
import ru.geekbrains.service.repr.SystemUser;

import javax.validation.Valid;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

//    private final UserServiceJpaImpl userService;
    private  SystemUser systemUser;

//    @Autowired
//    public LoginController(UserServiceJpaImpl userService) {
//        this.userService = userService;
//    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserRepr());
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute("user") @Valid UserRepr userRepr,
                                  BindingResult result) {
        logger.info("New user {}", userRepr);

        if (result.hasErrors()) {
            return "register";
        }
        if (!userRepr.getPassword().equals(userRepr.getMatchingPassword())) {
            result.rejectValue("password", "", "Password not matching");
            return "register";
        }
//        userService.save(systemUser);
        return "redirect:/login";
        }
}
