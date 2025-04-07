package com.informaticonfig.srping.app1.springboot_aplications.controllers;

import java.util.HashMap;
import java.util.Map;

import com.informaticonfig.srping.app1.springboot_aplications.models.dto.ClaseDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EjemploRestController {

    @GetMapping("/detalles_info2")
    public Map<String, Object> detalles_info() {
        // Crear un objeto ClaseDTO y asignar valores
        ClaseDTO usuario1 = new ClaseDTO();
        usuario1.setTitulo("Administrador");
        usuario1.setUsuario("nhassan");
        usuario1.setNombre("Nabid");
        usuario1.setApellido("Hassan");
        usuario1.setEdad(30);

        // Crear un mapa para la respuesta
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("usuario", usuario1);
        respuesta.put("mensaje", "Detalles del usuario obtenidos correctamente");
        respuesta.put("estado", "success");

        // Retornar el mapa como respuesta
        return respuesta;
    }
}
