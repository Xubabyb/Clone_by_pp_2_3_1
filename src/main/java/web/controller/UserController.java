package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm BD with user");
        messages.add("1.0 version by apr'22 ");
        model.addAttribute("messages", messages);
        return "/index";
    }

    @GetMapping("/list")
    public String getUserList(Model model, @RequestParam(value = "count", required = false) Integer count) {
        model.addAttribute("users", userService.listUsers(count));
        return "/user";
    }

    @GetMapping("/user/{id}")
    public String getUserById(Model model, @PathVariable("id") int id) {
        model.addAttribute("users", userService.getUserById(id));
        return "/user";
    }

    @GetMapping("/add")
    public String getForm() {
        return "/registry";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute(name = "user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

}
