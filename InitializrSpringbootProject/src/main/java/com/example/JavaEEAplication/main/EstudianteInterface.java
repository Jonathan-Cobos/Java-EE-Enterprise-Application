
package com.example.JavaEEAplication.main;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteInterface extends JpaRepository<Estudiante, Long> {
    List<Estudiante> findByNombre(String nombre);
    List<Estudiante> findByApellido (String apeliido);
    
          
}
