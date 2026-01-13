/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/Service.java to edit this template
 */
package com.example.JavaEEAplication.controladores;

import com.example.JavaEEAplication.main.CursoInterface;
import com.example.JavaEEAplication.main.Cursos;
import com.example.JavaEEAplication.main.Estudiante;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class ClasesServicio {
        private final CursoInterface cursosInterface;

    @Autowired
    public ClasesServicio(CursoInterface cursosInterface) {
        this.cursosInterface = cursosInterface;
    }
    
    @Autowired
    public List<Cursos>ListarCuros(){
    return cursosInterface.findAll();
    }
    
    public Cursos BuscarID(long codigoCurso){
    return cursosInterface.findById(codigoCurso).orElse(null);
    }
     
    public Cursos AñadirCursos(long codigoCurso, String nombreCurso, int creditos, int semestre, int numeroEstudiantes ){
        Cursos nuevoCursos= new Cursos(codigoCurso, nombreCurso, creditos, semestre, numeroEstudiantes);
        return cursosInterface.save(nuevoCursos);
    }
    
        

}
