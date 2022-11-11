package ru.rsreu.kibamba.clientserverapplw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.rsreu.kibamba.clientserverapplw.dao.DormDAO;

@Controller
public class HomeController {

    private DormDAO dormDAO;
    public HomeController(DormDAO dormDAO){
        this.dormDAO = dormDAO;
    }
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("dorms",dormDAO.index());
        return "index";
    }
}
