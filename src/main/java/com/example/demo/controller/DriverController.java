package com.example.demo.controller;

import com.example.demo.dao.DriverService;
import com.example.demo.entity.Driver;
import com.example.demo.entity.WayBil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@ComponentScan({"com.example.demo.dao"})
@ComponentScan({"com.example.demo.entity"})
public class DriverController {

    // for reload the driver
    Driver driver_Reload ;

    @Autowired
    DriverService driverService;


    @GetMapping("/drivers")
    public String getAllDrivers(Model model){
        List<Driver> drivers = driverService.getAllDriver();
        model.addAttribute("drivers", drivers);
        return "/Driver_Template/view_drivers.html";
    }

    @GetMapping("/get-driver")
    public String home(Model model){
        model.addAttribute("driver",new Driver());
        return "/Driver_Template/search_driver.html";
    }

    @PostMapping("/get-driver")
    public String getDriver(Model model, @ModelAttribute Driver driver){
        Driver driver_result = driverService.getDriver(driver);
        if (driver_result != null){
            driver_Reload = driver_result;
            model.addAttribute("driver",driver_result);
            return "/Driver_Template/form_driver.html";
        }
        else {
            model.addAttribute("message_search","راننده یافت نشد");
            model.addAttribute("driver",new Driver());
            return "/Driver_Template/search_driver.html";
        }
    }

    @PostMapping("/driver-update")
    public String driverUpdate(Model model, @ModelAttribute Driver driver){
        driver.setDrvId(driver_Reload.getDrvId());
        boolean result = driverService.updateDriver(driver);
        if (result == true){
            // initialize all thing for thymeleaf in get driver
            model.addAttribute("waybil", new WayBil());
            model.addAttribute("message_from_driver","با موفقیت ویرایش شد");
            return "home";
        }
        else{
            // initialize all thing for thymeleaf in get driver
            model.addAttribute("driver",driver);
            model.addAttribute("message","خطا در ثبت اطلاعات ");
            return "/Driver_Template/form_driver.html";
        }
    }
}
