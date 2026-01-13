package com.example.JavaEEAplication;

import com.example.JavaEEAplication.main.Estudiante;
import com.example.JavaEEAplication.main.Cursos;
import com.example.JavaEEAplication.controladores.EstudianteServicio;
import com.example.JavaEEAplication.controladores.CursoServicio;
import com.example.JavaEEAplication.controladores.RelacionServicio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;

@SpringBootApplication
public class JavaEeAplicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaEeAplicationApplication.class, args);
    }

    @Bean
    CommandLineRunner ejecutar(EstudianteServicio estudianteServicio, CursoServicio cursoServicio, RelacionServicio relacionServicio) {
        return args -> {

    
            Estudiante e1 = new Estudiante();
            e1.setNombre("Juan");
            e1.setApellido("Pérez");
            e1.setEdad(20);
            estudianteServicio.AñadirEstudiante(e1);


            Cursos matematicas = new Cursos(1001L, "Matemáticas", 4, 1, 0);
            cursoServicio.AñadirCurso(matematicas);

            System.out.println("Estudiantes:");
            estudianteServicio.Listar().forEach(System.out::println);

            System.out.println("\nCursos:");
            cursoServicio.Listar().forEach(System.out::println);

            
            Estudiante estudainteBuscar = estudianteServicio.BuscarID(1L);
            if (estudainteBuscar != null) {
                System.out.println("\n Buscar estudiante: " + estudainteBuscar.getNombre());
            }

     
            estudianteServicio.Modificar(1L, "Juan Carlos", "Pérez", 21);

           
            relacionServicio.AgregarEstudianteToCurso(1L, 1001L);

      /*
 
estudianteServicio.EliminarEstudiante(1L);
*/
};
    }
}
