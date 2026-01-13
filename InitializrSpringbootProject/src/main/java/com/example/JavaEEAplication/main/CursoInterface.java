/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/Repository.java to edit this template
 */
package com.example.JavaEEAplication.main;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author user
 */
public interface CursoInterface extends JpaRepository<Cursos, Long> {

    List<Estudiante> findByNombreCurso(String nombre);
}
