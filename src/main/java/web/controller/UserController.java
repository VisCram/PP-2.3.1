package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/addNewUser")
    public String showFormForAddUser(Model model) {
        model.addAttribute("user", new User());
        return "addNewUser";
    }

    @PostMapping("/saveNewUser")
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";

    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String showFormForUpdateUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("update", userService.getUserById(id));
        return "updateUser";
    }

    @PostMapping("/updateExistingUser")
    public String updateExistingUser(@RequestParam("id") Long id, @ModelAttribute("user") User user) {
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/";

    }
}


