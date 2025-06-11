package com.example.music_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.music_management.form.BudgetForm;
@Controller
 @RequestMapping("/albums")
public class BudgetController {
     @GetMapping("/budget")
   public String setBudget(Model model) {
    BudgetForm budgetForm = new BudgetForm();
    budgetForm.setBudget(100);
    model.addAttribute("setBudget" , budgetForm);
        return "album/album-list";
   }
}
