package com.example.demo.controller;

import com.example.demo.dao.DriverService;
import com.example.demo.dao.LookupService;
import com.example.demo.dao.WayBilService;
import com.example.demo.entity.Driver;
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
public class WayBilController {

    WayBil wayBil_Reload;

    @Autowired
    WayBilService wayBilService;

    @Autowired
    LookupService lookupService;

    @Autowired
    DriverService driverService;

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
        return "/WayBil_Template/view_data.html";
    }

    @GetMapping("/get-waybil")
    public String getWaybil(Model model){
        model.addAttribute("waybil",new WayBil());
        return "/WayBil_Template/search_waybil.html";
    }

    @PostMapping("/getwaybil_fromhome")
    public String getWaybilHome(@ModelAttribute WayBil waybil, Model model) {
        WayBil wayBil = wayBilService.getById(waybil);

        if (wayBil == null) {
            model.addAttribute("waybil", new WayBil());
            model.addAttribute("message_search_not_found_waybil","بارنامه یافت نشد !");
            return "/WayBil_Template/search_waybil.html";
        } else {
            wayBil_Reload = wayBil;
            wayBil = wayBilService.convertGeorgianToPersian(wayBil);
            model.addAttribute("waybil", wayBil);
            model.addAttribute("waybilForDelete", wayBil);
            model.addAttribute("list_lookup", lookupService.getGoodsLookup());
            model.addAttribute("list_status", lookupService.getStatusLookup());
            model.addAttribute("list_cars", lookupService.getCarsLookup());
            return "/WayBil_Template/update_form.html";
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
            return "/WayBil_Template/update_form.html";
        } else {
            model.addAttribute("waybil", new WayBil());
            model.addAttribute("message","با موفقیت ویرایش شد");
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
        return "/WayBil_Template/form.html";
    }


    @PostMapping("/addwaybil")
    public String formPage(Model model, @ModelAttribute WayBil wayBil, BindingResult bindingResult) {
        boolean result = wayBilService.insertWayBil(wayBil);
        if (result == true) {
            model.addAttribute("waybil", new WayBil());
            model.addAttribute("message","با موفقیت ثبت شد");
            return "home.html";
        } else {
            model.addAttribute("waybil", wayBil);
            model.addAttribute("list_lookup", lookupService.getGoodsLookup());
            model.addAttribute("list_status", lookupService.getStatusLookup());
            model.addAttribute("list_cars", lookupService.getCarsLookup());
            model.addAttribute("message","شناسه ملی راننده تکراری است");
            return "/WayBil_Template/form.html";
        }
    }


    @PostMapping("/deletewaybil")
    public String deleteWayBil(Model model, @ModelAttribute WayBil wayBil) {
        // for get id
        wayBil.setId(wayBil_Reload.getId());
        wayBilService.deleteWayBil(wayBil);
        model.addAttribute("waybil", new WayBil());
        model.addAttribute("message","با موفقیت حذف شد");
        return "home.html";
    }


    @GetMapping("/test")
    public String selectWybil(Model model) {

        model.addAttribute("waybil",new WayBil());

        return "/WayBil_Template/search_waybil.html";
    }
}
