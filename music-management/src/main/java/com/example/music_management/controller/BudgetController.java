package com.example.music_management.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.music_management.form.BudgetForm;
import com.example.music_management.service.AlbumService;
import com.example.music_management.viewmodel.AlbumViewModel;

@Controller
 @RequestMapping("/albums")
public class BudgetController {
     private final AlbumService albumService;
     public BudgetController(AlbumService albumService) {
         this.albumService = albumService;
     }
     @GetMapping("/budget")
   public String setBudget(Model model) {
    BudgetForm budgetForm = new BudgetForm();
    budgetForm.setBudget(100);
    model.addAttribute("setBudget" , budgetForm);
        return "album/album-list";
   }

     @GetMapping("/detail")
     public String detailForm(Model model) {
          List<AlbumViewModel> albums = albumService.getAllAlbumsWithMusicCount();
          model.addAttribute("albums", albums);
          return "album/album-edit2";
     }
}
