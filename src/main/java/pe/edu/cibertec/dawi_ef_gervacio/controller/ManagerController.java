package pe.edu.cibertec.dawi_ef_gervacio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.dawi_ef_gervacio.dto.CarDto;
import pe.edu.cibertec.dawi_ef_gervacio.service.ManageService;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManagerController {

@Autowired
    ManageService manageService;

    @GetMapping("/start")
    public String start(Model model) {

        try {
            List<CarDto> users = manageService.getAllCars();
            model.addAttribute("users", users);
            model.addAttribute("error", null);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrió un error al obtener los datos de vehículos");

        }
        return "manage";

    }



}
