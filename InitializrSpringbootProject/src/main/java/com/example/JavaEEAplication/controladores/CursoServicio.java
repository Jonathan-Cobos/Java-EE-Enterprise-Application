package com.example.JavaEEAplication.controladores;

import java.util.List;
import com.example.JavaEEAplication.main.Cursos;
import com.example.JavaEEAplication.main.CursoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServicio {

    private final CursoInterface cursoInterface;

    @Autowired
    public CursoServicio(CursoInterface cursoInterface) {
        this.cursoInterface = cursoInterface;
    }

    @Autowired         
    public List<Cursos> Listar(){
        return cursoInterface.findAll();
    }
    
    public Cursos BuscarPorCodigo(long codigoCurso){
        return cursoInterface.findById(codigoCurso).orElse(null);
    }
    
    public Cursos AñadirCurso(Cursos nuevoCurso){
        return cursoInterface.save(nuevoCurso);
    }
    
    public Cursos Modificar(long codigoCurso, String nombreCurso, int numCreditos, int semestre) {
        Cursos curso = BuscarPorCodigo(codigoCurso);
        if (curso != null) {
            curso.setNombreCurso(nombreCurso);
            curso.setNumCreditos(numCreditos);
            curso.setSemestre(semestre);
            return cursoInterface.save(curso);
        }
        return null;
    }
    
    public void EliminarCurso(Long codigoCurso){
        cursoInterface.deleteById(codigoCurso);
    }
}
