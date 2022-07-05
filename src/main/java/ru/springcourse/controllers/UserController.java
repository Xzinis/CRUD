package ru.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.springcourse.dao.UserDAO;
import ru.springcourse.models.User;

import javax.validation.Valid;


@Controller
@RequestMapping("/")
public class UserController {

    private final UserDAO UserDAO;

    @Autowired
    public UserController(UserDAO UserDAO) {
        this.UserDAO = UserDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", UserDAO.index());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("User", UserDAO.show(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("User") User user) {
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("User") @Valid User user) {
        UserDAO.save(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("User", UserDAO.show(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("User") @Valid User user,
                         @PathVariable("id") int id) {
        UserDAO.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        UserDAO.delete(id);
        return "redirect:/";
    }
}