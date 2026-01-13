package com.example.JavaEEAplication.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RelacionWebController {

    private final RelacionServicio servicio;

    public RelacionWebController(RelacionServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/relaciones")
    public String verRelaciones(Model model) {
        model.addAttribute("estudiantes", servicio.ObtenerEstudiantesConCursos());
        model.addAttribute("cursos", servicio.ObtenerCursosConEstudiantes());
        return "relaciones";
    }
}
