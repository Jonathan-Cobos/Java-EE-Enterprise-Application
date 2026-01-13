package com.example.JavaEEAplication.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CursoWebController {

    private final CursoServicio servicio;

    public CursoWebController(CursoServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/cursos")
    public String verCursos(Model model) {
        model.addAttribute("listaCursos", servicio.Listar());
        return "cursos";
    }
}
