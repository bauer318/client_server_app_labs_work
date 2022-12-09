package ru.rsreu.kibamba.clientserverapplw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.rsreu.kibamba.clientserverapplw.models.Dorm;
import ru.rsreu.kibamba.clientserverapplw.service.DormServiceImpl;

@Controller
public class HomeController {
    private DormServiceImpl dormServiceImpl;
    public HomeController(DormServiceImpl dormServiceImpl){
        this.dormServiceImpl = dormServiceImpl;
    }
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/dorms")
    public String dorms(Model model){
        model.addAttribute("dorms", dormServiceImpl.getAllDorm());
        return "dorms";
    }
    @GetMapping("/dorms/{dormId}")
    public String getHomeById(@PathVariable("dormId") int dormId, Model model){
        Dorm dorm = dormServiceImpl.getDormById(dormId);
        if(dorm==null)
        {
            return "index";
        }
        model.addAttribute("dorm", dorm);
        return "dorm";
    }
    @GetMapping("/dorms/{dormId}/edit")
    public String edit(Model model, @PathVariable("dormId") int dormId){
        model.addAttribute("dorm", dormServiceImpl.getDormById(dormId));
        return "editDorm";
    }
    @PatchMapping("/dorms/{id}")
    public String updateDorm(@ModelAttribute("dorm") Dorm dorm, @PathVariable("id") int dormId){
        if(dorm==null){
            return "editDorm";
        }
        dormServiceImpl.updateDorm(dormId,dorm);
        return "redirect:/dorms";
    }
    @GetMapping("/dorms/new")
    public String newDorm(Model model){
        model.addAttribute("dorm", new Dorm());
        return "newDorm";
    }
    @PostMapping()
    public String createDorm(@ModelAttribute("dorm") Dorm dorm){
        dormServiceImpl.createDorm(dorm);
        return "redirect:/dorms";
    }
    @GetMapping("/dorms/{dormId}/delete")
    public String delete(Model model, @PathVariable("dormId") int dormId){
        model.addAttribute("dorm", dormServiceImpl.getDormById(dormId));
        return "deleteDorm";
    }
    @DeleteMapping("/dorms/{id}")
    public String deleteDorm(@ModelAttribute("dorm") Dorm dorm, @PathVariable("id") int dormId){
      if(dorm == null){
          return "dorms";
      }
      dormServiceImpl.deleteDormById(dormId);
      return "redirect:/dorms";
    }
}
