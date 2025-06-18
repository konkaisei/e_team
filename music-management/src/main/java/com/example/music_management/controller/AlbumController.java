package com.example.music_management.controller;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.music_management.entity.Album;
import com.example.music_management.entity.IE;
import com.example.music_management.form.IEForm;
import com.example.music_management.form.MusicForm;
import com.example.music_management.form.BudgetForm;
import com.example.music_management.security.CustomUserDetails;
import com.example.music_management.service.AlbumService;
import com.example.music_management.service.BudgetService;
import com.example.music_management.service.IEService;
import com.example.music_management.service.MusicService;
import com.example.music_management.service.BudgetService;
import com.example.music_management.viewmodel.AlbumViewModel;
import com.example.music_management.viewmodel.MusicViewModel;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.music_management.entity.Music;
import org.springframework.web.bind.annotation.RequestBody;









@Controller
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;
    private final MusicService musicService;
    private final IEService ieService;
    private final BudgetService budgetService;
    private static final String[] TYPES = {"収入", "支出"};
    public AlbumController(AlbumService albumService,MusicService musicService,IEService ieService,BudgetService budgetService){
        this.albumService = albumService;
        this.musicService = musicService;
        this.ieService = ieService;
        this.budgetService = budgetService;
    }
    //Home画面
    @GetMapping
    public String home(Model model,@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        long userId = customUserDetails.getUserId();
        List<IE> IEList = ieService.getAllIE(userId);
        Integer incomeSum = ieService.getIncomeSum(userId);
        Integer expenseSum = ieService.getExpenseSum(userId);
        Integer budget = budgetService.getBudgetAmount(userId);
        if (incomeSum == null) {
            incomeSum = 0;
        }
        if (expenseSum == null) {
            expenseSum = 0;
        }
        model.addAttribute("types", TYPES);
        model.addAttribute("IEList", IEList);
        model.addAttribute("incomeSum", incomeSum);
        model.addAttribute("expenseSum", expenseSum);
        model.addAttribute("budget", budget);
        return "album/album-list"; 
    }   

    @GetMapping("/new")
    public String albumForm(Model model) {
        IEForm ieForm = new IEForm();
        model.addAttribute("IEForm", ieForm);
        return "album/album-form";
    }
    @PostMapping("/new")
    public String createIE(IEForm ieForm, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        long userId = customUserDetails.getUserId();
        ieService.createIE(ieForm, userId);
        return "redirect:/albums";
    }

    
    /*@PostMapping("/new")
    public String createAlbum(AlbumForm albumForm/* , Model model*///) {
        //albumService.createAlbum(albumForm);
        //List<Album> albums = albumService.getAllAlbums();
        //model.addAttribute("albums", albums);
    //    return "redirect:/albums";
    //}
    
    @GetMapping("/{albumId}")
    public String album(@PathVariable long albumId,
                        Model model,
                        @AuthenticationPrincipal CustomUserDetails userDetails) {
        Album album = albumService.getAlbumById(albumId);
        // List<Music> musics = musicService.getMusicsByAlbumId(albumId);
        List<MusicViewModel> musics = musicService.selectMusicsWithFavorite(albumId, userDetails.getUserId());
        model.addAttribute("album", album);
        model.addAttribute("musics", musics);
        return "album/album-detail";
    }

    @PostMapping("/{albumId}/delete")
    public String deleteAlbum(@PathVariable long albumId) {
        albumService.deleteAlbum(albumId);
        return "redirect:/albums";
    }
    
    @GetMapping("/{albumId}/edit")
    public String editAlbum(@PathVariable long albumId, Model model) {
        Album album = albumService.getAlbumById(albumId);
        model.addAttribute("album", album);
        return "album/album-edit";
    }
    @PostMapping("/{albumId}/edit")
    public String updateAlbum(@PathVariable long albumId, Album album) {
        albumService.updateAlbum(albumId, album);
        return "redirect:/albums";
    }
    @GetMapping("/{albumId}/musics/new")
    public String createMusicForm(@PathVariable long albumId, Model model) {
        MusicForm musicForm = new MusicForm();
        musicForm.setAlbumId(albumId);
        model.addAttribute("musicForm", musicForm);
        return "music/music-form";
    }
    @PostMapping("/{albumId}/musics/new")
    public String createMusic(@PathVariable long albumId, MusicForm musicForm) {
        musicService.createMusic(musicForm);
        return "redirect:/albums/" + albumId;
    }

    @PostMapping("/{albumId}/musics/{musicId}/delete")
    public String deleteMusic(@PathVariable long albumId,@PathVariable long musicId) {
        musicService.deleteMusic(musicId);
        
        return "redirect:/albums/" + albumId;
    }
    
    @GetMapping("/{albumId}/musics/{musicId}/edit")
    public String editMusic(@PathVariable long albumId, @PathVariable long musicId, Model model) {
        Music music = musicService.getMusicById(musicId);
        model.addAttribute("music", music);
        return "music/music-edit";
    }
    @PostMapping("/{albumId}/musics/{musicId}/edit")
    public String updateMusic(@PathVariable long albumId, @PathVariable long musicId, Music music) {
        musicService.updateMusic(musicId, music);
        return "redirect:/albums/" + albumId;
    }
    // @GetMapping("/ie")
    // public String ListIE(Model model,@AuthenticationPrincipal CustomUserDetails userDetails) {
    //     List<IE> ie = ieService.getAllIEWithMusicCount(userDetails.getUserId());
    //     model.addAttribute("IE", ie);
    //     return "album/album-list"; 
    // }   

    @GetMapping("/detail")
    public String ListIE2(Model model,@AuthenticationPrincipal CustomUserDetails userDetails) {
        List<IE> ie = ieService.getAllIEWithMusicCount(userDetails.getUserId());
        model.addAttribute("IE", ie);
        return "album/album-edit2"; 
    }
    
    @PostMapping("/detail/{ieId}/delete")
    public String deleteIE(@PathVariable long ieId) {
        ieService.deleteIE(ieId);
        return "redirect:/albums/detail";
    }

    //編集
    @GetMapping("/detail/{ieId}/edit")
    public String editIE(@PathVariable long ieId, Model model) {
        IE ie = ieService.selectIEById(ieId);
        model.addAttribute("IE", ie);
        return "album/album-edit";
    }

    @PostMapping("/detail/{ieId}/edit")
    public String updateIE(@PathVariable long ieId, IE ie) {
        ieService.updateIE(ieId, ie);
        return "redirect:/albums/detail";
    }
    
    // 予算反映の実装
    @GetMapping("/budget-23")
    public String editBudgetAmount(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return "album/album-budget";
    }

    @PostMapping("/budget-23")
    public String updateBudgetAmount(@RequestParam(required = false) Integer budgetAmount, @AuthenticationPrincipal CustomUserDetails customUserDetails, BudgetForm budget) {
        long userId = customUserDetails.getUserId();
        if (budget.getBudget() == 0) {
        budget.setBudget(0);
        }
        budgetService.getBudgetAmount(userId);
        if (budgetService.getBudgetAmount(userId) == null) {
            budgetService.createBudget(budget.getBudget(), userId);
        }else{
            budgetService.updateBudgetAmount(budget.getBudget(), userId);
        }
        return "redirect:/albums";
    }
}
