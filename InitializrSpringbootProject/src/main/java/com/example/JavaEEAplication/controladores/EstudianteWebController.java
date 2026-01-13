package com.example.JavaEEAplication.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EstudianteWebController {

    private final EstudianteServicio servicio;

    public EstudianteWebController(EstudianteServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/estudiantes")
    public String verEstudiantes(Model model) {
        model.addAttribute("listaEstudiantes", servicio.Listar());
        return "estudiantes";
    }
}
