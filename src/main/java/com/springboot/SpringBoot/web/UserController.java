package com.springboot.SpringBoot.web;

import com.springboot.SpringBoot.model.User;
import com.springboot.SpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/User")
    public String viewHomePage(Model model)
    {
        model.addAttribute("allUserList", userService.getAllUser());
        return "userindex";
    }

    @GetMapping("/addnewuser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "newuser";
    }

    @PostMapping("/saveuser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/User";
    }

    @PostMapping("/test")
    public String tester()

    @GetMapping("/showFormForUpdateuser/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "updateuser";
    }

    @GetMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id, Model model){
        userService.deleteViaId(id);
        return "redirect:/User";
    }
}
