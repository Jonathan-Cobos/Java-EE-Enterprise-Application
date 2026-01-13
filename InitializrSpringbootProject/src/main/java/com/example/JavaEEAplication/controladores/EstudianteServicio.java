package com.example.JavaEEAplication.controladores;

import java.util.List;
import com.example.JavaEEAplication.main.Estudiante;
import com.example.JavaEEAplication.main.EstudianteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServicio {

    private final EstudianteInterface estudianteInterface;

    @Autowired
    public EstudianteServicio(EstudianteInterface estudianteInterface) {
        this.estudianteInterface = estudianteInterface;
    }

    @Autowired         
    public List<Estudiante>Listar(){
    return estudianteInterface.findAll();
    }
    
    public List<Estudiante> BuscarPorNombre(String nombre){
    return estudianteInterface.findByNombre(nombre);
    }
    
    public Estudiante BuscarID(long id){
    return estudianteInterface.findById(id).orElse(null);
    }
    
    public Estudiante AñadirEstudiante(Estudiante nuevoEstudiante){
        return estudianteInterface.save(nuevoEstudiante);
    };
    
    public Estudiante Modificar(long id, String nombre, String apellido, int edad) {
        Estudiante estudiante = BuscarID(id);
        if (estudiante != null) {
            estudiante.setNombre(nombre);
            estudiante.setApellido(apellido);
            estudiante.setEdad(edad);
            return estudianteInterface.save(estudiante);
        }
        return null;
    }
    
    public void EliminarEstudiante(Long id){
        estudianteInterface.deleteById(id);
    }
    
      
    
    
}
