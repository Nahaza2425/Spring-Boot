package com.informaticonfig.srping.app1.springboot_aplications.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EjemploController {

    @GetMapping("/detalles_info")

    public String info(Model model){

        model.addAttribute("Titulo", "Servidor en linia");
        model.addAttribute("Servidor","Nabid HAssan");

        return "detalles_info";
    }
}
