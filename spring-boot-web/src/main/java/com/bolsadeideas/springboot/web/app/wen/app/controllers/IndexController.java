package com.bolsadeideas.springboot.web.app.wen.app.controllers;
import com.bolsadeideas.springboot.web.app.app.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //
public class IndexController {

    @RequestMapping("/index")
    public String index(){

        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        model.addAttibute("usuario", attributeValue);
        return "perfil";
    }


}

