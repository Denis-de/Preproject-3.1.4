package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user")
    public String getUserInfo(Authentication authentication, Model model) {
        User user = userService.findByUserName(authentication.getName());
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping(value = "/admin")
    public String listUsers(Authentication user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("allUsers", userService.getUsersList());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "admin";
    }
}