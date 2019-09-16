package com.example.demo.controller;

import com.example.demo.dao.MineService;
import com.example.demo.entity.Mine;
import com.example.demo.entity.WayBil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.WebParam;
import java.util.List;

@Controller
@ComponentScan({"com.example.demo.dao"})
@ComponentScan({"com.example.demo.entity"})
public class MineController {

    @Autowired
    MineService mineService;

    Mine mine_Reload;

    @GetMapping("/mines")
    public String getAllMines(Model model){
        List<Mine> mines = mineService.getAllMines();
        model.addAttribute("mines",mines);
        return "/Mine_Template/view_mines.html";
    }

    @GetMapping("/get-mine")
    public String search_Mine(Model model){
        model.addAttribute("mine", new Mine());
        return "/Mine_Template/search_mines.html";
    }

    @PostMapping("/get-mine")
    public String get_Mine(@ModelAttribute Mine mine, Model model){
        Mine mine_Result= mineService.getMine(mine);
        if (mine_Result != null){
            mine_Reload = mine_Result;
            model.addAttribute("mine", mine_Result);
            return "/Mine_Template/form-mine.html";
        }
        else {
            model.addAttribute("message_search","معدن مورد نظر یافت نشد");
            model.addAttribute("mine",new Mine());
            return "/Mine_Template/search_mines.html";
        }
    }
    @PostMapping("/mine-update")
    public String update(@ModelAttribute Mine mine, Model model){
        mine.setMineId(mine_Reload.getMineId());
        boolean result = mineService.updateMine(mine);
        if (result == true){
            model.addAttribute("waybil", new WayBil());
            model.addAttribute("message_from_mine","با موفقیت ویرایش شد");
            return "home";
        }
        else {
            model.addAttribute("mine",mine);
            model.addAttribute("message","خطا در ثبت اطلاعات");
            return "/Mine_Template/form-mine.html";
        }
    }

}
