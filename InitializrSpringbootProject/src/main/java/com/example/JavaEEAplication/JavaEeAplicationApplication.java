package com.example.JavaEEAplication;

import com.example.JavaEEAplication.main.Estudiante;
import com.example.JavaEEAplication.controladores.EstudianteServicio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaEeAplicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaEeAplicationApplication.class, args);
    }

    @Bean
    CommandLineRunner ejecutar(EstudianteServicio servicio) {
        return args -> {

    
            Estudiante e1 = new Estudiante();
            e1.setNombre("Juan");
            e1.setApellido("Pérez");
            e1.setEdad(20);
            servicio.añadirEstudiante(e1);

            System.out.println("LISTA:");
            servicio.listar().forEach(System.out::println);

            
            Estudiante encontrado = servicio.buscarID(1L);
            if (encontrado != null) {
                System.out.println("ENCONTRADO: " + encontrado.getNombre());
            }

     
            servicio.modificar(1L, "Juan Carlos", "Pérez", 21);

      
            // servicio.eliminarEstudiante(2L);
        };
    }
}
