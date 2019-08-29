package com.example.demo.controller;

import com.example.demo.dao.LookupService;
import com.example.demo.dao.WayBilService;
import com.example.demo.entity.WayBil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@ComponentScan({"com.example.demo.dao"})
@ComponentScan({"com.example.demo.entity"})
public class SimpleController {

    WayBil wayBil_Reload;

    @Autowired
    WayBilService wayBilService;

    @Autowired
    LookupService lookupService;


    @Value("${APP_NOT_FOUND}")
    String appName;

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("waybil", new WayBil());
        return "home";
    }

    @GetMapping("/getwaybils")
    public String getWayBils(Model model) {
        List<WayBil> wayBils = wayBilService.getAllWayBil();
        model.addAttribute("allWayBils", wayBils);
        return "view_data.html";
    }

    @PostMapping("/getwaybil_fromhome")
    public String getWaybilHome(@ModelAttribute WayBil waybil, Model model) {
        WayBil wayBil = wayBilService.getById(waybil);

        if (wayBil == null) {
            model.addAttribute("waybil", new WayBil());
            return "home_Danger_Alert.html";
        } else {
            wayBil_Reload = wayBil;
            wayBil = wayBilService.convertGeorgianToPersian(wayBil);
            model.addAttribute("waybil", wayBil);
            model.addAttribute("waybilForDelete", wayBil);
            model.addAttribute("list_lookup", lookupService.getGoodsLookup());
            model.addAttribute("list_status", lookupService.getStatusLookup());
            model.addAttribute("list_cars", lookupService.getCarsLookup());
            return "update_form.html";
        }
    }

    @PostMapping("/updatewaybil")
    public String updateWayBil(Model model, @ModelAttribute WayBil wayBil_Update) {
        // for set id
        wayBil_Update.setId(wayBil_Reload.getId()); // because in view layer we miss id
        boolean result = wayBilService.updateWayBil(wayBil_Update);
        if (result == false) {
            wayBil_Update = wayBil_Reload; // because wayBil_Update not valid
            model.addAttribute("waybil", wayBil_Update);
            model.addAttribute("waybilForDelete", wayBil_Update);
            model.addAttribute("list_lookup", lookupService.getGoodsLookup());
            model.addAttribute("list_status", lookupService.getStatusLookup());
            model.addAttribute("list_cars", lookupService.getCarsLookup());
            return "update_form.html";
        } else {
            model.addAttribute("waybil", new WayBil());
            return "home.html";
        }
    }


    @GetMapping("/addwaybil")
    public String addWayBil(Model model, WayBil wayBil) {
        wayBil = wayBilService.prepareForAdd();
        model.addAttribute("waybil", wayBil);
        model.addAttribute("list_lookup", lookupService.getGoodsLookup());
        model.addAttribute("list_status", lookupService.getStatusLookup());
        model.addAttribute("list_cars", lookupService.getCarsLookup());
        return "form.html";
    }


    @PostMapping("/addwaybil")
    public String formPage(Model model, @ModelAttribute WayBil wayBil, BindingResult bindingResult) {
        boolean result = wayBilService.insertWayBil(wayBil);
        if (result == true) {
            model.addAttribute("waybil", new WayBil());
            return "home.html";
        } else {
            model.addAttribute("waybil", wayBil);
            model.addAttribute("list_lookup", lookupService.getGoodsLookup());
            model.addAttribute("list_status", lookupService.getStatusLookup());
            model.addAttribute("list_cars", lookupService.getCarsLookup());
            return "form.html";
        }
    }


    @PostMapping("/deletewaybil")
    public String deleteWayBil(Model model, @ModelAttribute WayBil wayBil) {
        // for get id
        wayBil.setId(wayBil_Reload.getId());
        wayBilService.deleteWayBil(wayBil);
        model.addAttribute("waybil", new WayBil());
        return "home.html";
    }


    @GetMapping("/test")
    public String selectWybil(Model model) {
        WayBil wayBil = new WayBil();
        wayBil = wayBilService.prepareForAdd();
        model.addAttribute("waybil", wayBil);
        model.addAttribute("list_lookup", lookupService.getGoodsLookup());
        model.addAttribute("list_status", lookupService.getStatusLookup());
        model.addAttribute("list_cars", lookupService.getCarsLookup());
        return "test2";
    }
}
