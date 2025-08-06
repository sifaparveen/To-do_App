package com.example.To_Do_App;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {

    private final List<String> taskList = new ArrayList<>();

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("tasks", taskList);
        return "index";
    }

    @PostMapping("/submit")
    public String addTask(@RequestParam("text") String text) {
        taskList.add(text);
        return "redirect:/";  // PRG: Post-Redirect-Get
    }

    @PostMapping("/delete")
    public String deleteTask(@RequestParam("index") int index) {
        if (index >= 0 && index < taskList.size()) {
            taskList.remove(index);
        }
        return "redirect:/";
    }
}
