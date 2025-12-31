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
    public List<Estudiante>listar(){
        System.out.println(estudianteInterface.findAll());
    return estudianteInterface.findAll();
    }
    
    public List<Estudiante> buscarPorNombre(String nombre){
    return estudianteInterface.findByNombre(nombre);
    }
    
    public Estudiante buscarID(long id){
    return estudianteInterface.findById(id).orElse(null);
    }
    
    public Estudiante añadirEstudiante(Estudiante nuevoEstudiante){
        return estudianteInterface.save(nuevoEstudiante);
    };
    
    public Estudiante modificar(long id, String nombre, String apellido, int edad) {
        Estudiante e = buscarID(id);
        if (e != null) {
            e.setNombre(nombre);
            e.setApellido(apellido);
            e.setEdad(edad);
            return estudianteInterface.save(e);
        }
        return null;
    }
    
    public void eliminarEstudiante(Long id){
        estudianteInterface.deleteById(id);
    }
    
      
    
    
}
