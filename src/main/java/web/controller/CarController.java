package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

@Controller
public class CarController {

    @GetMapping("/car-list")
    public String carList(Model model, @RequestParam(value = "count", required = false) Integer count) {
        model.addAttribute("cars", new CarServiceImpl().getCarList(count));
        return "car";
    }

}
