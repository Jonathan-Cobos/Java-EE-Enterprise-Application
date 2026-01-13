package com.example.JavaEEAplication.controladores;

import java.util.List;
import com.example.JavaEEAplication.main.Estudiante;
import com.example.JavaEEAplication.main.Cursos;
import com.example.JavaEEAplication.main.EstudianteInterface;
import com.example.JavaEEAplication.main.CursoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RelacionServicio {

    private final EstudianteInterface estudianteInterface;
    private final CursoInterface cursoInterface;

    @Autowired
    public RelacionServicio(EstudianteInterface estudianteInterface, CursoInterface cursoInterface) {
        this.estudianteInterface = estudianteInterface;
        this.cursoInterface = cursoInterface;
    }

    public List<Estudiante> ObtenerEstudiantesConCursos() {
        return estudianteInterface.findAll();
    }

    public List<Cursos> ObtenerCursosConEstudiantes() {
        return cursoInterface.findAll();
    }

    @Transactional
    public void AgregarEstudianteToCurso(long estudianteId, long cursoId) {
        Estudiante estudiante = estudianteInterface.findById(estudianteId).orElse(null);
        Cursos curso = cursoInterface.findById(cursoId).orElse(null);
        if (estudiante != null && curso != null) {
            if (estudiante.getCursos() == null) {
                estudiante.setCursos(new java.util.ArrayList<>());
            }
            estudiante.getCursos().add(curso);
            estudianteInterface.save(estudiante);
        }
    }

    public void RemoverEstudianteDelCurso(long estudianteId, long cursoId) {
        Estudiante estudiante = estudianteInterface.findById(estudianteId).orElse(null);
        Cursos curso = cursoInterface.findById(cursoId).orElse(null);
        
        if (estudiante != null && curso != null) {
            estudiante.getCursos().remove(curso);
            estudianteInterface.save(estudiante);
        }
    }
}
